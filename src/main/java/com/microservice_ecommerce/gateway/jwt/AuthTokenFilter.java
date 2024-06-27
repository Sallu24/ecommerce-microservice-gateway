package com.microservice_ecommerce.gateway.jwt;

import com.microservice_ecommerce.gateway.clients.IdentityClient;
import com.microservice_ecommerce.gateway.clients.UserClient;
import com.microservice_ecommerce.gateway.external.User;
import feign.FeignException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

public class AuthTokenFilter extends OncePerRequestFilter {

    @Autowired
    private IdentityClient identityClient;

    @Autowired
    private UserClient userClient;

    private static final Logger logger = LoggerFactory.getLogger(AuthTokenFilter.class);

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        try {
            String token = parseBearerToken(request);

            if (token != null) {
                Long userId = identityClient.validateTokenAndGetUserDetails(token);

                if (userId != null) {
                    User user = userClient.getUserById(userId);
                    logger.debug("Fetched user details: {}", user);

                    UsernamePasswordAuthenticationToken authentication =
                            new UsernamePasswordAuthenticationToken(
                                    user,
                                    null,
                                    null);
                    authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                    SecurityContextHolder.getContext().setAuthentication(authentication);
                } else {
                    logger.warn("User ID returned null for token: {}", token);
                    response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Invalid token: User ID is null");
                    return;
                }
            }
        } catch (FeignException feignException) {
            logger.error("FeignException occurred while validating token: {}", feignException.contentUTF8());
            response.setContentType(MediaType.APPLICATION_JSON_VALUE);
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.getWriter().write(feignException.contentUTF8());
            return;
        } catch (Exception exception) {
            logger.error("Cannot set user authentication: {}", exception);
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Cannot set user authentication: " + exception.getMessage());
            return;
        }

        filterChain.doFilter(request, response);
    }

    private String parseBearerToken(HttpServletRequest request) {
        String headerAuth = request.getHeader("Authorization");

        if (StringUtils.hasText(headerAuth) && headerAuth.startsWith("Bearer ")) {
            return headerAuth.substring(7);
        }

        return null;
    }

}

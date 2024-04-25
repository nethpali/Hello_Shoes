package lk.com.ijse.hello_shoes_test.Config;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lk.com.ijse.hello_shoes_test.Service.JWTService;
import lk.com.ijse.hello_shoes_test.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Configuration
@RequiredArgsConstructor
public class JWTConfigurationFilter extends OncePerRequestFilter {

    private final JWTService jwtService;
    private final UserService userService;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        final String userEmail;
        final String jwt;

        String authorization = request.getHeader("Authorization");

        if (StringUtils.isEmpty(authorization) || !authorization.startsWith("Bearer " )) {
            filterChain.doFilter(request,response);
            return;
        }

        jwt=authorization.substring(7);
        userEmail=jwtService.extractUserName(jwt);
        System.out.println("//////////////////////^^^^^^^^^^^^^^^^^^/////////////////////");

        //validation
        if(!StringUtils.isEmpty(userEmail) && SecurityContextHolder.getContext().getAuthentication()==null){
            UserDetails userDetails=userService.userDetailsService().loadUserByUsername(userEmail);

            if (jwtService.isValidateToken(jwt, userDetails)) {
                SecurityContext emptyContext = SecurityContextHolder.createEmptyContext();
                UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                authenticationToken.setDetails(new WebAuthenticationDetailsSource());
                emptyContext.setAuthentication(authenticationToken);
                SecurityContextHolder.setContext(emptyContext);
            }
        }
        filterChain.doFilter(request,response);
    }
}

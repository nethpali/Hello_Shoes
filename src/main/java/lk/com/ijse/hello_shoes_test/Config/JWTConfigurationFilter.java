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

        final String authorization = request.getHeader("Authorization");

        //validation - Get auth Header status
        if (StringUtils.isEmpty(authorization) || authorization.startsWith("Bearer ")){
            filterChain.doFilter(request,response);
            return;
        }
        jwt=authorization.substring(7);
        userEmail=jwtService.extractUserName(jwt);

        //validation
        if(!StringUtils.isEmpty(userEmail) && SecurityContextHolder.getContext()==null){
            UserDetails userDetails=userService.userDetailsService().loadUserByUsername(userEmail);


            //Validation of Token Status
            if(jwtService.isValidateToken(jwt,userDetails)){
                SecurityContext emptyContext=SecurityContextHolder.createEmptyContext();
                UsernamePasswordAuthenticationToken authToken =new UsernamePasswordAuthenticationToken(
                        userDetails,null,userDetails.getAuthorities()
                );
                authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                emptyContext.setAuthentication(authToken);
                SecurityContextHolder.setContext(emptyContext);
            }
        }
    }
}

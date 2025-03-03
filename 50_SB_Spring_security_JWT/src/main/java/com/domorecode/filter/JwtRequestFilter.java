package com.domorecode.filter;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.domorecode.service.MyUserDetailsService;
import com.domorecode.utils.JwtUtils;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtRequestFilter extends OncePerRequestFilter {
@Autowired
private MyUserDetailsService userDetailsService;
@Autowired
private JwtUtils jwtUtil;
@Override
protected void doFilterInternal(HttpServletRequest request, 
HttpServletResponse response, FilterChain chain)
throws ServletException, IOException {
	
	
//	Get authorization header from request
final String authorizationHeader = request.getHeader("Authorization");

//Extract username from token
String username = null;
String jwt = null;

//Authorization=Bearer <token>
if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) 
{
jwt = authorizationHeader.substring(7);
username = jwtUtil.extractUsername(jwt);
}

//loads userdata based on username using userDetailsService
if (username != null && 
SecurityContextHolder.getContext().getAuthentication() == null) {
UserDetails userDetails = 
this.userDetailsService.loadUserByUsername(username);
//validate token with userDetails
if (jwtUtil.validateToken(jwt, userDetails)) {
UsernamePasswordAuthenticationToken 
usernamePasswordAuthenticationToken = new 
UsernamePasswordAuthenticationToken(
userDetails, null, userDetails.getAuthorities());
usernamePasswordAuthenticationToken
.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
}
}
chain.doFilter(request, response);
}
}

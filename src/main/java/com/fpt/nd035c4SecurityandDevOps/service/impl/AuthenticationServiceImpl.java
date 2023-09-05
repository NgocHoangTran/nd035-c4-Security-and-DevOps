package com.fpt.nd035c4SecurityandDevOps.service.impl;

import com.fpt.nd035c4SecurityandDevOps.model.persistence.repositories.UserRepository;
import com.fpt.nd035c4SecurityandDevOps.model.requests.AuthenticationRequest;
import com.fpt.nd035c4SecurityandDevOps.model.responses.AuthenticationResponse;
import com.fpt.nd035c4SecurityandDevOps.security.JwtService;
import com.fpt.nd035c4SecurityandDevOps.security.SecurityConstants;
import com.fpt.nd035c4SecurityandDevOps.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtService jwtService;
    @Autowired
    private UserRepository userRepository;

    @Override
    public AuthenticationResponse authenticated(AuthenticationRequest authenticationRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authenticationRequest.getUsername(),
                        authenticationRequest.getPassword()
                )
        );
        String jwtToken = jwtService.generateToken((UserDetails) authentication.getPrincipal());
        return new AuthenticationResponse(SecurityConstants.TOKEN_PREFIX + jwtToken);
    }
}

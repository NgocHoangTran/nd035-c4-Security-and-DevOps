package com.fpt.nd035c4SecurityandDevOps.service;

import com.fpt.nd035c4SecurityandDevOps.model.requests.AuthenticationRequest;
import com.fpt.nd035c4SecurityandDevOps.model.responses.AuthenticationResponse;

public interface AuthenticationService {
    public AuthenticationResponse authenticated(AuthenticationRequest authenticationRequest);
}

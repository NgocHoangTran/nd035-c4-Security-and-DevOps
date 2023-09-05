package com.fpt.nd035c4SecurityandDevOps.service;

import com.fpt.nd035c4SecurityandDevOps.model.persistence.User;
import com.fpt.nd035c4SecurityandDevOps.model.requests.CreateUserRequest;
import com.fpt.nd035c4SecurityandDevOps.model.responses.UserResponse;

public interface UserService {
    User createUser(CreateUserRequest createUserRequest) throws Exception;
    UserResponse findByUserName(String username) throws Exception;
    UserResponse findById(Long id) throws Exception;
}

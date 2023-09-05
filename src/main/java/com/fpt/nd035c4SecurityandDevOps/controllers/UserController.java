package com.fpt.nd035c4SecurityandDevOps.controllers;

import com.fpt.nd035c4SecurityandDevOps.model.persistence.User;
import com.fpt.nd035c4SecurityandDevOps.model.persistence.repositories.UserRepository;
import com.fpt.nd035c4SecurityandDevOps.model.requests.AuthenticationRequest;
import com.fpt.nd035c4SecurityandDevOps.model.requests.CreateUserRequest;
import com.fpt.nd035c4SecurityandDevOps.model.responses.AuthenticationResponse;
import com.fpt.nd035c4SecurityandDevOps.model.responses.CreatedUserResponse;
import com.fpt.nd035c4SecurityandDevOps.model.responses.UserResponse;
import com.fpt.nd035c4SecurityandDevOps.service.AuthenticationService;
import com.fpt.nd035c4SecurityandDevOps.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private AuthenticationService authenticationService;

	@GetMapping("/id/{id}")
	public ResponseEntity<UserResponse> findById(@PathVariable Long id) {
		UserResponse user = new UserResponse();
		try{
			user = userService.findById(id);
			return new ResponseEntity<>(user, HttpStatus.OK);
		}catch (Exception e){
			return new ResponseEntity<>(user, HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/{username}")
	public ResponseEntity<UserResponse> findByUserName(@PathVariable String username) {
		UserResponse user = new UserResponse();
		try{
			user = userService.findByUserName(username);
			return new ResponseEntity<>(user, HttpStatus.OK);
		}catch (Exception e){
			return new ResponseEntity<>(user, HttpStatus.BAD_REQUEST);
		}
	}

	@PostMapping("/create")
	public ResponseEntity<CreatedUserResponse> createUser(@RequestBody CreateUserRequest createUserRequest) {
		CreatedUserResponse createdUserResponse =  new CreatedUserResponse();
		try{
			User user = userService.createUser(createUserRequest);
			createdUserResponse.setUsername(user.getUsername());
			createdUserResponse.setMessageId(String.valueOf(HttpStatus.OK.value()));
			createdUserResponse.setMessage("Create new user successful!");
			return new ResponseEntity<>(createdUserResponse, HttpStatus.OK);
		}
		catch (Exception e){
			createdUserResponse.setUsername(createUserRequest.getUsername());
			createdUserResponse.setMessageId(String.valueOf(HttpStatus.BAD_REQUEST.value()));
			createdUserResponse.setMessage(e.getMessage());
			return new ResponseEntity<>(createdUserResponse, HttpStatus.BAD_REQUEST);
		}
	}

	@PostMapping("/login")
	public ResponseEntity<AuthenticationResponse> authenticated(
			@RequestBody AuthenticationRequest authenticationRequest) {
		AuthenticationResponse authenticationResponse = authenticationService.authenticated(authenticationRequest);
		return new ResponseEntity<AuthenticationResponse>(authenticationResponse, HttpStatus.OK);
	}
}
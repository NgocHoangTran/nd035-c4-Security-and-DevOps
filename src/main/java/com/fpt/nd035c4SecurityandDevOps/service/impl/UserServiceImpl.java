package com.fpt.nd035c4SecurityandDevOps.service.impl;

import com.fpt.nd035c4SecurityandDevOps.model.persistence.Cart;
import com.fpt.nd035c4SecurityandDevOps.model.persistence.User;
import com.fpt.nd035c4SecurityandDevOps.model.persistence.repositories.CartRepository;
import com.fpt.nd035c4SecurityandDevOps.model.persistence.repositories.UserRepository;
import com.fpt.nd035c4SecurityandDevOps.model.requests.CreateUserRequest;
import com.fpt.nd035c4SecurityandDevOps.model.responses.UserResponse;
import com.fpt.nd035c4SecurityandDevOps.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private UserRepository userRepository;

    @Override
    public User createUser(CreateUserRequest createUserRequest) throws Exception {
        User user = new User();
        user.setUsername(createUserRequest.getUsername());
        Cart cart = new Cart();
        cartRepository.save(cart);
        user.setCart(cart);
        if(createUserRequest.getPassword().length()<7 ||
                !createUserRequest.getPassword().equals(createUserRequest.getConfirmPassword())){
           throw new Exception("Password and Confirm password not match!");
        }
        user.setPassword(bCryptPasswordEncoder.encode(createUserRequest.getPassword()));
        userRepository.save(user);
        return user;
    }

    @Override
    public UserResponse findByUserName(String username) throws Exception {
        User user = userRepository.findByUsername(username);
        if (user == null){
            return new UserResponse("User not found!!",String.valueOf(HttpStatus.BAD_REQUEST));
        }
        return new UserResponse("Get information user successful!!",
                String.valueOf(HttpStatus.OK),user.getId(), user.getUsername(),
                user.getCart().getId(), user.getCart().getItems(), user.getCart().getTotal());
    }

    @Override
    public UserResponse findById(Long id) throws Exception {
        Optional<User> optionalUser = userRepository.findById(id);
        UserResponse userResponse = new UserResponse();
        if (!optionalUser.isPresent()){
            userResponse.setMessageId(String.valueOf(HttpStatus.BAD_REQUEST));
            userResponse.setMessage("User not found!!");
            return userResponse;
        }
        User user = optionalUser.get();
        Cart cart = user.getCart();
        userResponse.setIdUser(user.getId());
        userResponse.setMessage("Get information user successful!!");
        userResponse.setMessageId(String.valueOf(HttpStatus.OK));
        if (cart != null){
            userResponse.setIdCard(cart.getId());
            userResponse.setItemsCard(cart.getItems());
            userResponse.setTotalCard(cart.getTotal());
        }
        return userResponse;
    }
}
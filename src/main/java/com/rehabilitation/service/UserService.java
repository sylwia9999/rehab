package com.rehabilitation.service;

import com.rehabilitation.Dto.UserRequest;
import com.rehabilitation.Dto.UserResponse;

import java.util.List;

public interface UserService {
    List<UserResponse> getByEmailPassword(String email, String password);
    List<UserResponse> getByEmail(String email);
    void registerUser(UserRequest readerRequest);
}

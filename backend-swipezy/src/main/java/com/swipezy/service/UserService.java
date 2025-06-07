package com.swipezy.service;

import com.swipezy.dto.UserRequestDTO;
import com.swipezy.dto.UserResponseDTO;

import java.util.Optional;

public interface UserService {
   UserResponseDTO createUser(UserRequestDTO userRequestDTO);
   Optional<UserResponseDTO> getUserById(String id);
}


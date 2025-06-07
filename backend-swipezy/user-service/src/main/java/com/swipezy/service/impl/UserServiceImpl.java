package com.swipezy.service.impl;

import com.swipezy.constant.ErrorMessages;
import com.swipezy.dto.UserRequestDTO;
import com.swipezy.dto.UserResponseDTO;
import com.swipezy.model.User;
import com.swipezy.enums.Role;
import com.swipezy.repository.UserRepository;
import com.swipezy.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Override
    public UserResponseDTO createUser(UserRequestDTO userRequestDTO) {
        if (userRepository.findByEmail(userRequestDTO.getEmail()).isPresent()) {
            throw new IllegalArgumentException(ErrorMessages.EMAIL_ALREADY_EXISTS);
        }

        User user = User.builder()
                .name(userRequestDTO.getName())
                .email(userRequestDTO.getEmail())
                .password(passwordEncoder.encode(userRequestDTO.getPassword()))
                .age(userRequestDTO.getAge())
                .gender(userRequestDTO.getGender())
                .bio(userRequestDTO.getBio())
                .interests(userRequestDTO.getInterests())
                .profilePictureUrl(userRequestDTO.getProfilePictureUrl())
                .locationCoordinates(userRequestDTO.getLocationCoordinates())
                .role(Role.USER)
                .isActive(true)
                .createdAt(new Date())
                .updatedAt(new Date())
                .build();

        User savedUser = userRepository.save(user);
        return mapToResponseDTO(savedUser);
    }

    @Override
    public Optional<UserResponseDTO> getUserById(String id) {
        return userRepository.findById(id).map(this::mapToResponseDTO);
    }

    private UserResponseDTO mapToResponseDTO(User user) {
        return UserResponseDTO.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .age(user.getAge())
                .gender(user.getGender())
                .bio(user.getBio())
                .interests(user.getInterests())
                .profilePictureUrl(user.getProfilePictureUrl())
                .locationCoordinates(user.getLocationCoordinates())
                .role(user.getRole())
                .build();
    }
}

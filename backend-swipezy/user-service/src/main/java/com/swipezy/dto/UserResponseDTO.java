package com.swipezy.dto;

import com.swipezy.enums.Role;
import com.swipezy.model.User;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class UserResponseDTO {
    private String id;
    private String name;
    private String email;
    private int age;
    private String gender;
    private String bio;
    private List<String> interests;
    private String profilePictureUrl;
    private double[] locationCoordinates;
    private Role role;
}


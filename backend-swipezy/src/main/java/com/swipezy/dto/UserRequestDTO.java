package com.swipezy.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class UserRequestDTO {
    private String name;
    private String email;
    private String password;
    private int age;
    private String gender;
    private String bio;
    private List<String> interests;
    private String profilePictureUrl;
    private double[] locationCoordinates;
}

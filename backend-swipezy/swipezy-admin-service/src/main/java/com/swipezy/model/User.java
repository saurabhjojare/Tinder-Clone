package com.swipezy.model;

import com.swipezy.enums.Role;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "users")
public class User {

    @Id
    private String id;

    private String name;
    private String email;
    private String password;  // hashed

    private int age;
    private String gender;
    private String bio;
    private List<String> interests = new ArrayList<>();
    private String profilePictureUrl;
    private double[] locationCoordinates;

    private List<String> likedUserIds = new ArrayList<>();
    private List<String> likedByUserIds = new ArrayList<>();
    private List<String> matchedUserIds = new ArrayList<>();

    private Role role;

    private boolean isActive = true;
    private Date createdAt = new Date();
    private Date updatedAt = new Date();
}

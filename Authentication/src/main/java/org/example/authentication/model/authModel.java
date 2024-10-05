package org.example.authentication.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data

public class authModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Use this for auto-increment
    private Long id; // Change from String to Long
    private String username;
    private String email;
    private String password;
}

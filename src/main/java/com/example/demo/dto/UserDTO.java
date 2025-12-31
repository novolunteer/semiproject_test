package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDTO {
    private int user_id;
    private String id;
    private String password;
    private String name;
    private int role_id;
    private String account_status;
    private LocalDate created_at;
}

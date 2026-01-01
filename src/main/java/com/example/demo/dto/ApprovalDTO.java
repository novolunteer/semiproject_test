package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ApprovalDTO {
    private int approval_id;
    private String target_type;
    private int bound_id;
    private String decision_type;
    private String reason;
    private int user_id;
    private LocalDateTime created_at;
}

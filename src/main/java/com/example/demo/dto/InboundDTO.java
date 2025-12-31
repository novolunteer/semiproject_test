package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class InboundDTO {
    private int inbound_id;
    private String user_id;
    private LocalDate request_date;
    private String status;
}

package com.example.demo.controller.request;

import com.example.demo.dto.InboundDTO;
import com.example.demo.dto.InboundDetailDTO;
import com.example.demo.service.RequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class SelectController {
    private final RequestService service;

    @GetMapping("/request/select")
    public String inboundOne(@RequestParam int inbound_id, Model model){
        InboundDetailDTO dto=service.inboundOne(inbound_id);
        model.addAttribute("dto",dto);
        return "request/select";
    }
}

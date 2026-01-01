package com.example.demo.controller.request;

import com.example.demo.dto.InboundDetailDTO;
import com.example.demo.service.RequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class DetailController {
    private final RequestService service;

    @GetMapping("/request/detail")
    public String inboundOne(@RequestParam int inbound_id, Model model){
        List<InboundDetailDTO> list=service.inboundList(inbound_id);
        model.addAttribute("list",list);
        return "request/select";
    }

    @GetMapping("/request/userDetail")
    public String UserinboundOne(@RequestParam int inbound_id, @RequestParam int user_id, Model model){
        List<InboundDetailDTO> list=service.inboundList(inbound_id);
        model.addAttribute("list",list);
        model.addAttribute("inbound_id",inbound_id);
        model.addAttribute("user_id",user_id);
        return "request/userSelect";
    }
}

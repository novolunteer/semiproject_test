package com.example.demo.controller;

import com.example.demo.dto.InboundDTO;
import com.example.demo.service.RequestService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class MainController {
    private final RequestService service;

    @GetMapping("/main")
    public String main(HttpSession session, Model model){
        int user_id=(int)session.getAttribute("userid");
        if(user_id == 1){
            List<InboundDTO> list=service.inboundAll();
            model.addAttribute("list",list);
            model.addAttribute("user_id",user_id);
        }else {
            List<InboundDTO> list=service.selectInbound(user_id);
            model.addAttribute("user_id",user_id);
            model.addAttribute("list",list);
        }
        return "main";
    }
}

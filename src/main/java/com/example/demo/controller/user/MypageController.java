package com.example.demo.controller.user;

import com.example.demo.dto.InboundDTO;
import com.example.demo.service.RequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class MypageController {
    private final RequestService service;

    @GetMapping("/user/mypage")
    public String mypage(Model model){
        List<InboundDTO> list=service.inboundAll();
        model.addAttribute("list",list);
        return "user/mypage";
    }
}

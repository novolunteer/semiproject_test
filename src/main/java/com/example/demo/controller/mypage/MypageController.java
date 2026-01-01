package com.example.demo.controller.mypage;

import com.example.demo.dto.InboundDTO;
import com.example.demo.service.RequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class MypageController {
    private final RequestService service;

    @GetMapping("/admin/mypage")
    public String adminMypage(Model model){
        List<InboundDTO> list=service.inboundAll();
        model.addAttribute("list",list);
        return "mypage/admin";
    }

    @GetMapping("/user/mypage")
    public String userMypage(@RequestParam int user_id, Model model){
        List<InboundDTO> list=service.selectInbound(user_id);
        model.addAttribute("list",list);
        return "mypage/user";
    }

    @GetMapping("/user/backMypage")
    public String userBackMypage(@RequestParam int user_id, Model model){
        List<InboundDTO> list=service.selectInbound(user_id);
        model.addAttribute("list",list);
        return "mypage/user";
    }

    @GetMapping("/admin/backMypage")
    public String adminBackMypage(Model model){
        List<InboundDTO> list=service.inboundAll();
        model.addAttribute("list",list);
        return "mypage/admin";
    }

}

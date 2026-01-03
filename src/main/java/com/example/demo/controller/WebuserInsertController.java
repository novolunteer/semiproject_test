package com.example.demo.controller;

import com.example.demo.dto.WebuserDTO;
import com.example.demo.service.WebuserService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class WebuserInsertController {
    private final WebuserService service;

    @GetMapping("/webuser/insert")
    public String webuserInsert(){
        return "webuserInsert";
    }

    @PostMapping("/webuser/insert")
    public String webuserInsertOk(WebuserDTO dto, HttpSession session){
        int n=service.insertWebuser(dto);
        if(n>0){
            return "redirect:/webuser/list";
        }else {
            session.setAttribute("error","계정 추가 실패!");
            return "redirect:/webuser/list";
        }
    }
}

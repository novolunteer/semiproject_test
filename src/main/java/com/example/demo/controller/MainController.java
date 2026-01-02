package com.example.demo.controller;

import com.example.demo.dto.BoundDTO;
import com.example.demo.dto.InboundDTO;
import com.example.demo.dto.OutboundDTO;
import com.example.demo.service.RequestService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class MainController {
    private final RequestService service;

    @GetMapping("/main")
    public String main(HttpSession session, Model model){
        int role_id = (int) session.getAttribute("role_id");
        int webuser_id = (int) session.getAttribute("webuser_id");
        if(role_id == 1){
            List<BoundDTO> list=service.adminBound();
            model.addAttribute("list",list);
            model.addAttribute("webuser_id",webuser_id);
            model.addAttribute("role_id",role_id);
        }else {
            List<BoundDTO> list=service.userBound(webuser_id);
            model.addAttribute("list",list);
            model.addAttribute("webuser_id",webuser_id);
            model.addAttribute("role_id",role_id);
        }
        return "main";
    }

    @GetMapping("/goinbound")
    @ResponseBody
    public List<InboundDTO> goinbound(HttpSession session){
        int role_id = (int) session.getAttribute("role_id");
        int webuser_id = (int) session.getAttribute("webuser_id");
        if(role_id == 1){
            return service.inboundAll();
        }else {
            return service.selectInbound(webuser_id);
        }
    }

    @GetMapping("/gooutbound")
    @ResponseBody
    public List<OutboundDTO> gooutbound(HttpSession session){
        int role_id = (int) session.getAttribute("role_id");
        int webuser_id = (int) session.getAttribute("webuser_id");
        if(role_id == 1){
            return service.outbloundAll();
        }else {
            return service.selectOutbound(webuser_id);
        }
    }
}

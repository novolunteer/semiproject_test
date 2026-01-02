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
        int user_id=(int)session.getAttribute("userid");
        if(user_id == 1){
            List<BoundDTO> list=service.adminBound();
            model.addAttribute("list",list);
            model.addAttribute("user_id",user_id);
        }else {
            List<BoundDTO> list=service.userBound(user_id);
            model.addAttribute("list",list);
        }
        return "main";
    }

    @GetMapping("/goinbound")
    @ResponseBody
    public List<InboundDTO> goinbound(HttpSession session){
        int user_id=(int)session.getAttribute("userid");
        if(user_id == 1){
            return service.inboundAll();
        }else {
            return service.selectInbound(user_id);
        }
    }

    @GetMapping("/gooutbound")
    @ResponseBody
    public List<OutboundDTO> gooutbound(HttpSession session){
        int user_id=(int)session.getAttribute("userid");
        if(user_id == 1){
            return service.outbloundAll();
        }else {
            return service.selectOutbound(user_id);
        }
    }
}

package com.example.demo.controller.request;

import com.example.demo.dto.InboundDetailDTO;
import com.example.demo.dto.OutboundDetailDTO;
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

    @GetMapping("/request/detail") //관리자 로그인 시 전체 탭에서 상세보기
    public String inboundOne(@RequestParam String io_type, @RequestParam int io_id, Model model){
        if(io_type.equals("in")){
            List<InboundDetailDTO> list=service.inboundList(io_id);
            model.addAttribute("list",list);
            model.addAttribute("io_type",io_type);
        }else {
            List<OutboundDetailDTO> list=service.outboundList(io_id);
            model.addAttribute("list",list);
            model.addAttribute("io_type",io_type);
        }
        return "request/detail";
    }

    @GetMapping("/request/userDetail")
    public String UserinboundOne(@RequestParam int inbound_id, @RequestParam int user_id, Model model){
        List<InboundDetailDTO> list=service.inboundList(inbound_id);
        model.addAttribute("list",list);
        model.addAttribute("inbound_id",inbound_id);
        model.addAttribute("user_id",user_id);
        return "request/userDetail";
    }
}

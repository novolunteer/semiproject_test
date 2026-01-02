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

    @GetMapping("/request/Indetail") //관리자 로그인 시 전체 입고 탭에서 상세보기
    public String inboundOne(@RequestParam int io_id, Model model){
            List<InboundDetailDTO> list=service.inboundList(io_id);
            model.addAttribute("list",list);
        return "request/Indetail";
    }

    @GetMapping("/request/Outdetail") //관리자 로그인 시 전체 탭에서 출고 상세보기
    public String outboundOne(@RequestParam int io_id, Model model){
        List<OutboundDetailDTO> list=service.outboundList(io_id);
        model.addAttribute("list",list);
        return "request/Outdetail";
    }

    @GetMapping("/request/indetail")
    public String indetail(@RequestParam int inbound_id,Model model){
        List<InboundDetailDTO> list=service.inboundList(inbound_id);
        model.addAttribute("list",list);
        return "request/Indetail1";
    }

    @GetMapping("/request/indetail1")
    public String indetail1(@RequestParam int io_id,Model model){
        List<InboundDetailDTO> list=service.inboundList(io_id);
        model.addAttribute("list",list);
        return "request/Indetail1";
    }

    @GetMapping("/request/outdetail")
    public String outdetail(@RequestParam int outbound_id,Model model){
        List<OutboundDetailDTO> list=service.outboundList(outbound_id);
        model.addAttribute("list",list);
        return "request/Outdetail1";
    }

    @GetMapping("/request/outdetail1")
    public String outdetail1(@RequestParam int io_id,Model model){
        List<OutboundDetailDTO> list=service.outboundList(io_id);
        model.addAttribute("list",list);
        return "request/Outdetail1";
    }

    @GetMapping("/request/userDetail")
    public String UserinboundOne(@RequestParam int inbound_id, @RequestParam int webuser_id, Model model){
        List<InboundDetailDTO> list=service.inboundList(inbound_id);
        model.addAttribute("list",list);
        model.addAttribute("inbound_id",inbound_id);
        model.addAttribute("webuser_id",webuser_id);
        return "request/userDetail";
    }
}

package com.example.demo.controller.request;

import com.example.demo.dto.InboundDTO;
import com.example.demo.service.RequestService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequiredArgsConstructor
public class ApprovalController {
    private final RequestService service;

    @GetMapping("/request/approvalIn")
    public String approvalIn(@RequestParam("inbound_detail_id") int inbound_detail_id,
                             @RequestParam("inbound_id") int inbound_id,
                             HttpSession session,
                             RedirectAttributes r){
        int approver_id = (int) session.getAttribute("webuser_id");
        String approval_status="approved";
        boolean result= service.approvalIn(approver_id,inbound_id,approval_status);
        if(result){
            boolean result2=service.inboundDetailStatus(inbound_detail_id,approval_status);
            if(result2){
                InboundDTO dto=service.selectInboundId(inbound_id);
                if(dto.getApproval_status().equals("request")){
                    boolean result3=service.inboundStatus(inbound_id,approval_status);
                    if(result3){
                        r.addFlashAttribute("status","sucess");
                        r.addFlashAttribute("msg","입고 요청 승인 성공!");
                        return "redirect:/main";
                    }else {
                        r.addFlashAttribute("status","failure");
                        r.addFlashAttribute("msg","입고 요청 승인 후 상태 변경 실패!");
                        return "redirect:/main";
                    }
                }else {
                    r.addFlashAttribute("status","sucess");
                    r.addFlashAttribute("msg","입고 요청 승인 성공!");
                    return "redirect:/main";
                }
            }else {
                r.addFlashAttribute("status","failure");
                r.addFlashAttribute("msg","입고 요청 승인 후 상태 변경 실패!");
                return "redirect:/main";
            }
        }else {
            r.addFlashAttribute("status","failure");
            r.addFlashAttribute("msg","입고 요청 승인 실패!");
            return "redirect:/main";
        }
    }
}

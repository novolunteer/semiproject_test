package com.example.demo.controller.request;

import com.example.demo.dto.*;
import com.example.demo.service.RequestService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

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

    @GetMapping("/request/approvalOut")
    public String approvalOut(@RequestParam("outbound_detail_id") int outbound_detail_id,
                              @RequestParam("outbound_id") int outbound_id,
                              HttpSession session,
                              RedirectAttributes r){
        int approver_id = (int) session.getAttribute("webuser_id");
        String approval_status="approved";
        boolean result= service.approvalOut(approver_id,outbound_id,approval_status);
        if(result){
            boolean result2=service.outboundDetailStatus(outbound_detail_id,approval_status);
            if(result2){
                OutboundDTO dto=service.selectOutboundId(outbound_id);
                if(dto.getApproval_status().equals("request")){
                    boolean result3=service.outboundStatus(outbound_id,approval_status);
                    if(result3){
                        r.addFlashAttribute("status","sucess");
                        r.addFlashAttribute("msg","출고 요청 승인 성공!");
                        return "redirect:/main";
                    }else {
                        r.addFlashAttribute("status","failure");
                        r.addFlashAttribute("msg","출고 요청 승인 후 상태 변경 실패!");
                        return "redirect:/main";
                    }
                }else {
                    r.addFlashAttribute("status","sucess");
                    r.addFlashAttribute("msg","출고 요청 승인 성공!");
                    return "redirect:/main";
                }
            }else {
                r.addFlashAttribute("status","failure");
                r.addFlashAttribute("msg","출고 요청 승인 후 상태 변경 실패!");
                return "redirect:/main";
            }
        }else {
            r.addFlashAttribute("status","failure");
            r.addFlashAttribute("msg","출고 요청 승인 실패!");
            return "redirect:/main";
        }

    }

    @PostMapping("/request/rejectionIn")
    public String rejectionIn(@RequestParam int inbound_detail_id,
                              @RequestParam int inbound_id,
                              @RequestParam String reason,
                              HttpSession session,
                              RedirectAttributes r){
        int approver_id = (int) session.getAttribute("webuser_id");
        String approval_status="rejected";
        boolean result=service.rejectionIn(approver_id,inbound_id,approval_status,reason);
        if(result){
            boolean result2=service.inboundDetailStatus(inbound_detail_id,approval_status);
            if(result2){
                List<InboundDetailDTO> list=service.inboundList(inbound_id);
                int count=0;
                int a=list.size();
                for(InboundDetailDTO dto:list){
                    if("rejected".equals(dto.getApproval_status())){
                        count++;
                    }
                }
                if(a > 0 && count == a){
                    service.inboundStatus(inbound_id,approval_status);
                }

                r.addFlashAttribute("status","success");
                r.addFlashAttribute("msg","입고 요청 반려 성공!");
                return "redirect:/main";
            }else {
                r.addFlashAttribute("status","failure");
                r.addFlashAttribute("msg","입고 요청 반려 후 상태 변경 실패!");
                return "redirect:/main";
            }
        }else {
            r.addFlashAttribute("status","failure");
            r.addFlashAttribute("msg","입고 요청 반려 실패!");
            return "redirect:/main";
        }
    }

    @PostMapping("/request/rejectionOut")
    public String rejectionOut(@RequestParam int outbound_detail_id,
                              @RequestParam int outbound_id,
                              @RequestParam String reason,
                              HttpSession session,
                              RedirectAttributes r){
        int approver_id = (int) session.getAttribute("webuser_id");
        String approval_status="rejected";
        boolean result=service.rejectionOut(approver_id,outbound_id,reason,approval_status);
        if(result){
            boolean result2=service.outboundDetailStatus(outbound_detail_id,approval_status);
            if(result2){
                List<OutboundDetailDTO> list=service.outboundList(outbound_id);
                int count=0;
                int a=list.size();
                for(OutboundDetailDTO dto:list){
                    if("rejected".equals(dto.getApproval_status())){
                        count++;
                    }
                }
                if(a > 0 && count == a){
                    service.outboundStatus(outbound_id,approval_status);
                }

                r.addFlashAttribute("status","success");
                r.addFlashAttribute("msg","출고 요청 반려 성공!");
                return "redirect:/main";
            }else {
                r.addFlashAttribute("status","failure");
                r.addFlashAttribute("msg","출고 요청 반려 후 상태 변경 실패!");
                return "redirect:/main";
            }
        }else {
            r.addFlashAttribute("status","failure");
            r.addFlashAttribute("msg","출고 요청 반려 실패!");
            return "redirect:/main";
        }
    }

    @GetMapping("/approval/list")
    public String approvalList(Model model){
        List<ApprovalDTO> list=service.approvalAll();
        model.addAttribute("list",list);
        return "approvalList";
    }
}

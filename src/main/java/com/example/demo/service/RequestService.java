package com.example.demo.service;

import com.example.demo.dto.*;
import com.example.demo.mapper.RequestMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class RequestService {
    private final RequestMapper mapper;

    public List<InboundDTO> inboundAll(){
        return mapper.inboundAll();
    }
    public List<InboundDetailDTO> inboundList(int inbound_id){
        return mapper.inboundList(inbound_id);
    }
    public List<InboundDTO> selectInbound(int webuser_id){return mapper.selectInbound(webuser_id);}
    public List<OutboundDTO> outbloundAll(){ return mapper.outboundAll(); }
    public List<OutboundDetailDTO> outboundList(int outbound_id){ return mapper.outboundList(outbound_id); }
    public List<OutboundDTO> selectOutbound(int webuser_id){ return mapper.selectOutbound(webuser_id); }
    public List<BoundDTO> adminBound(){ return mapper.adminBound(); }
    public List<BoundDTO> userBound(int webuser_id){ return mapper.userBound(webuser_id); }
    public boolean approvalIn(int approver_id,int inbound_id,String approval_status){
        Map<String,Object> map=new HashMap<>();
        map.put("approver_id",approver_id);
        map.put("inbound_id",inbound_id);
        map.put("approval_status",approval_status);
        return mapper.approvalIn(map) > 0;
    }

    public boolean approvalOut(int approver_id,int outbound_id,String approval_status){
        Map<String,Object> map=new HashMap<>();
        map.put("approver_id",approver_id);
        map.put("outbound_id",outbound_id);
        map.put("approval_status",approval_status);
        return mapper.approvalOut(map) > 0;
    }

    public boolean rejectionIn(int approver_id,int inbound_id, String approval_status) {
        Map<String, Object> map = new HashMap<>();
        map.put("approver_id", approver_id);
        map.put("inbound_id", inbound_id);
        map.put("approval_status", approval_status);
        return mapper.rejectionIn(map) > 0;
    }

    public boolean rejectionOut(int approver_id,int outbound_id, String approval_status){
        Map<String,Object> map=new HashMap<>();
        map.put("approver_id",approver_id);
        map.put("outbound_id",outbound_id);
        map.put("approval_status",approval_status);
        return mapper.rejectionOut(map) > 0;
    }
    public boolean inboundDetailStatus(int inbound_detail_id,String approval_status,String reason){
        Map<String,Object> map=new HashMap<>();
        map.put("inbound_detail_id",inbound_detail_id);
        map.put("approval_status",approval_status);
        map.put("reason",reason);
        return mapper.inboundDetailStatus(map) > 0;
    }
    public boolean outboundDetailStatus(int outbound_detail_id,String approval_status,String reason){
        Map<String,Object> map=new HashMap<>();
        map.put("outbound_detail_id",outbound_detail_id);
        map.put("approval_status",approval_status);
        map.put("reason",reason);
        return mapper.outboundDetailStatus(map) > 0;
    }

    public boolean inboundStatus(int inbound_id,String approval_status){
        Map<String,Object> map=new HashMap<>();
        map.put("inbound_id",inbound_id);
        map.put("approval_status",approval_status);
        return mapper.inboundStatus(map) > 0;
    }

    public boolean outboundStatus(int outbound_id,String approval_status){
        Map<String,Object> map=new HashMap<>();
        map.put("outbound_id",outbound_id);
        map.put("approval_status",approval_status);
        return mapper.outboundStatus(map) > 0;
    }

    public InboundDTO selectInboundId(int inbound_id){
        return mapper.selectInboundId(inbound_id);
    }

    public OutboundDTO selectOutboundId(int outbound_id){
        return mapper.selectOutboundId(outbound_id);
    }

    public List<ApprovalDTO> approvalAll(){
        return mapper.approvalAll();
    }

    public ApprovalDTO selectApprovalIn(int inbound_id){
        return mapper.selectApprovalIn(inbound_id);
    }

    public ApprovalDTO selectApprovalOut(int outbound_id){
        return mapper.selectApprovalOut(outbound_id);
    }

    public boolean updateApprovalIn(int inbound_id){
        return mapper.updateApprovalIn(inbound_id) > 0;
    }

    public boolean updateApprovalOut(int outbound_id){
        return mapper.updateApprovalOut(outbound_id) > 0;
    }

    public InboundDetailDTO selectDetailIn(int inbound_detail_id){
        return mapper.selectDetailIn(inbound_detail_id);
    }

    public OutboundDetailDTO selectDetailOut(int outbound_detail_id){
        return mapper.selectDetailOut(outbound_detail_id);
    }
}

package com.example.demo.service;

import com.example.demo.dto.*;
import com.example.demo.mapper.RequestMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public int approvalIn(ApprovalDTO dto){ return mapper.approvalIn(dto); }
    public int approvalOut(ApprovalDTO dto){ return mapper.approvalOut(dto); }
}

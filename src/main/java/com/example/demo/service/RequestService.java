package com.example.demo.service;

import com.example.demo.dto.InboundDTO;
import com.example.demo.dto.InboundDetailDTO;
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
    public InboundDetailDTO inboundOne(int inbound_id){
        return mapper.inboundOne(inbound_id);
    }
    public List<InboundDTO> selectInbound(int user_id){
        return mapper.selectInbound(user_id);
    }
    public InboundDTO selectInboundId(int inbound_id){
        return mapper.selectInboundId(inbound_id);
    }
}

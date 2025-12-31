package com.example.demo.mapper;

import com.example.demo.dto.InboundDTO;
import com.example.demo.dto.InboundDetailDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RequestMapper {
    List<InboundDTO> inboundAll();
    InboundDetailDTO inboundOne(int inbound_id);
    List<InboundDTO> selectInbound(int user_id);
    InboundDTO selectInboundId(int inbound_id);
}

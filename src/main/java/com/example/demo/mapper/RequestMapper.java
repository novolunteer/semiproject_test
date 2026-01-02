package com.example.demo.mapper;

import com.example.demo.dto.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RequestMapper {
    List<InboundDTO> inboundAll();
    List<InboundDetailDTO> inboundList(int inbound_id);
    List<InboundDTO> selectInbound(int user_id);
    List<OutboundDTO> outboundAll();
    List<OutboundDetailDTO> outboundList(int outbound_id);
    List<OutboundDTO> selectOutbound(int user_id);
    List<BoundDTO> adminBound();
    List<BoundDTO> userBound(int user_id);


}

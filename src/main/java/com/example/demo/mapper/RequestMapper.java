package com.example.demo.mapper;

import com.example.demo.dto.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface RequestMapper {
    List<InboundDTO> inboundAll();
    List<InboundDetailDTO> inboundList(int inbound_id);
    List<InboundDTO> selectInbound(int webuser_id);
    List<OutboundDTO> outboundAll();
    List<OutboundDetailDTO> outboundList(int outbound_id);
    List<OutboundDTO> selectOutbound(int webuser_id);
    List<BoundDTO> adminBound();
    List<BoundDTO> userBound(int webuser_id);
    int approvalIn(Map<String,Object> map);
    int rejectionIn(Map<String,Object> map);
    int approvalOut(Map<String,Object> map);
    int rejectionOut(Map<String,Object> map);
    int inboundDetailStatus(Map<String,Object> map);
    int outboundDetailStatus(Map<String,Object> map);
    int inboundStatus(Map<String,Object> map);
    int outboundStatus(Map<String,Object> map);
    InboundDTO selectInboundId(int inbound_id);
    OutboundDTO selectOutboundId(int Outbound_id);

}

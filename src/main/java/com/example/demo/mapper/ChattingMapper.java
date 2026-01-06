package com.example.demo.mapper;

import com.example.demo.dto.ChatMessageDTO;
import com.example.demo.dto.ChatRoomDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@Mapper
public interface ChattingMapper {
    List<ChatRoomDTO> chatRoomAll(int user_id);
    int isParticipant(Map<String, Object> map);
    ChatRoomDTO getRoom(int room_id);
    List<ChatMessageDTO> getMessages(int room_id);
    int sendMessage(Map<String,Object> map);
}

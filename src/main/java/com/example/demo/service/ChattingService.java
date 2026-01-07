package com.example.demo.service;

import com.example.demo.dto.ChatMessageDTO;
import com.example.demo.dto.ChatRoomDTO;
import com.example.demo.mapper.ChattingMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Service
@RequiredArgsConstructor
@Transactional
public class ChattingService {
    private final ChattingMapper mapper;

    public List<ChatRoomDTO> chatRoomAll(int user_id){
        return mapper.chatRoomAll(user_id);
    }

    public boolean isParticipant(int room_id, int user_id){
        Map<String, Object> map=new HashMap<>();
        map.put("room_id",room_id);
        map.put("user_id",user_id);
        return mapper.isParticipant(map) > 0;
    }

    public ChatRoomDTO getRoom(int room_id){
        return mapper.getRoom(room_id);
    }

    public List<ChatMessageDTO> getMessages(int room_id){
        return mapper.getMessages(room_id);
    }

    public void sendMessage(ChatMessageDTO dto){
        int n=mapper.sendMessage(dto);
        System.out.println("insert => " + n);
    }
}

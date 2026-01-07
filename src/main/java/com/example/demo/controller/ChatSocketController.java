package com.example.demo.controller;

import com.example.demo.ChatPresenceStore;
import com.example.demo.dto.ChatMessageDTO;
import com.example.demo.dto.ChatPresenceDTO;
import com.example.demo.service.ChattingService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ChatSocketController {
    private final ChattingService service;
    private final SimpMessagingTemplate template;
    private final ChatPresenceStore store;

    @MessageMapping("/chat/message")
    public void sendMessage(ChatMessageDTO dto){
        System.out.println("ws 수신: " + dto);

        //db 저장
        service.sendMessage(dto);

        //같은 방에 메시지 뿌리기
        template.convertAndSend(
                "/topic/chat/" + dto.getRoom_id(), dto
        );

        Integer readId = service.markLastMessageAsRead(dto.getRoom_id(),dto.getSender_id());
        if(readId != null){
            template.convertAndSend("/topic/read/" + dto.getRoom_id(), readId);
        }

    }

    //채팅방 입장
    @MessageMapping("/chat/enter")
    public void enter(ChatPresenceDTO dto,
                      SimpMessageHeaderAccessor headerAccessor){
        //세션에 저장
        headerAccessor.getSessionAttributes().put("roomId",dto.getRoomId());
        headerAccessor.getSessionAttributes().put("userId",dto.getUserId());

        store.enterRoom(dto.getRoomId(), dto.getUserId());

        Integer lastReadId = service.markLastMessageAsRead(dto.getRoomId(),dto.getUserId());
        if(lastReadId != null){
            template.convertAndSend("/topic/read/" + dto.getRoomId(), lastReadId);
        }

        //접속 인원 알림
        template.convertAndSend(
                "/topic/presence/" + dto.getRoomId(),
                store.getUserCount(dto.getRoomId())
        );
    }

    //채팅방 퇴장
    @MessageMapping("/chat/leave")
    public void leave(ChatPresenceDTO dto){
        store.leaveRoom(dto.getRoomId(), dto.getUserId());

        template.convertAndSend(
                "/topic/presence/" + dto.getRoomId(),
                store.getUserCount(dto.getRoomId())
        );
    }

}

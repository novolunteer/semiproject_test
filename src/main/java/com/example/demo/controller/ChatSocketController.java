package com.example.demo.controller;

import com.example.demo.ChatPresenceStore;
import com.example.demo.dto.ChatMessageDTO;
import com.example.demo.dto.ChatPresenceDTO;
import com.example.demo.service.ChattingService;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

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
    }

    //채팅방 입장
    @MessageMapping("/chat/enter")
    public void enter(ChatPresenceDTO dto){
        store.enterRoom(dto.getRoomId(), dto.getUserId());

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

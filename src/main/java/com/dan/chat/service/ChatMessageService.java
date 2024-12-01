package com.dan.chat.service;

import com.dan.chat.exception.NoSuchChatRoomException;
import com.dan.chat.model.ChatMessage;
import com.dan.chat.repository.ChatMessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ChatMessageService {

    private final ChatMessageRepository repository;
    private final ChatRoomService chatRoomService;

    public ChatMessage save(ChatMessage chatMessage) {
        String chatId = chatRoomService.getChatRoomId(chatMessage.getSenderId(),
                chatMessage.getReceiverId(),
                true)
                .orElseThrow(() -> new NoSuchChatRoomException("No such chatRoom"));
        chatMessage.setChatId(chatId);

        return repository.save(chatMessage);
    }

    public List<ChatMessage> findChatMessages(String senderId, String receiverId) {
        Optional<String> chatId = chatRoomService.getChatRoomId(senderId,
                receiverId,
                false);
        return chatId.map(repository::findByChatId).orElse(new ArrayList<>());
    }
}

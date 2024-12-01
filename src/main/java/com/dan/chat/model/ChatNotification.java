package com.dan.chat.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ChatNotification {
    private String id;
    private String senderId;
    private String receiverId;
    private String content;
}

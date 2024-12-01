package com.dan.chat.exception;

public class NoSuchChatRoomException extends RuntimeException {
    public NoSuchChatRoomException(String message) {
        super(message);
    }
}

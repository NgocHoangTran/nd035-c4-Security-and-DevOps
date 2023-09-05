package com.fpt.nd035c4SecurityandDevOps.model.responses;

public class ApiResponse {
    private String messageId;
    private String message;

    public ApiResponse() {
    }

    public ApiResponse(String messageId, String message) {
        this.messageId = messageId;
        this.message = message;
    }

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

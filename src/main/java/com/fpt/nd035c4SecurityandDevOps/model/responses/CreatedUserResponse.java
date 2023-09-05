package com.fpt.nd035c4SecurityandDevOps.model.responses;

public class CreatedUserResponse extends ApiResponse{
    private String username;

    public CreatedUserResponse() {
        super();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}

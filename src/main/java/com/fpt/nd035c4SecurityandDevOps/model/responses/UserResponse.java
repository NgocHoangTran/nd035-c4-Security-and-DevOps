package com.fpt.nd035c4SecurityandDevOps.model.responses;

import com.fpt.nd035c4SecurityandDevOps.model.persistence.Item;

import java.math.BigDecimal;
import java.util.List;

public class UserResponse extends ApiResponse{

    private long idUser;
    private String username;
    private long idCard;
    private List<Item> itemsCard;
    private BigDecimal totalCard;

    public UserResponse() {
        super();
    }

    public UserResponse(String messageId, String message) {
        super(messageId, message);
    }

    public UserResponse(String messageId, String message, long idUser, String username,
                        long idCard, List<Item> itemsCard, BigDecimal totalCard) {
        super(messageId, message);
        this.idUser = idUser;
        this.username = username;
        this.idCard = idCard;
        this.itemsCard = itemsCard;
        this.totalCard = totalCard;
    }

    public long getIdUser() {
        return idUser;
    }

    public void setIdUser(long idUser) {
        this.idUser = idUser;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public long getIdCard() {
        return idCard;
    }

    public void setIdCard(long idCard) {
        this.idCard = idCard;
    }

    public List<Item> getItemsCard() {
        return itemsCard;
    }

    public void setItemsCard(List<Item> itemsCard) {
        this.itemsCard = itemsCard;
    }

    public BigDecimal getTotalCard() {
        return totalCard;
    }

    public void setTotalCard(BigDecimal totalCard) {
        this.totalCard = totalCard;
    }
}

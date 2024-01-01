package com.jat.demo10;

import javax.persistence.Transient;
import java.io.Serializable;

public class UserCardPOPK implements Serializable {

    @Transient//此字段不需要持久化到数据库
    private static final long serialVersionUID = -7958594354477412380L;

    private Long userId;
    private Long cardId;

    public UserCardPOPK() {
    }

    public UserCardPOPK(Long userId, Long cardId) {
        this.userId = userId;
        this.cardId = cardId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getCardId() {
        return cardId;
    }

    public void setCardId(Long cardId) {
        this.cardId = cardId;
    }
}

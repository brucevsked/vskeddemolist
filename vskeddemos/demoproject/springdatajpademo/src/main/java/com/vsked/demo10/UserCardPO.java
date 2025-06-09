package com.vsked.demo10;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.io.Serializable;

@IdClass(UserCardPOPK.class) // 添加 @IdClass 注解 , 指定 复合主键类
@Table(name = "userCard1")//表名
@Entity
public class UserCardPO implements Serializable {

    @Transient//此字段不需要持久化到数据库
    private static final long serialVersionUID = -1711796258457291082L;

    @Id // 添加复合主键标识
    private Long userId;
    @Id // 添加复合主键标识
    private Long cardId;

    public UserCardPO() {
    }

    public UserCardPO(Long userId, Long cardId) {
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

    @Override
    public String toString() {
        return "UserCardPO{" +
                "userId=" + userId +
                ", cardId=" + cardId +
                '}';
    }
}

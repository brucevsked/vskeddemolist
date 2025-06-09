package com.vsked.demo10;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.io.Serializable;
import java.math.BigDecimal;

@Table(name = "card1")//表名
@Entity //实体 表示实体化后可以被跟踪
public class CardPO implements Serializable {

    @Transient//此字段不需要持久化到数据库
    private static final long serialVersionUID = -4354965420207089692L;

    @Id
    private Long id;
    private Long number;
    private BigDecimal balance;

    public CardPO() {
    }

    public CardPO(Long id, Long number, BigDecimal balance) {
        this.id = id;
        this.number = number;
        this.balance = balance;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
}

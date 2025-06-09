package com.vsked.demo27;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.io.Serializable;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.Date;

@Table(name = "datatest")//表名
@Entity //实体 表示实体化后可以被跟踪
public class DataTest implements Serializable {

    @Transient//此字段不需要持久化到数据库
    private static final long serialVersionUID = 5811319762705704017L;

    @Id
    private Long id;

    private Date date1; //Fri Jan 07 09:58:01 CST 2022
    private java.sql.Date sqldate1;//2022-01-07
    private Instant instant1; //是不带时区的即时时间点 2022-01-07T01:58:01.991Z 推荐
    private LocalDate localdate1; //不带时区的 日期 2022-01-07 推荐
    private LocalDateTime localdatetime1; //不带时区的 日期及时间 2022-01-07T09:58:01.997 推荐
    private Timestamp timestamp1;//2022-01-07 10:06:34.714
    private ZonedDateTime zoneddatetime;//带时间区日期及时间 2022-01-07T10:06:34.719+08:00[Asia/Shanghai] 推荐


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate1() {
        return date1;
    }

    public void setDate1(Date date1) {
        this.date1 = date1;
    }

    public java.sql.Date getSqldate1() {
        return sqldate1;
    }

    public void setSqldate1(java.sql.Date sqldate1) {
        this.sqldate1 = sqldate1;
    }

    public Instant getInstant1() {
        return instant1;
    }

    public void setInstant1(Instant instant1) {
        this.instant1 = instant1;
    }

    public LocalDate getLocaldate1() {
        return localdate1;
    }

    public void setLocaldate1(LocalDate localdate1) {
        this.localdate1 = localdate1;
    }

    public LocalDateTime getLocaldatetime1() {
        return localdatetime1;
    }

    public void setLocaldatetime1(LocalDateTime localdatetime1) {
        this.localdatetime1 = localdatetime1;
    }

    public Timestamp getTimestamp1() {
        return timestamp1;
    }

    public void setTimestamp1(Timestamp timestamp1) {
        this.timestamp1 = timestamp1;
    }

    public ZonedDateTime getZoneddatetime() {
        return zoneddatetime;
    }

    public void setZoneddatetime(ZonedDateTime zoneddatetime) {
        this.zoneddatetime = zoneddatetime;
    }

    public DataTest() {
    }

    @Override
    public String toString() {
        return "DataTest{" +
                "id=" + id +
                ", date1=" + date1 +
                ", sqldate1=" + sqldate1 +
                ", instant1=" + instant1 +
                ", localdate1=" + localdate1 +
                ", localdatetime1=" + localdatetime1 +
                ", timestamp1=" + timestamp1 +
                ", zoneddatetime=" + zoneddatetime +
                '}';
    }
}

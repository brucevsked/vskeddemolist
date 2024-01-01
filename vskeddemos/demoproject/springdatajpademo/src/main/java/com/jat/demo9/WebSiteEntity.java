package com.jat.demo9;

import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.ParamDef;
import org.hibernate.annotations.SQLDelete;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.io.Serializable;

@Table(name = "website")
@Entity
@SQLDelete(sql = "update website set deleted=1 where id=?") //删除语句变为更新语句
@FilterDef(name = "deletedFilter", parameters = @ParamDef(name = "isDeleted", type = "boolean"))//定义一个过滤器
@Filter(name = "deletedFilter", condition = "deleted = :isDeleted")//过滤器参数设置
public class WebSiteEntity implements Serializable {

    @Transient//此字段不需要持久化到数据库
    private static final long serialVersionUID = 7394230413970634323L;

    @Id
    private long id;
    private String name;
    private String url;
    private boolean deleted;

    public WebSiteEntity() {
    }

    public WebSiteEntity(long id, String name, String url) {
        this.id = id;
        this.name = name;
        this.url = url;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    @Override
    public String toString() {
        return "WebSiteEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", deleted=" + deleted +
                '}';
    }
}

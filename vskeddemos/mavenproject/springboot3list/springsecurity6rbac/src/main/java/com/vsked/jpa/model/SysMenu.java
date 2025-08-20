package com.vsked.jpa.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "sysmenu")
public class SysMenu {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "parentid")
    private Long parentid; // 注意：这里存储的是父级ID，通常不直接映射为实体关联，除非需要级联操作

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "title", length = 100)
    private String title;

    @Column(name = "path", length = 255)
    private String path;

    @Column(name = "component", length = 255)
    private String component;

    @Column(name = "redirect", length = 255)
    private String redirect;

    @Column(name = "type")
    private Integer type;

    @Column(name = "icon", length = 100)
    private String icon;

    @Column(name = "sort")
    private Integer sort = 0;

    @Column(name = "status")
    private Byte status = 1;

    @Column(name = "visible")
    private Byte visible = 1;

    @Column(name = "isframe")
    private Byte isframe = 0;

    @Column(name = "alwaysshow")
    private Byte alwaysshow = 0;

    @Column(name = "nocache")
    private Byte nocache = 0;

    @Column(name = "affix")
    private Byte affix = 0;

    @Column(name = "notagsview")
    private Byte notagsview = 0;

    @Column(name = "hidden")
    private Byte hidden = 0;

    @Column(name = "canto")
    private Byte canto = 0;

    @Column(name = "showmainroute")
    private Byte showmainroute = 0;

    @Column(name = "activemenu", length = 255)
    private String activemenu;

    @Column(name = "permission", length = 500)
    private String permission; // 可能需要序列化/反序列化处理

    @Column(name = "titlekey", length = 255)
    private String titlekey;

    @Column(name = "createtime")
    private LocalDateTime createtime;

    @Column(name = "isdeleted")
    private Byte isdeleted = 0;

    // 默认构造函数
    public SysMenu() {
    }

    // Getter 和 Setter 方法
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getParentid() {
        return parentid;
    }

    public void setParentid(Long parentid) {
        this.parentid = parentid;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getComponent() {
        return component;
    }

    public void setComponent(String component) {
        this.component = component;
    }

    public String getRedirect() {
        return redirect;
    }

    public void setRedirect(String redirect) {
        this.redirect = redirect;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Byte getVisible() {
        return visible;
    }

    public void setVisible(Byte visible) {
        this.visible = visible;
    }

    public Byte getIsframe() {
        return isframe;
    }

    public void setIsframe(Byte isframe) {
        this.isframe = isframe;
    }

    public Byte getAlwaysshow() {
        return alwaysshow;
    }

    public void setAlwaysshow(Byte alwaysshow) {
        this.alwaysshow = alwaysshow;
    }

    public Byte getNocache() {
        return nocache;
    }

    public void setNocache(Byte nocache) {
        this.nocache = nocache;
    }

    public Byte getAffix() {
        return affix;
    }

    public void setAffix(Byte affix) {
        this.affix = affix;
    }

    public Byte getNotagsview() {
        return notagsview;
    }

    public void setNotagsview(Byte notagsview) {
        this.notagsview = notagsview;
    }

    public Byte getHidden() {
        return hidden;
    }

    public void setHidden(Byte hidden) {
        this.hidden = hidden;
    }

    public Byte getCanto() {
        return canto;
    }

    public void setCanto(Byte canto) {
        this.canto = canto;
    }

    public Byte getShowmainroute() {
        return showmainroute;
    }

    public void setShowmainroute(Byte showmainroute) {
        this.showmainroute = showmainroute;
    }

    public String getActivemenu() {
        return activemenu;
    }

    public void setActivemenu(String activemenu) {
        this.activemenu = activemenu;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public String getTitlekey() {
        return titlekey;
    }

    public void setTitlekey(String titlekey) {
        this.titlekey = titlekey;
    }

    public LocalDateTime getCreatetime() {
        return createtime;
    }

    public void setCreatetime(LocalDateTime createtime) {
        this.createtime = createtime;
    }

    public Byte getIsdeleted() {
        return isdeleted;
    }

    public void setIsdeleted(Byte isdeleted) {
        this.isdeleted = isdeleted;
    }

    @Override
    public String toString() {
        return "SysMenu{" +
                "id=" + id +
                ", parentid=" + parentid +
                ", name='" + name + '\'' +
                ", title='" + title + '\'' +
                ", path='" + path + '\'' +
                ", component='" + component + '\'' +
                ", redirect='" + redirect + '\'' +
                ", type=" + type +
                ", icon='" + icon + '\'' +
                ", sort=" + sort +
                ", status=" + status +
                ", visible=" + visible +
                ", isframe=" + isframe +
                ", alwaysshow=" + alwaysshow +
                ", nocache=" + nocache +
                ", affix=" + affix +
                ", notagsview=" + notagsview +
                ", hidden=" + hidden +
                ", canto=" + canto +
                ", showmainroute=" + showmainroute +
                ", activemenu='" + activemenu + '\'' +
                ", permission='" + permission + '\'' +
                ", titlekey='" + titlekey + '\'' +
                ", createtime=" + createtime +
                ", isdeleted=" + isdeleted +
                '}';
    }
}
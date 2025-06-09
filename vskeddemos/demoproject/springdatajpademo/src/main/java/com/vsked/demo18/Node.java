package com.vsked.demo18;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.io.Serializable;
import java.util.Set;

@Table(name = "node")
@Entity
public class Node implements Serializable {

    @Transient//此字段不需要持久化到数据库
    private static final long serialVersionUID = -4468225519729802216L;

    @Id
    private Long id;
    private String name;
    private Integer level;

    @ManyToOne
    @JoinColumn(name = "parentId")
    private Node parent;

    @OneToMany(mappedBy = "parent",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Node> childs;

    public Node() {
    }

    public Node(Long id, String name,Integer level) {
        this.id = id;
        this.name = name;
        this.level=level;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public Set<Node> getChilds() {
        return childs;
    }

    public void setChilds(Set<Node> childs) {
        this.childs = childs;
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", name=" + name +
                ", childs=" + childs +
                "}";
    }
}

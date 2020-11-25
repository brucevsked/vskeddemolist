package com.vsked.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="menu")
public class Menu {
	
	@Id
	private Integer mid;
	
	private String menuText;
	
	private String menuLink;
	
	private Integer parentMid;
	
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name = "parentMid")
	private Set<Menu> Menus;

	public Integer getMid() {
		return mid;
	}

	public void setMid(Integer mid) {
		this.mid = mid;
	}

	public String getMenuText() {
		return menuText;
	}

	public void setMenuText(String menuText) {
		this.menuText = menuText;
	}

	public String getMenuLink() {
		return menuLink;
	}

	public void setMenuLink(String menuLink) {
		this.menuLink = menuLink;
	}
	
	public Integer getParentMid() {
		return parentMid;
	}

	public void setParentMid(Integer parentMid) {
		this.parentMid = parentMid;
	}

	public Set<Menu> getMenus() {
		return Menus;
	}

	public void setMenus(Set<Menu> menus) {
		Menus = menus;
	}

	public Menu() {
		super();
	}

	public Menu(Integer mid, String menuText, String menuLink) {
		super();
		this.mid = mid;
		this.menuText = menuText;
		this.menuLink = menuLink;
	}

	public Menu(Integer mid, String menuText, String menuLink, Integer parentMid) {
		super();
		this.mid = mid;
		this.menuText = menuText;
		this.menuLink = menuLink;
		this.parentMid = parentMid;
	}

	public Menu(Integer mid, String menuText, String menuLink, Integer parentMid, Set<Menu> menus) {
		super();
		this.mid = mid;
		this.menuText = menuText;
		this.menuLink = menuLink;
		this.parentMid = parentMid;
		Menus = menus;
	}

	@Override
	public String toString() {
		return "Menu [mid=" + mid + ", menuText=" + menuText + ", menuLink=" + menuLink + ", parentMid=" + parentMid
				+ ", Menus=" + Menus + "]";
	}
	
	
	
	
}

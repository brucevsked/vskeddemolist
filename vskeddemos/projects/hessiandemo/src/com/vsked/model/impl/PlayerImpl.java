package com.vsked.model.impl;


import com.vsked.model.Player;

public class PlayerImpl implements Player{
	
	private String pname="default";

	public String getPlayerName(String cs) {
		System.out.println("this method is run:"+cs);
		pname="server say my name is :"+cs;
		return pname;
	}

	public void setPlayerName(String s) {
		this.pname=s;
	}
	
}

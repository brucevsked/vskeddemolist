package com.vsked.draws;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class DrawCircles extends JPanel {
	private final int cr=70;
	Color co=Color.black;
	
	public Color getCo() {
		return co;
	}

	public void setCo(Color co) {
		this.co = co;
	}

	public void paint(Graphics g) {
		g.clearRect(0,0,200,200);
		g.setColor(co);
		g.fillOval(10, 10, cr, cr);
	}

}

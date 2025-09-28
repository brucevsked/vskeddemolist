package com.vsked;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class MainFrame extends JFrame implements KeyListener, Runnable,ActionListener {
	DrawCircles[] dc = new DrawCircles[9];
	JPanel p = new JPanel();
	Thread t = null;
	Random rd = new Random();
	JButton[] bts=new JButton[9];
	int yb=350;
	int bw=30;

	public MainFrame() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(420, 520);
		setTitle("生化危机1密码锁Byvsk");
		getContentPane().setLayout(null);

		p.setLayout(new GridLayout(3, 3));
		p.setBounds(10, 10, 400, 300);
		p.setFocusable(true);
		p.addKeyListener(this);
		getContentPane().add(p);

		for (int i = 0; i < 9; i++) {
			dc[i] = new DrawCircles();
			bts[i]=new JButton((i+1)+"");
			bts[i].addActionListener(this);
			if(i==2){
			bts[i].setBounds(230, yb, 43, bw);
			}
			if(i==0||i==3||i==6){
				bts[i].setBounds(130, yb+i*15, 43, bw);
			}
			if(i==1||i==4||i==7){
				bts[i].setBounds(180, yb+(i-1)*15, 43, bw);
			}
			if(i==5||i==8){
				bts[i].setBounds(230, yb+(i-1)*15-15, 43, bw);
			}
			getContentPane().add(bts[i]);
			if (i == rd.nextInt(5) || i == rd.nextInt(5) || i == rd.nextInt(5) || i == rd.nextInt(8))
				dc[i].setCo(Color.red);
			p.add(dc[i]);
		}
		setVisible(true);
	}

	public Color changeCircleColor(Color co) {
		return co==Color.black?Color.red:Color.black;
	}
	
	public void changeNumberColor(int n){
		for(int i=0;i<9;i++){
			bts[i].setForeground(Color.black);
		}
		bts[n].setForeground(Color.green);
	}
	//----------------------this is main method
	public static void main(String[] args) {
		new MainFrame();
	}

	// -------key event----------------
	public void keyPressed(KeyEvent e) {
		// press 1
		if (e.getKeyCode() == 49 || e.getKeyCode() == 97)
			processdc(dc, 1);
		if (e.getKeyCode() == 50 || e.getKeyCode() == 98) 
			processdc(dc, 2);
		// press 3
		if (e.getKeyCode() == 51 || e.getKeyCode() == 99)
			processdc(dc,3);
		if (e.getKeyCode() == 52 || e.getKeyCode() == 100)
			processdc(dc, 4);
		if (e.getKeyCode() == 53 || e.getKeyCode() == 101) 
			processdc(dc, 5);
		// press 6
		if (e.getKeyCode() == 54 || e.getKeyCode() == 102)
			processdc(dc, 6);
		if (e.getKeyCode() == 55 || e.getKeyCode() == 103)
			processdc(dc, 7);
		if (e.getKeyCode() == 56 || e.getKeyCode() == 104)
			processdc(dc, 8);
		// press 9
		if (e.getKeyCode() == 57 || e.getKeyCode() == 105) 
			processdc(dc, 9);
		
	}

	public void keyReleased(KeyEvent e) {	}

	public void keyTyped(KeyEvent arg0) {}

	// ---Thread body
	public void run() {
		try {
			for (int i = 0; i < 9; i++) {
				dc[i].setCo(Color.green);
				changeNumberColor(i);
				Thread.currentThread().sleep(300);
				dc[i].repaint();
			}
			for (int i = 0; i < 9; i++) {
				dc[i].setCo(Color.black);
				changeNumberColor(i);
				Thread.currentThread().sleep(300);
				dc[i].repaint();
			}
			for (int i = 0; i < 9; i++) {
				if (i == rd.nextInt(5) || i == rd.nextInt(5)
						|| i == rd.nextInt(5) || i == rd.nextInt(5)) {
					dc[i].setCo(Color.red);
					dc[i].repaint();
				}
			}
			changeNumberColor(0);
		} catch (Exception e) {
		}
	}

	public void actionPerformed(ActionEvent e) {
		for(int i=0;i<9;i++)
			if(e.getSource()==bts[i])
				processdc(dc, i+1);
	}
	
	public void processdc(DrawCircles dc[],int num){
		changeNumberColor(num-1);
		switch (num) {
		case 1:
			for(int i=0;i<4;i++)
				if(i!=2)
				  setColorAndPaint(dc, i);
			break;
		case 2:
			for(int i=0;i<5;i++)
				if(i!=3)
					setColorAndPaint(dc, i);
			break;
		case 3:
			for(int i=1;i<6;i++)
				if(i!=3 && i!=4)
					setColorAndPaint(dc, i);
			break;
		case 4:
			for(int i=0;i<7;i++)
				if(i!=1 &&i!=2 && i!=5)
					setColorAndPaint(dc, i);
			break;
		case 5:
			for(int i=1;i<8;i++)
				if(i!=2 && i!=6 )
					setColorAndPaint(dc, i);
			break;
		case 6:
			for(int i=2;i<9;i++)
				if(i!=3 && i!=6 && i!=7 )
					setColorAndPaint(dc, i);
			break;
		case 7:
			for(int i=3;i<8;i++)
				if(i!=4 && i!=5 )
					setColorAndPaint(dc, i);
			break;
		case 8:
			for(int i=4;i<9;i++)
				if(i!=5)
					setColorAndPaint(dc, i);
			break;
		case 9:
			for(int i=5;i<9;i++)
				if(i!=6)
					setColorAndPaint(dc, i);
			break;
		}
		if (dc[0].getCo() == Color.red && dc[1].getCo() == Color.red
				&& dc[2].getCo() == Color.red && dc[3].getCo() == Color.red
				&& dc[4].getCo() == Color.red && dc[5].getCo() == Color.red
				&& dc[6].getCo() == Color.red && dc[7].getCo() == Color.red
				&& dc[8].getCo() == Color.red) {
			JOptionPane.showMessageDialog(null, "你太强了...解锁成功!自动全黑色");
			t = new Thread(this);
			t.start();
		}
		p.requestFocus();
	}
	
	public void setColorAndPaint(DrawCircles dc[],int num){
		dc[num].setCo(changeCircleColor(dc[num].getCo()));
		dc[num].repaint();
	}

}

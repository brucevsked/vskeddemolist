package com.vsked;

import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainUI extends JFrame implements ActionListener {
	
	JButton btstart=new JButton("start");
	JButton btstop =new JButton("stop");
	JButton btexit=new JButton("exit");
	Drawrect drt=new Drawrect();
	Thread th=new Thread(drt);
	public MainUI() {
		setTitle("protect game by vsk");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(400, 400);
		int wx=(Toolkit.getDefaultToolkit().getScreenSize().width-this.getWidth())/2;
		int wy=(Toolkit.getDefaultToolkit().getScreenSize().height-this.getHeight())/2;
		setLocation(wx, wy);
		init(); 	
		setVisible(true);
	}//end struct
	//------------------start init
	public void init(){		
		drt.setFocusable(true);
		drt.requestFocus();
		this.add(drt,"Center");
		JPanel sp=new JPanel();
		sp.setLayout(new FlowLayout());
		
		btstart.addActionListener(this);
		btexit.addActionListener(this);
		btstop.addActionListener(this);
		sp.add(btstart);
		sp.add(btstop);
		sp.add(btexit);
		this.add(sp,"South");
	}
	//------------------end init
	//start main
	public static void main(String[] args) {
		new MainUI();
	}//end main
	
	//start buttonevent
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btexit){
			System.exit(0);
		}
		if(e.getSource()==btstart){			
			if(th.isAlive())
				th.resume();
			else
				th.start();
		}
		if(e.getSource()==btstop)
			th.suspend();
		
	}	
	
}// end class mainUI

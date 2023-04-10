package com.vsked.game;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Drawrect extends JPanel implements Runnable,MouseListener {
	Color[] col={Color.black,Color.blue,Color.cyan,Color.green,Color.lightGray,Color.yellow,Color.pink,Color.red};
	Random rmz=new Random();
	int rx=rmz.nextInt(350),ry=20;
	int wid=rmz.nextInt(100);
	int con=rmz.nextInt(col.length); 
	int life=10;
	//start struct drawrect
	public Drawrect() {	
		this.setSize(400,400);
		this.addMouseListener(this);	
	}	
	public void init(){
		con=rmz.nextInt(col.length);
		rx=rmz.nextInt(350);
		ry=20;
		wid=rmz.nextInt(100);
		
	}
	//-------------start paint
	public void paint(Graphics g){
		g.clearRect(0, 0, this.getWidth(), this.getHeight());
		g.setColor(Color.black);
		g.drawString("Current Life:"+life, 10, 10);	
		g.setColor(col[con]);		
		g.fillRect(rx, ry, 50+wid, 50+wid);		
	}//end paint

	//------------start runnable
	public void run() {		
		while(true){					
			if(ry>19&&ry+wid+50<400){
				try {
					Thread.currentThread().sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				ry+=20;							
			}
			else{				
				life--;	
				if(life<=0){
					int regame=JOptionPane.showConfirmDialog(null, "now you no life");
					if(regame==0){						
						life=10;
					}else{
						Thread.currentThread().suspend();
					}
				}
				init();
			}
			this.repaint();	
		}
	}//end runnable

	public void mouseClicked(MouseEvent e) {	}

	public void mouseEntered(MouseEvent e) {}

	public void mouseExited(MouseEvent e) {}

	public void mousePressed(MouseEvent e) {
		int mx=e.getX(); //mouse x
		int my=e.getY(); //mouse y		
		if(mx>rx&&my>ry&&mx<rx+wid+50&&my<ry+wid+50){
			ry-=50;
			this.repaint();			
		}	
	}

	public void mouseReleased(MouseEvent e) {	}
}

package com.vsked.scarddraw;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class TestDrawScard extends JPanel{

	public static void main(String[] args) throws Exception {
		new TestDrawScard().testDraw();
	}
	
	public  void testDraw() throws Exception{
		String sPic="e:/cardbg1.jpg";
		String oPic="e:/v.jpg";
		String uHead="e:/head1.png";
		
		String uName="快吃ff饭";
		int uNamex=300;
		int uNamey=175;
		String uSex="男";
		int uSexx=300;
		int uSexy=280;
		String uNation="汉";
		int uNationx=550;
		int uNationy=280;
		String uYeah="1999";
		int uYeahx=300;
		int uYeahy=380;
		String uMonth="33";
		int uMonthx=470;
		int uMonthy=380;
		String uDay="06";
		int uDayx=600;
		int uDayy=380;
		String uAddr1="山东省济南市8888888888889999";
		int uAddr1x=300;
		int uAddr1y=490;
		
		String uCardCode="370188888888888888";
		int uCardCodex=450;
		int uCardCodey=760;
		
		int uHeadx=850;
		int uHeady=150;
		int uHeadWidth=400;
		int uHeadHeight=500;
		
		File sf=new File(sPic);
		File of=new File(oPic);
		File head=new File(uHead);
		
		BufferedImage bi=ImageIO.read(sf);
		Graphics g=bi.getGraphics();
		g.setFont(new Font("Microsoft YaHei", Font.PLAIN, 45));
		g.setColor(Color.black);
		g.drawString(uName,uNamex,uNamey);
		g.drawString(uSex,uSexx,uSexy);
		g.drawString(uNation,uNationx,uNationy);
		g.drawString(uYeah,uYeahx,uYeahy);
		g.drawString(uMonth,uMonthx,uMonthy);
		g.drawString(uDay,uDayx,uDayy);
		g.drawString(uAddr1,uAddr1x,uAddr1y);
		g.drawString(uCardCode,uCardCodex,uCardCodey);
//		g.drawImage(ImageIO.read(head), uHeadx, uHeady, this);
		g.drawImage(ImageIO.read(head), uHeadx, uHeady, uHeadWidth, uHeadHeight, this);
		ImageIO.write(bi, "jpg", of);
	}


}

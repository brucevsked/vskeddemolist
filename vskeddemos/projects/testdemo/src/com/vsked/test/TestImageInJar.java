package com.vsked.test;

import java.net.URL;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import com.vsked.util.SystemUtil;


public class TestImageInJar extends JFrame {
	private static final long serialVersionUID = 1L;

	public TestImageInJar(String inTitle,URL inUrl){
		setTitle(inTitle);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		JLabel bg=new JLabel(new ImageIcon(inUrl));
		bg.setLayout(new BoxLayout(bg, 1));
		add(bg);
		setSize(500,500);
		//setLocation(FrameP.locationCenter(this));
		setLocationRelativeTo(null);
		setVisible(true);
	}

	public static void main(String[] args) throws Exception {
		URL inPath=SystemUtil.getUrl("com/vsked/img/VirtualBacviewLogo.jpg");
		//inPath=inPath.replace("file:/", "");
		//inPath="add-green.png";
		//inPath="successful.gif";
		//BufferedImage bi=ImagesP.getImage(StringsP.getUrl(inPath));
		new TestImageInJar("About KillerTimer",inPath);
		
	}

}

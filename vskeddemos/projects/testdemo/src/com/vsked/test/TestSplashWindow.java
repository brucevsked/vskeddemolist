package com.vsked.test;

import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JWindow;

import com.vsked.util.SystemUtil;

public class TestSplashWindow {
	public static void main(String[] args) throws Exception {
		URL inPath=SystemUtil.getUrl("com/vsked/img/VirtualBacviewLogo.jpg");
		JWindow splash=new JWindow();
		System.out.println(inPath);
		splash.getContentPane().add(new JLabel(new ImageIcon(inPath)));
		splash.pack();
		splash.setLocationRelativeTo(null);
		splash.setVisible(true);
	}

}

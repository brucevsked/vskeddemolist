package com.vsked.lesson2;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Toolkit;

import javax.media.opengl.GLCapabilities;
import javax.media.opengl.GLProfile;
import javax.media.opengl.awt.GLCanvas;
import javax.swing.JFrame;

import com.jogamp.opengl.util.FPSAnimator;

public class DrawPolygon {
	
	public static void main(String[] args) {
		String windowTitle="title is Draw polygon";
		int windowWidth=500;
		int windowHeight=500;
		
		GraphicsDevice device = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
		
		GLCanvas glCanvas = new GLCanvas(new GLCapabilities(GLProfile.get(GLProfile.GL2)));
		
		glCanvas.setSize( windowWidth, windowHeight );
		glCanvas.addGLEventListener(new DrawPolygonRender());
        glCanvas.setIgnoreRepaint( true );
        
        JFrame frame = new JFrame( windowTitle );
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().setLayout( new BorderLayout() );
        frame.getContentPane().add( glCanvas, BorderLayout.CENTER );
        
        FPSAnimator animator = new FPSAnimator( glCanvas, 60 );
        
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setSize( frame.getContentPane().getPreferredSize() );
        frame.setLocation(( screenSize.width - frame.getWidth() ) / 2 , ( screenSize.height - frame.getHeight() ) / 2 );
        frame.setVisible( true );
        
        glCanvas.requestFocus();
        animator.start();

	}

}

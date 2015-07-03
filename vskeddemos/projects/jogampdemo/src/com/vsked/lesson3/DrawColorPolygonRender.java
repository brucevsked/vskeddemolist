package com.vsked.lesson3;

import javax.media.opengl.GL;
import javax.media.opengl.GL2;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.glu.GLU;

public class DrawColorPolygonRender implements GLEventListener{
	private GLU glu = new GLU();

	public void display(GLAutoDrawable gLDrawable) {
		final GL2 gl = gLDrawable.getGL().getGL2();
        gl.glClear(GL.GL_COLOR_BUFFER_BIT | GL.GL_DEPTH_BUFFER_BIT);
        gl.glLoadIdentity();
        gl.glTranslatef(-1.5f, 0.0f, -6.0f);
        gl.glBegin(GL.GL_TRIANGLES);		// Drawing Using Triangles
        gl.glColor3f(1.0f, 0.0f, 0.0f);   // Set the current drawing color to red
        gl.glVertex3f(0.0f, 1.0f, 0.0f);	// Top
        gl.glVertex3f(-1.0f, -1.0f, 0.0f);	// Bottom Left
        gl.glVertex3f(1.0f, -1.0f, 0.0f);	// Bottom Right
        gl.glEnd();				// Finished Drawing The Triangle
        gl.glTranslatef(3.0f, 0.0f, 0.0f);
        gl.glBegin(GL2.GL_QUADS);           	// Draw A Quad
        gl.glColor3f(0.0f, 1.0f, 0.0f);   // Set the current drawing color to light blue
        gl.glVertex3f(-1.0f, 1.0f, 0.0f);	// Top Left
        gl.glVertex3f(1.0f, 1.0f, 0.0f);	// Top Right
        gl.glVertex3f(1.0f, -1.0f, 0.0f);	// Bottom Right
        gl.glVertex3f(-1.0f, -1.0f, 0.0f);	// Bottom Left
        gl.glEnd();				// Done Drawing The Quad
        gl.glFlush();
	}

	public void dispose(GLAutoDrawable gLDrawable) {
	}

	public void init(GLAutoDrawable gLDrawable) {
		 GL2 gl = gLDrawable.getGL().getGL2();
	     gl.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
	     gl.glShadeModel(GL2.GL_FLAT);
		
	}

    public void reshape(GLAutoDrawable gLDrawable, int x, int y, int width, int height) {
        final GL2 gl = gLDrawable.getGL().getGL2();

        height=height<=0?1:height; // avoid a divide by zero error!
        
        final float h = (float) width / (float) height;
        gl.glViewport(0, 0, width, height);
        gl.glMatrixMode(GL2.GL_PROJECTION);
        gl.glLoadIdentity();
        glu.gluPerspective(45.0f, h, 1.0, 20.0);
        gl.glMatrixMode(GL2.GL_MODELVIEW);
        gl.glLoadIdentity();
    }

}

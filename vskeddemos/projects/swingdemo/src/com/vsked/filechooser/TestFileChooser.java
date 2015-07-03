package com.vsked.filechooser;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class TestFileChooser extends JFrame implements ActionListener{

	private static final long serialVersionUID = 884824076606191654L;
	
	JButton bt1=new JButton("click");
	JLabel lable1=new JLabel("text:");
	
	public TestFileChooser() {
		setTitle("test window");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		bt1.addActionListener(this);
		setLayout(new BorderLayout());
		add(bt1,BorderLayout.CENTER);
		add(lable1,BorderLayout.SOUTH);
		setSize(500,500);
		setVisible(true);
	}

	public static void main(String[] args) {
		new TestFileChooser();

	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==bt1){
			String s="<html>";
			JFileChooser jfc;
			try {
				jfc = new JFileChooser(new File (".").getCanonicalPath());
			} catch (IOException e1) {
				jfc = new JFileChooser("/");
				e1.printStackTrace();
			}
			
			jfc.setAcceptAllFileFilterUsed(false); // "all files". I would like this to be AFTER the others.
			jfc.addChoosableFileFilter(new CustomFileFilter("All supported files", new String[] { "BSP", "WAD", "D3DBSP" }));
			jfc.addChoosableFileFilter(new CustomFileFilter("Binary Space Partition files", new String[] { "BSP", "D3DBSP" }));
			jfc.addChoosableFileFilter(new CustomFileFilter("WAD files", new String[] { "WAD" }));
			jfc.setAcceptAllFileFilterUsed(true); // Setting this false above then true here forces the "all files" filter to be last.
			jfc.setMultiSelectionEnabled(true);
			
			int returnVal = jfc.showOpenDialog(this);
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				File[] files = jfc.getSelectedFiles();
				for(int i=0;i<files.length;i++) {
					if(!files[i].exists() || files[i].isDirectory()) {
						files[i]=null; // Set any invalid files to null entries; this is easy to check later
					}
					s+=(files[i].getName())+"<br><br>";
				}
				
			}//end if returnVal
			s+="</html>";
			lable1.setText(s);
		}//end if bt1
		
	}//end actionPerformed

}

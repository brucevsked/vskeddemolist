package com.vsked.filechooser;

import java.io.File;

import javax.swing.filechooser.FileFilter;

public class CustomFileFilter extends FileFilter {
	private String description = "";
	private String[] extensions=new String[0];
	
	public CustomFileFilter(String description, String[] extensions) {
		this.description=description;
		if(extensions.length>0) {
			this.description+=" (*."+extensions[0];
			for(int i=1;i<extensions.length;i++) {
				this.description+=", *."+extensions[i];
			}
			this.description+=")";
		}
		this.extensions=extensions;
	}
	
	public boolean accept(File file) {
		if (file.isDirectory()) {
			return true; // Must return true for a directory, otherwise you can't navigate the filesystem using the GUI!
		} else {
			if (file.isFile()) {
				for(int i=0;i<extensions.length;i++) {
					try { // Avoid StringIndexOutOfBoundsExceptions
						if (file.getName().substring(file.getName().length()-extensions[i].length()-1).equalsIgnoreCase("."+extensions[i])) {
							return true;
						}
					} catch(java.lang.StringIndexOutOfBoundsException e) {
						e.printStackTrace()	; // The entire name of the requested file is shorter than the specified extension
					}
				}
			}
		}
		return false; // It's not a dir or a filetype listed in extensions
	}

	public String getDescription() {
		return description;
	}
}

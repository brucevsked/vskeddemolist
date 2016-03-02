package com.vsked.test;

import org.eclipse.swt.SWT; 
import org.eclipse.swt.browser.Browser; 
import org.eclipse.swt.widgets.Button; 
import org.eclipse.swt.widgets.Display; 
import org.eclipse.swt.widgets.Event; 
import org.eclipse.swt.widgets.Listener; 
import org.eclipse.swt.widgets.Shell; 
import org.eclipse.swt.widgets.Text; 

public class SWTBrowserTest 
{ 
    public static void main(String args[]) 
    { 
        Display display=new Display(); 
        Shell shell=new Shell(display); 
        shell.setText("SWT Browser Test"); 
        shell.setSize(800,600); 
        
        final Text text=new Text(shell,SWT.BORDER); 
        text.setBounds(5,5,300,25); 
        text.setText("http://www.baidu.com");
        Button button=new Button(shell,SWT.BORDER); 
        button.setBounds(310,5,50,25);        
        button.setText("go"); 
        
        Button button1=new Button(shell,SWT.BORDER);
        button1.setText("auto");
        button1.setBounds(360,5,50,25);
        
        Button button2=new Button(shell,SWT.BORDER);
        button2.setText("get");
        button2.setBounds(430,5,50,25);
        
        
        
        final Browser browser=new Browser(shell,SWT.FILL); 
        browser.setBounds(5,30,780,560); 
        
        button.addListener(SWT.Selection, new Listener() 
        { 
            public void handleEvent(Event event) 
            { 
                String input=text.getText().trim(); 
                if(input.length()==0)return; 
                if(!input.startsWith("http://")) 
                { 
                    input="http://"+input; 
                    text.setText(input); 
                } 
                browser.setUrl(input); 
            } 
        }); 
        
        button1.addListener(SWT.Selection, new Listener(){

			@Override
			public void handleEvent(Event arg0) {
				browser.execute("document.getElementById('kw').value='vsked汉字测试';");
				browser.execute("document.getElementById('form').submit();");
			}
        	
        });
        
        button2.addListener(SWT.Selection, new Listener(){

			@Override
			public void handleEvent(Event arg0) {
				System.out.println(browser.getText());
			}
        	
        });
        
        shell.open(); 
        while (!shell.isDisposed()) { 
            if (!display.readAndDispatch()) 
              display.sleep(); 
          } 
          display.dispose(); 
        
    } 
}

package com.vsked.test;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.SwingConstants;
import java.io.File;
import java.net.URL;
import java.net.MalformedURLException;

import org.jdesktop.jdic.browser.*;

public class Browser extends JPanel {
	String myDefaultUrl="http://www.baidu.com";
	private static final long serialVersionUID = 636016859422505216L;

	BorderLayout borderLayout1 = new BorderLayout();

    JToolBar jBrowserToolBar = new JToolBar();
    JButton jStopButton = new JButton("Stopp");
    JButton jAutoA1Button = new JButton("auto");

    JButton jRefreshButton = new JButton("Refresh");
    JButton jForwardButton = new JButton("Forward");
    JButton jBackButton = new JButton("Back");

    JPanel jAddressPanel = new JPanel();
    JLabel jAddressLabel = new JLabel();
    JTextField jAddressTextField = new JTextField();
    JButton jGoButton = new JButton();
    JPanel jAddrToolBarPanel = new JPanel();
    MyStatusBar statusBar = new MyStatusBar();
    JPanel jBrowserPanel = new JPanel();

    IWebBrowser webBrowser;

    public Browser() {
        try {
            jbInit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {}

        JFrame frame = new JFrame("JDIC API Demo - Browser");

        Container contentPane = frame.getContentPane();

        contentPane.setLayout(new GridLayout(1, 1));
        contentPane.add(new Browser());

        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        frame.pack();
        frame.setVisible(true);
    }

    private void jbInit() throws Exception {
        this.setLayout(borderLayout1);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        this.setPreferredSize(new Dimension(screenSize.width * 9 / 10, screenSize.height * 8 / 10));

        ToolTipManager.sharedInstance().setLightWeightPopupEnabled(false);

        jAddressLabel.setBorder(BorderFactory.createEmptyBorder(0, 4, 0, 4));
        jAddressLabel.setToolTipText("");
        jAddressLabel.setText(" URL: ");

        jGoButton.setBorder(BorderFactory.createCompoundBorder(new EmptyBorder(0, 2, 0, 2), new EtchedBorder()));
        jGoButton.setToolTipText("Load the given URL");
        jGoButton.setText("GO");
        jGoButton.addActionListener(new Browser_jGoButton_actionAdapter(this));
        jAddressPanel.setLayout(new BorderLayout());

        jAddressTextField.addActionListener(new Browser_jAddressTextField_actionAdapter(this));
        jBackButton.setToolTipText("Go back one page");
        jBackButton.setHorizontalTextPosition(SwingConstants.TRAILING);
        jBackButton.addActionListener(new Browser_jBackButton_actionAdapter(this));
        jForwardButton.setToolTipText("Go forward one page");
        jForwardButton.addActionListener(new Browser_jForwardButton_actionAdapter(this));
        jRefreshButton.setToolTipText("Reload current page");
        jRefreshButton.addActionListener(new Browser_jRefreshButton_actionAdapter(this));
        jStopButton.setToolTipText("Stop loading this page");
        jStopButton.setVerifyInputWhenFocusTarget(true);
        jStopButton.setText("Stop");
        jStopButton.addActionListener(new Browser_jStopButton_actionAdapter(this));
        jAutoA1Button.addActionListener(new Browser_jAutoA1Button_actionAdapter(this));
        jAddressPanel.add(jAddressLabel, BorderLayout.WEST);
        jAddressPanel.add(jAddressTextField, BorderLayout.CENTER);
        jAddressPanel.add(jGoButton, BorderLayout.EAST);
        jAddressPanel.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createEtchedBorder(),
            BorderFactory.createEmptyBorder(2, 0, 2, 0)));

        jBrowserToolBar.setFloatable(false);
        jBrowserToolBar.add(jBackButton, null);
        jBrowserToolBar.add(jForwardButton, null);
        jBrowserToolBar.addSeparator();
        jBrowserToolBar.add(jRefreshButton, null);
        jBrowserToolBar.add(jStopButton, null);
        jBrowserToolBar.add(jAutoA1Button, null);
        jBrowserToolBar.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createEtchedBorder(),
            BorderFactory.createEmptyBorder(2, 2, 2, 0)));

        jAddrToolBarPanel.setLayout(new BorderLayout());
        jAddrToolBarPanel.add(jAddressPanel, BorderLayout.CENTER);
        jAddrToolBarPanel.add(jBrowserToolBar, BorderLayout.WEST);
        jAddrToolBarPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 2, 0));

        statusBar.setBorder(BorderFactory.createEmptyBorder(2, 0, 0, 0));
        statusBar.lblDesc.setText("JDIC API Demo - Browser");

        try {
            BrowserEngineManager bem = BrowserEngineManager.instance();
            webBrowser = bem.getActiveEngine().getWebBrowser();
            webBrowser.setURL(new URL(myDefaultUrl));

            // Print out debug messages in the command line.
            //webBrowser.setDebug(true);
        } catch (MalformedURLException e) {
            System.out.println(e.getMessage());
            return;
        }

        webBrowser.addWebBrowserListener(new WebBrowserListener() {
            public void downloadStarted(WebBrowserEvent event) {
                updateStatusInfo("Loading started.");
            }
						public void initializationCompleted(WebBrowserEvent event){;}
            public void downloadCompleted(WebBrowserEvent event) {
                jBackButton.setEnabled(webBrowser.isBackEnabled());
                jForwardButton.setEnabled(webBrowser.isForwardEnabled());

                updateStatusInfo("Loading completed.");

                URL currentUrl = webBrowser.getURL();

                if (currentUrl != null) {
                    jAddressTextField.setText(currentUrl.toString());
                }
            }

            public void downloadProgress(WebBrowserEvent event) {
                // updateStatusInfo("Loading in progress...");
            }

            public void downloadError(WebBrowserEvent event) {
                updateStatusInfo("Loading error.");
            }

            public void documentCompleted(WebBrowserEvent event) {
                updateStatusInfo("Document loading completed.");
            }

            public void titleChange(WebBrowserEvent event) {
                updateStatusInfo("Title of the browser window changed.");
            }  

            public void statusTextChange(WebBrowserEvent event) {
                // updateStatusInfo("Status text changed.");
            } 
            public void windowClose(WebBrowserEvent event) {;} 
        });

        jBrowserPanel.setLayout(new BorderLayout());
        jBrowserPanel.add(webBrowser.asComponent(), BorderLayout.CENTER);				

        this.add(jAddrToolBarPanel, BorderLayout.NORTH);
        this.add(statusBar, BorderLayout.SOUTH);
        this.add(jBrowserPanel, BorderLayout.CENTER);
    }

    void updateStatusInfo(String statusMessage) {
        statusBar.lblStatus.setText(statusMessage);
    }

    /**
     * Check the current input URL string in the address text field, load it,
     * and update the status info and toolbar info.
     */
    void loadURL() {
        String inputValue = jAddressTextField.getText();

        if (inputValue == null) {
            JOptionPane.showMessageDialog(this, "The given URL is NULL:",
                    "Warning", JOptionPane.WARNING_MESSAGE);
        } else {
            // Check if the text value is a URL string.
            URL curUrl = null;

            try {
                // Check if the input string is a local path by checking if it starts
                // with a driver name(on Windows) or root path(on Unix).               
                File[] roots = File.listRoots();

                for (int i = 0; i < roots.length; i++) {
                    if (inputValue.toLowerCase().startsWith(roots[i].toString().toLowerCase())) {
                        File curLocalFile = new File(inputValue);

                        curUrl = curLocalFile.toURL();
                        break;
                    }
                }

                if (curUrl == null) {
                    // Check if the text value is a valid URL.
                    try {
                        curUrl = new URL(inputValue);
                    } catch (MalformedURLException e) {
                            if (inputValue.toLowerCase().startsWith("ftp.")) {
                                curUrl = new URL("ftp://" + inputValue);
                            } else if (inputValue.toLowerCase().startsWith("gopher.")) {
                                curUrl = new URL("gopher://" + inputValue);
                            } else {
                                curUrl = new URL("http://" + inputValue);
                            }
                    }
                }
                            
                webBrowser.setURL(curUrl);

                // Update the address text field, statusbar, and toolbar info.
                updateStatusInfo("Loading " + curUrl.toString() + " ......");

            } catch (MalformedURLException mue) {
                JOptionPane.showMessageDialog(this,
                    "The given URL is not valid:" + inputValue, "Warning",
                    JOptionPane.WARNING_MESSAGE);
            }                
        }
    }

    void jGoButton_actionPerformed(ActionEvent e) {
        loadURL();
    }

    void jAddressTextField_actionPerformed(ActionEvent e) {
        loadURL();
    }

    void jBackButton_actionPerformed(ActionEvent e) {
        webBrowser.back();
    }

    void jForwardButton_actionPerformed(ActionEvent e) {
        webBrowser.forward();
    }

    void jRefreshButton_actionPerformed(ActionEvent e) {
        webBrowser.refresh();
    }

    void jStopButton_actionPerformed(ActionEvent e) {
        webBrowser.stop();
    }
    
    void jAutoA1Button_actionPerformed(ActionEvent e) {
        webBrowser.executeScript("document.getElementById('kw').value='vsked';");
        webBrowser.executeScript("document.getElementById('form').submit();");
    }
}

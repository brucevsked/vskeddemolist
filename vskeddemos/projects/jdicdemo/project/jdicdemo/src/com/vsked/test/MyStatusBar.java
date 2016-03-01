package com.vsked.test;

import javax.swing.*;
import java.awt.*;



class MyStatusBar extends Box {
    public JLabel lblStatus, lblDesc;

    public MyStatusBar() {
        super(BoxLayout.X_AXIS);

        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();

        // Add the JLabel displaying the selected object numbers.
        lblStatus = new JLabel("Status:", SwingConstants.LEADING);
        lblStatus.setPreferredSize(new Dimension((int) (0.7 * screenSize.width),
                22));
        lblStatus.setBorder(BorderFactory.createLoweredBevelBorder());
        this.add(lblStatus, null);

        // Add the JLabel displaying the selected object size.
        // lblSize = new JLabel("Size:", SwingConstants.LEADING);
        // lblSize.setPreferredSize(new Dimension((int)(0.2*screenSize.width), 22));
        // lblSize.setBorder(BorderFactory.createLoweredBevelBorder());
        // this.add(lblSize, null);

        // Add the JLabel displaying the description.
        lblDesc = new JLabel("Description:", SwingConstants.LEADING);
        lblDesc.setPreferredSize(new Dimension((int) (0.3 * screenSize.width),
                22));
        lblDesc.setBorder(BorderFactory.createLoweredBevelBorder());
        this.add(lblDesc, null);
    }
}

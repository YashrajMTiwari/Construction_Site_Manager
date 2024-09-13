package org.csms;

import UIComponents.PreColors;
import UIComponents.TitleBar;
import org.csms.login.*;
import org.csms.dashboard.*;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;
import java.io.IOException;

public class Main {

    private static JFrame CSMSFrame;
    private static JPanel MainContainer;

    public static void main(String[] args) throws IOException {

        CSMSFrame = new JFrame();

        MainContainer = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        TitleBar titleBar = new TitleBar();
        Shape shape = new RoundRectangle2D.Double(0, 0, 1080, 720, 25, 25);

        CSMSFrame.setUndecorated(true);
        CSMSFrame.setShape(shape);

        CSMSLoginPage csmsloginPage = new CSMSLoginPage();
        JPanel loginPanel = csmsloginPage.createLoginPage();

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 0.001;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        MainContainer.add(titleBar.titleBar("CSMS"), gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 1.0;
        gbc.weighty = 0.91;
        gbc.fill = GridBagConstraints.BOTH;
        MainContainer.add(loginPanel, gbc);

        CSMSFrame.add(MainContainer);
        CSMSFrame.setSize(1080, 720);
        CSMSFrame.setLocationRelativeTo(null);
        CSMSFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        CSMSFrame.setVisible(true);
    }

    public static void switchPanel(JPanel newPanel) {
        MainContainer.remove(1);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        MainContainer.add(newPanel, gbc);
        CSMSFrame.revalidate();
        CSMSFrame.repaint();
    }
}
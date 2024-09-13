package org.csms.login;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;
import java.io.IOException;
import UIComponents.*;


public class CSMSLoginPage {

    public JPanel createLoginPage() throws IOException {

        JPanel LoginPanel = new JPanel();
        LoginPanel.setLayout(new GridLayout(1, 2));

        Background_image imagePanel = new Background_image("src/main/Images/2d-graphic-colorful-wallpaper-with-grainy-gradients.jpg");
        imagePanel.setBackground(Color.red);

        LoginFormCom loginFormCom = new LoginFormCom();
        JPanel lPanel = loginFormCom.createPanel();

        JPanel loginPage = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        loginPage.setBackground(PreColors.BACKGROUND_BLACK);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weighty = 1.0;
        gbc.weightx = 1.0;
        loginPage.add(lPanel, gbc);


        LoginPanel.add(imagePanel);
        LoginPanel.add(loginPage, BorderLayout.CENTER);

        return LoginPanel;
    }
}

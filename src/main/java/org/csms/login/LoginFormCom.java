package org.csms.login;

import UIComponents.PreColors;
import org.csms.DataBaseCon.DBConnection;
import org.csms.Main;
import org.csms.dashboard.CSMSDashBoard;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

public class LoginFormCom {

    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    LocalDateTime now = LocalDateTime.now();

    public JPanel createPanel() {

        JPanel loginForm = new JPanel(new GridLayout(7, 1));
        loginForm.setBackground(PreColors.BACKGROUND_GREY);
        loginForm.setBorder(new EmptyBorder(50, 50, 50, 50));

        JLabel loginLabel = new JLabel("Login");
        loginForm.setFont(new Font("Arial", Font.BOLD, 48));
        loginLabel.setForeground(PreColors.WHITESMOKE);
        loginForm.add(loginLabel);

        JLabel usernameLabel = new JLabel("Username");
        usernameLabel.setForeground(PreColors.WHITESMOKE);
        loginForm.add(usernameLabel);

        JTextField usernameField = new JTextField(20);
        usernameField.setBackground(Color.DARK_GRAY);
        usernameField.setForeground(PreColors.WHITESMOKE);
        usernameField.setCaretColor(PreColors.WHITESMOKE);
        usernameField.setBorder(null);
        loginForm.add(usernameField);

        JLabel passwordlabel = new JLabel("Password");
        passwordlabel.setForeground(PreColors.WHITESMOKE);
        loginForm.add(passwordlabel);


        JPasswordField passwordField = new JPasswordField(20);
        passwordField.setBackground(Color.DARK_GRAY);
        passwordField.setForeground(PreColors.WHITESMOKE);
        passwordField.setCaretColor(PreColors.WHITESMOKE);
        passwordField.setBorder(null);
        loginForm.add(passwordField);

        JButton loginBtn =  new JButton("Login");
        loginForm.add(loginBtn);

        loginBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());

                DBConnection db = new DBConnection();
                if (db.verifyLogin(username, password)) {
                    try {
                        CSMSDashBoard dashboard = new CSMSDashBoard();
                        JPanel dashboardPanel = dashboard.Dashboard();
                        Main.switchPanel(dashboardPanel);
                        File LoginLogs = new File("LoginLogs.txt");
                        if (LoginLogs.createNewFile()) {
                            System.out.println("Log File created at: " + dtf.format(now));
                        } else {
                            try (FileWriter writeLoginLogs = new FileWriter("LoginLogs.txt", true)) {
                                writeLoginLogs.append("[Login Success] Time: " + dtf.format(now) + "| By user: " + username + "\n");
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid Username or Password", "Login Failed", JOptionPane.INFORMATION_MESSAGE);
                    try {
                        File LoginLogs = new File("LoginLogs.txt");
                        if (LoginLogs.createNewFile()) {
                            System.out.println("Log File created at: " + dtf.format(now));
                        } else {
                            try (FileWriter writeLoginLogs = new FileWriter("LoginLogs.txt", true)) {
                                writeLoginLogs.append("[Login Failed] Time: " + dtf.format(now) + "| By using username: " + username + "\n");
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
                usernameField.setText("");
                passwordField.setText("");
                db.closeConnection();
            }
        });
        JButton forgotPassBtn = new JButton("Forgot Password?");
        loginForm.add(forgotPassBtn);

        return loginForm;
    }
}

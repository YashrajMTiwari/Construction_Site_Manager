package UIComponents;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TitleBar {

    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    LocalDateTime now = LocalDateTime.now();

    public JPanel titleBar(String WindowName) {

        JPanel titleBar = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        titleBar.setBackground(PreColors.BACKGROUND_GREY);

        JPanel windowNamePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel windowName = new JLabel(WindowName);
        windowName.setForeground(PreColors.WHITESMOKE);
        windowNamePanel.setBorder(new EmptyBorder(0, 20, 0, 0));
        windowName.setFont(new Font("Arial", Font.BOLD, 16));
        windowNamePanel.add(windowName);
        windowNamePanel.setBackground(null);

        JPanel closeButtonPanel = new JPanel();
        closeButtonPanel.setBackground(Color.GREEN);

        JButton closeButton = new JButton("close");
        closeButton.setForeground(PreColors.WHITESMOKE);
        closeButton.setBackground(null);
        closeButton.setFocusable(false);
        closeButton.setBorder(null);
        closeButton.setPreferredSize(new Dimension(60, 30));
        closeButton.setFont(new Font("Arial", Font.PLAIN, 16));

        closeButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                System.exit(0);
                closeButton.setBackground(null);
            }
        });

        closeButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                closeButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
                closeButton.setForeground(Color.red);
                closeButton.setBackground(PreColors.HOVER_BACKGROUDN_GREY);
            }
        });

        closeButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                closeButton.setForeground(PreColors.WHITESMOKE);
                closeButton.setBackground(null);
            }
        });

        closeButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                closeButton.setBackground(null);
                closeButton.setOpaque(true);
            }
        });

        closeButtonPanel.setBackground(null);
        closeButtonPanel.add(closeButton, BorderLayout.EAST);
        closeButtonPanel.setBorder(new EmptyBorder(0, 0, 0, 20));

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 0.9;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        titleBar.add(windowNamePanel, gbc);


        titleBar.add(closeButtonPanel);
        return titleBar;
    }
}

package org.csms.dashboard;

import UIComponents.PreColors;
import UIComponents.TitleBar;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

public class CSMSDashBoard {

    ProjectsPanel projectsPanel = new ProjectsPanel();

    public JPanel Dashboard() {

        JPanel DashboardPanel = new JPanel();
        DashboardPanel.setPreferredSize(null);
        DashboardPanel.setBackground(PreColors.BACKGROUND_BLACK);

        JScrollPane projectsPane = projectsPanel.createProjectsCards();


        DashboardPanel.add(projectsPane, BorderLayout.CENTER);
        return DashboardPanel;
    }
}

package org.csms.dashboard;

import UIComponents.PreColors;
import UIComponents.TitleBar;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

public class CSMSDashBoard {

    ProjectsPanel projectsPanel = new ProjectsPanel();
    ScheduleList scheduleList = new ScheduleList();

    public JPanel Dashboard() {

        JPanel DashboardPanel = new JPanel();
        DashboardPanel.setPreferredSize(null);
        DashboardPanel.setBackground(PreColors.BACKGROUND_BLACK);

        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.setBackground(PreColors.BACKGROUND_GREY);
        tabbedPane.setForeground(PreColors.WHITESMOKE);
        tabbedPane.setPreferredSize(new Dimension(1080, 720));

        JScrollPane projectsPane = projectsPanel.createProjectsCards();
        JPanel schedulePane = scheduleList.createScheduleList();

        tabbedPane.addTab("Projects", projectsPane);
        tabbedPane.addTab("Schedules", schedulePane);

        DashboardPanel.add(tabbedPane, BorderLayout.CENTER);
        return DashboardPanel;
    }
}

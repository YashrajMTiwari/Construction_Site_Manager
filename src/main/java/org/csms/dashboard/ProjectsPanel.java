package org.csms.dashboard;

import UIComponents.PreColors;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class ProjectsPanel {

    public JScrollPane createProjectsCards() {

        JScrollPane ProjectsContainer = new JScrollPane();
        ProjectsContainer.setBorder(BorderFactory.createEmptyBorder());
        ProjectsContainer.getViewport().setBackground(PreColors.BACKGROUND_GREY);


        return ProjectsContainer;
    }
}

package org.csms.dashboard;

import UIComponents.PreColors;

import javax.swing.*;

public class ScheduleList {

    public JPanel createScheduleList() {

        JPanel ScheduleList = new JPanel();

        ScheduleList.add(new JLabel("Test Schedules"));
        ScheduleList.setBackground(PreColors.BACKGROUND_GREY);
        ScheduleList.setBorder(null);
        return ScheduleList;
    }
}

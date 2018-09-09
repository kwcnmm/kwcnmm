package com.vermouthx.util;

import javax.swing.*;

public class FrameUtil {

    private FrameUtil() {

    }

    public static void setContentPanel(JFrame containerFrame, JPanel contentPanel) {
        containerFrame.setContentPane(contentPanel);
        containerFrame.revalidate();
    }
}

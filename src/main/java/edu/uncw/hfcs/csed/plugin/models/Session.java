package edu.uncw.hfcs.csed.plugin.models;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.project.ProjectManager;
import com.intellij.openapi.wm.WindowManager;

import java.awt.*;

public class Session {
    private long initTime;
    private Project activeProject = null;

    public Session() {
        init();
    }

    private void init() {
        Project[] projects = ProjectManager.getInstance().getOpenProjects();
        for (Project project : projects) {
            Window window = WindowManager.getInstance().suggestParentWindow(project);
            if (window != null && window.isActive()) {
                activeProject = project;
            }
        }
    }
}

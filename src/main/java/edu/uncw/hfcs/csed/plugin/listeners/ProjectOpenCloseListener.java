package edu.uncw.hfcs.csed.plugin.listeners;

import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.components.ServiceManager;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.project.ProjectManagerListener;
import edu.uncw.hfcs.csed.plugin.services.ProjectCountService;
import edu.uncw.hfcs.csed.plugin.session.Alert;
import org.jetbrains.annotations.NotNull;

public class ProjectOpenCloseListener implements ProjectManagerListener {
    /**
     * Invoked on project open.
     *
     * @param project opening project
     */
    @Override
    public void projectOpened(@NotNull Project project) {
        // Ensure this isn't part of testing
        if (ApplicationManager.getApplication().isUnitTestMode()) return;
        // Get the counting service
        ProjectCountService projectCountService = ServiceManager.getService(ProjectCountService.class);
        // Increment the project count
        projectCountService.incrProjectCount();
        // Spawn an alert
        Alert.openProject(project);
    }

    /**
     * Invoked on project close.
     *
     * @param project closing project
     */
    @Override
    public void projectClosed(@NotNull Project project) {
        // Ensure this isn't part of testing
        if (ApplicationManager.getApplication().isUnitTestMode()) return;
        // Get the counting service
        ProjectCountService projectCountService = ServiceManager.getService(ProjectCountService.class);
        // Decrement the count because a project just closed
        projectCountService.decrProjectCount();
        // Spawn an alert
        Alert.closeProject(project);
    }
}

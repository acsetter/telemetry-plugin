package edu.uncw.hfcs.csed.plugin.actions;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.editor.*;
import com.intellij.openapi.project.Project;
import org.jetbrains.annotations.NotNull;

public class EditorAction extends AnAction {
    @Override
    public void actionPerformed(@NotNull AnActionEvent event) {
        final Editor editor = event.getRequiredData(CommonDataKeys.EDITOR);
        final Project project = event.getRequiredData(CommonDataKeys.PROJECT);
        System.out.println(project.getWorkspaceFile().getName());
    }
}

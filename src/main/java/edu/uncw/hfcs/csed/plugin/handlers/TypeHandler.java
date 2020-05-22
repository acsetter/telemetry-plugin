package edu.uncw.hfcs.csed.plugin.handlers;

import edu.uncw.hfcs.csed.plugin.session.Alert;
import com.intellij.codeInsight.editorActions.TypedHandlerDelegate;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiFile;
import org.jetbrains.annotations.NotNull;

public class TypeHandler extends TypedHandlerDelegate {
    @NotNull
    @Override
    public Result charTyped(char c, @NotNull Project project, @NotNull Editor editor, @NotNull PsiFile file) {
        final Document document = editor.getDocument();
        Alert.userType(file);
        return super.charTyped(c, project, editor, file);
    }


}

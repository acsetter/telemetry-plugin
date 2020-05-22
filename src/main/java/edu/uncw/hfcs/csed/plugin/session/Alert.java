package edu.uncw.hfcs.csed.plugin.session;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiFile;
import java.text.SimpleDateFormat;
import java.util.EnumMap;

/**
 * Class used to create telemetry data based on an action in the IDE.
 */
public class Alert {
    private static final SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yy HH:mm:ss");

    public static String create(AlertType type, String name, long time) {
        return alerts.get(type) + ": " + name + " at " + sdf.format(time);
    }

    public static void openProject(Project project) {
        System.out.println(Alert.create(AlertType.PROJECT_OPEN, project.getName(), System.currentTimeMillis()));
    }

    public static void closeProject(Project project) {
        System.out.println(Alert.create(AlertType.PROJECT_CLOSE, project.getName(), System.currentTimeMillis()));
    }

    public static void userType(PsiFile file) {
        System.out.println(Alert.create(AlertType.FILE_EDIT, file.getName(), System.currentTimeMillis()));
    }

    public static void fileCreate(VirtualFile file) {
        System.out.println(create(AlertType.FILE_CREATE, file.getName(), System.currentTimeMillis()));
    }

    public static void fileDelete(VirtualFile file) {
        System.out.println(create(AlertType.FILE_DELETE, file.getName(), System.currentTimeMillis()));
    }

    public static void fileSave(VirtualFile file) {
        System.out.println(create(AlertType.FILE_SAVE, file.getName(), System.currentTimeMillis()));
    }

    private static EnumMap<AlertType, String> alerts = new EnumMap<AlertType, String>(AlertType.class) {{
        put(AlertType.PROJECT_OPEN, "Opening Project");
        put(AlertType.PROJECT_CLOSE, "Closing Project");
        put(AlertType.FILE_CREATE, "Creating File");
        put(AlertType.FILE_DELETE, "Deleting File");
        put(AlertType.FILE_EDIT, "Editing File");
        put(AlertType.FILE_SAVE, "Saving File");
    }};
}

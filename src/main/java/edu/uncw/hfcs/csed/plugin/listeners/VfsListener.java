package edu.uncw.hfcs.csed.plugin.listeners;

import edu.uncw.hfcs.csed.plugin.session.Alert;
import com.intellij.openapi.vfs.newvfs.BulkFileListener;
import com.intellij.openapi.vfs.newvfs.events.VFileEvent;
import org.jetbrains.annotations.NotNull;
import java.util.List;
import java.util.Objects;

/**
 * Listener subscribed to the Virtual File System.
 * Listens for file creation, file deletion, and file save events in the IDE.
 */
public class VfsListener implements BulkFileListener {
    @Override
    public void after(@NotNull List<? extends VFileEvent> events) {
        events.forEach(e -> {
            // Analysis of each event type captured to spawn an alert.
            if(e.isFromSave())
                Alert.fileSave(Objects.requireNonNull(e.getFile()));
            else if(e.toString().startsWith("VfsEvent[create "))
                Alert.fileCreate(Objects.requireNonNull(e.getFile()));
            else if(e.toString().startsWith("VfsEvent[deleted: "))
                Alert.fileDelete(Objects.requireNonNull(e.getFile()));
        });
    }
}

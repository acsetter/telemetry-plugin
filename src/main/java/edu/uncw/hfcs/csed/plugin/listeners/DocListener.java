package edu.uncw.hfcs.csed.plugin.listeners;

import com.intellij.openapi.editor.Document;
import com.intellij.openapi.editor.event.BulkAwareDocumentListener;
import com.intellij.openapi.editor.event.DocumentEvent;
import org.jetbrains.annotations.NotNull;

/**
 * Listener class that can be added to a document.
 * document.addDocumentListener(this);
 */
public class DocListener implements BulkAwareDocumentListener {

    public DocListener() {
    }

    @Override
    public void beforeDocumentChange(@NotNull DocumentEvent event) {
        System.out.println(event.getDocument().getLineCount());
    }

    @Override
    public void documentChanged(@NotNull DocumentEvent event) {
        System.out.println(event.getDocument().getLineCount());
    }

    @Override
    public void beforeDocumentChangeNonBulk(@NotNull DocumentEvent event) {
    }

    @Override
    public void documentChangedNonBulk(@NotNull DocumentEvent event) {
    }

    @Override
    public void bulkUpdateStarting(@NotNull Document document) {
    }

    @Override
    public void bulkUpdateFinished(@NotNull Document document) {
    }
}

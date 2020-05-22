package edu.uncw.hfcs.csed.plugin.models;

import edu.uncw.hfcs.csed.plugin.utils.TimeStamp;
import com.intellij.openapi.project.Project;

/**
 * A lightweight representation of a project in the IDE.
 * TODO: Implement the ProjectModel to track information about an active project.
 */
public class ProjectModel {
    private String name;
    private String path;
    private long initTime;
    private long lastModTime;

    public ProjectModel(Project project) {
        this.name = project.getName();
        this.path = project.getProjectFilePath();
        this.initTime = System.currentTimeMillis();
        this.lastModTime = initTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public long getInitTime() {
        return initTime;
    }

    public void setInitTime(long initTime) {
        this.initTime = initTime;
    }

    public long getLastModTime() {
        return lastModTime;
    }

    public void setLastModTime(long lastModTime) {
        this.lastModTime = lastModTime;
    }

    public String getInitTimeStamp() {
        return TimeStamp.format(initTime);
    }

    public String getLastModTimeStamp() {
        return TimeStamp.format(initTime);
    }
}

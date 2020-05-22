package edu.uncw.hfcs.csed.plugin.services;

public class ProjectCountService {
    // The count of open projects must always be >= 0
    private int openProjectCount = 0;

    public void incrProjectCount() {
        validateProjectCount();
        openProjectCount++;
    }

    public void decrProjectCount() {
        openProjectCount--;
        validateProjectCount();
    }

    public int getOpenProjectCount() {
        return openProjectCount;
    }

    private void validateProjectCount() {
        openProjectCount = Math.max(openProjectCount, 0);
    }
}

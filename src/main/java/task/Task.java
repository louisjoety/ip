package task;

import others.TaskOperations;

public class Task implements TaskOperations {
    protected String description;
    protected boolean isDone;

    //Constructor for task.Task
    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    public String getMarker() {
        String result;
        if (isDone) {
            result = "X";
        } else {
            result = " ";
        }
        return result;
    }

    //Method to mark as undone
    public void setAsUndone() {
        this.isDone = false;
    }

    //Method to mark as done
    public void setAsDone() {
        this.isDone = true;
    }

    /**
     * Adds status icon and converts to a string for the task.
     *
     * @return string of either "[X] description" or "[ ] description".
     */
    public String toString() {
        return "[" + getMarker() + "] " + description;
    }

    public String toFileFormat() {
        String status;
        if (isDone) {
            status = "1";
        } else {
            status = "0";
        }
        return "T | " + status + " | " + description;
    }

}

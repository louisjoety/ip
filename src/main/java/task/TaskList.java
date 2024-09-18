package task;

import java.util.ArrayList;

public class TaskList {
    private ArrayList<Task> tasks;
    private int taskNumber;
    private Task[] tasks;
    private Storage storage;

    //Using ArrayList instead of Array
    public TaskList(){
        tasks = new ArrayList<>();
    public TaskList() {
        taskNumber = 0;
        tasks = new Task[100];
        storage = new Storage();
        loadTasks();
    }

    public int getTaskNumber() {
        return tasks.size();
    }

    /**
     * Storage of new task in the task list.
     *
     * @param task Name of the task is added.
     */
    public void storeTask(Task task) {
        if (taskNumber >= tasks.length) {
            return;
        }
        tasks[taskNumber] = task;
        taskNumber += 1;
        saveTasks();
    }

    /**
     * Displays all tasks in the array.
     *
     * @return A string representing all the tasks.
     */
    public String displayTasks() {
        String taskList = "";
        for (int i = 0; i < tasks.size(); i += 1) {
            taskList += (i + 1) + ". " + tasks.get(i) + "\n";
        }
        return taskList;
    }

    /**
     * Marks the task as done.
     *
     * @param index The task number to be marked as done.
     * @return A confirmation message.
     */
    public String markTaskAsDone(int index) {
        if (index < 1 || index > tasks.size()) {
            return "Invalid task number.";
        }
        Task task = tasks.get(index - 1);
        task.setAsDone();
        saveTasks();
        return "Nice! I've marked this task as done:\n" + task;
    }

    /**
     * Marks the task as undone.
     *
     * @param index The task number to be marked as undone.
     * @return A confirmation message.
     */
    public String markTaskAsNotDone(int index) {
        if (index < 1 || index > tasks.size()) {
            return "Invalid task number.";
        }
        Task task = tasks.get(index - 1);
        task.setAsUndone();
        saveTasks();
        return "OK, I've marked this task as not done yet:\n" + task;
    }

    /**
     * Delete task from ArrayList
     *
     * @param index The task number to be deleted.
     * @return A confirmation message.
     */
    public String deleteTask(int index) {
        if (index < 1 || index > tasks.size()) {
            return "Invalid task number.";
        }
        Task deletedTask = tasks.remove(index - 1);
        return "Noted. I've removed this task:\n"
                + deletedTask +
                "\nNow you have " + tasks.size() + " tasks in the list.";
    }

    public void saveTasks() {
        storage.saveTasks(tasks, taskNumber);
    }

    public void loadTasks() {
        Task[] loadedTasks = storage.loadTasks();
        for (Task task : loadedTasks) {
            if (task != null) {
                tasks[taskNumber++] = task;
            }
        }
    }
}

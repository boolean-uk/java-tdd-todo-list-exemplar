package com.booleanuk.core;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

// Could fairly easily refactor some of these methods so that they called a single method passing it a context to
// do things such as return all/complete/incomplete tasks and return the tasks in ascending/descending order etc.

public class TodoList {
    HashMap<String, String[]> taskList;

    public TodoList() {
        this.taskList = new HashMap<>();
    }

    public boolean add(String title, String taskDetails) {
        if (this.taskList.containsKey(title)) {
            return false;
        } else {
            this.taskList.put(title, new String[] {taskDetails, "Incomplete"});
            return true;
        }
    }

    public String displayAllTasks() {
        String result = "";
        for (HashMap.Entry<String, String[]> entry : this.taskList.entrySet()) {
            String key = entry.getKey();
            String[] item = entry.getValue();
            result += "Title: " + key + " Task: " + item[0] + " Status: " + item[1] +"\n";
        }
        return result;
    }

    public String toggleStatus(String title) {
        if (this.taskList.containsKey(title)) {
            String[] contents = this.taskList.get(title);
            if (contents[1].equals("Complete")) {
                contents[1] = "Incomplete";
            } else {
                contents[1] = "Complete";
            }
            this.taskList.put(title, contents);
            return "Success";
        } else {
            return "Failure";
        }
    }

    public String displayCompletedTasks() {
        String result = "";
        for (HashMap.Entry<String, String[]> entry : this.taskList.entrySet()) {
            String key = entry.getKey();
            String[] item = entry.getValue();
            if (item[1].equals("Complete")) {
                result += "Title: " + key + " Task: " + item[0] + " Status: " + item[1] + "\n";
            }
        }
        return result;
    }

    public String displayIncompleteTasks() {
        String result = "";
        for (HashMap.Entry<String, String[]> entry : this.taskList.entrySet()) {
            String key = entry.getKey();
            String[] item = entry.getValue();
            if (item[1].equals("Incomplete")) {
                result += "Title: " + key + " Task: " + item[0] + " Status: " + item[1] + "\n";
            }
        }
        return result;
    }

    public String getTaskByName(String title) {
        String result = "";
        if (this.taskList.containsKey(title))
        {
            String[] contents = this.taskList.get(title);
            result = "Title: " + title + " Task: " + contents[0] + " Status: " + contents[1];
        } else {
            result = "I'm sorry we couldn't find that item.";
        }
        return result;
    }

    public String remove(String title) {
        String result = "";
        if (this.taskList.containsKey(title)) {
            this.taskList.remove(title);
            result = "Successfully removed task.";
        } else {
            result = "Could not find the task specified.";
        }
        return result;
    }

    public String displayAllTasksAscending() {
        ArrayList<String> theKeys = new ArrayList<>(this.taskList.keySet());
        Collections.sort(theKeys);
        String result = "";
        for (String key : theKeys) {
            String[] contents = this.taskList.get(key);
            result += "Title: " + key + " Task: " + contents[0] + " Status: " + contents[1] +"\n";
        }
        return result;
    }

    public String displayAllTasksDescending() {
        ArrayList<String> theKeys = new ArrayList<>(this.taskList.keySet());
        Collections.sort(theKeys);
        Collections.reverse(theKeys);
        String result = "";
        for (String key : theKeys) {
            String[] contents = this.taskList.get(key);
            result += "Title: " + key + " Task: " + contents[0] + " Status: " + contents[1] +"\n";
        }
        return result;
    }
}

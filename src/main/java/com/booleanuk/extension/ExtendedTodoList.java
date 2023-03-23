package com.booleanuk.extension;

import java.time.LocalDateTime;
import java.util.HashMap;

public class ExtendedTodoList {
    HashMap<String, String[]> taskList;

    public ExtendedTodoList() {
        this.taskList = new HashMap<>();
    }

    public boolean add(String id, String title, String details) {
        if (this.taskList.containsKey(id)) {
            return false;
        } else {
            LocalDateTime timestamp = LocalDateTime.now();
            String when = timestamp.getYear() + " " + timestamp.getMonth() + " " + timestamp.getDayOfMonth()  + " ";
            when += timestamp.getHour() + " " + timestamp.getMinute()  + " " + timestamp.getSecond();
                    this.taskList.put(id, new String[]{title, details, "Incomplete", when});
            return true;
        }
    }

    public String displayTask(String id) {
        String result = "";
        if (this.taskList.containsKey(id)) {
            String[] contents = this.taskList.get(id);
            result = "ID: " + id + " Title: " + contents[0] + " Task: " + contents[1] +  " Status: " + contents[2] + " Timestamp: " + contents[3];
        } else {
            result = "I'm sorry we couldn't find that task.";
        }
        return result;
    }

    public boolean toggleStatus(String id) {
        if (this.taskList.containsKey(id)) {
            String[] contents = this.taskList.get(id);
            if (contents[2].equals("Incomplete")) {
                contents[2] = "Complete";
            } else {
                contents[2] = "Incomplete";
            }
            this.taskList.put(id, contents);
            return true;
        } else {
            return false;
        }
    }

    public boolean updateTitle(String id, String title) {
        if (this.taskList.containsKey(id)) {
            String[] contents = this.taskList.get(id);
            contents[0] = title;
            this.taskList.put(id, contents);
            return true;
        } else {
            return false;
        }

    }
}

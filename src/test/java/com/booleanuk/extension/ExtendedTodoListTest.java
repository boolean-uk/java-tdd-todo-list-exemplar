package com.booleanuk.extension;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

public class ExtendedTodoListTest {

    @Test
    public void addTaskSucceeds() {
        ExtendedTodoList myList = new ExtendedTodoList();
        boolean result = myList.add("1", "Tidy room", "Tidy up all of the stuff in the room.");
        Assertions.assertTrue(result);
    }

    @Test
    public void addTaskFails() {
        ExtendedTodoList myList = new ExtendedTodoList();
        boolean result = myList.add("1", "Tidy room", "Tidy up all of the stuff in the room.");
        result = myList.add("1", "Do washing up", "Wash up all dirty dishes etc.");
        Assertions.assertFalse(result);
    }

    @Test
    public void displayTaskSucceeds() {
        ExtendedTodoList myList = new ExtendedTodoList();
        myList.add("1", "Tidy room", "Tidy up all of the stuff in the room.");
        myList.add("2", "Do washing up", "Wash up all dirty dishes etc.");
        // Could theoretically fail if the seconds change between creating the task and creating this timestamp.
        LocalDateTime timestamp = LocalDateTime.now();
        String when = timestamp.getYear() + " " + timestamp.getMonth() + " " + timestamp.getDayOfMonth()  + " ";
        when += timestamp.getHour() + " " + timestamp.getMinute()  + " " + timestamp.getSecond();

        String task = "ID: 2 Title: Do washing up Task: Wash up all dirty dishes etc. Status: Incomplete Timestamp: " + when;
        Assertions.assertEquals(task, myList.displayTask("2"));
    }

    @Test
    public void displayTaskFails() {
        ExtendedTodoList myList = new ExtendedTodoList();
        myList.add("1", "Tidy room", "Tidy up all of the stuff in the room.");
        myList.add("2", "Do washing up", "Wash up all dirty dishes etc.");
        String result = "I'm sorry we couldn't find that task.";
        Assertions.assertEquals(result, myList.displayTask("3"));

    }

    @Test
    public void checkForTaskCompletedAfterToggle() {
        ExtendedTodoList myList = new ExtendedTodoList();
        myList.add("1", "Tidy room", "Tidy up all of the stuff in the room.");
        myList.add("2", "Do washing up", "Wash up all dirty dishes etc.");
        // Could theoretically fail if the seconds change between creating the task and creating this timestamp.
        LocalDateTime timestamp = LocalDateTime.now();
        String when = timestamp.getYear() + " " + timestamp.getMonth() + " " + timestamp.getDayOfMonth() + " ";
        when += timestamp.getHour() + " " + timestamp.getMinute() + " " + timestamp.getSecond();

        Assertions.assertTrue(myList.toggleStatus("2"));
        String task = "ID: 2 Title: Do washing up Task: Wash up all dirty dishes etc. Status: Complete Timestamp: " + when;
        Assertions.assertEquals(task, myList.displayTask("2"));
    }

    @Test
    public void checkForTaskIncompleteAfterToggle() {
        ExtendedTodoList myList = new ExtendedTodoList();
        myList.add("1", "Tidy room", "Tidy up all of the stuff in the room.");
        myList.add("2", "Do washing up", "Wash up all dirty dishes etc.");
        // Could theoretically fail if the seconds change between creating the task and creating this timestamp.
        LocalDateTime timestamp = LocalDateTime.now();
        String when = timestamp.getYear() + " " + timestamp.getMonth() + " " + timestamp.getDayOfMonth() + " ";
        when += timestamp.getHour() + " " + timestamp.getMinute() + " " + timestamp.getSecond();

        myList.toggleStatus("2");
        myList.toggleStatus("2");
        String task = "ID: 2 Title: Do washing up Task: Wash up all dirty dishes etc. Status: Incomplete Timestamp: " + when;
        Assertions.assertEquals(task, myList.displayTask("2"));
    }

    @Test
    public void checkForFailureOnToggle() {
        ExtendedTodoList myList = new ExtendedTodoList();
        myList.add("1", "Tidy room", "Tidy up all of the stuff in the room.");
        myList.add("2", "Do washing up", "Wash up all dirty dishes etc.");

        Assertions.assertFalse(myList.toggleStatus("3"));
    }

    @Test
    public void checkTaskTitleChanges() {
        ExtendedTodoList myList = new ExtendedTodoList();
        myList.add("1", "Tidy room", "Tidy up all of the stuff in the room.");
        // Could theoretically fail if the seconds change between creating the task and creating this timestamp.
        LocalDateTime timestamp = LocalDateTime.now();
        String when = timestamp.getYear() + " " + timestamp.getMonth() + " " + timestamp.getDayOfMonth() + " ";
        when += timestamp.getHour() + " " + timestamp.getMinute() + " " + timestamp.getSecond();
        myList.add("2", "Do washing up", "Wash up all dirty dishes etc.");

        Assertions.assertTrue(myList.updateTitle("1", "Tidy bedroom"));
        String task = "ID: 1 Title: Tidy bedroom Task: Tidy up all of the stuff in the room. Status: Incomplete Timestamp: " + when;
        Assertions.assertEquals(task, myList.displayTask("1"));
    }


    @Test
    public void checkTaskTitleChangeFailure() {
        ExtendedTodoList myList = new ExtendedTodoList();
        myList.add("1", "Tidy room", "Tidy up all of the stuff in the room.");
        myList.add("2", "Do washing up", "Wash up all dirty dishes etc.");

        Assertions.assertFalse(myList.updateTitle("3", "Tidy bedroom"));
    }
}

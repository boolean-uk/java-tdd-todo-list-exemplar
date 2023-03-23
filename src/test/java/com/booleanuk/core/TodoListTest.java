package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TodoListTest {
    @Test
    public void addTaskSucceeds() {
        TodoList myList = new TodoList();
        boolean result = myList.add("Tidy room", "Tidy up all of the stuff in the room.");
        Assertions.assertTrue(result);
    }

    @Test
    public void addTaskFails() {
        // Adding a task should fail if the title is a duplicate.
        TodoList myList = new TodoList();
        myList.add("Tidy room", "Tidy up all of the stuff in the room.");
        boolean result = myList.add("Tidy room", "Tidy up all of the stuff in the room.");
        Assertions.assertFalse(result);
    }

    @Test
    public void displayAllTasksCorrectly() {
        TodoList myList = new TodoList();
        myList.add("Tidy room", "Tidy up all of the stuff in the room.");
        myList.add("Do washing up", "Wash up all dirty dishes etc.");
        myList.add("Wash clothes", "Do all of the laundry.");

        String result = "Title: Tidy room Task: Tidy up all of the stuff in the room. Status: Incomplete\n";
        result += "Title: Do washing up Task: Wash up all dirty dishes etc. Status: Incomplete\n";
        result += "Title: Wash clothes Task: Do all of the laundry. Status: Incomplete\n";

        Assertions.assertEquals(result, myList.displayAllTasks());
    }

    @Test
    public void checkForTaskCompletedAfterToggle() {
        TodoList myList = new TodoList();
        myList.add("Tidy room", "Tidy up all of the stuff in the room.");
        myList.add("Do washing up", "Wash up all dirty dishes etc.");

        String result = myList.toggleStatus("Tidy room");
        Assertions.assertEquals("Success", result);
        String outcome = "Title: Tidy room Task: Tidy up all of the stuff in the room. Status: Complete\n";
        outcome += "Title: Do washing up Task: Wash up all dirty dishes etc. Status: Incomplete\n";
        Assertions.assertEquals(outcome, myList.displayAllTasks());
    }

    @Test
    public void checkForTaskIncompleteAfterToggle() {
        TodoList myList = new TodoList();
        myList.add("Tidy room", "Tidy up all of the stuff in the room.");
        myList.add("Do washing up", "Wash up all dirty dishes etc.");
        myList.toggleStatus("Tidy room");
        String result = myList.toggleStatus("Tidy room");
        Assertions.assertEquals("Success", result);
        String outcome = "Title: Tidy room Task: Tidy up all of the stuff in the room. Status: Incomplete\n";
        outcome += "Title: Do washing up Task: Wash up all dirty dishes etc. Status: Incomplete\n";
        Assertions.assertEquals(outcome, myList.displayAllTasks());
    }

    @Test
    public void checkForFailureOnToggle() {
        TodoList myList = new TodoList();
        myList.add("Tidy room", "Tidy up all of the stuff in the room.");
        myList.add("Do washing up", "Wash up all dirty dishes etc.");

        String result = myList.toggleStatus("Tidy");
        Assertions.assertEquals("Failure", result);
        String outcome = "Title: Tidy room Task: Tidy up all of the stuff in the room. Status: Incomplete\n";
        outcome += "Title: Do washing up Task: Wash up all dirty dishes etc. Status: Incomplete\n";
        Assertions.assertEquals(outcome, myList.displayAllTasks());
    }

    @Test
    public void displayCompletedTasksCorrectly() {
        TodoList myList = new TodoList();
        myList.add("Tidy room", "Tidy up all of the stuff in the room.");
        myList.add("Do washing up", "Wash up all dirty dishes etc.");
        myList.add("Wash clothes", "Do all of the laundry.");

        myList.toggleStatus("Tidy room");
        myList.toggleStatus("Wash clothes");

        String result = "Title: Tidy room Task: Tidy up all of the stuff in the room. Status: Complete\n";
        result += "Title: Wash clothes Task: Do all of the laundry. Status: Complete\n";

        Assertions.assertEquals(result, myList.displayCompletedTasks());
    }

    @Test
    public void displayIncompleteTasksCorrectly() {
        TodoList myList = new TodoList();
        myList.add("Tidy room", "Tidy up all of the stuff in the room.");
        myList.add("Do washing up", "Wash up all dirty dishes etc.");
        myList.add("Wash clothes", "Do all of the laundry.");

        myList.toggleStatus("Tidy room");
        myList.toggleStatus("Wash clothes");

        String result = "Title: Do washing up Task: Wash up all dirty dishes etc. Status: Incomplete\n";

        Assertions.assertEquals(result, myList.displayIncompleteTasks());
    }

    @Test
    public void displayTaskByTitle() {
        TodoList myList = new TodoList();
        myList.add("Tidy room", "Tidy up all of the stuff in the room.");
        myList.add("Do washing up", "Wash up all dirty dishes etc.");
        myList.add("Wash clothes", "Do all of the laundry.");

        String result = "Title: Do washing up Task: Wash up all dirty dishes etc. Status: Incomplete";

        Assertions.assertEquals(result, myList.getTaskByName("Do washing up"));
    }

    @Test
    public void displayTaskByTitleFailureMessage() {
        TodoList myList = new TodoList();
        myList.add("Tidy room", "Tidy up all of the stuff in the room.");
        myList.add("Do washing up", "Wash up all dirty dishes etc.");
        myList.add("Wash clothes", "Do all of the laundry.");

        String result = "I'm sorry we couldn't find that item.";

        Assertions.assertEquals(result, myList.getTaskByName("Wash up"));
    }

    @Test
    public void removeTaskFromList() {
        TodoList myList = new TodoList();
        myList.add("Tidy room", "Tidy up all of the stuff in the room.");
        myList.add("Do washing up", "Wash up all dirty dishes etc.");
        myList.add("Wash clothes", "Do all of the laundry.");

        String taskList = "Title: Do washing up Task: Wash up all dirty dishes etc. Status: Incomplete\n";
        taskList += "Title: Wash clothes Task: Do all of the laundry. Status: Incomplete\n";

        Assertions.assertEquals("Successfully removed task.", myList.remove("Tidy room"));
        Assertions.assertEquals(taskList, myList.displayAllTasks());
    }

    @Test
    public void failToRemoveTaskFromList() {
        TodoList myList = new TodoList();
        myList.add("Tidy room", "Tidy up all of the stuff in the room.");
        myList.add("Do washing up", "Wash up all dirty dishes etc.");
        myList.add("Wash clothes", "Do all of the laundry.");

        String taskList = "Title: Tidy room Task: Tidy up all of the stuff in the room. Status: Incomplete\n";
        taskList += "Title: Do washing up Task: Wash up all dirty dishes etc. Status: Incomplete\n";
        taskList += "Title: Wash clothes Task: Do all of the laundry. Status: Incomplete\n";

        Assertions.assertEquals("Could not find the task specified.", myList.remove("Tidy bedroom"));
        Assertions.assertEquals(taskList, myList.displayAllTasks());
    }

    @Test
    public void checkSeeTasksInAscendingOrder() {
        TodoList myList = new TodoList();
        myList.add("Tidy room", "Tidy up all of the stuff in the room.");
        myList.add("Do washing up", "Wash up all dirty dishes etc.");
        myList.add("Wash clothes", "Do all of the laundry.");

        String sortedTaskList = "Title: Do washing up Task: Wash up all dirty dishes etc. Status: Incomplete\n";
        sortedTaskList += "Title: Tidy room Task: Tidy up all of the stuff in the room. Status: Incomplete\n";
        sortedTaskList += "Title: Wash clothes Task: Do all of the laundry. Status: Incomplete\n";

        Assertions.assertEquals(sortedTaskList, myList.displayAllTasksAscending());
    }

    @Test
    public void checkSeeTasksInDescendingOrder() {
        TodoList myList = new TodoList();
        myList.add("Tidy room", "Tidy up all of the stuff in the room.");
        myList.add("Do washing up", "Wash up all dirty dishes etc.");
        myList.add("Wash clothes", "Do all of the laundry.");

        String sortedTaskList = "Title: Wash clothes Task: Do all of the laundry. Status: Incomplete\n";
        sortedTaskList += "Title: Tidy room Task: Tidy up all of the stuff in the room. Status: Incomplete\n";
        sortedTaskList += "Title: Do washing up Task: Wash up all dirty dishes etc. Status: Incomplete\n";

        Assertions.assertEquals(sortedTaskList, myList.displayAllTasksDescending());
    }
}

# Core Requirements

- I want to add tasks to my todo list.
- I want to see all the tasks in my todo list.
- I want to change the status of a task between incomplete and complete.
- I want to be able to get only the complete tasks.
- I want to be able to get only the incomplete tasks.
- I want to search for a task and receive a message that says it wasn't found if it doesn't exist.
- I want to remove tasks from my list.
- I want to see all the tasks in my list ordered alphabetically in ascending order.
- I want to see all the tasks in my list ordered alphabetically in descending order.

| Classes  | Members                                       | Methods                               | Scenarios                                             | Outputs                              |
|----------|-----------------------------------------------|---------------------------------------|-------------------------------------------------------|--------------------------------------|
| TodoList | HashMap<String title, String[] task> taskList | add(String title, String taskDetails) | Add a new task to the list.                           | true                                 |
|          |                                               | displayAllTasks()                     | List all tasks in the todo list and their status      | print all tasks to the screen        |
|          |                                               | displayCompletedTasks()               | List completed tasks only                             | print completed tasks to the screen  |
|          |                                               | displayIncompleteTasks()              | List incomplete tasks only                            | print incomplete tasks to the screen |
|          |                                               | displayTask(String title)             | Search for task by title and see task details         | print details of task to the screen  |
|          |                                               |                                       | Search for task by title and see message if not found | print message to screen              |
|          |                                               | removeTask(String title)              | Remove task from list successfully                    | print success message if task found  |
|          |                                               |                                       | Remove task unsuccessful as task not found            | print task not found message         |
|          |                                               | displayAllTasksAscending()            | List all tasks alphabetically in ascending order      | print all tasks in ascending order   |
|          |                                               | displayAllTasksDescending()           | List all tasks alphabetically in descending order     | print all tasks in descending order  |

First attempt will use a String Array to hold the task details and status, if this gets too fiddly then it might be worth replacing it with a separate Task class.
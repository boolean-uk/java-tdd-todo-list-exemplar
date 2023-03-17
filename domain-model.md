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

| Classes  | Members                                       | Methods                               | Scenarios                                                              | Outputs                                                  |
|----------|-----------------------------------------------|---------------------------------------|------------------------------------------------------------------------|----------------------------------------------------------|
| TodoList | HashMap<String title, String[] task> taskList | add(String title, String taskDetails) | Add a new task to the list succeeds.                                   | true                                                     |
|          |                                               |                                       | Add a new task to the list fails if it already exists.                 | false                                                    |
|          |                                               | displayAllTasks()                     | List all tasks in the todo list and their status                       | return a string containing all tasks                     |
|          |                                               | changeStatusOfTask(String title)      | Successfully change the status of a task                               | return a string with success message                     |
|          |                                               |                                       | Successfully change the status of a task because the title isn't found | return a string with failure message                     |
|          |                                               | displayCompletedTasks()               | List completed tasks only                                              | return a string containing completed tasks               |
|          |                                               | displayIncompleteTasks()              | List incomplete tasks only                                             | return a string containing incomplete tasks              |
|          |                                               | displayTask(String title)             | Search for task by title and see task details                          | return a string containing  details of task              |
|          |                                               |                                       | Search for task by title and see message if not found                  | return a string containing the message                   |
|          |                                               | removeTask(String title)              | Remove task from list successfully                                     | return a string containing success message if task found |
|          |                                               |                                       | Remove task unsuccessful as task not found                             | return a string containing task not found message        |
|          |                                               | displayAllTasksAscending()            | List all tasks alphabetically in ascending order                       | return a string containing all tasks in ascending order  |
|          |                                               | displayAllTasksDescending()           | List all tasks alphabetically in descending order                      | return a string containing all tasks in descending order |

First attempt will use a String Array to hold the task details and status, if this gets too fiddly then it might be worth replacing it with a separate Task clas
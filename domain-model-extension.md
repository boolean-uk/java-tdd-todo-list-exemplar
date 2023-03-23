# Extension Requirements

- I want to be able to get a task by a unique ID.
- I want to update the name of a task by providing its ID and a new name.
- I want to be able to change the status of a task by providing its ID.
- I want to be able to see the date and time that I created each task.

| Classes  | Members                                       | Methods                                          | Scenarios                                               | Outputs                               |
|----------|-----------------------------------------------|--------------------------------------------------|---------------------------------------------------------|---------------------------------------|
| TodoList | HashMap<String id, String[] task> taskList    | add(String id, String title, String taskDetails) | Add a new task to the list succeeds.                    | true                                  |                                                    |
|          |                                               |                                                  | Add a new task to the list fails if it already exists.  | false                                 | 
|          |                                               | update(String id, String title)                  | Update the task if the id exists                        | true                                  |
|          |                                               |                                                  | Signal failure if the id does not exist                 | false                                 |
|          |                                               | toggleStatus(String id)                          | Toggle the status if the id exists                      | true                                  |
|          |                                               |                                                  | Signal failure if the id does not exist                 | false                                 |
|          |                                               | displayTask(String id)                           | Show the task with the given id including creation time | Task details                          |
|          |                                               |                                                  | Show a failure message if the id doesn't exist          | Failure message as task doesn't exist |

Will reimplement the taskList from the Core part as a Hashmap using the id string as the key and incorporating the title and a timestamp into the constructor.
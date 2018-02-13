package umm3601.todo;

import com.google.gson.Gson;

import javax.script.ScriptEngine;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;

/**
 * A fake "database" of user info
 *
 * Since we don't want to complicate this lab with a real database,
 * we're going to instead just read a bunch of user data from a
 * specified JSON file, and then provide various database-like
 * methods that allow the `UserController` to "query" the "database".
 */
public class TodoDatabase {

  private Todo[] allTodos;

  public TodoDatabase(String todoDataFile) throws IOException {
    Gson gson = new Gson();
    FileReader reader = new FileReader(todoDataFile);
    allTodos = gson.fromJson(reader, Todo[].class);
  }

  /**
   * Get the single todo specified by the given ID. Return
   * `null` if there is no todo with that ID.
   *
   * @param id the ID of the desired todo
   * @return the todo with the given ID, or null if there is no todo
   * with that ID
   */
  public Todo getTodo(String id) {
    return Arrays.stream(allTodos).filter(x -> x._id.equals(id)).findFirst().orElse(null);
  }

  /**
   * Get an array of all the todos satisfying the queries in the params.
   *
   * @param queryParams map of required key-valuimport umm3601.todo.TodoController;e pairs for the query
   * @return an array of all the todos matching the given criteria
   */
  public Todo[] listTodos(Map<String, String[]> queryParams) {
    Todo[] filteredTodos = allTodos;

    // Filter complete if defined

    if (queryParams.containsKey("status")) {
      String targetStatus = queryParams.get("status")[0];

      if (targetStatus.equals("complete")) {
        filteredTodos = filterTodosByStatus(filteredTodos, true);
      } else if (targetStatus.equals("incomplete")) {
        filteredTodos = filterTodosByStatus(filteredTodos, false);
      }
    }

    if (queryParams.containsKey("contains")) {
      String targetContains = queryParams.get("contains")[0];
      filteredTodos = filterTodosByContains(filteredTodos, targetContains);
    }

    if(queryParams.containsKey("owner")){
      String targetOwners = queryParams.get("owner")[0];
      filteredTodos = filterTodosByOwners(filteredTodos, targetOwners);
    }

    if(queryParams.containsKey("category")){
      String targetCategory = queryParams.get("category")[0];
      filteredTodos = filterTodosByCategory(filteredTodos, targetCategory);
    }

    if (queryParams.containsKey("limit")) {
      int targetLimit = Integer.parseInt(queryParams.get("limit")[0]);
      filteredTodos = filterTodosByLimit(filteredTodos, targetLimit);
    }

    if(queryParams.containsKey("orderBy")){
      String targetOrder = queryParams.get("orderBy")[0];
      filteredTodos = filterTodosByOrder(filteredTodos, targetOrder);
    }



    // Process other query parameters here...

    return filteredTodos;
  }

  /**
   * Get an array of all the todos having the target status.
   *
   * @param todos        the list of todos to filter by status
   * @param targetStatus the target status to look for
   * @return an array of all the users from the given list that have
   * the target age
   */
  public Todo[] filterTodosByStatus(Todo[] todos, boolean targetStatus) {
    return Arrays.stream(todos).filter(x -> x.status == targetStatus).toArray(Todo[]::new);
  }

  public Todo[] filterTodosByLimit(Todo[] todos, int targetLimit) {
    return Arrays.stream(todos).limit(targetLimit).toArray(Todo[]::new);

  }
  public Todo[] filterTodosByContains(Todo[] todos, String targetContains) {
    return Arrays.stream(todos).filter(x -> x.body.toLowerCase().contains(targetContains.toLowerCase())).toArray(Todo[]::new);

  }

  public Todo[] filterTodosByOwners(Todo[] todos, String targetOwners){
    return Arrays.stream(todos).filter(x -> x.owner.toLowerCase().contains(targetOwners.toLowerCase())).toArray(Todo[]::new);
  }

  public Todo[] filterTodosByCategory(Todo[] todos, String targetCategory){
    return Arrays.stream(todos).filter(x -> x.category.equals (targetCategory)).toArray(Todo[]::new);
  }

  public Todo[] filterTodosByOrder(Todo[] todos, String targetOrder){
    Arrays.sort(todos, ((o1, o2) ->
    {
      if (targetOrder.equals("status")) {
        int x = 0;
        int y = 0;
        if (o1.status) { x = 1; }
        if (o2.status) { y = 1; }
        return x - y;
      }

      if (targetOrder.equals("owner")) {
        return o1.owner.compareToIgnoreCase(o2.owner);
      }

      if (targetOrder.equals("category")) {
        return o1.category.compareToIgnoreCase(o2.category);
      }

      if (targetOrder.equals("body")) {
        return o1.body.compareToIgnoreCase(o2.body);
      }

      if (targetOrder.equals("_id")) {
        return o1._id.compareToIgnoreCase(o2._id);
      }

      return 0;
    }));

    return todos;
  }

}

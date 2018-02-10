package umm3601.todo;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import spark.Request;
import spark.Response;

import static umm3601.Util.*;

/**
 * Controller that manages requests for info about todos.
 */
public class TodoController {

  private final Gson gson;
  private TodoDatabase todoDatabase;

  /**
   * Construct a controller for todos.
   *
   * This loads the "todoDatabase" of user info from a JSON file and
   * stores that internally so that (subsets of) todos can be returned
   * in response to requests.
   *
   * @param todoDatabase the todoDatabase containing todo data
   */
  public TodoController(TodoDatabase todoDatabase) {
    gson = new Gson();
    this.todoDatabase = todoDatabase;
  }

  /**
   * Get the single todo specified by the `id` parameter in the request.
   *
   * @param req the HTTP request
   * @param res the HTTP response
   * @return a success JSON object if the todo with that ID is found, a fail
   * JSON object if no todo with that ID is found
   */
  public JsonObject getTodo(Request req, Response res) {
    res.type("application/json");
    String id = req.params("id");
    Todo todo = todoDatabase.getTodo(id);
    if (todo != null) {
      return buildSuccessJsonResponse("todo", gson.toJsonTree(todo));
    } else {
      String message = "Todo with ID " + id + " wasn't found.";
      return buildFailJsonResponse("id", message);
    }
  }

  /**
   * Get a JSON response with a list of all the todos in the "todoDatabase".
   *
   * @param req the HTTP request
   * @param res the HTTP response
   * @return a success JSON object containing all the todos
   */
  public JsonObject getTodos(Request req, Response res) {
    res.type("application/json");
    Todo[] users = todoDatabase.listTodos(req.queryMap().toMap());
    return buildSuccessJsonResponse("todos", gson.toJsonTree(users));
  }

}

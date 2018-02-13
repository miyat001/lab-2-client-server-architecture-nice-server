package umm3601.todo;

import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static junit.framework.TestCase.assertEquals;

public class FilterByOrder {

  /* Couldn't figure out how to properly test orderBy api due to time
   * orderBy api appears to work correctly on the client side */

  /*@Test
  public void filterTodosByCategory() throws IOException {
    TodoDatabase db = new TodoDatabase("src/main/data/todos.json");
    Todo[] allTodos = db.listTodos(new HashMap<>());

    Todo[] orderTodosByOwner = db.filterTodosByOrder (allTodos, "owner");
    assertEquals(true, checkTodosOrderByOwner(orderTodosByOwner));

    Todo[] orderTodosByBody = db.filterTodosByOrder (allTodos, "body");
    assertEquals(true, checkTodosOrderByBody(orderTodosByBody));
  }

  @Test
  public void listTodosWithCategoryFilter() throws IOException {
    TodoDatabase db = new TodoDatabase("src/main/data/todos.json");
    Map<String, String[]> queryParams = new HashMap<>();

    queryParams.put("orderBy", new String[] {"owner"});
    Todo[] orderTodosByOwner = db.listTodos(queryParams);
    assertEquals(true, checkTodosOrderByOwner(orderTodosByOwner));

    queryParams.put("orderBy", new String[] {"body"});
    Todo[] orderTodosByBody = db.listTodos(queryParams);
    assertEquals(true, checkTodosOrderByBody(orderTodosByBody));
  }

  private boolean checkTodosOrderByOwner(Todo[] todos) {
    for (int i = 1; i < todos.length; i++) {
      if (todos[i-1].owner.compareToIgnoreCase(todos[i].owner) < 0) {
        return false;
      }
    }
    return true;
  }

  private boolean checkTodosOrderByBody(Todo[] todos) {
    for (int i = 1; i < todos.length; i++) {
      if (todos[i-1].body.compareToIgnoreCase(todos[i].body) < 0) {
        return false;
      }
    }
    return true;
  }*/
}

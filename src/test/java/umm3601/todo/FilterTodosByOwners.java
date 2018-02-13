package umm3601.todo;

import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static junit.framework.TestCase.assertEquals;

public class FilterTodosByOwners {
  @Test
  public void filterTodosByOwners() throws IOException {
    TodoDatabase db = new TodoDatabase("src/main/data/todos.json");
    Todo[] allTodos = db.listTodos(new HashMap<>());

    Todo[] blancheOwnersTodos = db.filterTodosByOwners (allTodos, "Blanche");
    assertEquals("Incorrect Owners of todos with owners true", 43, blancheOwnersTodos.length);

    Todo[] fryOwnersTodos = db.filterTodosByOwners(allTodos, "Fry");
    assertEquals("Incorrect Owners of todos with owners false", 61, fryOwnersTodos.length);
  }

  @Test
  public void listTodosWithOwnersFilter() throws IOException {
    TodoDatabase db = new TodoDatabase("src/main/data/todos.json");
    Map<String, String[]> queryParams = new HashMap<>();

    queryParams.put("owner", new String[] {"Blanche"});
    Todo[] blancheOwnersTodos = db.listTodos(queryParams);
    assertEquals("Incorrect owners of todos with owner true", 43, blancheOwnersTodos.length);

    queryParams.put("owner", new String[] {"Fry"});
    Todo[] fryOwnersTodos = db.listTodos(queryParams);
    assertEquals("Incorrect owners of todos with owner false", 61, fryOwnersTodos.length);
  }
}

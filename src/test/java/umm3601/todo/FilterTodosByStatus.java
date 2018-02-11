package umm3601.todo;

import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static junit.framework.TestCase.assertEquals;

public class FilterTodosByStatus {
  @Test
  public void filterUsersByAge() throws IOException {
    TodoDatabase db = new TodoDatabase("src/main/data/todos.json");
    Todo[] allTodos = db.listTodos(new HashMap<>());

    Todo[] trueStatusTodos = db.filterTodosByStatus (allTodos, true);
    assertEquals("Incorrect number of todos with status true", 143, trueStatusTodos.length);

    Todo[] falseStatusTodos = db.filterTodosByStatus(allTodos, false);
    assertEquals("Incorrect number of todos with status false", 157, falseStatusTodos.length);
  }

  @Test
  public void listUsersWithAgeFilter() throws IOException {
    TodoDatabase db = new TodoDatabase("src/main/data/todos.json");
    Map<String, String[]> queryParams = new HashMap<>();

    queryParams.put("status", new String[] {"true"});
    Todo[] trueStatusTodos = db.listTodos(queryParams);
    assertEquals("Incorrect number of todos with status true", 143, trueStatusTodos.length);

    queryParams.put("status", new String[] {"false"});
    Todo[] falseStatusTodos = db.listTodos(queryParams);
    assertEquals("Incorrect number of todos with status false", 157, falseStatusTodos.length);
  }

}

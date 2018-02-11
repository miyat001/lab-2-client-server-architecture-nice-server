package umm3601.todo;

import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import static junit.framework.TestCase.assertEquals;

public class FilterTodosByLimit {
  @Test
  public void filterTodosByLimit() throws IOException {
    TodoDatabase db = new TodoDatabase("src/main/data/todos.json");
    Todo[] allTodos = db.listTodos(new HashMap<>());

    Todo[] sevenLimitTodos = db.filterTodosByLimit (allTodos, 7);
    assertEquals("Incorrect number of todos with limit 7", 7, sevenLimitTodos.length);

    Todo[] tenLimitTodos = db.filterTodosByLimit(allTodos, 10);
    assertEquals("Incorrect number of todos with limit 10", 10, tenLimitTodos.length);
  }

  @Test
  public void listTodosWithLimitFilter() throws IOException {
    TodoDatabase db = new TodoDatabase("src/main/data/todos.json");
    Map<String, String[]> queryParams = new HashMap<>();

    queryParams.put("limit", new String[] {"7"});
    Todo[] sevenLimitTodos = db.listTodos(queryParams);
    assertEquals("Incorrect number of todos with limit 7", 7, sevenLimitTodos.length);

    queryParams.put("limit", new String[] {"10"});
    Todo[] tenLimitTodos
      = db.listTodos(queryParams);
    assertEquals("Incorrect number of todos with limit 10", 10, tenLimitTodos.length);
  }
}

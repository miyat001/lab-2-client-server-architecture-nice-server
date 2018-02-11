package umm3601.todo;

import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static junit.framework.TestCase.assertEquals;

public class FilterTodosByContains {

  @Test
  public void filterTodosByContains() throws IOException {
    TodoDatabase db = new TodoDatabase("src/main/data/todos.json");
    Todo[] allTodos = db.listTodos(new HashMap<>());

    Todo[] containsSuntTodos = db.filterTodosByContains (allTodos, "sunt");
    assertEquals("Incorrect number of todos that contains sunt", 92, containsSuntTodos.length);

    Todo[] containsBananaTodos = db.filterTodosByContains(allTodos, "banana");
    assertEquals("Incorrect number of todos that contains banana", 0, containsBananaTodos.length);
  }

  @Test
  public void listTodosWithContainsFilter() throws IOException {
    TodoDatabase db = new TodoDatabase("src/main/data/todos.json");
    Map<String, String[]> queryParams = new HashMap<>();

    queryParams.put("contains", new String[] {"sunt"});
    Todo[] containsSuntTodos = db.listTodos(queryParams);
    assertEquals("Incorrect number of todos containing sunt", 92, containsSuntTodos.length);

    queryParams.put("contains", new String[] {"banana"});
    Todo[] containsBananaTodos = db.listTodos(queryParams);
    assertEquals("Incorrect number of todos containing banana", 0, containsBananaTodos.length);
  }
}

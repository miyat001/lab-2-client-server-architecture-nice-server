package umm3601.todo;

import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static junit.framework.TestCase.assertEquals;

public class FilterByCategory {
  @Test
  public void filterTodosByCategory() throws IOException {
    TodoDatabase db = new TodoDatabase("src/main/data/todos.json");
    Todo[] allTodos = db.listTodos(new HashMap<>());

    Todo[] groceriesCategoryTodos = db.filterTodosByCategory (allTodos, "video games");
    assertEquals("Incorrect Category of todos with category true", 71, groceriesCategoryTodos.length);

    Todo[] homeworkCategoryTodos = db.filterTodosByCategory (allTodos, "homework");
    assertEquals("Incorrect Category of todos with category false", 79, homeworkCategoryTodos.length);
  }

  @Test
  public void listTodosWithCategoryFilter() throws IOException {
    TodoDatabase db = new TodoDatabase("src/main/data/todos.json");
    Map<String, String[]> queryParams = new HashMap<>();

    queryParams.put("category", new String[] {"video games"});
    Todo[] groceriesCategoryTodos = db.listTodos(queryParams);
    assertEquals("Incorrect category of todos with category true", 71, groceriesCategoryTodos.length);

    queryParams.put("category", new String[] {"homework"});
    Todo[] homeworkCategoryTodos = db.listTodos(queryParams);
    assertEquals("Incorrect category of todos with category false", 79, homeworkCategoryTodos.length);
  }
}

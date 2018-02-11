package umm3601.todo;

import org.junit.Test;

import java.io.IOException;

import static junit.framework.TestCase.assertEquals;

public class GetTodoByID {

  @Test
  public void getBlanche() throws IOException {
    TodoDatabase db = new TodoDatabase("src/main/data/todos.json");
    Todo todo = db.getTodo("58895985a22c04e761776d54");
    assertEquals("Incorrect name", "Blanche", todo.owner);
  }

  @Test
  public void getFry() throws IOException {
    TodoDatabase db = new TodoDatabase("src/main/data/todos.json");
    Todo todo = db.getTodo("588959852af9def8ad69f6a2");
    assertEquals("Incorrect name", "Fry", todo.owner);
  }
}

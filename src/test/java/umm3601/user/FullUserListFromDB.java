package umm3601.user;

import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;

/**
 * Tests umm3601.user.TodoDatabase listUser functionality
 */
public class FullUserListFromDB {

    @Test
    public void totalUserCount() throws IOException {
        Database db = new Database("src/main/data/users.json");
        User[] allUsers = db.listUsers(new HashMap<>());
        assertEquals("Incorrect total number of users", 10, allUsers.length);
    }

    @Test
    public void firstUserInFullList() throws IOException {
      Database db = new Database("src/main/data/users.json");
        User[] allUsers = db.listUsers(new HashMap<>());
        User firstUser = allUsers[0];
        assertEquals("Incorrect name", "Connie Stewart", firstUser.name);
        assertEquals("Incorrect age", 25, firstUser.age);
        assertEquals("Incorrect company", "OHMNET", firstUser.company);
        assertEquals("Incorrect e-mail", "conniestewart@ohmnet.com", firstUser.email);
    }
}

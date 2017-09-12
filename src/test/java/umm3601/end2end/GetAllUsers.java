package umm3601.end2end;

import org.fluentlenium.adapter.junit.FluentTest;
import org.fluentlenium.core.hook.wait.Wait;

import org.junit.Test;

import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;

@Wait
public class GetAllUsers extends FluentTest {
  @Test
  public void noUsersBeforeClick() {
    goTo("http://0.0.0.0:4567/users.html");
//    await().atMost(5, TimeUnit.SECONDS).until(el("#jsonDump")).present();
    assertThat($("#jsonDump").textContent()).contains("Json will go here");
  }

  @Test
  public void clickingIsSuccessful() {
    goTo("http://0.0.0.0:4567/users.html");
//    await().atMost(5, TimeUnit.SECONDS).until(el("#getAll")).present();
    $("#getAll").click();
//    await().atMost(5, TimeUnit.SECONDS).until($("#jsonDump", withText().startsWith("{\"status\""))).present();
//    await().explicitlyFor(5, TimeUnit.SECONDS);
    assertThat($("#jsonDump").textContent()).contains("\"status\":\"success\"");
  }
}

/*
import org.fluentlenium.adapter.junit.FluentTest;
  import org.fluentlenium.core.hook.wait.Wait;
  import org.junit.Test;

  import java.util.concurrent.TimeUnit;

  import static org.assertj.core.api.Assertions.assertThat;

@Wait
public class DuckDuckGoTest extends FluentTest {
  @Test
  public void titleOfDuckDuckGoShouldContainSearchQueryName() {
    goTo("https://duckduckgo.com");
    $("#search_form_input_homepage").fill().with("FluentLenium");
    $("#search_button_homepage").submit();
    await().atMost(5, TimeUnit.SECONDS).until(el("#search_form_homepage")).not().present();
    assertThat(window().title()).contains("FluentLenium");
  }
}
*/

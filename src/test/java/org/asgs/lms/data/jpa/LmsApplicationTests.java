package org.asgs.lms.data.jpa;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Integration test to run the application.
 *
 * @author Oliver Gierke
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("scratch")
// Separate profile for web tests to avoid clashing databases
public class LmsApplicationTests {

  @Autowired private WebApplicationContext context;

  private MockMvc mvc;

  @Before
  public void setUp() {
    this.mvc = MockMvcBuilders.webAppContextSetup(this.context).build();
  }

  @Test
  public void testHome() throws Exception {
    String city = "Bath";
    String country = "UK";
    String state = "Somerset";
    String expected =
        String.format(
            "The city of %s in the country %s is located in the state %s", city, country, state);
    this.mvc
        .perform(get("/?city=" + city + "&country=" + country))
        .andExpect(status().isOk())
        .andExpect(content().string(expected));
  }
}

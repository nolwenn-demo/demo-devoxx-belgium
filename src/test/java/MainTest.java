import com.google.zxing.WriterException;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.authenticator.Main;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainTest {


  private final InputStream originalSystemIn = System.in;
  private final PrintStream originalSystemOut = System.out;

  private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

  @BeforeEach
  void setUp() {
    System.setOut(new PrintStream(outputStreamCaptor));
  }

  @AfterEach
  void tearDown() {
    System.setIn(originalSystemIn);
    System.setOut(originalSystemOut);
  }

  @Test
  void testMainFailure() throws IOException, WriterException {
    // Simulate user input
    String simulatedUserInput = "654321"; // Replace with an invalid TOTP code

    ByteArrayInputStream inputStream = new ByteArrayInputStream(simulatedUserInput.getBytes());
    System.setIn(inputStream);

    // Redirect System.out to capture console output
    ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outputStreamCaptor));

    // Run the main method
    Main.main(new String[]{});
  }
}

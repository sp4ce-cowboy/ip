package duke;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class UiTest {

    private final ByteArrayOutputStream outContent =
            new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    /*@Test
    public void tabPrinter_HelloWorld_correctOutput() {
        Ui ui = new Ui();
        ui.tabPrinter("Hello World");

        String expected = "      Hello World";
        assertEquals(expected, outContent.toString());
    }*/

}

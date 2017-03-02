package it.esteco.pos.adapters;

import it.esteco.pos.domain.Money;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class ConsoleDisplayTest {

    private final ConsoleDisplay display = new ConsoleDisplay();

    @Test
    public void displayPrice() throws Exception {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        display.displayPrice(new Money(0));

        assertThat(outputStream.toString().trim(), is(equalTo("$0.00")));
    }
}

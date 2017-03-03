package it.esteco.pos.domain;

import org.jmock.Expectations;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.junit.Rule;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class BarcodeValidatorTest {

    @Rule
    public JUnitRuleMockery context = new JUnitRuleMockery();
    private Display display = context.mock(Display.class);

    private BarcodeValidator validator = new BarcodeValidator(display);

    @Test
    public void validBarcodeText() throws Exception {
        assertThat(validator.validate("12345"), is(true));
    }

    @Test
    public void emptyBarcodeText() throws Exception {
        context.checking(new Expectations(){{
            oneOf(display).displayEmptyBarcodeError();
        }});

        assertThat(validator.validate(""), is(false));
    }
}

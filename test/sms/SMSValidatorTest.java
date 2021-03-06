package sms;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;

/**
 * @author Krasimir Raikov(raikov.krasimir@gmail.com)
 */
@RunWith(Parameterized.class)
public class SMSValidatorTest {
    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"0", "gfre", "message3"},{"0000000000", "", "message3"},
                {"0899232323", "title4", ""}, {"0878787878", "t5", "qqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqq" +
                "qqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqq"}
        });
    }

    private String number;
    private String title;
    private String message;

    public SMSValidatorTest(String number, String title, String message) {

        this.number = number;
        this.title = title;
        this.message = message;
    }

    @Test
    public void realSMSIsValid() {
        SMSValidator validator = new SMSValidator(10, new MessageRange(1, 120));
        Recipient recipient = new Recipient("tony", "0888888888");
        boolean valid = validator.validate(recipient.number(), "title", "message");
        assertThat(valid, is(equalTo(true)));
    }

    @Test(expected = IllegalArgumentException.class)
    public void invalidNumberThrowsException() {
        SMSValidator validator = new SMSValidator(10, new MessageRange(1, 120));
        Recipient recipient = new Recipient("mark", "");
        validator.validate(recipient.number(), "re", "twe");
    }

    @Test
    public void returnsFalse() {
        SMSValidator validator = new SMSValidator(10, new MessageRange(1, 120));
        Recipient recipient = new Recipient("mark", number);
        assertThat(validator.validate(recipient.number(), title, message), is(equalTo(false)));
    }


}

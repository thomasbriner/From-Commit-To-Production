package ch.hsr.mge.gadgeothek.dummy;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;

public class StringAppenderTest {

    @Test
    public void shouldAppend() {
        StringAppender appender = new StringAppender("abc");

        String result = appender.append("def");

        Assert.assertThat(result, Is.is("abcdef"));
    }
}
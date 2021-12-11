package org.jooq;

import org.jooq.tools.Convert;
import org.jooq.conf.ParseBackslashEscaping;
import org.junit.Test;
import org.junit.Assert;

import java.time.LocalDateTime;
import java.time.Month;
import java.sql.Timestamp;



public class ZuhairTests {

    // CS 427 issue link: github.com/jOOQ/jOOQ/issues/12547
    @Test
    public void testYearDateConversion() throws ClassNotFoundException {
        LocalDateTime res = (LocalDateTime) Convert.convert("2007-12-03T10:15:30",  Class.forName("java.time.LocalDateTime"));
        LocalDateTime expected = LocalDateTime.of(2007, Month.DECEMBER, 3, 10, 15, 30);
        Assert.assertEquals(expected, res);
    }

    // CS 427 issue link: github.com/jOOQ/jOOQ/issues/12547
    @Test
    public void test3DigitYearDateConversion() throws ClassNotFoundException {
        LocalDateTime res = (LocalDateTime) Convert.convert("0201-12-03T10:15:30", Class.forName("java.time.LocalDateTime"));
        LocalDateTime expected = LocalDateTime.of(201, Month.DECEMBER, 3, 10, 15, 30);
        Assert.assertEquals(expected, res);
    }

    // CS 427 issue link: github.com/jOOQ/jOOQ/issues/12547
    @Test
    public void testInvalidDateConversion() throws ClassNotFoundException {
        LocalDateTime res = (LocalDateTime) Convert.convert("0202-03T10:15:30", Class.forName("java.time.LocalDateTime"));
        Assert.assertNull(res);
    }

    // CS 427 issue link: github.com/jOOQ/jOOQ/issues/12547
    @Test
    public void testTimestampConversion() throws ClassNotFoundException {
        Timestamp res = (Timestamp) Convert.convert("2007-12-03T10:15:30",  Class.forName("java.sql.Timestamp"));
        LocalDateTime expectedDate = LocalDateTime.of(2007, Month.DECEMBER, 3, 10, 15, 30);
        Timestamp expected = Timestamp.valueOf(expectedDate);
        Assert.assertEquals(expected, res);
    }

    // CS 427 issue link: github.com/jOOQ/jOOQ/issues/12553
    @Test
    public void testParseBackslashEscapingValueOf() {
        Assert.assertEquals("DEFAULT", ParseBackslashEscaping.DEFAULT.value());
        Assert.assertEquals("ON", ParseBackslashEscaping.ON.value());
        Assert.assertEquals("OFF", ParseBackslashEscaping.OFF.value());
    }

    // CS 427 issue link: github.com/jOOQ/jOOQ/issues/12553
    @Test
    public void testParseBackslashEscapingFromValue() {
        Assert.assertEquals(ParseBackslashEscaping.fromValue("DEFAULT"), ParseBackslashEscaping.DEFAULT);
        Assert.assertEquals(ParseBackslashEscaping.fromValue("ON"), ParseBackslashEscaping.ON);
        Assert.assertEquals(ParseBackslashEscaping.fromValue("OFF"), ParseBackslashEscaping.OFF);
    }
}

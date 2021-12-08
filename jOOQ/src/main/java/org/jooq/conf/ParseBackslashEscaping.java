
package org.jooq.conf;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ParseBackslashEscaping.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <pre>
 * &lt;simpleType name="BackslashEscaping"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="DEFAULT"/&gt;
 *     &lt;enumeration value="ON"/&gt;
 *     &lt;enumeration value="OFF"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 *
 */
@XmlType(name = "ParseBackslashEscaping")
@XmlEnum
public enum ParseBackslashEscaping {

    DEFAULT,
    ON,
    OFF;

    /**
     * Get the string name of the enum value.
     * @return - string representation of the enum value
     */
    public String value() {
        return name();
    }

    /**
     * Return the enum value from the string name.
     * @param value - the string name of the enum value.
     * @return - The enum value represented by the string.
     */
    public static ParseBackslashEscaping fromValue(final String value) {
        return valueOf(value);
    }

}

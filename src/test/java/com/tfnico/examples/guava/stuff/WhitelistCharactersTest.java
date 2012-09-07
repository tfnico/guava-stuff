package com.tfnico.examples.guava.stuff;

import org.junit.Test;

import static com.tfnico.examples.guava.stuff.WhitelistCharacters.VALID_NAME_CHAR_SET;
import static com.tfnico.examples.guava.stuff.WhitelistCharacters.findInvalidChars;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.matchers.JUnitMatchers.hasItems;

public class WhitelistCharactersTest {

    @Test
    public void validName() {
        String name = "Thomas";
        assertTrue(findInvalidChars(name, WhitelistCharacters.VALID_NAME_CHAR_SET).isEmpty());
    }

    @Test
    public void invalidName() {
        String name = "<Thomas>";
        assertThat(findInvalidChars(name, VALID_NAME_CHAR_SET), hasItems('<', '>'));
    }

    @Test
    public void prettyListOfInvalidChars() {
        String name = "<Th0mas>";
        assertEquals("<, 0, >", WhitelistCharacters.printChars(findInvalidChars(name, VALID_NAME_CHAR_SET)));
    }
}

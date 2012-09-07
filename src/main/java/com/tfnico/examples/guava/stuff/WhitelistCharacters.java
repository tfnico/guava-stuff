package com.tfnico.examples.guava.stuff;

import com.google.common.base.Joiner;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets;
import com.google.common.primitives.Chars;

public class WhitelistCharacters {


    public static ImmutableSet<Character> findInvalidChars(String name, ImmutableSet<Character> validCharSet) {
        return Sets.difference(stringToCharSet(name), validCharSet).immutableCopy();
    }

    public static String printChars(Iterable<Character> chars) {
        return Joiner.on(", ").join(chars);
    }

    private static final String VALID_NAME_CHAR_SEQ = " ',-./" +
            "ABCDEFGHIJKLMNO" +
            "PQRSTUVWXYZ\\_" +
            "`abcdefghijklmnopqrstuvwxyz°Žµ·žŒœŸ" +
            "ÀÁÂÃÄÅÆÇÈÉÊËÌÍÎÏ" +
            "ÐÑÒÓÔÕÖØÙÚÛÜÝÞß" +
            "àáâãäåæçèéêëìíîï" +
            "ðñòóôõöøùúûüýþÿ";


    private static ImmutableSet<Character> stringToCharSet(String validChars) {
        return ImmutableSet.copyOf(Chars.asList(validChars.toCharArray()));
    }

    public static final ImmutableSet<Character> VALID_NAME_CHAR_SET = stringToCharSet(VALID_NAME_CHAR_SEQ);
}

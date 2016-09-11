package test;

import CS3219.RequiredWords;
import org.junit.Test;

import static org.junit.Assert.*;

public class RequiredWordsTest {

    @Test
    public void testIsRequiredWords() throws Exception {
    	RequiredWords requiredWords = RequiredWords.getRequiredWords();

        assertFalse(requiredWords.isRequiredWords("Star"));

        requiredWords.addRequiredWords("Star");
        requiredWords.addRequiredWords("Space");
        requiredWords.addRequiredWords("");
        assertTrue(requiredWords.isRequiredWords("Star"));
        assertTrue(requiredWords.isRequiredWords("Space"));
        assertTrue(requiredWords.isRequiredWords(""));
        assertFalse(requiredWords.isRequiredWords("Day"));
        assertFalse(requiredWords.isRequiredWords("Fast"));

        requiredWords.addRequiredWords("Star"); // add duplicated word
        requiredWords.addRequiredWords("Day");
        requiredWords.removeRequiredWords("Star");
        requiredWords.removeRequiredWords("");
        assertFalse(requiredWords.isRequiredWords("Star"));
        assertTrue(requiredWords.isRequiredWords("Space"));
        assertFalse(requiredWords.isRequiredWords(""));
        assertTrue(requiredWords.isRequiredWords("Day"));
        assertFalse(requiredWords.isRequiredWords("Fast"));
    }
}
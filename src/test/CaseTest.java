package test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import CS3219.*;

/**
 * test function Without RequiredWords
 */
public class CaseTest {
	@Test
    public void caseTest() throws Exception {
		List<String> inputs = new ArrayList<String>();
		inputs.add("The Day after Tomorrow");
		inputs.add("Fast and Furious");
		inputs.add("Man of Steel");
		WordsToIgnore wordsToIgnore = WordsToIgnore.getWordsToIgnore();
		wordsToIgnore.addWordToIgnore("is");
		wordsToIgnore.addWordToIgnore("the");
		wordsToIgnore.addWordToIgnore("of");
		wordsToIgnore.addWordToIgnore("and");
		wordsToIgnore.addWordToIgnore("as");
		wordsToIgnore.addWordToIgnore("a");
		wordsToIgnore.addWordToIgnore("after");
		Alphabetizer alphabetizer = new Alphabetizer();
        for (String str : inputs) {
            CircularShift shifter = new CircularShift(str);
            alphabetizer.addLines(shifter.getCircularShifts());
        }

        String[] result = alphabetizer.getSortedLines();
        StringBuilder builder = new StringBuilder();
        String separator = "\n";
        for (String str : result) {
            builder.append(str).append("\n");
        }
        assertEquals("Day after Tomorrow the\nFast and Furious\nFurious Fast and\nMan of Steel\nSteel Man of\nTomorrow the Day after\n",builder.toString());

    }
}

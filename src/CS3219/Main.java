package CS3219;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 * Created by junchao on 8/23/2014.
 * Modified by wangminchen on 9/9/2016.
 */
public class Main {

    public static void main(String[] args){
        long startTime = System.currentTimeMillis();
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter movie titles (terminate input by entering empty line) ");
        
        List<String> inputs = new ArrayList<String>();
        String userInput = sc.nextLine();
        while (!userInput.isEmpty()) {
            inputs.add(userInput);
            userInput = sc.nextLine();
        }

        System.out.println("Enter words to ignore (terminate input by entering empty line) ");
        String inputWordToIgnore = sc.nextLine();
        WordsToIgnore wordsToIgnore = WordsToIgnore.getWordsToIgnore();
        while (!inputWordToIgnore.isEmpty()) {
            wordsToIgnore.addWordToIgnore(inputWordToIgnore);
            inputWordToIgnore = sc.nextLine();
        }

        System.out.println("Enter required words (terminate input by entering empty line) ");
        String inputRequiredWords = sc.nextLine();
        RequiredWords requiredwords = RequiredWords.getRequiredWords();
        while (!inputRequiredWords.isEmpty()) {
        	if(wordsToIgnore.isWordIgnored(inputRequiredWords)){
        		System.out.println("\""+inputRequiredWords+"\" conflicts with ignore words! Exit!");
        		System.exit(0);
        	}
        	requiredwords.addRequiredWords(inputRequiredWords);
        	inputRequiredWords = sc.nextLine();
        }

        Alphabetizer alphabetizer = new Alphabetizer();
        for (String str : inputs) {
            CircularShift shifter = new CircularShift(str);
            alphabetizer.addLines(shifter.getCircularShifts());
        }

        String[] result = alphabetizer.getSortedLines();
        StringBuilder builder = new StringBuilder();
        String separator = System.lineSeparator();
        for (String str : result) {
            builder.append(str).append(separator);
        }
        System.out.print(builder.toString());

        long endTime = System.currentTimeMillis();

        System.out.println("Total execution time: " + (endTime - startTime) );
        System.exit(0);
    }
}
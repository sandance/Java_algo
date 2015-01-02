import java.io.*;
import java.util.*;


/**
 * Created by nazmul on 12/15/14.
 */
public class HashMap_SpellChecker {

    public static void main(String[] args) throws IOException {
        Map<String,String> misspeltWords = new HashMap<String,String> ();
        misspeltWords.put("Calender","Calendar");
        misspeltWords.put("tomatos","tomatoes");
        misspeltWords.put("existance", "existence");
        misspeltWords.put("aquaintance", "acquaintance");

        String sentence = "Buy a calender for the year 2013";
        System.out.println("The given sentence is: " + sentence);

        for (String word: sentence.split("\\W+")){
            if(misspeltWords.containsKey(word)){
                System.out.println("The correct spelling for "+word + " is "+misspeltWords.get(word));
            }
        }

    }
}

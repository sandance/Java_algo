/**
 * Created by nazmul on 12/15/14.
 */
public class MatchRegionInString {
    public static void main(String[] args){
        String chat = "Tarzan: Hi Jane, wanna ride an Elephant? \n Jane: No thanks! I'm  preparing for OCPJP now!";
        String matchString = "Jane: No thanks!";

        // first get the index of the position from which the search region starts

        int startIndex = chat.indexOf("\n");
        System.out.println("Jane's response starts at index :" + startIndex);

        if (startIndex > -1) {
            // remember index starts from 0 and not 1,
            boolean doesMatch = chat.regionMatches(startIndex + 1, matchString,0,matchString.length());
            if (doesMatch)
                System.out.println("Jane reponse matches with the String" + matchString);
        }
    }
}

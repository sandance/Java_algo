import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by nazmul on 12/15/14.
 */
public class StringRegexExample {
    public static void main(String[] args){
        String str = "Danny Doo, Flat no 502, Big Apartment, Wide Road, Near Huge Milestone,  Hugo-city 56010, Ph: 9876543210, Email: danny@myworld.com. Maggi Myer, Post bag no 52, " +
                "Big bank post office, Big bank city 56000, ph: 9876501234, Email: maggi07@myuniverse.com.";

        /*
        Pattern pattern = Pattern.compile("\\w+");

        Matcher matcher = pattern.matcher(str);

        while(matcher.find()){
            System.out.println(matcher.group());
        }
        */
        String Astr = "Danny Doo, Flat no 502, Big Apartment, Wide Road, Near Huge Milestone, " +
                "Hugo-city 56010, Ph: 9876543210, Email: danny@myworld.com. Maggi Myer, Post bag no 52, Big bank post " +
                "office, Big bank city 56000, ph: 9876501234, Email: maggi07@myuniverse.com.";

        Pattern pattern1 = Pattern.compile("\\b\\d{5}\\b");

        Matcher matcher1 = pattern1.matcher(Astr);

        while(matcher1.find()){
            System.out.println(matcher1.group());
        }


    }
}

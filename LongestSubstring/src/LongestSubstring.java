import java.util.*;


/**
 * Created by nazmul on 8/8/14.
 */
public class LongestSubstring {


    private Set<String> subStrList = new HashSet<String>();

    private int finalSubStrSize =0;


    public Set<String> getLongestSubStr(String input){

        // reset instance variables
        subStrList.clear();
        finalSubStrSize = 0;

        // have a boolean flag on each character ascii value

        boolean [] flag = new boolean[256];

        int j =0;

        char [] inputCharArr = input.toCharArray();

        for(int i=0; i < inputCharArr.length ; i++){
            char c = inputCharArr[i];

            if(flag[c]){
                extractSubString(inputCharArr,j,i);
                for(int k=j; k < i; k++){
                    if(inputCharArr[k] == c){
                        j = k+1;
                        break;
                    }
                    flag[inputCharArr[k]] = false;
                }


            }else {
                flag[c] = true;
            }

        }


    }

}

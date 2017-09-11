package airbnb;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tyh on 2017/9/11.
 */
public class TextJustification {
    public static void main(String[] args) {
        String[] words = new String[]{"This", "is", "an", "example", "of", "text", "justification."};
        int maxWidth = 16;
        List<String> res = fullJustify(words, maxWidth);
        for(String s : res){
            System.out.println(s);
        }
    }
    public static List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        if(words.length == 0){
            return res;
        }
        int low = 0;
        while(low < words.length){
            int currentLen = words[low].length();
            int next = low + 1;
            while(next < words.length){
                if(currentLen + 1 + words[next].length() > maxWidth){
                    break;
                }
                currentLen += (1 + words[next].length());
                next++;
            }
            //get one line
            int wordCount = next - low;
            StringBuilder sb = new StringBuilder();
            //case 1: last line or only one word in this line
            if(next == words.length || wordCount == 1){
                for(int i = low; i < next; i++){
                    sb.append(words[i]).append(" ");
                }
                sb.deleteCharAt(sb.length() - 1);
                for(int i = sb.length(); i < maxWidth; i++){
                    sb.append(" ");
                }
            }else{//otherwise, construct a line
                int slots = wordCount - 1;
                int space = maxWidth - currentLen + slots;
                int baseSpace = space/slots;
                int diffCount = space%slots;
                for(int i = low; i < next; i++){
                    sb.append(words[i]);
                    if(i != next - 1){
                        for(int j = 0; j < baseSpace + (i - low < diffCount ? 1 : 0); j++){
                            sb.append(" ");
                        }
                    }
                }
            }
            res.add(sb.toString());
            low = next;
        }
        return res;
    }
}

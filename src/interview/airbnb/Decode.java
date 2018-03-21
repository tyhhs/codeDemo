package interview.airbnb;

/**
 * Decode
 * Author: bjtangyunhao
 * Creation date: 2017年09月12日 15:05
 * Modified by: bjtangyunhao
 * Last modified: 2017年09月12日 15:05
 */
public class Decode {
    public static void main(String[] args){
        String res = decodeFind("kljjj324hjkS_");
        System.out.println(res);
    }

    private static String decode(String testEncStr) {
        return testEncStr.equals("kljJJ324hjkS_") ? testEncStr : null;
    }

    public static String decodeFind(String badEncStr) {
        StringBuilder sb = new StringBuilder(badEncStr);
        for (int i = 0; i < sb.length(); i++){
            if(Character.isUpperCase(sb.charAt(i))){
                sb.setCharAt(i, Character.toLowerCase(sb.charAt(i)));
            }
        }

        return recursive(sb, 0);
    }

    private static String recursive(StringBuilder sb, int pos) {
        if (pos == sb.length())
            return decode(sb.toString());
        if (Character.isLetter(sb.charAt(pos))) {
            String s1 = recursive(sb, pos + 1);
            if (s1 != null)
                return s1;
            sb.setCharAt(pos, Character.toUpperCase(sb.charAt(pos)));
            String s2 = recursive(sb, pos + 1);
            if (s2 != null)
                return s2;
            sb.setCharAt(pos, Character.toLowerCase(sb.charAt(pos)));
            return null;
        } else {
            return recursive(sb, pos + 1);
        }
    }
}

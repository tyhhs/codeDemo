package interview.airbnb;

/**
 * Created by tyh on 2017/9/11.
 */
public class MultiplyStrings {
    public static void main(String[] args) {
        String num1 = "4352465242141252";
        String num2 = "89502878914675891479814520";
        System.out.println(multiply(num1, num2));
    }
    public static String multiply(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0")){
            return "0";
        }
        int[] res = new int[num1.length() + num2.length()];
        for(int i = num1.length()-1; i >= 0; i--){
            for(int j = num2.length()-1; j >= 0; j--){
                int multi = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int plusNum = multi + res[i+j+1];
                res[i+j] += plusNum/10;
                res[i+j+1] = plusNum%10;
            }
        }
        int i = 0;
        while(res[i] == 0){
            i++;
        }
        StringBuilder sb = new StringBuilder();
        for(int j = i; j < res.length; j++){
            sb.append(res[j]);
        }
        return sb.toString();
    }
}

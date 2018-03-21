package interview.airbnb;

/**
 * Created by tyh on 2017/9/5.
 */
public class BullsAndCows {
    public static void main(String[] args) {
        String secret = "1807";
        String guess = "7810";
        System.out.println(getHint(secret, guess));
    }

    /**
     * The idea is to iterate over the numbers in secret and in guess and count all bulls right away.
     * For cows maintain an array that stores count of the number appearances in secret and in guess.
     * Increment cows when either number from secret was already seen in guest or vice versa.
     * @param secret
     * @param guess
     * @return
     */
    public static String getHint(String secret, String guess) {
        if(secret == null || guess == null || secret.length() != guess.length()){
            return null;
        }
        int bulls = 0;
        int cows = 0;
        //as a map to record numbers
        int[] numbers = new int[10];
        for(int i = 0; i < secret.length(); i++){
            //exactly same, bulls
            int s = secret.charAt(i) - '0';
            int g = guess.charAt(i) - '0';
            if(s == g){
                bulls++;
            }else{
                //guess number s occur before
                if(numbers[s] < 0){
                    cows++;
                }
                //secret number g occur before
                if(numbers[g] > 0){
                    cows++;
                }
                //record s and g
                numbers[s]++;
                numbers[g]--;
            }
        }
        return bulls + "A" + cows + "B";
    }
}

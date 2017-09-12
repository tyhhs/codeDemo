package airbnb;

/**
 * Created by tyh on 2017/9/11.
 */
public class SqrtXWithPrecision {
    public static void main(String[] args) {
        System.out.println(mySqrt(0.9, 0.8));
    }
    //比如x是100， precision是0.8， 那么你的返回值要在[9.2, 10.8]之间，随便返回一个这个区间的数，就算对。
    public static double mySqrt(double x, double precision) {
        if(x < precision){
            return precision;
        }
        double left = precision;
        double right = x;
        while(left < right){
            double mid = left + (right - left)/2;
            if(mid > x/mid){
                right = mid - precision;
            }else{
                if(mid+1 > x/(mid+1)){
                    return mid;
                }
                left = mid + precision;
            }
        }
        return x;
    }
}

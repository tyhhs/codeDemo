package airbnb;

import airbnb.struct.Interval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * TwoDimensionalIterator
 * Author: bjtangyunhao
 * Creation date: 2017年09月10日 17:35
 * Modified by: bjtangyunhao
 * Last modified: 2017年09月10日 17:35
 */
public class TwoDimensionalIterator {
    public static void main(String[] args){
        List<List<Integer>> array = new ArrayList<>();
        array.add(new ArrayList(Arrays.asList(1,3,4)));
        array.add(new ArrayList(Arrays.asList(2,3)));
        array.add(new ArrayList(Arrays.asList(10)));
        ListIterator3 iterator1 = new ListIterator3(array);
        while(iterator1.hasNext()){
            int i = iterator1.next();
            System.out.println(i);
            if(i == 3){
                iterator1.remove();
            }
        }
        System.out.println("#############");
        for(List<Integer> list :array){
            for(int i : list){
                System.out.println(i);
            }
        }
    }
}

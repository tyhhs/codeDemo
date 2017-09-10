package airbnb;

import java.util.ArrayList;
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
    }

    public class ListIterator1{
        List<Iterator<Integer>> iterList;
        int curr;
        public ListIterator1(List<List<Integer>> array) {
            this.iterList = new ArrayList<>();
            for(List<Integer> list : array){
                if(list.size() != 0){
                    this.iterList.add(list.iterator());
                }
            }
            this.curr = 0;
        }

        public boolean hasNext(){
            return curr < iterList.size() && iterList.get(curr).hasNext();
        }

        public int next(){
            int res = iterList.get(curr).next();
            if(!iterList.get(curr).hasNext()){
                curr++;
            }
            return res;
        }
    }
}

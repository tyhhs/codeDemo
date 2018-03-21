package interview.airbnb;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by tyh on 2017/9/10.
 */
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
        while(curr < iterList.size() && !iterList.get(curr).hasNext()){
            curr++;
        }
        return curr < iterList.size() && iterList.get(curr).hasNext();
    }

    public int next(){
        hasNext();
        return iterList.get(curr).next();
    }

    public void remove(){
        iterList.get(curr).remove();
    }
}

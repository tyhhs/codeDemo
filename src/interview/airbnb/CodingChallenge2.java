package interview.airbnb;

import java.util.*;

/**
 * Created by tyh on 2017/9/4.
 */
public class CodingChallenge2 {
    public static void main(String[] args) {
        int pageSize = 5;
        String[] list = {"1,28,310.6,SF", "4,5,204.1,SF", "20,7,203.2,Oakland",
                "6,8,202.2,SF", "6,10,199.1,SF", "1,16,190.4,SF", "6,29,185.2,SF",
                "7,20,180.1,SF", "6,21,162.1,SF", "2,18,161.2,SF", "2,30,149.1,SF",
                "3,76,146.2,SF", "2,14,141.1,San Jose"};
        String[] res = sortList(pageSize, list);

        for (String line : res) {
            System.out.println(line);
        }
    }

    public static String[] sortList(int n, String[] results) {
        if(results == null || results.length == 0){
            return null;
        }
        //结果集的长度=原长度+分页符号
        int len = results.length;
        int pageSeparator = len/n;
        int remaining = len%n;
        String[] res = new String[len + (remaining == 0 ? pageSeparator - 1 : pageSeparator)];

        //put results into a arrayList
        List<String> resultsList = new ArrayList<>();
        for(int i = 0; i < len; i++){
            resultsList.add(results[i]);
        }
        //list下标
        int listIndex = 0;
        //结果集下标
        int resIndex = 0;
        //当前页面条目
        int pageCount = 0;
        //是否遍历一遍
        boolean flag = false;
        //当前页已添加的hostID
        Set<String> hostIdSet = new HashSet<>();

        while(resultsList.size() != 0){
            //one page done
            if(pageCount == n){
                pageCount = 0;
                res[resIndex] = "#########";
                resIndex++;
                flag = false;
                hostIdSet.clear();
                listIndex = 0;
            }
            String info = resultsList.get(listIndex);
            if(info == null){
                continue;
            }
            String[] tokens = info.split(",");
            if(tokens.length != 4){
                continue;
            }
            String hostId = tokens[0];
            //已经遍历过一遍 || set中不包含该hostId
            if(flag || !hostIdSet.contains(hostId)){
                res[resIndex] = info;
                resIndex++;
                pageCount++;
                resultsList.remove(listIndex);
                hostIdSet.add(hostId);
            }else {//下一个
                listIndex++;
            }
            //list遍历到头，从头开始补全
            if(listIndex == resultsList.size()){
                listIndex = 0;
                flag = true;
            }
        }
        return res;
    }
}

package binarySearch;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 *
 * @Leetcode #981. Time Based Key-Value Store
 * @Type:   Binary Search
 * @Key Point:      二分查找：sorted array,  || low ~ mid-1 || mid+1 ~ high ||
 * @Description:    因为时间点是单调递增的 所以可以用二分法来查找arraylist
 *                  这题相当于： 在升序数列中找目标值，如果不存在目标值 返回比他小且相差最少的值
 */
public class _981 {

    class Pair{
        private String val;
        private int timestamp;
        Pair(String val, int timestamp){
            this.val = val;
            this.timestamp = timestamp;
        }
    }

    private HashMap<String, ArrayList<Pair>> map;
    public _981() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        if(!map.containsKey(key)){
            map.put(key, new ArrayList<>());
        }
        map.get(key).add(new Pair(value, timestamp));
    }

    public String get(String key, int timestamp) {
        String result = "";

        if(map.containsKey(key)){
            ArrayList<Pair> arrayList = map.get(key);
            int lo = 0;
            int hi = arrayList.size() - 1;

            while(lo <= hi){
                int mid = lo + (hi - lo) / 2;
                if(arrayList.get(mid).timestamp == timestamp){
                    return arrayList.get(mid).val;
                }
                else if(arrayList.get(mid).timestamp <= timestamp){
                    result = arrayList.get(mid).val;
                    lo = mid + 1;
                }else{
                    hi = mid - 1;
                }

            }
        }
        return result;
    }
}

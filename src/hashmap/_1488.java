package hashmap;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: handsome guy
 * @Date: 2023/10/12/11:46 PM
 * @Description:
 */
public class _1488 {
    public int[] avoidFlood(int[] rains) {
        int [] ans = new int[rains.length];
        Map<Integer, Integer> when2full = new HashMap<>();
        TreeSet<Integer> intSet = new TreeSet<>();
        for(int i = 0; i < rains.length; i++){
            if(rains[i] == 0){
                intSet.add(i);
            }else{
                if (!when2full.containsKey(rains[i])) { // 如果还没被淹过，记录
                    when2full.put(rains[i], i);
                    ans[i] = -1;
                }else { // 如果已经被淹过
                    if(intSet.size() == 0) return new int[]{}; // 如果没有干旱的一天可以晒干
                    Integer m = intSet.ceiling(when2full.get(rains[i])); //找干旱队列里，比这个湖上一次被淹大，且最小的那个元素
                    if(m != null){
                        ans[m] = rains[i]; // 用找到的最小的那一个晴天晒干当前lake
                        when2full.put(rains[i], i); // 更新lake被淹的位置
                        ans[i] = -1;
                        intSet.remove(m); // 消耗一个晴天
                    }else{
                        return new int[]{};
                    }
                }
            }
        }
        for (int i = 0; i < ans.length; i++) {
            if(ans[i] == 0) ans[i] = 1;
        }
        return ans;
    }
    public static void main(String[] args) {
        _1488 test = new _1488();
        int[] rains = new int[]{69,0,0,0,69};
        test.avoidFlood(rains);
    }
}

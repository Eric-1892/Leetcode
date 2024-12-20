package heap;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @Leetcode #692. Top K Frequent Words
 * @Type:       pq
 * @Key Point:      自定义 comparator
 * @Description:    hashmap的每一个key-value pair 是一个Map.Entry 对象，用pq存这个类型的对象
 */
public class _692 {
    public List<String> topKFrequent(String[] words, int k) {

        Map<String, Integer> map = new HashMap<>();
        for(String s: words){
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(new MyCompatator());

        // 如何返回hashmap的entry集合：
        for(Map.Entry entry: map.entrySet()){
            pq.offer(entry);
        }
        List<String> result = new ArrayList<>(k);
        for(int i = 0; i < k; i++){
            result.add(pq.poll().getKey());
        }

        return result;
    }
}

class MyCompatator implements Comparator<Map.Entry<String, Integer>> {
    // 返回类型为int： e1-e2 升序； e2-e1 降序
    public int compare(Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2){
        String s1 = e1.getKey();
        String s2 = e2.getKey();
        int freq1 = e1.getValue();
        int freq2 = e2.getValue();

        if(freq1 != freq2){
            // 频率高的项排在前面，实现降序
            return freq2-freq1;
        }else {
            // 单词按照字典顺序,升序排列
            return s1.compareTo(s2);
        }
    }
}

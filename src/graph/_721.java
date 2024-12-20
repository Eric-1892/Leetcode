package graph;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @Leetcode #721. Accounts Merge
 * @Type:
 * @KeyPoint: graph + bfs+queue
 * @Description:    用Adj-List(Hashmap 实现) 来表示每个email的connection的情况，再用过bfs来遍历每个email node的
 * @RelevantProblems:
 */
public class _721 {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        HashMap<String, Set<String>> graph = new HashMap<>();
        HashMap<String, String> emailToName = new HashMap<>();

        //  graph create
        for(List<String> account: accounts){
            String name = account.get(0);
            for(int i = 1; i < account.size(); i++){
                // 如果hashmap里还没有当前这个email， 则建立一个以它为key的hashset来存储和它相连的node
                graph.putIfAbsent(account.get(i), new HashSet<>());
                emailToName.put(account.get(i), name);
                if(i != 1){
                    graph.get(account.get(i)).add(account.get(i-1));
                    graph.get(account.get(i-1)).add(account.get(i));
                }
            }
        }

        // BFS
        // 检查visited 通过入队时进行检查，只要入队就等代表将对此node进行连通性检测，所以需要在每次入队操作前，检测其是否visited
        List<List<String>> result = new ArrayList<>();
        Set<String> visited = new HashSet<>();
        for(String email: graph.keySet()){
            if(!visited.contains(email)){
                visited.add(email);
                List newList = bfs(graph, visited, email);
                Collections.sort(newList);
                newList.add(0, emailToName.get(email));
                result.add(newList);
            }
        }
        return result;
    }


    private List<String> bfs(HashMap<String, Set<String>> graph, Set<String> visited, String curNode){
        Queue<String> queue = new LinkedList();
        queue.offer(curNode);

        List<String> newList = new LinkedList<>();

        while(!queue.isEmpty()){
            // 这里需要遍历同一层的所有node 所以需要for-loop
            int size = queue.size();
            for(int i = 0; i < size; i++){
                String cur = queue.poll();
                newList.add(cur);
                Set<String> neighbors = graph.get(cur);
                for(String neighbor: neighbors){
                    if(!visited.contains(neighbor)){
                        visited.add(neighbor);
                        queue.offer(neighbor);
                    }
                }
            }
        }
        return  newList;
    }
}

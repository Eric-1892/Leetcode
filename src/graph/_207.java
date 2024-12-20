package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Leetcode #207. Course Schedule
 * @Type:       graph + topological sort
 * @KeyPoint:   [adjacency list] + [in-degree list] + bfs
 * @Description: 邻接表array of ArrayList<Integer顶点s>          +       入度表array of 顶点 来解决拓扑排序
 *                  index代表(前置)课号，arrayList存的是这节课指向的课       index：当前课程；值表示这节课被几节前置课指着
 *                  当in-degree == 0 代表这节课不再受限
 * @RelevantProblems:
 */
public class _207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // graph数组 邻接表 提供图结构，即课程的先后关系
        // degree数组 记录每节课的入度值

        // index代表前置课课号，arraylist存的是前置课指向的后置课
        // 如果index无法表示课号，则需要用map
        ArrayList[] graph = new ArrayList[numCourses];
        for(int i=0; i<numCourses; i++){
            graph[i] = new ArrayList();
        }
        // 表示每节课的入度in-degree
        int[] degree = new int[numCourses];

        for(int i=0; i<prerequisites.length; i++){
            degree[prerequisites[i][1]]++;
            graph[prerequisites[i][0]].add(prerequisites[i][1]);
        }

        Queue queue = new LinkedList();
        int count=0;

        // 将所有入度为0的课入队 （入队代表该课已修 count++）
        for(int i=0; i<degree.length; i++){
            // 如果入度为0（没有前置课束缚了）
            if(degree[i] == 0){
                queue.add(i);
                count++;
            }
        }

        while(queue.size() != 0){
            int course = (int)queue.poll();
            for(int i=0; i<graph[course].size();i++){
                // 得到了当前入度为0的课指向的课
                int pointer = (int)graph[course].get(i);
                // 被指向的课入度--
                degree[pointer]--;
                // 将所有入度为0的课入队 （入队代表该课已修 count++）
                if(degree[pointer] == 0){
                    queue.add(pointer);
                    count++;
                }
            }
        }
        if(count == numCourses)
            return true;
        else
            return false;
    }

    public boolean canFinish2(int numCourses, int[][] prerequisites){
        // Input: numCourses = 2, prerequisites = [[1,0],[0,1]]

        int count = 0;
        //adjacency list
        ArrayList<Integer>[] adjList = new ArrayList[numCourses];
        for(int i = 0; i < numCourses; i++){
            adjList[i] = new ArrayList();
        }
        // inDegree list
        int[] inDegreeList = new int[numCourses];

        for(int i = 0; i < prerequisites.length; i++){
            inDegreeList[prerequisites[i][1]]++;
            adjList[prerequisites[i][0]].add(prerequisites[i][1]);
        }

        Queue<Integer> queue = new LinkedList<>();

        for(int i = 0; i < inDegreeList.length; i++){
            if(inDegreeList[i] == 0){
                queue.add(i);
                count++;
            }
        }

        while (!queue.isEmpty()){
            int course = queue.poll();
            for(int i = 0; i < adjList[course].size(); i++){
                int pointer = (int)adjList[course].get(i);
                inDegreeList[pointer]--;
                if(inDegreeList[pointer] == 0){
                    queue.add(pointer);
                    count++;
                }
            }
        }
        if(count == numCourses) return true;

        return false;
    }
}

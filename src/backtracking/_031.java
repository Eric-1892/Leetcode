package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: handsome guy
 * @Date: 2023/10/06/11:01 AM
 * @Description:
 */
public class _031 {
    public void nextPermutation(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        dfs(nums, ans, cur);
        int matchingIndex = findMatchingIndex(ans, nums);
        nums = listToArray(ans.get(matchingIndex));
        System.out.println(Arrays.toString(nums));

    }

    public static int findMatchingIndex(List<List<Integer>> ans, int[] nums) {
        for (int i = 0; i < ans.size(); i++) {
            List<Integer> innerList = ans.get(i);

            // 将 List 转换为数组
            int[] innerArray = new int[innerList.size()];
            for (int j = 0; j < innerList.size(); j++) {
                innerArray[j] = innerList.get(j);
            }

            // 比较内部数组与 nums 是否相同
            if (Arrays.equals(innerArray, nums)) {
                if(i == ans.size()-1) return 0;
                return i+1; // 找到匹配的内容，返回索引
            }
        }

        return -1; // 没有找到匹配的内容
    }

    public void dfs(int[] nums, List<List<Integer>> ans, List<Integer> cur){
        if(cur.size() == nums.length){
            ans.add(new ArrayList<>(cur));
            return;
        }

        for(int i = 0; i < nums.length; i++){
            if(!cur.contains(nums[i])){
                cur.add(nums[i]);
                dfs(nums, ans, cur);
                cur.remove(cur.size()-1);
            }
        }
    }

    public static void main(String[] args) {
        _031 test = new _031();
        int[] nums = new int[]{1,2,3};
        test.nextPermutation(nums);
    }

    public static int[] listToArray(List<Integer> list) {
        int[] arr = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }
}

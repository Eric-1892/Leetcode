package array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: handsome guy
 * @Date: 2023/10/17/11:45 AM
 * @Description:
 */
public class _217 {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num :nums) {
            set.add(num);
        }
        if(set.size() != nums.length) return true;
        return false;
    }
}

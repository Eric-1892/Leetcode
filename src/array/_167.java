package array;

/**
 * Created with IntelliJ IDEA.
 *
 * @Leetcode: Problem #167. Two Sum II - Input Array Is Sorted
 * @Type: Array
 * @KeyPoint: two pointers
 * @Description:
 * @RelevantProblems:1. Two Sum; 15. 3Sum
 */
public class _167 {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {
            if(numbers[left] + numbers[right] == target) {
                return new int[]{left+1, right+1};
            }else if(numbers[left] + numbers[right] < target) {
                left++;
            }else{
                right--;
            }
        }

        return new int[]{};
    }
}

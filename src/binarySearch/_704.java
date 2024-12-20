package binarySearch;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: handsome guy
 * @Date: 2023/10/08/9:30 PM
 * @Description:
 */
public class _704 {
    public int search(int[] nums, int target) {
        return binarySearch(nums, 0, nums.length - 1, target);
    }
    private int binarySearch(int[] nums, int left, int right, int target){
        int mid = (left + right) / 2;
        System.out.println("mid: " + mid);
        if (nums[mid] == target)    return mid;
        if(right <= left) return -1;

        if(nums[mid] < target)      return binarySearch(nums, mid+1, right, target); // 注意 mid+1
        else                        return binarySearch(nums, left, mid-1, target);  // 注意 mid-1
    }

    public int search_while(int[] nums, int target) {
        int i = 0;
        int j = nums.length - 1;

        while(i <= j){
            int mid = i + (j - i) / 2;
            if(nums[mid] == target) return mid;
            if (nums[mid] < target){
                i = mid+1;
            }else{
                j = mid-1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        _704 test = new _704();
        int []nums = new int[]{0,1,2,3,4};
        test.search(nums,4);
    }
}

package Tool_Methods;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: handsome guy
 * @Date: 2023/09/25/1:11 PM
 * @Description:
 */
public class _binarySearch {
    // 二分查找函数
    public static int _binarySearch(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2; // 计算中间索引

            if (array[mid] == target) {
                return mid; // 找到目标元素，返回索引
            } else if (array[mid] < target) {
                left = mid + 1; // 目标在右半部分，调整左边界
            } else {
                right = mid - 1; // 目标在左半部分，调整右边界
            }
        }

        return -1; // 没有找到目标元素，返回-1
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int target = 5;

        int result = _binarySearch(arr, target);

        if (result != -1) {
            System.out.println("目标元素 " + target + " 在数组中的索引为 " + result);
        } else {
            System.out.println("目标元素 " + target + " 未找到");
        }
    }
}

package binarySearch;

import java.util.PriorityQueue;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: handsome guy
 * @Date: 2023/10/09/11:52 AM
 * @Description:
 */
public class _278 {
    /* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */
    private boolean isBadVersion(int version){
        if(version == 4) return true;
        if(version == 5) return true;
        return false;
    }

    public int firstBadVersion(int n) {
        return biSearch(0, n-1);
    }
    private int biSearch(int left, int right){
        if(right<=left) return left;
        int mid = (left + right) / 2;

        if(isBadVersion(mid)){
            biSearch(left, mid-1);
        }else{
            biSearch(mid+1, right);
        }
        return -1;
    }

    public static void main(String[] args) {
        _278 test = new _278();
        test.firstBadVersion(5);
    }
}

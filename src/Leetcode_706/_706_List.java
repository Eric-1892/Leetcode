package Leetcode_706;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: handsome guy
 * @Date: 2023/10/04/10:59 AM
 * @Description:
 */
public class _706_List {
    int[] data;
    public _706_List() {
        List<Integer> data = new ArrayList<>();
    }

    public void put(int key, int value) {
        data[key] = value;
    }

    public int get(int key) {
        return data[key];
    }

    public void remove(int key) {
        data[key] = -1;
    }
}

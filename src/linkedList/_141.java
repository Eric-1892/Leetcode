package linkedList;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: handsome guy
 * @Date: 2023/11/01/9:36 PM
 * @Description: Linked List Cycle
 */

public class _141 {
    // 如果链表中存在环，fast 指针比 slow 指针移动得快，因此必然会在某一时刻追上 slow 指针。
    public boolean hasCycle(ListNode head) {
        ListNode slow = head,fast =head;
        while(fast != null && fast.next != null){
            if(slow.equals(fast)) return true;
            slow = slow.next;
            fast = fast.next.next;
        }
        return false;
    }
}

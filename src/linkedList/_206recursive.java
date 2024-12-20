package linkedList;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: handsome guy
 * @Date: 2023/11/01/10:30 PM
 * @Description:
 */
public class _206recursive {
    public ListNode reverseList(ListNode head) {
        if( head == null || head.next == null) return head;
        ListNode res = reverseList(head.next); // 最内层的res会一直返回到最外层
        head.next.next = head;
        head.next = null;
        return res;
    }
}

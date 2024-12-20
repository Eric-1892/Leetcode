package linkedList;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: handsome guy
 * @Date: 2023/11/02/9:22 PM
 * @Description: Remove Nth Node From End of List
 */
public class _19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
//        if(head.next == null) return null;

        int num = 1;
        ListNode cur = head;
        while(cur.next != null){
            cur = cur.next;
            num++;
        }
        num = num - n;

        if(num == 0) return head.next;

        cur = head;
        for(int i = 0; i < num-1; i++){
            cur = cur.next;
        }
        if(cur.next.next == null) cur.next = null;
        else                      cur.next = cur.next.next;

        return head;
    }
}

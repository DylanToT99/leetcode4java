package DoublePointer;

/**
 * @author Dylan
 * @version 1.0
 * @date 2022/11/15 16:13
 * @description 给定一个链表的头节点  head ，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 *
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。
 * 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。如果 pos 是 -1，则在该链表中没有环。
 * 注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
 *
 * 不允许修改 链表。
 *
 * 142. 环形链表 II
 **/
public class detectCycle_ {

    public ListNode detectCycle(ListNode head) {
        /**
         *2x+2y=x+n(y+z)+y  --->
         * x=(n-1)(y+z)+z
         * 说明当快慢指针相遇时, 若让慢指针重回起点走X距离, 会和快指针在环的起点相遇(相遇后让快指针的速度变为1)
         */
        ListNode fast=head;
        ListNode slow=head;
        while (fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if (slow==fast){
                ListNode index1=head;
                ListNode index2=fast;
                while (index1!=index2){
                    index2=index2.next;
                    index1=index1.next;
                }
                return index1;
            }
        }
        return null;
    }
}

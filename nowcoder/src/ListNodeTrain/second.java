package ListNodeTrain;

/**
 * @author Dylan
 * @version 1.0
 * @date 2022/5/26 11:13
 * @description 指定链表位置反转,如输入2,4,则第二个到第四个节点反转,其他不变.
 **/



public class second {
 /**
  *
  * 版本一,无头结点,需要判断是否从第一个节点开始反转,较为复杂.
  */

    public static ListNode reverseBetween (ListNode head, int m, int n) {
        int count=1;
        ListNode next=null;
        ListNode cur=null;
        ListNode savehead=head;
        ListNode pre;
        if(head.next==null||n==1){
         return head;
        }
     if(m!=1){
      //第一步:找到位于m-1的链表节点
      while(head!=null&&count<m-1){
       head=head.next;
       ++count;
      }
     }
     pre=savehead;
     //第二步:找到位于m的节点
     if(head!=null&&count<m) {
      //第二步:找到位于m的节点
      head = head.next;
      ++count;
     }
     //第三步:在大于等于m小于等于n的位置上进行链表反转
     while(head!=null&&count<=n){
      next=head.next;
      head.next=cur;
      cur=head;
      head=next;
      ++count;
     }
     ListNode cur1=cur;
     //找到反转链表的最后一个元素,将其下一个元素赋值为next或者head
     while(cur1.next!=null){
      cur1=cur1.next;
     }
     if(cur1!=null){
      cur1.next=next;
      if(m!=1){
       pre.next=cur;
      }
     }
     if(m==1){
      return cur;
     }else {
      return savehead;
     }
/**
 * 版本二,添加头结点:
 */


    }
    public static ListNode reverseSubListNode2(ListNode head,int m,int n){
/**
 * 该算法的优点是,在反转链表的同时,不会破坏反转链表外原来的链表的结构
 * 反转完之后不需要再拼接
 * 其利用头结点的便利之处随时为反转之后的第一个节点与前一个节点建立联系
 */

/**
 * pre始终指向反转链表的第一个节点的前一个节点
 *  * cur始终指向需要反转的第一个节点如1,2,3,4 ,若从1开始反转,则其始终指向1;
 *
 */
        ListNode next;
        ListNode preHead=new ListNode(-1);
        preHead.next=head;
        ListNode pre=preHead;
        //找到需要反转的节点的前面一个节点
       for(int i=0;i<m-1;i++){
          pre=pre.next;
       }
       //开始反转链表,cur始终指向反转链表的第一个节点
        ListNode cur=pre.next;
       for(int i=0;i<n-m;i++){
        next=cur.next;
        cur.next=next.next;
       next.next=pre.next;
       pre.next=next;
       }
       return preHead.next;

     }


}

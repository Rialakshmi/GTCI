import java.util.*;

class ListNode {
  int value = 0;
  ListNode next;

  ListNode(int value) {
    this.value = value;
  }
}

class ReverseEveryKElements {

  public static ListNode reverse(ListNode head, int k) {
     ListNode prev=null;
       ListNode curr=head;
       while(true) {
           ListNode lastNodeOfPrevSubList=prev;
           ListNode lastNodeOfCurrSubList=curr;
           if(countNodes(curr,k)) {
               for(int i=0;i<k&&curr!=null;i++) {
               ListNode temp=curr.next;
               curr.next=prev;
               prev=curr;
               curr=temp;
           }
           
           if(lastNodeOfPrevSubList!=null)
               lastNodeOfPrevSubList.next=prev;
           else
               head=prev;
           
           lastNodeOfCurrSubList.next=curr;
           
           if(curr==null)
               break;
           
           prev=lastNodeOfCurrSubList;
           } else
               break;
           
           
       }
        
        return head;
  }

    public static boolean countNodes(ListNode node,int num) {
        ListNode curr=node;
        int temp=num;
        while(curr!=null&&temp>0) {
            temp--;
            curr=curr.next;
        }
        
        return temp==0;
    }
  public static void main(String[] args) {
    ListNode head = new ListNode(1);
    head.next = new ListNode(2);
    head.next.next = new ListNode(3);
    head.next.next.next = new ListNode(4);
    head.next.next.next.next = new ListNode(5);
    head.next.next.next.next.next = new ListNode(6);
    head.next.next.next.next.next.next = new ListNode(7);
    head.next.next.next.next.next.next.next = new ListNode(8);

    ListNode result = ReverseEveryKElements.reverse(head, 3);
    System.out.print("Nodes of the reversed LinkedList are: ");
    while (result != null) {
      System.out.print(result.value + " ");
      result = result.next;
    }
  }
}

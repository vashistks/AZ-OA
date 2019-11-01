class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
         
        ListNode result = new ListNode(0);
        //result = result.next;
        ListNode head = result;
        if(l1==null) return l2;
        if(l2==null) return l1;
        while(l1 != null && l2 != null){
            if(l1.val < l2.val) {
                result.next = l1;
                l1 = l1.next;
            } else {
                result.next = l2;
                l2 = l2.next;
            }
            result = result.next;
        }
        
        if(l1!=null){
            while(l1!=null){
                result.next = l1;
                l1 = l1.next;
                result = result.next;
            }
        }
        if(l2!=null){
            while(l2!=null){
                result.next= l2;
                l2 = l2.next;
                result = result.next;
            }
        }
        return head.next;
    }
}

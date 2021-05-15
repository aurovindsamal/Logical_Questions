package com.projects.problemStatement;

//For example, given 1->1->1->2->3, return 2->3.
public class Remove_Duplicates_II {

	public ListNode deleteDuplicates(ListNode head) {
	    ListNode t = new ListNode(0);
	    t.next = head;
	 
	    ListNode p = t;
	    while(p.next!=null&&p.next.next!=null){
	        if(p.next.val == p.next.next.val){
	            int dup = p.next.val;
	            while(p.next!=null&&p.next.val==dup){
	                p.next = p.next.next;
	            }
	        }else{
	            p=p.next;
	        }
	 
	    }
	 
	    return t.next;
	}

}

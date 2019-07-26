
#         ListTest

	public class ListTest {

##	 查出倒数第K个节点的值	

	/**
	 * 查出倒数第K个节点的值
	 * 
	 * 思路：
	 * 首先定义一个长度为k的📏；然后往后移动直至📏的尾到最后一个；
	 * 
	 * @param head
	 * @param k
	 * @return
	 */
	public ListNode findKthToTail(ListNode head,int k) {	
		
		if(head==null||k<=0)
			return null;
		ListNode begin = head;
		ListNode end = head;
		
		for(int i=0;i<k;i++) {
			if(end.next!=null)
				end = end.next;
			else
				return null;
		}
		
		while(end.next!=null) {
			begin = begin.next;
			end = end.next;
		}
		
		return begin;

    }
##	 删除单向链表中间的某个结点
    
	/**
	 * 删除单向链表中间的某个结点，假定你只能访问该结点。
	 * 给定待删除的节点，请执行删除操作，
	 * 若该节点为尾节点，返回false，否则返回true 
	 * 
	 *思路：
	 *如果是1->2->3->4;要我们删除2的话
	 *我们可以让2=3；3=4；最后把4（最后一个）删除了
	 * 
	 * @param pNode
	 * @return
	 */
	 public boolean removeNode(ListNode pNode) {
	        if(pNode==null||pNode.next==null)
	        	return false;
	        pNode = pNode.next;
	        pNode.next = pNode.next.next;
	        return true;
	    }
	 
##	 以给定值x为基准将链表分割成两部分，所有小于x的结点排在大于或等于x的结点之前
	 
	 /**
	  * 以给定值x为基准将链表分割成两部分，所有小于x的结点排在大于或等于x的结点之前
	  * 给定一个链表的头指针 ListNode* pHead，请返回重新排列后的链表的头指针。
	  * 注意：分割以后保持原来的数据顺序不变。
	  * 
	  * 
	  * 
	  * 思路：
	  * 首先从头遍历链表，将大于等于和小于x分为两组；
	  * 然后让小的最后一个的next指向大的头就行
	  * 
	  * @param pHead
	  * @param x
	  * @return
	  */
	 public static ListNode partition(ListNode pHead, int x) {
		 if(pHead==null)
			 return pHead;
	     ListNode bigger = new ListNode(-1);
	     ListNode smaller = new ListNode(-1);
	     ListNode big = bigger;
	     ListNode small = smaller;
	     ListNode common = null;
	     while (pHead!=null) { 
	    	 System.out.println(pHead.val);
	    	 if(pHead.val<x) {
	    		 
	    			 smaller.next = pHead;
	    			 smaller = smaller.next;	    					 
	    	 }else {
	    		 
	    			 bigger.next = pHead;
	    			 bigger = bigger.next;
	    	 }
	    	 pHead = pHead.next;

	    	
	     }

	     smaller.next = big.next;
    	 bigger.next=null;
    	 
    	 return small.next;
	 }
	 
 ##	  给定两个链表ListNode* A，ListNode* B，请返回A+B的结果(ListNode*)。
	 
	 /**
	  * 给定两个链表ListNode* A，ListNode* B，请返回A+B的结果(ListNode*)。
	  * 
	  * 
	  * 思路：
	  * 分别计算每一个结点，
	  * 除10取整作为进位数，
	  * 除10取余作为本位数，
	  * 存到该结点中。
	  * 
	  * @param a
	  * @param b
	  * @return
	  */
	 public static ListNode plusAB(ListNode a, ListNode b) {
		 
		 if(a==null&&b==null)
			 return a;
		 ListNode result = new ListNode(-1);
		 if(a==null||b==null)
			 result.next  = (a == null)? b: a;
		 else {
			 ListNode node = new ListNode(-1);
			 result = node;
			 int jinwei  = 0;
			 boolean flag = true;
			 int count = 0;
			 while(flag) {
				 boolean f= false;
				 int numA = 0;
				 int numB = 0;
				 if(a!=null) {
					 numA = a.val;
				 	a = a.next;
				 	f=true;
				 }
				 if(b!=null) {
					 numB = b.val;
				 	b = b.next;
				 	f=true;
				 }
				 int sum = numA+numB+jinwei;
				 jinwei = 0;
				 if(sum == 0&&!f) {
					 node.next = null;
					 flag = false;
				 }else {
					 jinwei = sum/10;
					 node.next = new ListNode(sum%10);
					 node = node.next;
				 }

				
			 }
		 }
		 
		 
		 return result.next;
	 }
	 
 ##	  给定一个链表ListNode* pHead，请返回一个bool，代表链表是否为回文。
	 
	 /**
	  * 给定一个链表ListNode* pHead，请返回一个bool，代表链表是否为回文。
	  * 
	  * 思路：
	  * 从头遍历链表，把value值取出，存到一个list或者数组中；
	  * 取两个游标往中间移动比较，
	  * 如果相同，继续移动，直至中间后，返回true；
	  * 否则，返回false；
	  * 
	  * @param pHead
	  * @return
	  */
	 public boolean isPalindrome(ListNode pHead) {
	     if(pHead==null)
	    	 return false;
	     List<Integer> list = new ArrayList<Integer>();
		 while(pHead!=null) {
			 list.add(pHead.val);
			 pHead= pHead.next;
		 }
		 for(int i=0;i<list.size()/2+1;i++) {
			 if(list.get(i)!=list.get(list.size()-1-i))
				 return false;
		 }
		 
		 return true;
	 }
	 /**
	 
##	  main函数
	 
	  * main函数
	  * Test测试
	  * @param args
	  */
	 
	 public static void main(String[] args) {
		 
		 ListNode list = new ListNode(0);
		 list.next = new  ListNode(1);
		 list.next.next = new  ListNode(1);
		// list.next.next.next = new  ListNode(4);
		 ListNode list1 = new ListNode(0);
	//	list1.next = new  ListNode(7);
	//	list1.next.next = new  ListNode(6);
	//	list1.next.next.next = new  ListNode(5);
	//		 
	//	 System.out.println(1/10+" , "+1%10);
		 
		 ListNode result = plusAB(list,list1);
		 
		 while(result!=null) {
			 System.out.println(result.val);
			 result = result.next;
		 }
		 
	}
	 
	}
	
##     定义链表的数据结构   ListNode
	
	class ListNode {
	    int val;
	    ListNode next = null;

	    ListNode(int val) {
		this.val = val;
	    }
	}
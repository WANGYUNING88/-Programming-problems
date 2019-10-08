
#         ListTest

	public class ListTest {
	
##	反转链表

	/**
	 * Q:输入一个链表，反转链表后，输出新链表的表头。
	 * A:详见注释
	 * @param head
	 * @return
	 */
	public static ListNode ReverseList(ListNode head) {

		if (head == null)
			return null;
		// head为当前节点，如果当前节点为空的话，那就什么也不做，直接返回null；
		ListNode preNode = null;
		ListNode nextNode = null;
		// 当前节点是head，pre为当前节点的前一节点，next为当前节点的下一节点
		// 需要pre和next的目的是让当前节点从pre->head->next1->next2变成pre<-head next1->next2
		// 即pre让节点可以反转所指方向，但反转之后如果不用next节点保存next1节点的话，此单链表就此断开了
		// 所以需要用到pre和next两个节点
		// 1->2->3->4->5
		// 1<-2<-3 4->5
		while (head != null) {
			// 做循环，如果当前节点不为空的话，始终执行此循环，此循环的目的就是让当前节点从指向next到指向pre
			// 如此就可以做到反转链表的效果
			// 先用next保存head的下一个节点的信息，保证单链表不会因为失去head节点的原next节点而就此断裂
			nextNode = head.next;
			// 保存完next，就可以让head从指向next变成指向pre了，代码如下
			head.next = preNode;
			// head指向pre后，就继续依次反转下一个节点
			// 让pre，head，next依次向后移动一个节点，继续下一次的指针反转
			preNode = head;
			head = nextNode;
		}
		// 如果head为null的时候，pre就为最后一个节点了，但是链表已经反转完毕，pre就是反转后链表的第一个节点
		// 直接输出pre就是我们想要得到的反转后的链表
		return preNode;
	}
	
##	两个链表的第一个公共结点
	
	/**
	 * Q：输入两个链表，找出它们的第一个公共结点。
	 * A：用两个指针扫描”两个链表“，最终两个指针到达 null 或者到达公共结点。 
	 * @param pHead1
	 * @param pHead2
	 * @return
	 */
	public static ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
		 ListNode l1 = pHead1;
		 ListNode l2 = pHead2;
		 while(l1!=l2) {
			 if(l1!=null)
				 l1 = l1.next;
			 else
				 l1 = pHead2;
			 if(l2!=null) 
				 l2 = l2.next;
			 else
				 l2 = pHead1;
		 }
		 return l1;
    }

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

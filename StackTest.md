import java.util.*;

#       StackTest


public class StackTest {

##	栈的压入、弹出序列 

	/**
	 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。
	 * 假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺序，序列4,5,3,2,1是该压栈序列对应的一个弹出序列，
	 * 但4,3,5,1,2就不可能是该压栈序列的弹出序列。（注意：这两个序列的长度是相等的）
	 * 
	 *模拟堆栈操作：将原数列依次压栈，栈顶元素与所给出栈队列相比，如果相同则出栈，
	 *如果不同则继续压栈，直到原数列中所有数字压栈完毕。
	 *检测栈中是否为空，若空，说明出栈队列可由原数列进行栈操作得到。否则，说明出栈队列不能由原数列进行栈操作得到。
	 *
	 * @param pushA
	 * @param popA
	 * @return
	 */
	public static  boolean IsPopOrder(int [] pushA,int [] popA) {
		
		Stack<Integer> stack = new Stack<Integer>();
		int j=0;
		for(int i=0;i<pushA.length;i++) {
			stack.add(pushA[i]);
			while(!stack.isEmpty()&&stack.peek()==popA[j]) {
				stack.pop();
				j++;
			}
		}
		
		
		return stack.isEmpty();
	      
    }	

##      用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。

	/**
	 * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
	 * 
	 * 
	 * 思路：
	 * 栈是后进先出，队列是先进后出
	 * 每次push都按栈的顺序排列在stack1中，然后依次把stack1的元素移到stack2
	 * 每次pop直接pop stack2的就ok了；
	 */
	
	
	static Stack<Integer> stack1 = new Stack<Integer>();
    static Stack<Integer> stack2 = new Stack<Integer>();
    
    public static void push(int node) {

    	System.out.println("stack1的长度"+stack1.size());
    	
    	if(stack1.isEmpty()&&!stack2.isEmpty()) {
            while (!stack2.isEmpty()) {
    		    stack1.push(stack2.pop());
            }
    	}
    	stack1.push(node);
        while (!stack1.isEmpty()) {
        	stack2.push(stack1.pop());
        }
    }
    
    public static int pop() {
        if(!stack2.isEmpty()) {
        	return stack2.pop();
        }
        return (Integer) null;
    }
	
##	 创建数据结构setOfStacks	
	
	/**
	 * 给定一个操作序列int[][2] ope(C++为vector&ltvector&ltint>>)，
	 * 每个操作的第一个数代表操作类型，若为1，则为push操作，后一个数为应push的数字；
	 * 若为2，则为pop操作，后一个数无意义。
	 * 
	 * 
	 * 思路
	 * 依次遍历ope；
	 * 如是1，则判断arrList的大小是否小于size：小于，直接add；反之new一个arrList，再add；
	 * 如是2，则删除arrList最后一个值，然后判断arrList的大小，是0则删除，arrList等于此时的result最后一个；
	 * 
	 * @param args
	 */
	
	
	public static ArrayList<ArrayList<Integer>> setOfStacks(int[][] ope, int size) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if(ope==null||ope.length<1)
            return result;
		ArrayList<Integer> arrList = new ArrayList<Integer>();
		result.add(arrList);
		for(int i=0;i<ope.length;i++) {
			switch (ope[i][0]) {
			case 1:
				if(size==arrList.size()) {
					arrList = new ArrayList<Integer>();
					result.add(arrList);
				}
				arrList.add(ope[i][1]);	
				break ;
			case 2:
				if(arrList.size()!=0)
					arrList.remove(arrList.size()-1);
				if(arrList.size()==0&&result.size()>1) {
					result.remove(arrList);
					if(result.size()>0)
						arrList = result.get(result.size()-1);
				}
				break ;
			}
			
		}
			return result;

	}

##	twoStacksSort双栈排列

	/**
	 * 按升序对栈进行排序（即最大元素位于栈顶），要求最多只能使用一个额外的栈存放临时数据，但不得将元素复制到别的数据结构中。
	 * 
	 * 思路：
	 * 将初始栈中栈顶元素移到临时栈；
	 * 然后依次比较初始栈栈顶元素赋值给一个临时变量，并和临时栈元素的大小；
	 * 如何小于，则按照第一步来。反之，将临时栈大的元素一会初始栈，直至小于等于临时变量后，操作第一步；
	 * 最后将临时栈的值赋值给ArrayList
	 * 
	 * @param numbers
	 * @return
	 */
	
	 public static ArrayList<Integer> twoStacksSort(int[] numbers) {
		 
		 ArrayList<Integer> result = new ArrayList<Integer>();
		 Stack<Integer> initStack = new Stack<Integer>();
		 if(numbers.length<1)
			 return result;
		 for(int i:numbers) {
			 initStack.push(i);
		 }
		 Stack<Integer> temporaryStack = new Stack<Integer>();
		 while(!initStack.isEmpty()) {
			 if(temporaryStack.isEmpty())
				 temporaryStack.push(initStack.pop());
			 else {
				 int temp = initStack.pop();
				 while(!temporaryStack.isEmpty()&&temp<temporaryStack.peek()) {
					 
					 initStack.push(temporaryStack.pop());
					 
				 }
				 temporaryStack.push(temp);
			 }
		 }
		 while(!temporaryStack.isEmpty()) {
			 result.add(temporaryStack.pop());
		 }
		 return result;
	 }
	
##	asylum动物收养所

	 /**
	  * 	  有家动物收容所只收留猫和狗，但有特殊的收养规则，收养人有两种收养方式，
	  *  	第一种为直接收养所有动物中最早进入收容所的，第二种为选择收养的动物类型（猫或狗），并收养该种动物中最早进入收容所的。
	  * 	给定一个操作序列int[][2] ope(C++中为vector<vector<int>>)代表所有事件。
	  * 	若第一个元素为1，则代表有动物进入收容所，第二个元素为动物的编号，正数代表狗，负数代表猫；
	  * 	若第一个元素为2，则代表有人收养动物，第二个元素若为0，则采取第一种收养方式，若为1，则指定收养狗，若为-1则指定收养猫。
	  * 	请按顺序返回收养的序列。若出现不合法的操作，即没有可以符合领养要求的动物，则将这次领养操作忽略。 
	  * 
	  * 	思路：
	  * 	首先定义两个ArrayList，一个用来储存收养所的小动物；一个用来储存领养的动物；
	  * 	剩下个可参照第二的练习；
	  * 
	  * 
	  * @param ope
	  * @return
	  */
	 
	public static ArrayList<Integer> asylum(int[][] ope) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		ArrayList<Integer> asylum = new ArrayList<Integer>();
		if (ope == null || ope.length < 1)
			return asylum;
		for (int i = 0; i < ope.length; i++) {
			switch (ope[i][0]) {
			case 1:
				result.add(ope[i][1]);
				break;

			case 2:

				switch (ope[i][1]) {
					case 0:
						asylum.add(result.get(0));
						result.remove(0);
						break;
					case 1:
						for(int j =0;j<result.size();j++) {
							if(result.get(j)>0) {
								asylum.add(result.get(j));
								result.remove(j);
								break;
							}
						}
						break;
					case -1:
						for(int j =0;j<result.size();j++) {
							if(result.get(j)<0) {
								asylum.add(result.get(j));
								result.remove(j);
								break;
							}
						}
						break;
				}
				
				break;
			}

		}
		return asylum;
	}
	


## 合法括号序列判断
	
	/**
	 * Q:对于一个字符串，请设计一个算法，判断其是否为一个合法的括号串。
	 * 给定一个字符串A和它的长度n，请返回一个bool值代表它是否为一个合法的括号串。
	 * 
	 * A:定义一个栈；遇到（进栈，遇到）且栈非空，出栈，否则返回false
	 * 如何遇到其他字符，返回false，执行到最后，返回栈是否为空；
	 * 
	 * @param A
	 * @param n
	 * @return
	 */
	public boolean chkParenthesis(String A, int n) {
		Stack<Character> stack = new Stack<Character>();
		for(int i=0;i<n;i++) {
			char temp = A.charAt(i);
			switch (temp) {
			case '(':
				stack.add(temp);
				break ;
			case ')':
				if(stack.isEmpty())
					return false;
				stack.pop();
				break ;

			default:
				return false;
			}
		}
		return stack.isEmpty();
	}
	
	
##	main方法
	
	/**
	 * main方法
	 * Test测试
	 * @param args
	 */
	
	public static void main(String[] args) {
	
	//		int[][] i = {{1,2},{2,2},{1,3},{2,5},{1,1997},{1,3},{1,5}};
	//		ArrayList<ArrayList<Integer>> result = setOfStacks(i,3);
	//		System.out.println(result.size());
	//		System.out.println(result.get(0).get(0));
	//		System.out.println(result.get(0).get(1));
	//		System.out.println(result.get(0).get(2));

	//		push(1);
	//		push(2);
	//		push(3);
	//		System.out.println("删除:"+pop());

			int [][] num = {{1,1},{1,-1},{2,0},{2,-1}};
	//		
	//		ArrayList<Integer> list = twoStacksSort(num);
	//		for(int i:list) {
	//			System.out.println(i);
	//		}
		
		ArrayList<Integer> result = asylum(num);
		for(int i:result) {
			System.out.println(i);
		}
	}

}

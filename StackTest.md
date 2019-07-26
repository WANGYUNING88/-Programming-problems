import java.util.*;

#       StackTest


public class StackTest {
	
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
		
		push(1);
		push(2);
		push(3);
		System.out.println("删除:"+pop());
	}

}

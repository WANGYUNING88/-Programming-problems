# RecursiveMethod
**总结常见的递归问题**

##  hanoi汉诺塔问题
   /**
     * 
     * 思路：
     * 	虽有的问题都可以看做两种情况
     * 		1，一个盘子：A->C
     * 		2,两个盘子：上面所虽有盘子A->B,下面的一个盘A->C,上面所有盘子B->C.
     * 
     * @param n				一共几个盘子
     * @param from			起始盘子的柱子
     * @param in			中间柱子
     * @param to			目标柱子
     */
    public static void hanoi(int n,char from,char in ,char to) {
    	if(n==1) {
    		System.out.println("第 "+n+" 个盘子从 "+from+" 移动到 "+to);
    	}else {
    		//移动上面所有的盘子移到中间盘子
    		hanoi(n-1,from,to,in);
    		System.out.println("第 "+n+" 个盘子从 "+from+" 移动到 "+to);
    		//移动下面这一个盘子移到目标盘子
    		hanoi(n-1,in,from,to);
    		
    	}
    }

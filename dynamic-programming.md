#        dynamic programming   动态规划问题解决

##  经典问题 爬楼梯

    /**
	 * Q:有个小孩正在上楼梯，楼梯有n阶台阶，小孩一次可以上1阶、2阶、3阶。请实现一个方法，计算小孩有多少种上楼的方式。为了防止溢出，
	 * 	请将结果Mod 1000000007 ,给定一个正整数int n，请返回一个数，代表上楼的方式数。保证n小于等于100000。 
	 * 
	 * A:如果上到n层（n>=4），那么可以从n-1层上一层（即f(n-1)+1)，或者从n-2层上两层（即f(n-2)+2），
	 * 	或者从n-3层上三层（即f(n-3)+4），
	 * 	依次计算，可以使用递归（从上到下），也可以使用动态规划（自下而上）。
	 * 
	 * @param n
	 * @return
	 */
	public int countWays(int n) {
	    switch (n) {
			case 1:
				return 1;
			case 2:
				return 2;
			case 3:
				return 4;
		}
		int a = 1;
		int b =2;
		int c = 4;
		int temp = 0;
		for(int i=4;i<=n;i++) {
			temp = ((a+b)%1000000007+c)%1000000007;		//标志1</font>
			a=b;
			b=c;
			c= temp;
		}
		return temp;
    }
    
  ##      机器人走方格I

	/**
	 * Q：有一个XxY的网格，一个机器人只能走格点且只能向右或向下走，要从左上角走到右下角。请设计一个算法，计算机器人有多少种走法。
	 * 给定两个正整数int x,int y，请返回机器人的走法数目。保证x＋y小于等于12。
	 * 
	 * A:初始化第一行和第一列，因为横着走和竖着走都只有一种方法；
	 * dp[i][j] = dp[i-1][j]+dp[i][j-1]:即是，到某一格，就是到它左一格或者上一格，
	 * 
	 * @param x
	 * @param y
	 * @return
	 */
	public static int countWays(int x, int y) {
        int[][] dp = new int[13][13];
        dp[0][0]=1;
        for(int i =1;i<y;i++) {
        	dp[0][i] =1;
        }
        for(int i =1;i<x;i++) {
        	dp[i][0]=1;
        }
        for(int i=1;i<x;i++) {
        	for(int j=1;j<y;j++) {
        		dp[i][j] = dp[i-1][j]+dp[i][j-1];
        	}
        }
        return dp[x-1][y-1];
    }
    
  ##      机器人走方格Ii

	/**
	 * Q:有一个XxY的网格，一个机器人只能走格点且只能向右或向下走，要从左上角走到右下角。
	 * 请设计一个算法，计算机器人有多少种走法。注意这次的网格中有些障碍点是不能走的。
	 * 给定一个int[][] map(C++ 中为vector >),表示网格图，若map[i][j]为1则说明该点不是障碍点，否则则为障碍。
	 * 另外给定int x,int y，表示网格的大小。请返回机器人从(0,0)走到(x - 1,y - 1)的走法数，
	 * 为了防止溢出，请将结果Mod 1000000007。保证x和y均小于等于50
	 * 
	 * A:本题思路和机器人走方格1一样，但是要判断是否有障碍物；
	 * 
	 * @param map
	 * @param x
	 * @param y
	 * @return
	 */
	public static int countWaysII(int[][] map, int x, int y) {
        int [][] dp = new int[51][51];
        
        boolean xFlag = true;
        boolean yFlag = true;
        
        for(int  i=1;i<x;i++) {
        	if(map[i][0]==1&&xFlag)
        		dp[i][0] = 1;
        	else {
        		dp[i][0]=0;
        		xFlag = false;
        	}
        }
        
        for(int  i=1;i<y;i++) {
        	if(map[0][i]==1&&yFlag)
        		dp[0][i] = 1;
        	else {
        		dp[0][i]=0;
        		yFlag = false;
        	}
        }
        for(int i=1;i<x;i++) {
        	for(int j=1;j<y;j++) {
        		if(map[i][j]==0)
        			dp[i][j] = 0;
        		else
        			dp[i][j] = (dp[i-1][j]+dp[i][j-1])%1000000007;
        		
        	}
        }
        return dp[x-1][y-1];
    }

 ##   main 用来标注或解释问题
	
	/**
	 * main
	 * @param args
	 */
	public static void main(String[] args) {
		//标志1
		a[i]=((a[i-1]+a[i-2])%1000000007+a[i-3])%1000000007的解释：
		取模运算有这样一个性质：(a+b)%c = ((a%c)+(b%c))%c
		所以(a[i-1]+a[i-2])%1000000007就相当于(a[i-1]%X+a[i-2]%X)%X   用X代替1000000007
		这样就使得a[i-1]、a[i-2]、a[i-1]+a[i-2]都没有溢出，之后再与a[i-3]相加之后取模，使得全部结果没有溢出。
	}

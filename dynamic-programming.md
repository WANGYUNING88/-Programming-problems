#        dynamic programming   动态规划问题解决

##	最长递增子序列（LCS） 
	/**
	 * 	Q:给定一个序列 An = a1 ,a2 ,  ... , an ，
	 * 	找出最长的子序列使得对所有 i < j ，ai < aj 。求出这个子序列的长度
	 * 
	 *	A:dp[i]: 表示以a[i]为结尾的最长递增子序列的长度
	 *	dp[i] = 1    i属于[0, len(a))
   	 *	i属于[0, len(a))
	 *	if (a[j] <= a[i]) dp[i] = max(dp[i], dp[j] + 1)  j属于[0, i)
	 * @param 
	 * @return
	 */
	public static void getNum() {

		Scanner sc = new Scanner(System.in);

		ArrayList<Integer> list = new ArrayList<Integer>();
		String an = sc.nextLine();
		String[] strings = an.split(" ");
		if(strings.length==0) {
			System.out.println(0);
			return;
		}
		for (String s : strings) {
			list.add(Integer.parseInt(s));
		}

		int[] counts = new int[list.size()];
		int max = 0;
		for (int i = 0; i < counts.length; i++) {
			counts[i] = 1;
			for (int j = 0; j < i; j++) {
				if (list.get(i) >= list.get(j))
					counts[i] = Math.max(counts[i], counts[j] + 1);
				// System.out.println("第"+i+"是"+counts[i]);
			}
			max = Math.max(max, counts[i]);
		}

		System.out.println(max);

	}

##	整数成绩最大化
	/**整数成绩最大化
	 * Q:给出一个整数n，将n分解为至少两个整数之和，
	 * 	使得这些整数的乘积最大化，输出能够获得的最大的乘积。 
	 * A:最大收益是3，余数为1则分给其中一个3,得到4，余数为2则乘上去
	 * 	所以只需要列举出递推的前三项，第4、5、6项，然后递推a[i]=a[i-3]*3
	 * @param n
	 * @return
	 */
	public static void getNums() {

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] result = new int[n > 6 ? n : 6];
		int[] temp = { 0, 1, 2, 4, 6, 9 };
		if (n <= 6) {
			System.out.println(temp[n - 1]);
		} else {
			for (int i = 0; i < 6; i++) {
				result[i] = temp[i];
			}
			for (int i = 6; i < n; i++) {
				result[i] = result[i - 3] * 3;
			}
			System.out.println(result[n - 1]);
		}

	}

##	最大连续子序和
	/**
	 * 最大连续子序和
	 * 
	 *思路：到第i的为最后一个数的数组最大连续子序和（sums[i]）是到第i-1个的数组的最大连续子序和(sums[i-1])与第i的数的和(nums[i])，
	 *即是sums[i-1]+nums[i]与第i个数(nums[i])比较取最大的数。即公式是nums[i]=Math.MAX(nums[i-1]+nums[i],nums[i];
	 * @param n
	 * @return
	 */
	public static void getNum() {

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int[] nums = new int[N];
		for (int i = 0; i < N; i++) {
			nums[i] = sc.nextInt();
		}

		int[] sums = new int[N];
		sums[0] = nums[0];
		int max = sums[0];
		for (int i = 1; i < N; i++) {
			sums[i] = Math.max(nums[i], sums[i - 1] + nums[i]);
			max = Math.max(max, sums[i]);
			//System.out.println("第"+i+"个sums:"+sums[i]);
		}

		System.out.println(max);
	
	}

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
    
  ##      机器人走方格II

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
    
##  经典问题:硬币
    
    /**
	 * Q：有数量不限的硬币，币值为25分、10分、5分和1分，请编写代码计算n分有几种表示法。
	 * 给定一个int n，请返回n分有几种表示法。保证n小于等于100000，为了防止溢出，请将答案Mod 1000000007。
	 * 
	 * A：依然采用动态规划；要求n分，那么我们可以加上n-25,n-10,n-5和n-1的总数；
	 * countWays1是一维数组的解法。countWays2是二维数组的思路；
	 * 
	 * @param n
	 * @return
	 */
	public static int countWays1(int n) {
        // write code here
		int []face_value = {1,5,10,25};
		int[] dp = new int[n+1];
		dp[0]=1;
		if(n==0)
			return dp[0];
		
		for (int i= 0; i < 4; i++) {
			for(int j=face_value[i];j<=n;j++) {
				dp[j] = (dp[j] + dp[j - face_value[i]]) % 1000000007;
		
			}
		}

		return dp[n];
    }
	
	public static int countWays2(int n) {
        // write code here
		 int A[] = {1, 5, 10, 25}, dp[][] = new int[A.length][n + 1];
		    for (int j = 0; j <= n; j++) {
		        dp[0][j] = 1;
		    }
		    for (int i = 1; i < A.length; i++) {
		        for (int j = 0; j <= n; j++) {
		            int t = j - A[i];
		            if (t >= 0) {
		                dp[i][j] = (dp[i - 1][j] + dp[i][t]) % 1000000007;
		            } else {
		                dp[i][j] = dp[i - 1][j];
		            }
		        }
		    }
		 
		    return dp[A.length - 1][n];
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

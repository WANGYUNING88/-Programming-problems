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
			temp = ((a+b)%1000000007+c)%1000000007;
			a=b;
			b=c;
			c= temp;
		}
		return temp;
    }
	
 ##   main 
	
	/**
	 * main
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

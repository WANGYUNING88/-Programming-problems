
#        MathSolution

            public class MathSolution {

##        碰撞的蚂蚁

            /**
             *  在n个顶点的多边形上有n只蚂蚁，这些蚂蚁同时开始沿着多边形的边爬行，请求出这些蚂蚁相撞的概率。(这里的相撞是指存在任意两只蚂蚁会相撞)
             *  给定一个int n(3<=n<=10000)，代表n边形和n只蚂蚁，请返回一个double，为相撞的概率
             * 
             *  思路：
             *  每个蚂蚁都有两个方向可以走，
             *  如果都按照同一方向走，就不会撞；
             * 
             * @param n
             * @return
             */
            public double antsCollision(int n) {
              return 1 - Math.pow(0.5, n) * 2;
            }
            
##       判断直线是否相交

            /**
             * 线段以斜率和截距的形式给出，即double s1，double s2，double y1，double y2，
             * 分别代表直线1和2的斜率(即s1,s2)和截距(即y1,y2)，
             * 请返回一个bool，代表给定的两条直线是否相交。这里两直线重合也认为相交
             * 
             * 思路：
             * 只要斜率不相等，就不会相交，除非重合；
             * 
             * @param s1
             * @param s2
             * @param y1
             * @param y2
             * @return
             */
            public boolean checkCrossLine(double s1, double s2, double y1, double y2) {
                  // write code here
                  return s1!=s2||y1==y2;
              }
              
##        加法运算代替              

            /**
             * 实现整数的乘法、减法和除法运算(这里的除指整除)。只允许使用加号。
             * 给定两个正整数int a,int b,同时给定一个int type代表运算的类型，1为求a ＊ b，0为求a ／ b，-1为求a － b。
             * 请返回计算的结果，保证数据合法且结果一定在int范围内。
             * 
             * 思路：
             * a-b = a+(~b)+1;
             * ~b是b的反码；
             * 
             * @param a
             * @param b
             * @param type
             * @return
             */	
            public int calc(int a, int b, int type) {
              int result = 0;
              switch (type) {
              case 1:
                for(int i =0 ;i<b;i++) {
                  result+=a;
                }
                break;
              case 0:
                while(a>=b) {
                  a=a+(~b)+1;
                  result++;
                }
                break;
              case -1:
                result = a+(~b)+1;
                break;
              }
              return result;
            }

##      平分的直线

	/**
	 *	在二维平面上，有两个正方形，请找出一条直线，能够将这两个正方形对半分。假定正方形的上下两条边与x轴平行。
	 *	给定两个vecotrA和B，分别为两个正方形的四个顶点。请返回一个vector，代表所求的平分直线的斜率和截距，保证斜率存在。 
	 * 
	 * 	思路：
	 * 	1，如何平分正方形，必须经过中点，计算两个正方形的中心点，A,B
	 * 	2.k=(B.Y-A.Y)/(B.X-A.X);
	 *  3，b = y-k*x;
	 * 
	 * @param A
	 * @param B
	 * @return
	 */
	public static double[] getBipartition(Point[] A, Point[] B) {
		double[] result = new double[2];
		double[] centreA = new double[2];
		double[] centreB = new double[2];
		
		for(Point p:A) {
			centreA[0]+=p.x;
			centreA[1]+=p.y;
		}

		centreA[0]=centreA[0]/4;
		centreA[1]=centreA[1]/4;
		
		for(Point p:B) {
			centreB[0]+=p.x;
			centreB[1]+=p.y;
		}
	
		centreB[0]=centreB[0]/4;
		centreB[1]=centreB[1]/4;
		double k = (centreB[1]-centreA[1])/(centreB[0]-centreA[0]);
		double b = centreA[1]-k*centreA[0];
		result[0] = k;
		result[1] = b;
		return result;
        
             }
	
##     Main方法
            
            /**
	 * main方法
	 * @param args
	 */
            public static void main(String[] args) {
              int b = 5;
              System.out.println(~b+1);
            }
          }

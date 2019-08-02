
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

##     Main方法

            public static void main(String[] args) {
              int b = 5;
              System.out.println(~b+1);
            }
          }

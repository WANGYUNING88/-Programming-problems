
#    ShiftOperation

            public class ShiftOperation {

##  二进制插入

              /**
               *	有两个32位整数n和m，请编写算法将m的二进制数位插入到n的二进制的第j到第i位,其中二进制的位数从低位数到高位且以0开始。
               *	给定两个数int n和int m，同时给定int j和int i，意义如题所述，请返回操作后的数，保证n的第j到第i位均为零，且m的二进制位数小于等于i-j+1。
               * 
               * 	题目保证 j 到i 为0. 那么m左移j位后与 n相加即可 或者 m左移j位后与n做或运算 
               * 
               * @param n
               * @param m
               * @param j
               * @param i
               * @return
               */
              public int binInsert(int n, int m, int j, int i) {
                // return n+(m<<=j);    加运算；
                return n | (m <<= j);   // 或运算；
              }
              
      ##  二进制小数

              /**
               * 
               * 	有一个介于0和1之间的实数，类型为double，返回它的二进制表示。如果该数字无法精确地用32位以内的二进制表示，返回“Error”。
               * 	给定一个double num，表示0到1的实数，请返回一个string，代表该数的二进制表示或者“Error”。 
               * 
               * 	思路：
               * 	因为小数点后第一位表示的是0.5，第二位是0.25，第三位是0.125。。。。。。
               * 	如果num 大于等于 base = 0.5 则第一位则为1，num 减去0.5 否则为0。无论是不是为1，base都的除以2，以来判断第二位是不是为1，以此类推。。。。
               * 
               * @param num
               * @return
               */
              public String printBin(double num) {
                    if(num<=0||num>=1)
                      return "Error";
                    StringBuffer sb = new StringBuffer("0.");
                    double base = 0.5;
                    while(num!=0.0) {
                      if(num>=base) {
                        sb.append("1");
                        num = num-base;
                      }else {
                        sb.append("0");

                      }
                      base = base/2;
                      if(sb.length()>32)
                        return "Error";
                    }

                    return sb.toString();
                }



            }

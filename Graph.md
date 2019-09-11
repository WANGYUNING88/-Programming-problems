# Graph图
##  1.城市图
  如图：

### 1）Edge 边类
    /**
     * 	边
     * @author 1
     *
     */
    public class Edge {
        String beginCity;//开始的城市,边的开端；
        String endCity;//结束的城市，边的指向；
        int length;//城市之间的距离；边的权值

      public Edge(String beginCity, String endCity, int length) {
        this.beginCity = beginCity;
        this.endCity = endCity;
        this.length = length;
      }
    }
    
### 2)Graph 图类

      import java.util.*;

      public class Graph {
        int size;
        int[][] matrix;
        String[] cityArray;

    /**
     * 构造函数
     * @param cityArray 城市的数组
     * @param edges	边的数组
     * @param direction 有无向图
     */
    public Graph(String[] cityArray, Edge[] edges, boolean direction) {
        this.size = cityArray.length;
        this.cityArray = cityArray;
        this.matrix = new int [size][size];
        Map<String,Integer> cityMap =new HashMap<String, Integer>();
        for(int i=0;i<size;i++) {
          cityMap.put(cityArray[i], i);
        }

        for(int i=0;i<size;i++) {
          for(int j=0;j<size;j++) {

            if(i==j) {
              matrix[i][j] = 0;
            }else {
              matrix[i][j] = Integer.MAX_VALUE;
            }
          }
        }

        for (Edge e : edges) {
          int begin = cityMap.get(e.beginCity);
          int end = cityMap.get(e.endCity);
          matrix[begin][end] = e.length;
          if (!direction) {
            matrix[end][begin] = e.length;
          }
        }


      }

      /**
       * 打印图的邻接矩阵
       */
      public void print() {

        for (int i = 0; i < matrix.length; i++) {
          int[] ii = matrix[i];
          System.out.print(cityArray[i] + "  ");
          for (int j : ii) {
            System.out.printf("%-16d", j);
          }
          System.out.println();
        }
      }
      /**
       * 	深度优先
       * @param start
       * @param visit
       */
      public void dfs(int start, int[] visit) {

        //打印当前访问的节点
        System.out.println(cityArray[start]+"  " );
        visit[start]=1;
        for(int i =0;i<visit.length;i++) {
          if(matrix[start][i]>0&&matrix[start][i]!= Integer.MAX_VALUE&&visit[i]==0)
            dfs(i,visit);
        }

      }
      /**
       * 	广度优先
       * @param start
       */
      public void bfs(int start) {

        int visit[] = new int[size];
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(start);
        visit[start] = 1;
        while(!queue.isEmpty()) {
          int temp = queue.poll();
          System.out.println(cityArray[temp]+"  ");
          for(int i =0;i<size;i++) {
            if(matrix[temp][i]>0&&matrix[temp][i]!= Integer.MAX_VALUE&&visit[i]==0) {
              queue.add(i);
              visit[i] =1;
            }

          }
          //System.out.println("还剩"+queue.size()+"个元素");
        }


      }

    }
    
  ### 3)Test 测试类
    import java.util.*;
    public class Test {

      /**
       * 
       * @param direction
       *            是否生成有向图
       * 	false 是 无向图；true 是有向图；
       * @return
       */
      public static Graph createGraph(boolean direction) {
        String[] citys = new String[] { "北京", "上海", "广州", "重庆", "武汉", "南昌" };

        List<Edge> edgeList = new ArrayList<>();
        edgeList.add(new Edge("北京", "广州", 10));
        edgeList.add(new Edge("北京", "上海", 11));
        edgeList.add(new Edge("上海", "南昌", 6));
        edgeList.add(new Edge("广州", "重庆", 14));
        edgeList.add(new Edge("广州", "武汉", 9));
        edgeList.add(new Edge("重庆", "武汉", 20));
        edgeList.add(new Edge("武汉", "北京", 13));
        edgeList.add(new Edge("武汉", "南昌", 12));
        edgeList.add(new Edge("南昌", "广州", 18));

        Edge[] edgeArray = new Edge[edgeList.size()];

        return new Graph(citys, edgeList.toArray(edgeArray), direction);
      }

      public static void main(String[] args) {
        // TODO Auto-generated method stub
    //		Graph graph = createGraph(false);
    //		System.out.println("无向图的矩阵如下：");
    //		graph.print();
        Graph graph = createGraph(true);
        System.out.println("有向图的矩阵如下：");
        graph.print();
         // Graph graph = createGraph(false);

        System.out.println("深度优先遍历顺序如下：");
            int[] visit = new int[graph.size];
            graph.dfs(0, visit);

            System.out.println("广度优先遍历顺序如下：");
            graph.bfs(0);

      }

    }
 

import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int step = 0;
        int x = 1;
        while(x++ > 0){
            int num = x*x;
            int len = Math.abs(a-num);
        }
    }
    public static void main57(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int i = 0;i < T;i++){
            int s = sc.nextInt();
            System.out.println(whatGraphic(s));
        }
        sc.close();
    }
    //推测图形类型
    public static int whatGraphic(int s){
        //正方形
        double a = Math.sqrt(s);
        if(a == Math.floor(a)){
            return 0;
        }
        return 3;
    }
    public static void main56(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        if(a > b){
            System.out.println("kou");
        }else if(a < b){
            System.out.println("yukari");
        }else{
            System.out.println("draw");
        }
    }
    public static void main53(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();
        String [][]arr = new String[n][m];
        for(int i = 0;i < n;i++){
            for(int j = 0;j < m;j++){
                arr[i][j] = sc.nextLine();
            }
        }
        int num = 0;
        for(int i = 0;i < n;i++){
            for(int j = 0;j < m;j++){
                if(arr[i][j].equals("W")){//向上打怪
                    for(int k = 0;k < i;k++){
                        if(arr[k][j].equals("*")){
                            num++;
                        }
                    }
                    System.out.println(num);
                    return;
                }
                if(arr[i][j].equals("A")){//向左打怪
                    for(int k = 0;k < j;k++){
                        if(arr[i][k].equals("*")){
                            num++;
                        }
                    }
                    System.out.println(num);
                    return;
                }
                if(arr[i][j].equals("S")){//向下打怪
                    for(int k = i;k < n ;k++){
                        if(arr[k][j].equals("*")){
                            num++;
                        }
                    }
                    System.out.println(num);
                    return;
                }
                if(arr[i][j].equals("D")){//向右打怪
                    for(int k = j;k < m ;k++){
                        if(arr[i][k].equals("*")){
                            num++;
                        }
                    }
                    System.out.println(num);
                    return;
                }
            }
        }
    }

    public static void main52(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0){
            int r = sc.nextInt();
            int h = sc.nextInt();
            sc.nextLine();
            double ball_V = (4.0/3)* 3.141592653589*Math.pow(r,3);//球体积
            double cylder_V = 3.141592653589*Math.pow(r,2)*h;//圆柱体体积
            if(h < 2*r){//放不下一个球
                System.out.println(String.format("%.3f",cylder_V));
                continue;
            }
            int ballNum = h/(2 * r);//计算可以放下的球的个数
            double left_V = cylder_V-ball_V*ballNum;//计算放球后的剩余体积
            System.out.println(String.format("%.3f", left_V));
        }
        sc.close();
    }
    //计算最多可放下多少个球
    public static int ballCount(double x,double y){
        return (int)(y/x);
    }
    public static void main51(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int v = sc.nextInt();
        int []arr = new int [n];
        for(int i = 0;i < n;i++){
            arr[i] = sc.nextInt();
        }
        //quickSort(arr,0,n-1);
        int sum = 0;
        int time = 0;
        for(int i = 0;i < n;i++){
            if(arr[i] == v){
                time++;
                continue;
            }
            if(arr[i] <= v && (v - sum) >= arr[i]){
                sum+=arr[i];
            }
            if(i == n-1 && arr[i] <= v && (v - sum) >= arr[i]){
                //最后一个商品并且可以装下
                time++;
                continue;
            }
            if((sum + arr[i+1]) > v){//此时无法再装下后面一个商品.开始计数
                time++;
                sum = 0;
            }
        }
        System.out.println(time);
    }
    public static void main55(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int sum = a+b+c;
        int maxNum = Math.max(Math.max(a,b),c);
        int minNum = Math.min(Math.min(a,b),c);
        int midNum = sum-minNum-maxNum;
        int num1 = minNum * midNum;
        int num2 = minNum + midNum;
        if(num1 >= num2){
            System.out.println(num1*maxNum);
        }else{
            System.out.println(num2*maxNum);
        }
    }
    public static void main45(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        if(a < 1 || b < 1 || c < 1){
            System.out.println("No");
            return;
        }
        if(a + b > 2*c && b + c > 2*a && a + c > 2*b){
            System.out.println("Yes");
        }else{
            System.out.println("No");
        }
    }
    public static void main19(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();//消耗换行符,避免换行符被读取到数组中
        String[]arr = new String[n];//存储操作记录
        for(int i = 0;i < n;i++){
            arr[i] = sc.nextLine();
        }
        for(int i = 0;i < n;i++){
            String str = arr[i];
            if(str.contains("insert")){//插入操作
                int index = Integer.valueOf(str.charAt(7));
                int num = Integer.valueOf(str.substring(9));//待插入数字
                if(list.size() == 0){
                    list.add(0,num);//头插法
                }
                if(list.contains(num) == false){//链表不包含待插入元素.使用尾插
                    list.add(num);
                }else{

                }
            }
        }
    }

    public static void main18(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();//消耗换行符,避免换行符被读取到数组中
        String[]arr = new String[n];//存储操作记录
        for(int i = 0;i < n;i++){
            arr[i] = sc.nextLine();
        }
        Stack<Integer> stack = new Stack<>();
        //遍历数组,做出对应的回复
        for(int i = 0;i < n;i++){
            String str = arr[i];
            if(str.contains("push")){
                int num = Integer.valueOf(str.substring(5));//截取数字
                stack.add(num);
                continue;
            }
            if(str.contains("pop")){
                if(stack.size() == 0){
                    System.out.println("error");
                    continue;
                }
                System.out.println(stack.pop());
                continue;
            }
            if(str.contains("top")){
                if(stack.size() == 0){//栈为空
                    System.out.println("error");
                    continue;
                }
                System.out.println(stack.peek());
            }
        }
    }

    public static void main17(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();//消耗换行符,避免换行符被读取到数组中
        String[]arr = new String[n];//存储操作记录
        for(int i = 0;i < n;i++){
            arr[i] = sc.nextLine();
        }
        Queue<Integer> queue = new LinkedList<>();
        //遍历数组,做出对应的回复
        for(int i = 0;i < n;i++){
            String str = arr[i];
            if(str.contains("push")){
                int num = Integer.valueOf(str.substring(5));//截取数字
                queue.add(num);
                continue;
            }
            if(str.contains("pop")){
                if(queue.size() == 0){
                    System.out.println("error");
                    continue;
                }
                System.out.println(queue.poll());
                continue;
            }
            if(str.contains("front")){
                if(queue.size() == 0){//队列为空
                    System.out.println("error");
                    continue;
                }
                System.out.println(queue.peek());
            }
        }
    }
    public static void main16(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int []arr = new int[n];
        for(int i = 0;i < n;i++){
            arr[i] = sc.nextInt();
        }
        //排序
        quickSort(arr,0, arr.length-1);
        for(int x:arr){
            System.out.print(x+" ");
        }
    }
    //快速排序
    public static void quickSort(int[] arr,int left,int right){
        if(left >= right){
            return;
        }
        //先整体快排
        int mid = quick(arr,left,right);
        //左边快排
        quickSort(arr,left,mid);
        //右边快排
        quickSort(arr,mid+1,right);
    }
    public static int quick(int []arr,int left,int right){
        int start = left;
        int end = right;
        int base = arr[start];
        while (start < end){
            while(start < end && arr[end] >= base){
                end--;
            }
            arr[start] = arr[end];
            while (start < end && arr[start] <= base){
                start++;;
            }
            arr[end] = arr[start];
        }
        arr[start] = base;
        return start;
    }
    public static void swap(int []arr,int x,int y){
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }
    public static void main15(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int M = sc.nextInt();
        int minStep = Math.abs(a)+Math.abs(b);
        if((minStep)%2==0){//坐标之和为偶数
            if(M%2 == 0&&M >= minStep){
                System.out.println("Yes");
            }else{
                System.out.println("No");
            }
        }else{//坐标之和为奇数
            if(M%2 != 0&& M>= minStep){
                System.out.println("Yes");
            }else{
                System.out.println("No");
            }
        }
    }
    public static void main14(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        sc.nextLine();
        String [][]arr = new String[x + 2][y + 2];
        //把最外层边界填入"?"
        for(int i = 0;i < x+2;i++){
            for(int j = 0;j < y+2;j++){
                if(i == 0 || i == x+1 || j == 0 || j == y+1) {
                    arr[i][j] = "?";
                }
            }
        }
        //内层填入雷
        for(int i = 1;i <= x;i++){
            String strline = sc.nextLine();
            for(int j = 1;j <= y;j++){
                arr[i][j] = String.valueOf(strline.charAt(j-1));
            }
        }
        for(int i = 1;i < x+1;i++){
            for (int j = 1;j < y+1;j++){
                System.out.print(bombCount(arr, i, j));
            }
            System.out.println();
        }
    }
    //计算九宫格内地雷个数
    public static String bombCount(String[][]arr,int x,int y){
        if(arr[x][y].equals("*")){//这里使用equals比较字符串内容,使用==比较的是字符串的引用
            return "*";
        }
        int count = 0;
        for(int i = x-1;i < x+2;i++){
            for(int j = y-1;j < y+2;j++){
                if(arr[i][j].equals("*")){
                    count++;
                }
            }
        }
        return String.valueOf(count);
    }


    public static void main13(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();//人数
        int k = sc.nextInt();//开始报数的编号
        int m = sc.nextInt();//报数次数
        LinkedList<Integer> list = new LinkedList<>();
        for(int i = 0;i < n;i++){
            list.add(i);
        }
        int delIndex = k;//起始报数位置
        while(list.size() > 1){
            delIndex = (delIndex + m - 1) % list.size();
            list.remove(delIndex);
        }
        System.out.println(list.get(0));
    }
    public static void main11(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        while(y > 0){
            int result = x%y;
            x = y;
            y = result;
        }
        System.out.println(x);
    }
    public static void main10(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(num1(n));
    }
    public static int num1(int n){
        if(n==1){
            return 0;
        }
        if (n == 2||n == 3) {
            return 1;
        }
        if(n>=4){
            return num1(n-3)+2*num1(n-2)+num1(n-1);
        }
        return 0;
    }
    public static void main9(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if(n == 1|| n==2){
            System.out.println(1);
            return;
        }
        int f1 = 1;
        int f2 = 1;
        int fibNum = 0;
        for(int i = 3;i <= n;i++){
            fibNum = f1 + f2;
            f1 = f2;
            f2 = fibNum;
        }
        System.out.println(fibNum);
    }
    public static void main8(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int sum = 0;
        int result = 0;
        for(int i = 1;i <= n;i++){
            result = 0;
            for(int j = 1;j <= i;j++){
                result += j;
            }
            sum += result;
        }
        System.out.println(sum);
    }
    public static void main7(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int tag = 1;
        float sum = 0;
        for(int i = 1;i <= n;i++){
            sum += 1.0/NumMom(i);
        }
        System.out.println(String.format("%.3f",sum));
    }
    public static int NumMom(int n){
        int tag = 1;
        int sum = 0;
        for(int i = 1;i <= n;i++){
            sum += (2*i-1)*tag;
            tag = -tag;
        }
        return sum;
    }
    public static void main6(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        float sum = 0;
        for(int i = 1;i <= n;i++){
            double result = 1.0 / i;
            sum+=result;
        }
        //String Sum = String.format("%.1f",sum);
        System.out.println(sum);
    }
    public static void main5(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int tag = 1;
        int sum = 0;
        for(int i = 1;i <= n;i++){
            sum+=(tag*i);
            tag = -tag;
        }
        System.out.println(sum);
    }
    public static void main4(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if(n % 4 == 0&&n % 100!=0||n % 400 ==0){
            System.out.println("yes");
        }else{
            System.out.println("no");
        }
    }
    public static void main3(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int x = num % 10;
        if(x >= 5){
            num += (10-x);
        }else{
            num -= x;
        }
        System.out.println(num);
    }
    public static void main2(String[] args) {
        Scanner sc = new Scanner(System.in);
        double f = sc.nextFloat();
        double c = 5.0 / 9 * (f - 32);
        String result = String.format("%.3f",c);
        System.out.println(result);
    }
    public static void main1(String[] args) {
        System.out.println("国庆快乐！");
    }
}
import java.util.Stack;

public class Main {
    public static int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int i = 0,n = s.length();
        char op = '+';
        while (i < n){
            if(s.charAt(i) == ' '){//1.字符是空格
                i++;
            }else if (s.charAt(i) >= '0' && s.charAt(i) <= '9'){//2.字符是数字
                int tmp = 0;
                while (i < n && s.charAt(i) >= '0' && s.charAt(i) <= '9'){//提取数字
                    tmp = tmp * 10 + (s.charAt(i) - '0');
                    i++;
                }
                if(op == '+'){
                    stack.push(tmp);
                }else if(op == '-'){
                    stack.push(-tmp);
                }else if(op == '*'){
                    stack.push(stack.pop() * tmp);
                }else{
                    stack.push(stack.pop() / tmp);
                }
            }else {//3.字符是运算符
                op = s.charAt(i);
                i++;
            }
        }
        int sum = 0;
        for(int x : stack){
            sum += x;
        }
        return sum;
    }
    //提取数字
    public static int getNum (String s,int i){
        int num = 0;
        while (s.charAt(i) > '0' && s.charAt(i) <= '9'){
            num = num * 10 + (s.charAt(i++) - '0');
        }
        return num;
    }
    public static void main(String[] args) {
        String s = "42";
        int sum = calculate(s);
        System.out.println(sum);
//        char ch = '6';
//        System.out.println(ch < '7');
    }
}
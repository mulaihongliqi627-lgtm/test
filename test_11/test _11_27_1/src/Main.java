import java.util.Arrays;
import java.util.Stack;

public class Main {
    public static String addBinary(String a, String b) {
        int i = a.length()-1,j = b.length()-1,cnt = 0;
        StringBuffer ret = new StringBuffer();
        while (i >= 0 || j >= 0 || cnt != 0){
            if(i >=0){
                cnt += a.charAt(i--) - '0';
            }
            if(j >= 0){
                cnt += b.charAt(j--) - '0';
            }
            ret.append((char)('0' + (char)(cnt % 2)));
            cnt /= 2;
        }
        return ret.reverse().toString();
    }
    public static String multiply(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0")){
            return "0";
        }
        int len1 = num1.length(),len2 = num2.length();
        int[]arr = new int[len1 + len2];
        StringBuffer str = new StringBuffer();
        for(int i = len1 - 1;i >=0;i--){
            for(int j = len2 - 1;j >= 0;j--){
                int x = num1.charAt(i) - '0';//字符转化为整数
                int y = num2.charAt(j) - '0';
                int sum = x * y;
                arr[i + j] += sum;//把计算之和存储到arr数组中，方便后续处理进位
                //判断sum值是否要进位,大于10就进位
                if(arr[i + j] >=10 && (i + j) > 0){//arr数组0位置无需进位
                    int t = arr[i + j] / 10;//计算进位数
                    arr[i + j - 1]  += t;
                    arr[i + j] = arr[i + j] % 10;
                }
            }
        }
        for(int k = 0;k < arr.length-1;k++){
            str.append(arr[k]);
        }
        return str.toString();
    }
    public static String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();
        StringBuffer str = new StringBuffer();
        for(int i = 0 ;i < s.length();i++){
            char ch = s.charAt(i);
            if(!stack.isEmpty() && ch == stack.peek() ){//和上一个入栈元素相同
                stack.pop();//栈顶元素出栈
                continue;
            }
            stack.push(ch);//入栈
        }
        while (!stack.isEmpty()){
            str.append(stack.pop());
        }
        return str.reverse().toString();
    }
    public static boolean backspaceCompare(String s, String t) {
        Stack<Character> stack1 = new Stack<>();
        Stack<Character> stack2 = new Stack<>();
        for(int i = 0;i < s.length();i++){
            char ch1 = s.charAt(i);
            if(!stack1.isEmpty() && ch1 =='#'){
                stack1.pop();
                continue;
            }else if(stack1.isEmpty() && ch1 == '#'){
                continue;
            }else{
                stack1.push(ch1);
            }
        }
        for(int j = 0;j < t.length();j++){
            char ch2 = t.charAt(j);
            if(!stack2.isEmpty() && ch2 =='#'){
                stack2.pop();
                continue;
            }else if(stack2.isEmpty() && ch2 == '#'){
                continue;
            }else{
                stack2.push(ch2);
            }
        }
        if(stack1.size() != stack2.size()){
            return false;
        }
        while (!stack1.isEmpty() && !stack2.isEmpty()){
            if(stack1.pop() != stack2.pop()){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        String s = "bxj##tw";
        String t = "bxj###tw";
        Boolean result = backspaceCompare(s,t);
        System.out.println(result);
    }
}
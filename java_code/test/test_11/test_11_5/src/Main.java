public class Main {

    public static String countAndSay(int n) {
        String []arr = new String[n];
        for(int i = 0;i < n;i++){//初始化
            arr[i] = "";
        }
        arr[0] = "1";
        for(int i = 1;i < n;i++){
            int left = 0,right = left;
            while(right < arr[i-1].length()){
                //找连续数字的长度
                while(right+1 < arr[i-1].length() && arr[i-1].charAt(right) == arr[i-1].charAt(right+1)){
                    right++;
                }
                int len = ++right - left;
                left = right;
                //添加字符
                arr[i] += len;
                arr[i] += arr[i-1].charAt(left-1);
            }
        }
        return arr[n-1];
    }

    public static void main(String[] args) {
        String result = countAndSay(4);
        System.out.println(result);
    }
}
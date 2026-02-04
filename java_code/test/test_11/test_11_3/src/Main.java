import java.util.Arrays;

public class Main {
    public static int[] missingTwo(int[] nums) {
        int n = nums.length;
        int ret = 0;
        //把这些数全部异或在一起
        for(int i = 1;i <= n + 2;i++){
            ret ^= i;
        }
        for(int x : nums){
            ret ^= x;
        }
        //此时的ret为a^b的结果，a和b就是缺少的两个数,ret中某个bit位绝对为1，找出该位置
        int diffIndex = 0;
        while(true){
            if(((ret>>diffIndex)&1) == 1){//说明ret此bit位值为1
                break;
            }else{
                diffIndex++;
            }
        }
        //此时diffIndex存储了ret对应bit位值为1 ，也就是a和b对应bit位不相同的位置
        //接下来按照该位置为1还是0把原数组和补齐缺失数字的数组划分为两部分，把这两部分异或在一起即为所得缺失值
        int []arr = new int[2];
        for(int x : nums){
            if(((x>>diffIndex)&1) == 1){//说明x该位置bit位是1
                arr[1]^=x;
            }else{
                arr[0]^=x;
            }
        }
        for(int i = 1;i <= n+2;i++){
            if(((i>>diffIndex)&1) == 1){//说明i该位置bit位是1
                arr[1]^=i;
            }else{
                arr[0]^=i;
            }
        }
        return arr;
    }
    public  static String modifyString(String s) {
        char []arr = s.toCharArray();
        int n = s.length();
        for(int i  = 0;i < n;i++){
            if(arr[i] == '?'){//开始替换
                for(char c = 'a';c <= 'z';c++){
                    if((i == 0 || c!=arr[i-1]) && (i == s.length()-1 || c != arr[i+1])){
                        arr[i] = c;
                        break;
                    }
                }
            }
        }
        return String.valueOf(arr);
    }

    public static void main(String[] args) {
        String s = "ubv?w";
        String result = modifyString(s);
        System.out.println(result);

    }
}
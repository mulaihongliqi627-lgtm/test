package org.example;

public class Main {
    public static String longestPalindrome(String s) {
        int n = s.length();
        char[]arr = s.toCharArray();
        int []nums = new int [2];//记录最长回文子字符串的起始和终止下标
        int len = 0;
        //使用从中心子字符串向外拓展方式寻找最长回文字符串
//        int left = 0,right = 0;
        for(int i = 0;i < n;i++){
            //中心字符串为奇数时
            int left1 = i,right1 = i;
            while ((left1 >= 0 && right1 < n) && arr[left1] == arr[right1]){
                if((right1 - left1 + 1) > len){//当字符串长度大于所记录的最长回文字符串长度时
                    //更新nums中的下标
                    nums[0] = left1;
                    nums[1] = right1;
                    len = Math.max(len,right1 - left1 + 1);
                }
                left1--;
                right1++;
            }
            //中心字符串为偶数时
            int left2 = i,right2 = i + 1;
            while ((left2 >= 0 && right2 < n) && arr[left2] == arr[right2]){
                if((right2 - left2 + 1) > len){//当字符串长度大于所记录的最长回文字符串长度时
                    //更新nums中的下标
                    nums[0] = left2;
                    nums[1] = right2;
                    len = Math.max(len,right2 - left2 + 1);
                }
                left2--;
                right2++;
            }
        }
        return s.substring(nums[0],nums[1] + 1);
    }

    public static void main(String[] args) {
        String s = "aaaa";
        String result = longestPalindrome(s);
        System.out.println(result);

    }

}
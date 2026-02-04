package org.example;

import java.util.LinkedList;
import java.util.List;

public class Main {
    private static List<List<StringBuilder>> list;
    private static List<StringBuilder> path;
    private static boolean check[];
    public List<List<StringBuilder>> subsets(int[] nums) {
        check = new boolean[nums.length];
        StringBuilder s = new StringBuilder();
        return list;

    }
//    public static void dfs(int []nums,StringBuilder s){
//        for(int i = 0;i < nums.length;i++){
//            if(check[i] == true){//被使用
//                continue;
//            }
//            //没被使用时，有两种选择，添加or不添加
//            check[i] = true;//标记该数字已被使用
//            dfs(nums,s);//不添加
//            s.append(nums[i]);
//            dfs(nums,s);//添加
//        }
//        path.add(s);
//        list.add(path);
//
//    }
//    public static void main(String[] args) {
//        System.out.println("Hello world!");
//    }
}
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<String>list=new ArrayList<>();
        list.add("晚安");
        list.add("cheems");
        list.add("去码头整点薯条");
        list.add("一路走好");
        list.add("114514");
        list.add("hello");
        System.out.println(list);
        list.set(0,"你好");
        System.out.println(list);
        list.remove("114514");
        list.add(1,"doge");
        System.out.println(list.size());
        System.out.println(list);
        System.out.println("---------------------");
        if(list.contains("doge")){
            list.add("happy!");
            System.out.println(list);
        }
        List<String>ret=new
    }
}
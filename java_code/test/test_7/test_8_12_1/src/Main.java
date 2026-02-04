import java.util.Arrays;

public class Main {
    //插入排序
    public static void insertSort(int [] array){
        for(int i = 1;i<array.length;i++){
            int tmp = array[i];
            int j = i-1;
            for(;j>=0;j--){
                if (tmp < array[j]){
                    array[j+1] = array[j];
                }else{
                    array[j+1] = tmp;
                    break;
                }
            }
            array[j+1] = tmp;
        }
    }
    public static void main(String[] args) {
        int []array = {1,22,13,34,87};
        insertSort(array);
        System.out.println(Arrays.toString(array));
    }
}
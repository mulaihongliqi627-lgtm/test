import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        int [] arr = {6,3,10,15,12,45,34,27};
        //Sort.selectSort(arr,arr.length);
        //Sort.heapSort(arr);
        //Sort.insertSort(arr, arr.length);
        //Sort.shellSort(arr, arr.length);
        //Sort.quickSort(arr);
        //Sort.bubbleSort(arr);
        //Sort.mergeSort(arr);
        //Sort.mergeSort2(arr);
        Sort.countSort(arr);
        System.out.println(Arrays.toString(arr));

    }

}

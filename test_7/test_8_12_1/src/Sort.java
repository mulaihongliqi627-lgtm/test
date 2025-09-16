public class Sort {
    //选择排序
    public static void selectSort(int []arr,int len){
        for(int i = 0;i < len;i++){
            int minIndex = i;
            for(int j = i+1;j<len;j++){
                if(arr[j] < arr[minIndex]){
                    minIndex = j;
                    swap(arr,i,minIndex);
                }
            }
        }
    }
    //堆排序
    public static void heapSort(int []arr){
        creatHeap(arr);
        int end = arr.length-1;
        while (end > 0) {
            swap(arr, 0, end);
            shiftDown(arr, 0, end);
            end--;
        }
    }
    //向下调整创建为大根堆
    private static void creatHeap(int []arr){
        int child = arr.length-1;
        for(int parent = (child-1)/2;parent >= 0;parent--){
            shiftDown(arr,parent, arr.length);
        }
    }
    //向下调整
    private static void shiftDown(int []arr,int parent,int len){
        int child = parent*2+1;
        while (child < len){
            if(child+1 < len && arr[child]<arr[child+1]){//有两个孩子节点，并且左孩子小于右孩子
                child++;//使child指向大的孩子节点
            }
            if(arr[child]>arr[parent]){
                swap(arr,child,parent);
                parent = child;
                child = 2*parent+1;
            }else{
                break;
            }
        }
    }
    //希尔排序
    public static void shellSort(int []arr,int len){
        int gap = len;
        while (gap > 1){
            gap/=2;
            Shell(arr,gap);
        }
    }
    private static void Shell(int []arr,int gap){
        for(int i = gap;i < arr.length;i++){
            int tmp = arr[i];
            int j = i-gap;
            for(;j >= 0;j -= gap){
                if(arr[j] > tmp){
                    arr[j+gap] = arr[j];
                }else{
                    break;
                }
            }
            arr[j+gap] = tmp;
        }
    }
    //插入排序
    public static void insertSort(int []arr,int len){
        for(int i = 1;i < len;i++){
            int tmp = arr[i];
            int j = i-1;
            for(;j >= 0;j--){
                if(arr[j] > tmp){
                    arr[j+1] = arr[j];
                }else{
                    break;
                }
            }
            arr[j+1] = tmp;
        }
    }
    //快速排序
    //时间复杂度为O（nlogn）
    //空间复杂度为O（logn）
    //不稳定
    public static void quickSort(int []arr){
        quick(arr,0,arr.length-1);
    }
    public static void quick(int []arr,int start ,int end){
        if(end <= start){
            return;
        }
        int privot = partition(arr,start,end);
        quick(arr,start,privot-1);
        quick(arr,privot+1,end);
    }
    private static int partition(int []arr,int start,int end){
        int left = start;
        int right = end;
        int base = arr[left];
        while (left < right){
            while (left < right && arr[right] >= base){
                right--;
            }
            arr[left] = arr[right];
            while(left < right && arr[left] <= base){
                left++;
            }
            arr[right] = arr[left];
        }
        arr[right] = base;
        return left;
    }
    /*
    冒泡排序
     */
    public static void bubbleSort(int []arr){
        boolean flag = true;
        for(int i = 0;i < arr.length-1;i++){
            for(int j = 0;j < arr.length-i-1;j++){
                if(arr[j] > arr[j+1]){
                    swap(arr,j,j+1);
                    flag = false;
                }
            }
            if(flag == true){
                break;
            }
        }
    }
    //归并排序（递归）
    public static void mergeSort(int []arr){
        mergeChild(0,arr.length-1,arr);
    }

    private static void mergeChild(int left, int right, int[] arr) {
        if(left>=right){
            return;
        }
        int mid = (left+right)/2;
        //分解数组
        mergeChild(left,mid,arr);
        mergeChild(mid+1,right,arr);
        //合并数组
        merge(arr,left,mid,right);
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int s1 = left;
        int e1 = mid;
        int s2 = mid+1;
        int e2 = right;
        int k = 0;
        int []tmpArray = new int [right-left+1];
        while (s1 <= e1 && s2 <= e2){
            if(arr[s1] <= arr[s2]){
                tmpArray[k] = arr[s1];
                k++;
                s1++;
            }else{
                tmpArray[k] = arr[s2];
                k++;
                s2++;
            }
        }
        //此时一定有一个子数组遍历完，再把另一个数组剩余数据填入临时数组中
        while (s1 <= e1){
            tmpArray[k++] = arr[s1++];
        }
        while (s2 <= e2){
            tmpArray[k++] = arr[s2++];
        }
        //把tmpArray拷贝到arr
        for (int i = 0;i < k;i++){
            arr[i+left] = tmpArray[i];
        }

    }

    //归并排序非递归
    public static void mergeSort2(int []arr){
        int gap = 1;
        while(gap < arr.length){
            for(int i = 0;i<arr.length;i+=2*gap){
                int left = i;
                int mid = left+gap-1;
                int right = mid+gap;
                if(mid >= arr.length){
                    mid--;
                }
                if(right >= arr.length){
                    right--;
                }
                merge(arr,left,mid,right);
            }
            gap*=2;
        }
    }
    //计数排序
    public static void countSort(int[]arr){
        int max = arr[0];
        int min = arr[0];
        for(int i = 1;i<arr.length;i++){
            if(arr[i] > max){
                max = arr[i];
            }
            if(arr[i] < min){
                min = arr[i];
            }
        }
        int len = max-min+1;
        int []countArray = new int [len];
        for(int i = 0;i < arr.length;i++){
            int index = arr[i]-min;
            countArray[index]++;
        }
        int k =0;
        for(int i = 0;i < countArray.length;i++){
            while (countArray[i] != 0){
                arr[k++] = i+min;
                countArray[i]--;
            }
        }
    }

    static void swap(int []arr,int i,int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}

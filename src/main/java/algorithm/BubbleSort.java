package algorithm;

/**
 * @Author: guodong
 * @Date: 2018/9/30
 */
public class BubbleSort {

    public static void bubbleSort(int[] arr){

        int lenth=arr.length;

        for (int i = 0; i < lenth-1; i++) {

            for (int j = 0; j < lenth-1-i ; j++) {
                if (arr[j]>arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }

        }

    }

    public static void main(String[] args) {

        int[] arr = {1,2,5,10,3,0,9,8,10};
        bubbleSort(arr);

        String out = "";
        for (int digit : arr) {
            out += (digit + ",");
        }
        System.out.println(out);
    }

}

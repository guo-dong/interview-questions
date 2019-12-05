package algorithm;

/**
 * 二分查找(从小到大的排序)
 * @Author: guodong
 * @Date: 2018/10/10
 */
public class BinarySearch {

    public static int binarySearch(int[] arr,int key) {

        int left = 0;
        int right = arr.length-1;

        while (left<=right){

            int mid = left + (right - left)/2;//防止溢位
            if (key<arr[mid]){
                right = mid - 1;
            }else if(key>arr[mid]){
                left = mid + 1;
            } else{
                return arr[mid];
            }
        }
        return -1;
    }


    /**
     * 二分法之递归
     * @param arr
     * @param key
     * @param start
     * @param end
     * @return
     */
    public static int binarySearch2(int[] arr,int key,int start ,int end) {
        if(start>end) return -1;

        int mid = start + (end-start)/2;//防止溢位
        if(key<arr[mid]){
            return binarySearch2(arr,key,start,mid-1);
        }else if (key>arr[mid]){
            return binarySearch2(arr,key,mid+1,end);
        }else{
            return arr[mid];
        }

    }



    public static void main(String[] args) {
        int[] arr = {0,1,2,3,4,5,6,7,8};

        System.out.println(binarySearch(arr,5));
        System.out.println(binarySearch(arr,0));
        System.out.println(binarySearch(arr,8));

        System.out.println(binarySearch2(arr,5,0,8));
        System.out.println(binarySearch2(arr,0,0,8));
        System.out.println(binarySearch2(arr,8,0,8));

    }

}

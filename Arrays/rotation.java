public class rotation{
    public static void main(String[] args){
        int arr[] = {1,2,3,4,5,6,7,8,9,10};
        int k = 3;
        rotate(arr, k);
    }

    public static void rotate(int[] nums, int k) {
        k = k%nums.length;
        nums = reverse(nums, 0, nums.length-1);
        nums = reverse(nums, 0, k-1);
        nums = reverse(nums, k, nums.length-1);
    }

    public static int[] reverse(int[] arr, int li, int ri){
        while(li<ri){
            int temp = arr[li];
            arr[li] = arr[ri];
            arr[ri] = temp;

            li++;
            ri--;
        }

        return arr;
    }

}
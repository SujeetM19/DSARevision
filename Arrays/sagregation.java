public class sagregation {
    public static void main(String[] args){
        int[] arr = {1,2,3,45,6,7,6,4,-1,2,3,-4,-4,6,-7};
        int[] ans = sagArr(arr);

        for(int i:ans){
            System.out.println(i);
        }
    }
    public static int[] sagArr(int[] arr){
        int left = 0;
        for(int right=0; right<arr.length; right++){
            if(arr[right]<0){
                int temp= arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
            }
                
        }
        return arr;
    }

}

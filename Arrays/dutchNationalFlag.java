class dutchNationalFlag{
    public static void main(String[] args){
        int[] arr = {1,2,0,1,0,1,2,0,1,2,0,1,0,1,0,2,2,0};
        int [] ans = DFNA(arr);
        
        for(int i: ans){
            System.out.println(i);
        }
    }
    public static int[] DFNA(int[] nums) {
        int i=0, j=0;
        for(int k=0; k<nums.length; k++){
            if(nums[k] == 0){
                swap(nums, k,j);
                swap(nums, j,i);
                // arr[k] =arr[j];
                // arr[j] = arr[i];
                // arr[i] = arr[k];
                i++;
                j++;
            }
            else if(nums[k] == 1){
                int temp = nums[j];
                nums[j] = nums[k];
                nums[k] = temp;
                j++;
            }

        }

        return nums;
    }
    public static void swap(int[] arr, int idx1, int idx2){
        int temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;
    }
}
// Max sum in the configuration   GFG
// Given an array(0-based indexing), you have to find the max sum of i*A[i] where A[i] is the element at index i in the array. The only operation allowed is to rotate(clock-wise or counter clock-wise) the array any number of times.

// Example 1:

// Input:
// N = 4
// A[] = {8,3,1,2}
// Output: 29
// Explanation: Above the configuration
// possible by rotating elements are
// 3 1 2 8 here sum is 3*0+1*1+2*2+8*3 = 29
// 1 2 8 3 here sum is 1*0+2*1+8*2+3*3 = 27
// 2 8 3 1 here sum is 2*0+8*1+3*2+1*3 = 17
// 8 3 1 2 here sum is 8*0+3*1+1*2+2*3 = 11
// Here the max sum is 29 
// Your Task:
// Your task is to complete the function max_sum which takes two arguments which is the array A [ ] and its size and returns an integer value denoting the required max sum.

// Expected Time Complexity: O(N).
// Expected Auxiliary Space: O(1).





public class maxSumConfiguration {


    public static void main(String args[] ){
        int [] arr = new int[] {8, 3, 1, 2};


        System.out.println(max_sum(arr, 4));
    }

    public static int max_sum(int A[], int n)
    {
        int sum =0;
	    for(int i=0;i<n;i++){
	        sum+=A[i];
	    }
	    
	    int currSum = 0;
	    
	    for(int i=0;i<n;i++){
	        currSum+=A[i]*i;
	    }
	    
	    int max = currSum;
	    for(int i=0; i<n; i++){
	        int nextSum = currSum - sum + n*A[i];
	        if(nextSum > max){
	            max = nextSum;
	        }
            currSum = nextSum;
	    }
	    
	    return max;
    }	
    
}

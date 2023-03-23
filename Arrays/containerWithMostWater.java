// Container With Most Water

// Given N non-negative integers a1,a2,....an where each represents a point at coordinate (i, ai). N vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i,0). Find two lines, which together with x-axis forms a container, such that it contains the most water.

// Note : In Case of single verticle line it will not be able to hold water.

// Example 1:

// Input:
// N = 4
// a[] = {1,5,4,3}
// Output: 6
// Explanation: 5 and 3 are distance 2 apart.
// So the size of the base = 2. Height of
// container = min(5, 3) = 3. So total area
// = 3 * 2 = 6.
// Example 2:

// Input:
// N = 5
// a[] = {3,1,2,4,5}
// Output: 12
// Explanation: 5 and 3 are distance 4 apart.
// So the size of the base = 4. Height of
// container = min(5, 3) = 3. So total area
// = 4 * 3 = 12.




public class containerWithMostWater {
    long maxArea(int A[], int len){
        // 
        //starting from end points left an dright
        int l = 0; int r = len-1;

    
        //if there is only one element
        if(len == 1){
            return 0;
        }
        
        int max = Integer.MIN_VALUE;
        
        while(l<r){
            int height = Math.min(A[l], A[r]);  //lower height decides the amount of water
            int width = r-l;
            
            int area = height*width;
            
            max = area>max? area:max;
            

            // if the height is lower there is the only posibility to get the bigger dimension 
            //stick to store more water therefore reduce the index of lower height stick
            
            if(height == A[l]){
                l++;
            }
            else{
                r--;
            }
        }
        return max;
        
    }
}

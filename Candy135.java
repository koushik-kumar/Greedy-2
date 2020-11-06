class Solution {
    // Approach: Taking an array, filled with 1s, since minimum candies for anychild is 1
    //     - Traverse from left to right => if curr > left ==> more candies than left ==> left +1
    //     - Similarly right to left, but here, candies[i] will be Max(prev + 1, curr)
    //     - Calculating the total candies, can be done in previous traversing itself
    

    // TC: O(NlogN), N is the total ratings, nlogn for sorting
    // SC: O(N)
    
    public int candy(int[] ratings) {
        if(ratings == null || ratings.length  == 0) return 0;
        if(ratings.length == 1) return 1;
        
        int[] candies = new int[ratings.length];
        Arrays.fill(candies, 1);
        
        for(int i = 1; i < ratings.length; i++){        // left to right
            if(ratings[i] > ratings[i-1])
                candies[i] = candies[i-1]+1;
        }
        
        int sum = candies[ratings.length - 1];          // right to left
        for(int i = ratings.length - 2; i >= 0; i--){
            if(ratings[i] > ratings[i+1])
                candies[i] = Math.max(candies[i], candies[i+1]+1);      // Max of curr and prev+1
            sum += candies[i];                                          // Calc total candies in same pass
        }
        return sum;
    }
}
class Solution {
    // Approach: Max freq character ==> idle_time calcualtion
    //     checking if other characters can be filled in that idle time
    //     if any idle time is remaining ==> remaining idle time + total characters
            
    // EDGE CASE: 3A 3B 3C 2D 1E ==> idle time becomes null ==> can just return total chars.
    //     ==>  idle_time = Max(0, idle_time)
    
    // TC: O(N). for calcualting the freq count
    // SC: O(1)
    public int leastInterval(char[] tasks, int n) {
        if(tasks == null || tasks.length == 0)
            return 0;
        
        if(n == 0)
            return tasks.length;
        
        // 1. Find the idle time
            // a. Count the frequencies
            // b. Sort the frequencies
            // c. Cal the idle time
        int[] freq = new int[26];
        //1-a
        for(char ch : tasks)
            freq[ch - 'A']++;
        //1-b
        Arrays.sort(freq);
        
        //1-c
        int f_max = freq[25];
        int idle_time = (f_max - 1) * n;        // f_max - 1 is because, for 5 A's => 4 gaps
            
        // 2. Finding the remaining idle time
        for(int i = freq.length - 2; i >= 0; i--){
            idle_time -= Math.min(f_max - 1, freq[i]);
        }
        idle_time = Math.max(0, idle_time);
        return idle_time + tasks.length;
    }
}
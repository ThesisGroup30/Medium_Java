import java.util.HashSet;

class Solution {
    public int findSmallestInteger(int[] nums, int value) {
        HashSet<Integer> set = new HashSet<>();
        
        for (int num : nums) {
            set.add(num);
            set.add(num - value);
        }
        
        int mex = 0;
        while (set.contains(mex)) {
            mex++;
        }
        
        return mex;
    }
}

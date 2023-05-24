class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int n = nums1.length;
        
        // Calculate the initial sum of squared difference
        long sumDiff = 0;
        for (int i = 0; i < n; i++) {
            sumDiff += (long) Math.pow(nums1[i] - nums2[i], 2);
        }
        
        // Sort the arrays in ascending order
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        
        int i = 0;
        int j = 0;
        
        // Perform the modifications by greedily choosing the largest difference to minimize the sum of squared difference
        while (k1 > 0 || k2 > 0) {
            if (i >= n || j >= n) {
                break;
            }
            
            int diff1 = nums1[i] - nums2[j];
            int diff2 = (i + 1 < n) ? nums1[i + 1] - nums2[j] : Integer.MAX_VALUE;
            int diff3 = (j + 1 < n) ? nums1[i] - nums2[j + 1] : Integer.MAX_VALUE;
            
            if (Math.abs(diff1) <= Math.abs(diff2) && Math.abs(diff1) <= Math.abs(diff3)) {
                sumDiff -= (long) Math.pow(diff1, 2);
                i++;
                k1--;
            } else if (Math.abs(diff2) <= Math.abs(diff1) && Math.abs(diff2) <= Math.abs(diff3)) {
                sumDiff -= (long) Math.pow(diff2, 2);
                i++;
                k1--;
            } else {
                sumDiff -= (long) Math.pow(diff3, 2);
                j++;
                k2--;
            }
        }
        
        return sumDiff;
    }
}

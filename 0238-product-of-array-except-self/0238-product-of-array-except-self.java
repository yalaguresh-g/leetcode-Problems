class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        
        // Pass 1: Calculate prefixes and store them in ans
        // The first element has nothing to its left, so prefix is 1
        ans[0] = 1;
        for (int i = 1; i < n; i++) {
            ans[i] = ans[i - 1] * nums[i - 1];
        }
        
        // Pass 2: Calculate suffixes on the fly and multiply into ans
        // The last element has nothing to its right, so suffix starts at 1
        int rightProduct = 1;
        for (int i = n - 1; i >= 0; i--) {
            ans[i] = ans[i] * rightProduct; // Prefix * Suffix
            rightProduct *= nums[i];        // Update the running suffix product
        }
        
        return ans;
    }
}

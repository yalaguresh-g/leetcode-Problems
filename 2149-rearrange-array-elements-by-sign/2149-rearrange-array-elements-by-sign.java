class Solution {
    public int[] rearrangeArray(int[] nums) {
        int result[] = new int[nums.length];
        int PositiveIdx = 0;
        int NegativeIdx = 1;
        for(int i = 0; i < nums.length ; i++){
            if(nums[i] > 0){
                result[PositiveIdx] = nums[i];
                PositiveIdx += 2;
            }
            else{
                result[NegativeIdx] = nums[i];
                NegativeIdx += 2;
            }
        }
        return result;
    }
}
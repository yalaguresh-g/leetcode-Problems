import java.util.*;

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        Stack<Integer> stack = new Stack<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        // Process nums2 from right to left
        for (int i = nums2.length - 1; i >= 0; i--) {

            // Remove elements smaller than or equal to current
            while (!stack.isEmpty() && stack.peek() <= nums2[i]) {
                stack.pop();
            }

            // Find next greater element
            if (stack.isEmpty()) {
                map.put(nums2[i], -1);
            } else {
                map.put(nums2[i], stack.peek());
            }

            // Push current element
            stack.push(nums2[i]);
        }

        // Build answer for nums1
        int[] result = new int[nums1.length];

        for (int i = 0; i < nums1.length; i++) {
            result[i] = map.get(nums1[i]);
        }

        return result;
    }
}
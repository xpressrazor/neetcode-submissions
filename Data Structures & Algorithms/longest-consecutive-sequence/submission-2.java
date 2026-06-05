class Solution {
    public int longestConsecutive(int[] nums) {
        
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int longest = 0;

        for (int num : set) {
            if (!set.contains(num - 1)) {
                int length = 1;

                // count the length of consecutive elements
                while (set.contains(num + length)) {
                    length++;
                }

                // maximize length
                longest = Math.max(longest, length);
            }
        }

        return longest;
    }
}

/*

Input: nums = [2,20,4,10,3,4,5]

Output: 4

set = [20, 4, 10, 3, 5, 2]

longest = 0
nums = [2,20,4,10,3,4,5]
num = 2 : 1 (x) : length = 1, set = [3, 4, 5], length = 4, longest = 4
num = 20: 19 (x) : length = 1, set = [], longest = 4
num = 10


sort and handle consecutive: O(nlogn), O(~)
length = 1 and iterate from 1 to n-1, if nums[i] == nums[i-1] continue, if nums[i] == nums[i-1] + 1, count, else reset count to 1, maximize count as length

// Another O(n), O(n) algorithm

add numbers to set. 
again iterate nums, and if set does not contain num-1, element was not consecutive at this point

count length, and maximize it
*/

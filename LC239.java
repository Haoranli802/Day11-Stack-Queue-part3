class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        int len = nums.length;
        int[] res = new int[len - k + 1];
        int index = 0;
        for(int i = 0; i < len; i++){
            while(!deque.isEmpty() && deque.peek() < i - k + 1){
                deque.poll();
            }
            while(!deque.isEmpty() && nums[i] > nums[deque.peekLast()]){
                deque.pollLast();
            }
            deque.offer(i);
            if(i >= k - 1){
                res[index++] = nums[deque.peek()];
            }
        }
        return res;
    }
}
// O(N), O(K)

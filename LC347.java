class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> map.get(b) - map.get(a));
        for(int num : map.keySet()){
            heap.add(num);
        }
        int[] res = new int[k];
        for(int i = 0; i < k; i++){
            res[i] = heap.poll();
        }
        return res;
    }
}
// 大顶堆 O(NlogN), O(N)

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> map.get(a) - map.get(b));
        for(int num : map.keySet()){
            if(heap.size() < k){
                heap.add(num);
            }
            else{
                if(map.get(num) > map.get(heap.peek())){
                    heap.poll();
                    heap.add(num);
                }
            }
        }
        int[] res = new int[k];
        for(int i = k-1; i >= 0; i--){
            res[i] = heap.poll();
        }
        return res;
    }
}
// 小顶堆 O(NlogK), O(N)

package neetcode150.greedy;

public class HandOfStraights {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand.length % groupSize != 0) return false;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<hand.length;i++){
            int count = map.getOrDefault(hand[i], 0);
            map.put(hand[i], ++count);
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            queue.add(entry.getKey());
        }
        while(!queue.isEmpty()){
            int num = queue.peek();
            for(int i=num;i<num+groupSize;i++){
                if(!map.containsKey(i)) return false;
                map.put(i, map.get(i) - 1);
                if(map.get(i) == 0){
                    if(i != queue.peek()) return false;
                    queue.poll();
                }
            }
        }
        return true;
    }
}

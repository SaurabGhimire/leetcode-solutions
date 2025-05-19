package neetcode150.greedy;

public class JumpGameII {
    public int jump(int[] nums) {
        Queue<int[]> queue = new LinkedList<>(); //index, count
        queue.add(new int[]{0, 0});
        int count = 0;
        boolean[] visited = new boolean[nums.length];
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size;i++){
                int[] item = queue.remove();
                int index = item[0];
                count = item[1]; // 0
                int num = nums[index];  // 2
                for(int j=1;j<=num;j++){
                    int nextIndex = index+j;
                    if(nextIndex >= nums.length) break;
                    if(nextIndex == nums.length-1){
                        return count+1;
                    }
                    if(visited[nextIndex]) continue;
                    visited[nextIndex] = true;
                    queue.add(new int[]{nextIndex, count+1});
                }
            }
        }
        return count;
    }
}

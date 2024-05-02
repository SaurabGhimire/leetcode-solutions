package dailyQuestions;

public class IslandPerimeter463 {
    public static void main(String[] args) {
        int[][] arr = {{0,1}};
        islandPerimeter(arr);
//        traverseOptimal(arr);
    }

//    public static void traverseOptimal(int[][] grid) {
//        int m = grid.length;
////        [
////                [0,1,0,0],
////                [1,1,1,0],
////                [0,1,0,0],
////                [1,1,0,0]
////        ]
//        Optional<Integer> currentX = null;
//        Optional<Integer> currentY = null;
//        boolean stopTraverse = false;
//        for(int i=0;i<grid.length;i++) {
//            int n = grid[i].length;
//            if(stopTraverse) break;
//            for (int j = 0; j < n; j++) {
//                if (grid[i][j] == 1) {
//                    currentX = Optional.of(i);
//                    currentY = Optional.of(j);
//                    break;
//                }
//            }
//        }
//        System.out.println(currentX.get());
//        System.out.println(currentY.get());
//
//        int x = currentX.get();
//        int y = currentY.get();
//
//        while(x>=0 && x<=m){
//            if(j!=0 && grid[i][j-1] == 1) countCommon++;
//            if(j+1 < n && grid[i][j+1] == 1) countCommon++;
//            if(i!=0 && grid[i-1][j] == 1) countCommon++;
//            if(i+1 < m && grid[i+1][j] == 1) countCommon++;
//        }
//
//    }

    public static void islandPerimeter(int[][] grid) {
        int m = grid.length;
        int countOnes = 0;
        int countCommon = 0;

//        [
//                [0,1,0,0],
//                [1,1,1,0],
//                [0,1,0,0],
//                [1,1,0,0]
//        ]

        for(int i=0;i<grid.length;i++){
            int n = grid[i].length;
            for(int j=0;j<n;j++){
                if(grid[i][j] == 0) continue;
                countOnes++;
                if(j!=0 && grid[i][j-1] == 1) countCommon++;
                if(j+1 < n && grid[i][j+1] == 1) countCommon++;
                if(i!=0 && grid[i-1][j] == 1) countCommon++;
                if(i+1 < m && grid[i+1][j] == 1) countCommon++;
            }
        }
        System.out.println(countOnes * 4 -countCommon);

    }


}


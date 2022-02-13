import java.util.*;

import static java.util.Arrays.asList;

public class MinimumDistance {

    public static void main(String[] args) {

        List<List<Integer>> list1 = asList(
                asList(1,0,0),
                asList(1,0,0),
                asList(1,9,1)
                );

        List<List<Integer>> list2 = asList(
                asList(1, 1, 1, 1),
                asList(0, 1, 1, 1),
                asList(0, 1, 0, 1),
                asList(1, 1, 9, 1),
                asList(0, 0, 1, 1)
                );

        System.out.println(new MinimumDistance().minimumDistance(list2));
    }


    private int minimumDistance(List<List<Integer>> lot) {
        if(lot==null || lot.size() == 0)
            return -1;
        Set<String> visited = new HashSet<>();
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[] {0,0});
        visited.add("0,0");
        int distance = 0;
        int[][] moves = { {0, 1} , {0, -1} , {-1, 0} , {1, 0}};
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                int[] point = q.remove();
                if(lot.get(point[0]).get(point[1]) == 9)
                    return distance;
                for(int[] move : moves) {
                    int x = point[0] + move[0];
                    int y = point[1] + move[1];
                    if(x >= 0 && x < lot.size()
                            && y >= 0 && y < lot.get(0).size()
                            && lot.get(x).get(y) != 0
                            && !visited.contains(x+","+y)) {
                        q.add(new int[] {x, y});
                        visited.add(x+","+y);
                    }
                }
            }
            distance++;
        }
        return -1;
    }

}

package math.problems.matrices;

//Problem: Shortest path in matrix

//Logic: 
//1. Initialize a queue to store the nodes to be visited.
//2. Add the starting node to the queue.
//3. Initialize a visited array to keep track of visited nodes.
//4. While the queue is not empty, dequeue the current node from the queue.
//5. Check if the current node is the destination node. If it is, return the distance.
//6. Add the current node to the visited array.
//7. Get the neighbors of the current node.
//8. For each neighbor, check if it is not visited.
//9. If it is not visited, add it to the queue with the distance increased by 1.
//10. Return -1 if the destination node is not reachable.

//Algorithm:
//1. Define a function shortestPath(matrix, i, j) that takes a matrix and starting coordinates as arguments.
//2. Initialize a queue to store the nodes to be visited.
//3. Add the starting node to the queue.
//4. Initialize a visited array to keep track of visited nodes.
//5. While the queue is not empty, dequeue the current node from the queue.
//6. Check if the current node is the destination node. If it is, return the distance.
//7. Add the current node to the visited array.
//8. Get the neighbors of the current node.
//9. For each neighbor, check if it is not visited.
//10. If it is not visited, add it to the queue with the distance increased by 1.
//11. Return -1 if the destination node is not reachable.

import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathInMatrix {

    public static void main(String[] args) {

        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int i = 0, j = 0;
        int shortestPath = shortestPath(matrix, i, j);
        System.out.println("Shortest path in matrix from ("+i+", "+j+") is: "+shortestPath);

    }
public static int shortestPath(int[][] grid, int i2, int j) {
    int[] dx = {0, 0, 1, -1};
    int[] dy = {1, -1, 0, 0};

    int rows = grid.length, cols = grid[0].length;
    boolean[][] visited = new boolean[rows][cols];

    Queue<int[]> queue = new LinkedList<>();
    queue.add(new int[]{0, 0, 0}); // {row, col, distance}
    visited[0][0] = true;

    while (!queue.isEmpty()) {
        int[] current = queue.poll();
        int x = current[0], y = current[1], dist = current[2];

        if (x == rows - 1 && y == cols - 1) return dist;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i], ny = y + dy[i];
            if (nx >= 0 && ny >= 0 && nx < rows && ny < cols && grid[nx][ny] == 1 && !visited[nx][ny]) {
                visited[nx][ny] = true;
                queue.add(new int[]{nx, ny, dist + 1});
            }
        }
    }
    return -1; // No path found
}
}

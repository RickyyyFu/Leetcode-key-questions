package LC_286_Walls_and_Gates;

import java.util.*;

public class BFS {
	public void wallsAndGates(int[][] rooms) {
		Queue<Integer> queue = new LinkedList<>();
		int rows = rooms.length;
		int cols = rooms[0].length;
		
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < cols; j++) {
				if(rooms[i][j] == 0) {
					int pos = i * cols + j;
					queue.offer(pos);
				}
			}
		}
		
		while(!queue.isEmpty()) {
			int pos = queue.poll();
			int i = pos/cols;
			int j = pos%cols;
			int distance = rooms[i][j]+1;
			
			if(i+1 < rows && rooms[i+1][j] != -1) {
				if(distance < rooms[i+1][j]) {
					rooms[i+1][j] = distance;
					int pos1 = (i+1) * cols + j;
					queue.offer(pos1);
				}	
			}
			
			if(i-1 >= 0 && rooms[i-1][j] != -1) {
				if(distance < rooms[i-1][j]) {
					rooms[i-1][j] = distance;
					int pos2 = (i-1) * cols + j;
					queue.offer(pos2);
				}	
			}
			
			if(j+1 < cols && rooms[i][j+1] != -1) {
				if(distance < rooms[i][j+1]) {
					rooms[i][j+1] = distance;
					int pos3 = i * cols + j+1;
					queue.offer(pos3);
				}	
			}
			
			if(j-1 >= 0 && rooms[i][j-1] != -1) {
				if(distance < rooms[i][j-1]) {
					rooms[i][j-1] = distance;
					int pos4 = i * cols + j-1;
					queue.offer(pos4);
				}	
			}
		}
	}
}

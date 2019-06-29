package LC_973_K_Closest_Points_to_Origin;

import java.util.*;

public class Solution_quickselect {
	Random rand = new Random();
    
    public int[][] kClosest(int[][] points, int k) {
        quickselect(points, 0, points.length-1, k);
        return Arrays.copyOf(points, k);
    }
    
    private void quickselect(int[][] points, int left, int right, int k) {
        if (left == right) {
            return;
        }
        
        int pivotIndex = rand.nextInt((right-left)+1) + left;
        
        pivotIndex = partition(points, left, right, pivotIndex);
        
        if (pivotIndex == k) {
            return;
        }
        if (pivotIndex < k) {
            quickselect(points, pivotIndex+1, right, k);
        } else {
            quickselect(points, left, pivotIndex-1, k);
        }
    }
    
    private int partition(int[][] points, int left, int right, int pivotIndex) {
        double pivotValue = distance(points[pivotIndex]);
        int sIndex = left;
        
        swap(points, right, pivotIndex);
        
        for (int i = sIndex; i < right; i++) {
            if (distance(points[i]) < pivotValue) {
                swap(points, i, sIndex);
                sIndex++;
            }
        }
        
        swap(points, sIndex, right);
        
        return sIndex;
    }
    
    private double distance(int[] point) {
        return (Math.pow(point[0], 2) + Math.pow(point[1], 2));
    }
    
    private void swap(int[][] points, int a, int b) {
        int[] t = points[a];
        points[a] = points[b];
        points[b] = t;
    }
}

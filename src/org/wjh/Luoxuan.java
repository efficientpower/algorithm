package org.wjh;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Luoxuan {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int startx =1;
        int starty =4;
        int m=5;
        int n =6;
        int x=startx,y=starty;
        int r = 1,d=1,l=2,u=2;
        List<Cord> cordList = new ArrayList<Cord>();;
        cordList.add(new Cord(x,y));
        while(cordList.size() < m*n) {
            for(int i=0; i<r; i++) {
                y = y+1;
                if(x>=0 && x<m && y>=0 && y<n) {
                    cordList.add(new Cord(x,y));
                }
            }
            for(int i=0; i<d; i++) {
                x = x + 1;
                if(x>=0 && x<m && y>=0 && y<n) {
                    cordList.add(new Cord(x,y));
                }
            }
            for(int i=0; i<l; i++) {
                y = y-1;
                if(x>=0 && x<m && y>=0 && y<n) {
                    cordList.add(new Cord(x,y));
                }
            }
            for(int i=0; i<u; i++) {
                x = x-1;
                if(x>=0 && x<m && y>=0 && y<n) {
                    cordList.add(new Cord(x,y));
                }
            }
            r= r+2;
            d = d+2;
            l = l +2;
            u = u+2;
        }
        for(Cord cord : cordList) {
            System.out.println("(" + cord.x +", " + cord.y +")");
        }
        
        int[] a = {1,8,6,2,5,4,8,3,7};
        maxArea(a);
        maxArea2(a);
        
        int[] b = {1,1,-1,-1,3};
        threeSumClosest(b, -1);
    }

    public static int maxArea(int[] height) {
        int max = 0;
        for(int i=0; i< height.length-1; i++){
            for(int j=i+1; j< height.length; j++){
                int h = height[i] > height[j]? height[j] : height[i];
                int capacity = (j-i)*h;
                max = max > capacity? max : capacity;
            }
        }
        return max;
    }
 
    public static int maxArea2(int[] height) {
        int max = 0;
        int left = 0;
        int right = height.length-1;
        while(left < right) {
            int h;
            int length = right - left;
            if(height[left] > height[right]) {
                h = height[right];
                right--;
            }else {
                h = height[left];
                left++;
            }
            
            int capacity = length * h;
            max = max > capacity? max : capacity;
        }
        return max;
    }

    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int sum = 0;
        int res = Integer.MAX_VALUE;
        for(int i=0; i<nums.length-2; i++){
            int j =i+1;
            int k = nums.length-1;
            while(j < k){
                sum = nums[i] + nums[j] +nums[k];
                if(Math.abs(sum - target) < Math.abs(res - target)){
                    res = sum;
                }
                if(sum <= target){
                    j++;
                }else{
                    k--;
                }
            }
        }
        return res;
    }
}

class Cord{
    int x;
    int y;
    public Cord(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

package org.wjh;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class TreeNUm {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] a = { -1,0,1,2,-1,-4,4};
        //List<List<Integer>> list = threeSum(a);
        int[] nums = {1, 2,1,1};
        //removeDuplicates(nums);
        intersect(a, nums);
    }

    public static List<List<Integer>> threeSum(int[] arr, int target) {
        Arrays.sort(arr);
        Set<List<Integer>> result = new HashSet<List<Integer>>();
        for(int i=0; i< arr.length - 2; i++) {
            int j=i + 1;
            int k = arr.length-1;
            while(j < k) {
                if(arr[i] + arr[j] + arr[k] <target) {
                    j++;
                }else if(arr[i] + arr[j] + arr[k] >target) {
                    k--;
                }else {
                    List<Integer> tmpList = new ArrayList<Integer>();
                    tmpList.add(arr[i]);
                    tmpList.add(arr[j]);
                    tmpList.add(arr[k]);
                    Collections.sort(tmpList);
                    result.add(tmpList);
                    k--;
                    j++;
                }
            }
        }
        return new ArrayList<List<Integer>>(result);
    }
    
 
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<Integer,Integer>();   
        for(int i=0; i<nums.length-1; i++){
            if(map.get(nums[i]) != null){
                continue;
            }
            int x = target - nums[i];
            for(int j=i+1; j<=nums.length-1; j++){
                if(x == nums[j]){
                    return new int[]{i,j};
                }
            }
            map.put(nums[i],nums[i]);
        }
        return null;
    }

    public static int removeDuplicates(int[] nums) {
        int length = 1;
        int x = nums[0];
        for(int i=1; i<nums.length; i++){
            if(nums[i] != x){
                nums[length] = nums[i];
                length = length + 1;
                x = nums[i];
            }
        }
        return length;
    }

    public static int[] intersect(int[] nums1, int[] nums2) {

        Map<Integer,Integer> map1 = new HashMap<Integer,Integer>();
        Map<Integer,Integer> map2 = new HashMap<Integer,Integer>();
        for(int num : nums1){
            Integer ct = map1.get(num);
            ct = ct == null? 1 : ct+1;
            map1.put(num, ct);
        }
        for(int num : nums2){
            Integer ct = map2.get(num);
            ct = ct == null? 1 : ct+1;
            map2.put(num, ct);
        }
        List<Integer> list = new ArrayList<Integer>();
        if(map1.size() < map2.size()){
            for(Map.Entry<Integer, Integer> entry : map1.entrySet()){
                Integer key = entry.getKey();
                Integer count1 = entry.getValue();
                Integer count2 = map2.get(key);
                if(count2!=null){
                    int count = count1 < count2? count1 : count2;
                    map1.put(key, count);
                }else{
                    map1.put(key, 0);
                }
            }
            for(Map.Entry<Integer, Integer> entry : map1.entrySet()){
                int count = entry.getValue();
                int num = entry.getKey();
                for(int i=0; i< count; i++){
                    list.add(num);
                }
            }
        }else{
            for(Map.Entry<Integer, Integer> entry : map2.entrySet()){
                Integer key = entry.getKey();
                Integer count2 = entry.getValue();
                Integer count1 = map1.get(key);
                if(count1!=null){
                    int count = count1 < count2? count1 : count2;
                    map2.put(key, count);
                }else{
                    map2.put(key, 0);
                }
            }
            for(Map.Entry<Integer, Integer> entry : map2.entrySet()){
                int count = entry.getValue();
                int num = entry.getKey();
                for(int i=0; i< count; i++){
                    list.add(num);
                }
            }
        }
        int a[] = new int[list.size()];
        int i=0;
        for(Integer x : list) {
            a[i] = x;
            i++;
        }
        return a;
    }
}

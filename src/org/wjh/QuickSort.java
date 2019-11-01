package org.wjh;

import java.util.Random;

public class QuickSort {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] a= new int[20];
        for(int i=0; i<20; i++) {
            a[i] = new Random().nextInt(100);
        }
        sort(a, 0, a.length-1);
        for(int x : a) {
            System.out.print(x +", ");
        }
    }

    public static void sort(int[] a, int left, int right) {
        if(left < right) {
            int p = partation(a, left, right);
            sort(a, left, p-1);
            sort(a, p+1, right);
        }
    }

    public static int partation(int[] a, int left, int right) {
        int pivotal = a[left];
        while(left < right) {
            while(left < right && a[right] > pivotal) {
                right--;
            }
            if(left < right) {
                a[left] = a[right];
                left++;
            }
            while(left < right && a[left] < pivotal) {
                left++;
            }
            if(left < right) {
                a[right] = a[left];
                right--;
            }
        }
        a[left] = pivotal;
        return left;
    }
}

package org.wjh;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
//        hms();
//        System.out.println(isLeapYear(1996));
        //pi2();
         //yuesefu();
        //prime();
        horse();
    }

    public static void hms() {
        double vh = 1.0/720, vm = 1.0/60, vs = 1.0;
        int total = 24 * 3600;
        for(int i=0; i<total; i++) {
            int sh = (int)(vh * i);
            int sm = (int)(vm * i);
            int ss = (int)(vs * i);
            if(sh%60 == sm%60 && sm%60==ss%60) {
                int h = i/3600;
                int m = (i- 3600 * h)/60;
                int s = i - 3600 *h -60 *m;
                System.out.println(h +":" + m +":" + s);
            }
        }
    }

    public static boolean isLeapYear(int year) {
        if(year%4 == 0 && year%100 !=0 || year % 400 == 0) {
            return true;
        }
        return false;
    }

    public static void pi(int n) {
        int i = 0, k=3;
        double length = 1.0;
        while(i < n) {
            length = 2 - Math.sqrt(4.0-length);
            k = k * 2;
            i++;
            System.out.println(1.0 * k * Math.sqrt(length));
        }
    }

    public static void pi2() {
        double sum =1;
        double a = 1;
        double b = 3;
        double x = a/b;
        sum = sum + x;
        int i = 0;
        while(i < 2000) {
            a = a +1;
            b = b +2;
            x = x*(a/b);
            sum = sum + x;
            i++;
        }
        System.out.println(2 * sum);
    }

    public static void yuesefu() {
        int NUM = 41;
        int a[] = new int[NUM];
        for(int i=0; i<NUM; i++) {
            a[i] = i+1;
        }
        
        List<Integer> list = new ArrayList<Integer>();
        
        int i = 0;
        int num = 1;
        
        while(list.size() < NUM-2) {
            while(i < NUM) {
                if(!list.contains(a[i])) {
                    if(num == 3) {
                        list.add(a[i]);
                        num = 1;
                    }else {
                        num++;
                    }
                }
                i++;
            }
            i=0;
        }
        list.size();
        for(Integer x : a) {
            if(list.contains(x)) {
                continue;
            }
            System.out.println(x);
        }
    }

    public static void prime() {
        for(int i=2; i<100; i++) {
            for(int j=2; j<=i/2; j++) {
                if(i/j == 0 && (j !=1 && j!=i)) {
                    break;
                }
            }
            System.out.print(i + ", ");
            
        }
    }

    public static void horse() {
        int[][] direct = {{-2,1},{-1,2},{1,2},{2,1},{2,-1},{1,-1},{-1,-2},{-2,-1}};
        int[][] qipan = new int[8][8];
        int x=2, y=3;
        dohorse(qipan, x, y, 1);
        for(int i=0; i<8;i++) {
            for(int j=0; j<8; j++) {
                System.out.print(String.format("%3d", qipan[i][j]) + " ");
            }
            System.out.println();
        }
    }

    public static void dohorse(int[][] qipan, int x, int y, int step) {
        if(x>0 && x<8 && y>0 && y<8 && qipan[x][y] == 0 ) {
            qipan[x][y] = step;
        }else {
            return;
        }
        for(int i=1; i<=64; i++) {
            step = step + 1;
            dohorse(qipan,x-2, y+1, step+1);
            dohorse(qipan,x-2, y+1, step+1);
            dohorse(qipan,x-1, y+2, step+1);
            dohorse(qipan,x+1, y+2, step+1);
            dohorse(qipan,x+2, y+1, step+1);
            dohorse(qipan,x+2, y-1, step+1);
            dohorse(qipan,x+1, y-1, step+1);
            dohorse(qipan,x-1, y-2, step+1);
            dohorse(qipan,x-2, y-1, step+1);
        }
        
    }
}

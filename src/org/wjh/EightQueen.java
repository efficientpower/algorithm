package org.wjh;

public class EightQueen {

    public static int[] a = new int[8];

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        queen(0);
    }

    public static void queen(int n) {
        if(n == 8) {
            output();
            System.out.println("===============");
            return;
        }
        
        for(int i=1; i<=8; i++) {
            a[n] = i;
            boolean ok = true;
            for(int j=0; j<n; j++) {
                if(!isOk(n, j)) {
                    ok = false;
                }
            }
            if(ok) {
                queen(n+1);
            }
        }
        
    }

    public static boolean isOk(int n, int j) {
        if(a[j] == a[n]) {
            return false;
        }
        if(Math.abs(a[n] - a[j]) == (n-j)) {
            return false;
        }
        return true;
    }

    public static void output() {
        for(int j=0; j<8; j++) {
            System.out.print(a[j] +"  " );
        }
    }
}

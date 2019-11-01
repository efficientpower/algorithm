package org.wjh;

public class Hannuota {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String from="A", to="B", other="C";
        move(5, from, to, other);
    }

    public static void move(int n, String from, String to, String other) {
        if(n == 1) {
            System.out.println(from + "-->" + to);
        }else {
            move(n-1, from, other, to);
            move(1, from, to, other);
            move(n-1, other, to, from);
        }
    }
}

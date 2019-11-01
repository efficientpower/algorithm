package org.wjh;

public class Kmp {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String a = "123456789";
        String b = "1234567890";
        System.out.println(add(a, b));
    }

    public static String add(String a, String b) {
        if(a.length() > b.length()) {
            String str = a;
            a = b;
            b = str;
        }
        int carry = 0;
        StringBuffer sum = new StringBuffer();
        int m = b.length() - 1;
        for(int i=a.length()-1; i >= 0; i--) {
            Integer x = Integer.parseInt(a.charAt(i)+"");
            Integer y = Integer.parseInt(b.charAt(m)+"");
            int ct = x + y + carry;
            int shang = ct%10;
            carry = ct/10;
            sum.append(shang+"");
            m--;
        }
        for(; m>=0; m--) {
            Integer y = Integer.parseInt(b.charAt(m)+"");
            int ct = y + carry;
            int shang = ct%10;
            carry = ct/10;
            sum.append(shang+"");
        }
        return sum.reverse().toString();
    }
}

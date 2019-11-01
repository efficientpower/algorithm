package org.wjh;

public class Beibao {

    static int maxValue;
    static int maxWt = 8;
    static int totalValue;
    static boolean[] select = new boolean[5];

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Goods[] goods = {new Goods(6,48), new Goods(5,40), new Goods(2,12), new Goods(1,8), new Goods(1,7)};
        for(Goods good : goods) {
            totalValue = totalValue + good.value;
        }
        backpack(goods, 0, 0, totalValue);
        
        for(Goods good : goods) {
            if(good.selected) {
                System.out.println(good.weight +"=====" + good.value);
            }
        }
        System.out.println(maxValue);
    }

    public static void backpack(Goods[] goods, int i, int wt, int val) {
        if(wt + goods[i].weight <= maxWt) {
            select[i] = true;
            if(i < goods.length-1) {
                backpack(goods, i+1, wt + goods[i].weight, val);
            }else {
                for(int k=0; k< goods.length; k++) {
                    goods[k].selected = select[k];
                }
                maxValue = val;
            }
        }
        select[i] = false;
        if(val - goods[i].value > maxValue) {
            if(i < goods.length-1) {
                backpack(goods, i + 1, wt, val - goods[i].value);
            }else {
                for(int k=0; k< goods.length; k++) {
                    goods[k].selected = select[k];
                }
                maxValue = val - goods[i].value;
            }
        }
    }
}

class Goods {
    int weight;
    int value;
    boolean selected;

    public Goods(int weight, int value) {
        this.weight = weight;
        this.value = value;
    }
}
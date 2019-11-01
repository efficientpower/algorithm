package org.wjh;

public class Horse {

    public static int step = 1;
    public static int[][] directArr = { { -2, 1 }, { -1, 2 }, { 1, 2 }, { 2, 1 }, { 2, -1 }, { 1, -2 }, { -1, -2 }, { -2, -1 } };
    public static int[][] qipan = new int[8][8];

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Cor cor = new Cor(0, 0);
        
        dohorse(cor);
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print(String.format("%3d", qipan[i][j]) + " ");
            }
            System.out.println();
        }
    }

    public static void dohorse(Cor cor) {
        /* 越界 */
        if (cor.x < 0 || cor.x > 7 || cor.y < 0 || cor.y > 7) {
            return;
        }
        /* 被占用 */
        if (qipan[cor.x][cor.y] != 0) {
            return;
        }
        /* 初步满足条件 */
        qipan[cor.x][cor.y] = step;
        step++;
        /* 全部走完 */
        if (step > 64) {
            return;
        } else {
            /* 尝试所有可能的方向 */
            Cor next = new Cor(0,0);
            for (int[] dir : directArr) {
                next.x = cor.x + dir[0];
                next.y = cor.y + dir[1];
                if (next.x >= 0 || next.x <= 7 || next.y >= 0 || next.y <= 7) {
                    dohorse(next);
                }
            }
        }
        if(step <= 64) {
            /* 如果走到这边说明不合适重置 */
            qipan[cor.x][cor.y] = 0;
            step--;
        }
    }

}

class Cor {
    int x;
    int y;

    public Cor(int x, int y) {
        this.x = x;
        this.y = y;
    }

}

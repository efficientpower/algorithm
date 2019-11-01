package org.wjh;

public class HorseAll {
    public static int count = 0;
    public static int N = 8;
    public static int step = 1;
    public static int[][] directArr = { { -2, 1 }, { -1, 2 }, { 1, 2 }, { 2, 1 }, { 2, -1 }, { 1, -2 }, { -1, -2 }, { -2, -1 } };
    public static int[][] qipan = new int[N][N];

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Cor c = new Cor(0,0);
        horse(c);
    }

    public static void horse(Cor cor) {
        for(int i=0; i<N; i++) {
            int x = cor.x + directArr[i][0];
            int y = cor.y + directArr[i][1];
            if(x >=0 && x<N && y>=0 && y<N && qipan[x][y] == 0) {
                qipan[x][y] = step;
                step++;
                if(step > N*N) {
                    count++;
                    printHorse();
                    qipan = new int[N][N];
                    step=1;
                }else {
                    horse(new Cor(x,y));
                }
                if(step <= N*N) {
                    qipan[x][y] = 0;
                    step--;
                }
               
            }
        }
    }

    public static void printHorse() {
        System.out.println("=======第" + count +"种========");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(String.format("%3d", qipan[i][j]) + " ");
            }
            System.out.println();
        }
    }
}

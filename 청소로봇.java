// 2차원 배열 board 안에서 움직이는 청소 로봇 (0, 0) 에서 시작하고, 3시 방향을 바라보고 있으며 1초에 1칸씩 움직일 수 있다.
// board 안에 1 자리는 장애물이 있어 갈 수 없다.
// 장애물을 마주치거나, 배열 끝에 도달하면 시계 방향으로 90도 회전한다.
// k 초가 지난 후 청소 로봇 위치를 Return 하는 문제

import java.util.*;

class 청소로봇 {
    public int[] solution(int[][] board, int k) {
        int[] answer = {0, 0};
        int time = 0;
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        int d = 1;
        int x = 0, y = 0;

        while(time < k) {
            time++;
            int nx = x + dx[d];
            int ny = y + dy[d];
            if (nx < 0 || nx >= board.length || ny < 0 || ny >= board.length || board[nx][ny] == 1) {
                d = (d + 1) % 4;
                continue;
            }
            x = nx;
            y = ny;
        }
        answer[0] = x;
        answer[1] = y;

        return answer;
    }

    public static void main(String[] args) {
        청소로봇 T = new 청소로봇();
        int[][] arr1 = {{0, 0, 0, 0, 0},
                        {0, 1, 1, 0, 0},
                        {0, 0, 0, 0, 0},
                        {1, 0, 1, 0, 1},
                        {0, 0, 0, 0, 0}};
        System.out.println(Arrays.toString(T.solution(arr1, 10)));

        int[][] arr2 = {{0, 0, 0, 1, 0, 1},
                        {0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 1},
                        {1, 1, 0, 0, 1, 0},
                        {0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0}};
        System.out.println(Arrays.toString(T.solution(arr2, 20)));

        int[][] arr3 = {{0, 0, 1, 0, 0},
                        {0, 1, 0, 0, 0},
                        {0, 0, 0, 0, 0},
                        {1, 0, 0, 0, 1},
                        {0, 0, 0, 0, 0}};
        System.out.println(Arrays.toString(T.solution(arr3, 25)));
    }
}

// 사다리의 세로는 n 줄, 사다리의 가로 정보는 2차원 배열로 주어진다. 예를 들어 n = 5, {{1, 2, 3}, {2, 4}} 로 나올 경우,
// 첫 가로 줄은 1 -> 2, 2 -> 3, 3 -> 4 로 이어지는 가로 줄이 있고, 두번째 가로 줄은 2 -> 3, 4 -> 5 로 이어지는 가로 줄이 있다는 뜻이다.
// 이 때, n 개의 알파벳 순으로 사다리를 탔을 때, 결과를 Return 하는 알고리즘을 작성하라.

// 제한사항:
// 3 ≤ n ≤ 25입니다.
// 매개변수 ladder의 길이(사다리 가로줄의 개수)는 1,000을 넘지 않습니다. • 매개변수 ladder[i]의 길이는 10을 넘지 않습니다.

public class LadderQuest {
    public static char[] ladder(int n, int[][] ladder) {
        char[] arr = new char[n];
        char A = 'A';

        for (int i = 0; i < n; i++) {
            arr[i] = A;
            A++;
        }

        char tmp;

        for (int j = 0; j < ladder.length; j++) {
            for (int k = 0; k < ladder[j].length; k++) {
               int x = ladder[j][k];
;               tmp = arr[x - 1];
                arr[x - 1] = arr[x];
                arr[x] = tmp;
            }
        }

        return arr;
    }
    public static void main(String[] args) {
        int[][] ladder1 = {{1, 3}, {2, 4}, {1, 4}};
        int[][] ladder2 = {{1, 3, 5}, {1, 3, 6}, {2, 4}};
        int[][] ladder3 = {{1, 5}, {2, 4, 7}, {1, 5, 7}, {2, 5, 7}};
        int[][] ladder4 = {{1, 5, 8, 10}, {2, 4, 7}, {1, 5, 7 ,9 ,11}, {2, 5, 7, 10}, {3, 6, 8, 11}};

        System.out.println(ladder(5, ladder1));
        System.out.println(ladder(7, ladder2));
        System.out.println(ladder(8, ladder3));
        System.out.println(ladder(12, ladder4));

    }
}

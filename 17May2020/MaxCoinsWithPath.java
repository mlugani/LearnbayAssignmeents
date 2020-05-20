public class MaxCoinsWithPath {

    public void maxCoinsWithPath(int[][] arr) {
        int counter = 0;
        int max = 0;
        for(int i = 0; i < arr.length; i++) {
            int maxCoins = recur(arr, 0, i);
            if(maxCoins > max) {
                max = maxCoins;
                counter = 1;
            } else if(maxCoins == max) {
                counter++;
            }
        }
    }

    private int recur(int[][] arr, int x, int y) {
        if(y == arr[1].length || x == arr.length || y < 0) {
            return 0;
        }
        int diagonallyLeft = recur(arr, x + 1, y - 1);
        int down = recur(arr, x + 1, y);
        int diagonallyRight = recur(arr, x + 1, y + 1);
        return arr[x][y] + Math.max(down, Math.max(diagonallyLeft, diagonallyRight));
    }
}

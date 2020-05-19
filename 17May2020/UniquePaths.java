package DS.Learnbay.week1;

/**
 * https://leetcode.com/problems/unique-paths/
 */

public class UniquePaths {
    private int counter = 0;
    public int uniquePaths(int m, int n) {
        recur(m, n, 0, 0);
        return counter;
    }

    public void recur(int m, int n, int x, int y) {

        if(y == n || x == m) {
            return;
        }
        if(y == n - 1 && x == m - 1) {
            counter++;
        }

        // go down
        recur(m, n,x + 1, y);
        //go right
        recur(m, n, x, y + 1);
        return;
    }

    public static void main(String[] args) {
        UniquePaths uniquePaths = new UniquePaths();
        System.out.println(uniquePaths.uniquePaths(3, 2));
    }
}

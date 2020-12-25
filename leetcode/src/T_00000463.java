/**
 * 给定一个包含 0 和 1 的二维网格地图，其中 1 表示陆地 0 表示水域。
 * <p>
 * 网格中的格子水平和垂直方向相连（对角线方向不相连）。整个网格被水完全包围，但其中恰好有一个岛屿（或者说，一个或多个表示陆地的格子相连组成的岛屿）。
 * <p>
 * 岛屿中没有“湖”（“湖” 指水域在岛屿内部且不和岛屿周围的水相连）。格子是边长为 1 的正方形。网格为长方形，且宽度和高度均不超过 100 。计算这个岛屿的周长。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/island-perimeter
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class T_00000463 {
    public static void main(String[] args) {
        int[][] grid = {{0, 1, 0, 0},
                        {1, 1, 1, 0},
                        {0, 1, 0, 0},
                        {1, 1, 0, 0}
        };

        System.out.println(islandPerimeter(grid));


    }

    public static int islandPerimeter(int[][] grid) {
        int sum = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j]!=1){
                    continue;
                }
                boolean flag1 = i + 1 < grid.length && grid[i + 1][j] == 1;//下
                boolean flag2 = i - 1 >= 0 && grid[i - 1][j] == 1;//上
                boolean flag3 = j + 1 < grid[i].length && grid[i][j + 1] == 1;//右
                boolean flag4 = j - 1 >= 0 && grid[i][j - 1] == 1;//左

                if (!flag1) {
                    sum++;
                }
                if (!flag2) {
                    sum++;
                }
                if (!flag3) {
                    sum++;
                }
                if (!flag4) {
                    sum++;
                }
            }

        }
        return sum;

    }
}

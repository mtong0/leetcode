import java.util.ArrayList;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class LargestRectangleInHistogram {
    class Rectangle {
        int start_x;
        int start_y;
        int end_x;
        int end_y;

        public Rectangle(int start_x, int start_y, int end_x, int end_y) {
            this.start_x = start_x;
            this.start_y = start_y;
            this.end_x = end_x;
            this.end_y = end_y;
        }

        public boolean contain(int x1, int y1, int x2, int y2) {
            return x1 >= start_x && y1 >= start_y && x2 <= end_x && y2 <= end_y;
        }

        public boolean contain(Rectangle rectangle) {
            return rectangle.start_x >= start_x && rectangle.start_y >= start_y
                    && rectangle.end_x <= end_x && rectangle.end_y <= end_y;
        }

        public int area() {
            return (end_x-start_x+1) * (end_y-start_y+1);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Rectangle)) return false;
            Rectangle rectangle = (Rectangle) o;
            return start_x == rectangle.start_x && start_y == rectangle.start_y && end_x == rectangle.end_x && end_y == rectangle.end_y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(start_x, start_y, end_x, end_y);
        }
    }

    public int[][] map;
    Set<Rectangle> possibleRecs;
    int max = 0;
    public int largestRectangleArea(int[] heights) {
        int maxHeight = 0;
        for (int height: heights) {
            if (height > maxHeight) maxHeight = height;
        }

         map = new int[heights.length][maxHeight];

        for (int i = 0; i < heights.length; i++) {
            for (int j = 0; j < heights[i]; j++) {
                map[i][j] = 1;
            }
        }

        possibleRecs = new HashSet<>();

        int start_x;
        int start_y;
        for (int a = 0; a < map.length; a++) {
            for (int b = 0; b < map[0].length; b++) {
                if (map[a][b] == 1) {
                    start_x = a;
                    start_y = b;
                } else {
                    continue;
                }
                for (int end_x = start_x; end_x < map.length; end_x++) {
                    for (int end_y = start_y; end_y < map[0].length; end_y++) {
                        if (map[end_x][end_y] == 0) break;
                        testRectangle(start_x, start_y, end_x, end_y);
                    }
                }
            }
        }
        return max;
    }

    public void testRectangle(int start_x, int start_y, int end_x, int end_y) {
        for (Rectangle rec: possibleRecs) {
            if (rec.contain(start_x, start_y, end_x, end_y)) return;
        }

        for (int i = start_x; i <= end_x; i++) {
            for (int j = start_y; j <= end_y; j++) {
                if (map[i][j] == 0) return;
            }
        }

        Rectangle rectangle = new Rectangle(start_x, start_y, end_x, end_y);
        possibleRecs.removeIf(rectangle::contain);
        possibleRecs.add(rectangle);
        if (rectangle.area() > max) {
            max = rectangle.area();
        }
    }

    public static void main(String[] args) {
        int[] heights = {2,4};
        System.out.println(new LargestRectangleInHistogram().largestRectangleArea(heights));
    }
}

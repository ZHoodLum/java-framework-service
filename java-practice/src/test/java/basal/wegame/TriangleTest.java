package basal.wegame;

/**
 * @author：ZDY
 * @Date：Created on 2022/2/14 10:57
 * @Description: 正倒三角形
 */
public class TriangleTest {
    public static void main(String[] args) {
        int line = 6;

        int i;
        int j;
        for(i = 0; i < line; ++i) {
            for(j = 0; j < i; ++j) {
                System.out.print(" ");
            }

            for(j = 0; j < 2 * (line - i) - 1; ++j) {
                System.out.print("*");
            }

            System.out.println();
        }

        for(i = 0; i < line; ++i) {
            for(j = 0; j < line - 1 - i; ++j) {
                System.out.print(" ");
            }

            for(j = 0; j < 2 * i + 1; ++j) {
                System.out.print("*");
            }

            System.out.println();
        }

    }
}

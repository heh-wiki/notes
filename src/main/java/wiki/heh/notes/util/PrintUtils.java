package wiki.heh.notes.util;

import java.util.StringJoiner;

/**
 * 打印工具类
 *
 * @author heh
 * @date 2021/1/20
 */
public class PrintUtils {

    /**
     * 打印数组
     *
     * @param objs
     * @return
     */
    public static String arrayInt(int[] objs) {
        StringBuffer sb = new StringBuffer("[");
        for (Object obj : objs) {
            if (sb.length() > 1) {
                sb.append(", ");
            }
            sb.append(obj);
        }
        sb.append("]");
        return sb.toString();
    }

    /**
     * 打印int 矩阵：二维数组
     *
     * @param matrix
     */
    public static void matrix(int[][] matrix) {
        int len = matrix.length;
        System.out.println("[");
        for (int i = 0; i < len; i++) {
            int[] nums = matrix[i];
            StringJoiner joiner = new StringJoiner(",", "[", "]");
            for (int num : nums) {
                joiner.add(num + "");
            }
            System.out.println(joiner.toString());
        }
        System.out.println("]");
    }
}

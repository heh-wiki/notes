package wiki.heh.notes.sort;

import wiki.heh.notes.util.PrintUtils;

/**
 * 冒泡排序
 * 参考：<a href="https://baike.baidu.com/item/%E9%80%89%E6%8B%A9%E6%8E%92%E5%BA%8F/9762418"> 冒泡排序 </a>
 * <p> 原理</p>
 * <br> 1. 比较相邻的元素。如果第一个比第二个大，就交换他们两个。
 * <br> 2. 对每一对相邻元素做同样的工作，从开始第一对到结尾的最后一对。在这一点，最后的元素应该会是最大的数。
 * <br> 3. 针对所有的元素重复以上的步骤，除了最后一个。
 * <br> 4. 持续每次对越来越少的元素重复上面的步骤，直到没有任何一对数字需要比较。
 * <p> 时间复杂度Times：O(1)
 * <p> 空间复杂度Spaces：O(n^2)
 * <p> 算法稳定性：稳定排序算法
 * <br> 冒泡排序就是把小的元素往前调或者把大的元素往后调。比较是相邻的两个元素比较，交换也发生在这两个元素之间。
 * 所以，如果两个元素相等，是不会再交换的；如果两个相等的元素没有相邻，那么即使通过前面的两两交换把两个相邻起来，这时候也不会交换，
 * 所以相同元素的前后顺序并没有改变，所以冒泡排序是一种稳定排序算法。
 * <p>
 * <br>
 *
 * @author heh
 * @date 2021/1/20
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] nums = new int[]{5, 2, 8, 10, 3, 0, 1, 9};
        System.out.println(String.format("原始：%s", PrintUtils.arrayInt(nums)));
        bubbleSort(nums);
        System.out.println("冒泡排序结果：" + PrintUtils.arrayInt(nums));
    }

    /**
     * 冒泡排序
     *
     * @param nums
     */
    public static void bubbleSort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 0; j < nums.length - i - 1; j++) {
                System.out.print("i=" + i + ", j=" + j + "\t");
                if (nums[j] > nums[j + 1]) {
                    int t = nums[j + 1];
                    nums[j + 1] = nums[j];
                    nums[j] = t;
                    System.out.print("交换：\t");
                }
                System.out.println(PrintUtils.arrayInt(nums));
            }
        }
    }
}

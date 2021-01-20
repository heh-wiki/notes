package wiki.heh.notes.sort;

import wiki.heh.notes.util.PrintUtils;

/**
 * 选择排序
 * 参考：<a href="https://baike.baidu.com/item/%E5%86%92%E6%B3%A1%E6%8E%92%E5%BA%8F/4602306"> 选择排序 </a>
 * <p> 原理</p>
 * <br> 1. 首先在未排序序列中找到最小（大）元素，存放到排序序列的起始位置，
 * <br> 2. 然后，再从剩余未排序元素中继续寻找最小（大）元素，然后放到已排序序列的末尾。
 * <br> 3. 以此类推，直到所有元素均排序完毕。
 * <br>
 * <p> 时间复杂度Times：O(n^2)
 * <p> 空间复杂度Spaces：O(1)
 * <p> 算法稳定性：不稳定
 * <br> 选择排序是给每个位置选择当前元素最小的，比如给第一个位置选择最小的，在剩余元素里面给第二个元素选择第二小的，
 * 依次类推，直到第n-1个元素，第n个元素不用选择了，因为只剩下它一个最大的元素了。
 * 那么，在一趟选择，如果一个元素比当前元素小，而该小的元素又出现在一个和当前元素相等的元素后面，那么交换后稳定性就被破坏了。
 * 举个例子，序列5 8 5 2 9，我们知道第一遍选择第1个元素5会和2交换，那么原序列中两个5的相对前后顺序就被破坏了，所以选择排序是一个不稳定的排序算法。
 * <p>
 * <br>
 *
 * @author heh
 * @date 2021/1/20
 */
public class SelectionSort {
    public static void main(String[] args) {
        int[] nums = new int[]{5, 2, 8, 10, 3, 0, 1, 1, 9};
        System.out.println(String.format("原始：%s", PrintUtils.arrayInt(nums)));
        selectionSort(nums);
        System.out.println("选择排序结果：" + PrintUtils.arrayInt(nums));
    }

    /**
     * 选择排序
     *
     * @param nums
     */
    private static void selectionSort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < nums.length - 1; j++) {
                if (nums[min] > nums[j]) {
                    min = j;
                }
            }
            System.out.print("i=" + i + ", min=" + min + "\t");
            if (i != min) {
                System.out.print("交换：nums[i]=" + nums[i] + ", nums[min]=" + nums[min] + "\t");
                int t = nums[i];
                nums[i] = nums[min];
                nums[min] = t;
            }
            System.out.println(PrintUtils.arrayInt(nums));
        }
    }

}

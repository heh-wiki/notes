package wiki.heh.notes.sort;

import wiki.heh.notes.util.PrintUtils;

/**
 * 插入排序（直接插入排序）
 * 参考：<a href="https://baike.baidu.com/item/%E6%8F%92%E5%85%A5%E6%8E%92%E5%BA%8F/7214992"> 插入排序（百度百科） </a>
 * 参考：<a href="https://www.runoob.com/w3cnote/insertion-sort.html"> 插入排序（菜鸟教程） </a>
 * <p> 原理</p>
 * <br> 1. 插入排序是指在待排序的元素中，假设前面n-1(其中n>=2)个数已经是排好顺序的，
 * <br> 2. 现将第n个数插到前面已经排好的序列中，然后找到合适自己的位置，使得插入第n个数的这个序列也是排好顺序的。
 * <br> 3. 按照此法对所有元素进行插入，直到整个序列排为有序的过程，称为插入排序
 * <br>
 * <p> 时间复杂度Times：O(n^2)
 * <p> 空间复杂度Spaces：O(1)
 * <p> 算法稳定性：
 * <br> 如果待排序的序列中存在两个或两个以上具有相同关键词的数据，排序后这些数据的相对次序保持不变，即它们的位置保持不变，
 * 通俗地讲，就是两个相同的数的相对顺序不会发生改变，则该算法是稳定的；
 * 如果排序后，数据的相对次序发生了变化，则该算法是不稳定的。
 * 关键词相同的数据元素将保持原有位置不变，所以该算法是稳定的
 * <p>
 * <br>
 *
 * @author heh
 * @date 2021/1/20
 */
public class InsertionSort {
    public static void main(String[] args) {
        int[] nums = new int[]{5, 2, 8, 10, 3, 0, 1, 1, 9};
        System.out.println(String.format("原始：%s", PrintUtils.arrayInt(nums)));
        insertionSort(nums);
        System.out.println("插入排序结果：" + PrintUtils.arrayInt(nums));
    }

    /**
     * 插入排序
     *
     * @param nums
     */
    private static void insertionSort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int cur = nums[i];
            int j = i;
            // 当前cur 依次跟前已经排好的元素比较
            for (; j > 0 && cur < nums[j - 1]; ) {
                nums[j] = nums[j - 1];
                j--;
            }

            System.out.print("i=" + i + ", j=" + j + "\t");
            if (j != i) {
                nums[j] = cur;
                System.out.print("交换：\t");
            }
            System.out.println(PrintUtils.arrayInt(nums));
        }
    }
}
package wiki.heh.notes.sort;

import wiki.heh.notes.util.PrintUtils;

import java.util.Arrays;

/**
 * 归并排序
 * 参考：<a href="https://baike.baidu.com/item/%E5%B8%8C%E5%B0%94%E6%8E%92%E5%BA%8F/3229428?fr=aladdin"> 希尔排序 </a>
 *
 * <p> 基本思想 </p>
 * <br> 归并排序（Merge sort）是建立在归并操作上的一种有效的排序算法。该算法是采用分治法（Divide and Conquer）的一个非常典型的应用。
 *
 * <p> 原理</p>
 * <br> 1. 申请空间，使其大小为两个已经排序序列之和，该空间用来存放合并后的序列；
 * <br> 2. 设定两个指针，最初位置分别为两个已经排序序列的起始位置；
 * <br> 3. 比较两个指针所指向的元素，选择相对小的元素放入到合并空间，并移动指针到下一位置；
 * <br> 4. 重复步骤 3 直到某一指针达到序列尾；
 * <br> 5. 将另一序列剩下的所有元素直接复制到合并序列尾。
 * <br>
 * <p> 时间复杂度Times：O(nlogn)
 * <p> 空间复杂度Spaces：O(n)
 * <p> 算法稳定性：稳定
 * <br> 即相等的元素的顺序不会改变.
 * 如输入记录 1(1) 3(2) 2(3) 2(4) 5(5) (括号中是记录的关键字)时输出的 1(1) 2(3) 2(4) 3(2) 5(5) 中的2 和 2 是按输入的顺序.
 * 这对要排序数据包含多个信息而要按其中的某一个信息排序,要求其它信息尽量按输入的顺序排列时很重要。
 * 归并排序的比较次数小于快速排序的比较次数，移动次数一般多于快速排序的移动次数。
 * <p>
 * <br>
 *
 * @author heh
 * @date 2021/1/20
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] nums = new int[]{5, 2, 8, 10, 3, 0, 1, 1, 9};
        System.out.println(String.format("原始：%s", PrintUtils.arrayInt(nums)));
        int[] results = mergeSort(nums);
        System.out.println("归并排序结果：" + PrintUtils.arrayInt(results));
    }

    private static int[] mergeSort(int[] nums) {
        if (nums == null || nums.length < 2) {
            return nums;
        }
        int mid = nums.length / 2;
        // 左边子数组
        int[] l = Arrays.copyOfRange(nums, 0, mid);
        // 右边子数组
        int[] r = Arrays.copyOfRange(nums, mid, nums.length);
        return merge(mergeSort(l), mergeSort(r));
    }

    /**
     * 自上而下递归
     *
     * @param l
     * @param r
     * @return
     */
    private static int[] merge(int[] l, int[] r) {
        int[] results = new int[l.length + r.length];
        int i = 0;
        while (l.length > 0 && r.length > 0) {
            if (l[0] <= r[0]) {
                results[i++] = l[0];
                l = Arrays.copyOfRange(l, 1, l.length);
            } else {
                results[i++] = r[0];
                r = Arrays.copyOfRange(r, 1, r.length);
            }
        }
        while (l.length > 0) {
            results[i++] = l[0];
            l = Arrays.copyOfRange(l, 1, l.length);
        }
        while (r.length > 0) {
            results[i++] = r[0];
            r = Arrays.copyOfRange(r, 1, r.length);
        }
        return results;
    }
}

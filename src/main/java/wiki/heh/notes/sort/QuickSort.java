package wiki.heh.notes.sort;

import wiki.heh.notes.util.PrintUtils;

/**
 * 快速排序
 * 参考：<a href="https://baike.baidu.com/item/%E5%BF%AB%E9%80%9F%E6%8E%92%E5%BA%8F%E7%AE%97%E6%B3%95?fromtitle=%E5%BF%AB%E9%80%9F%E6%8E%92%E5%BA%8F&fromid=2084344"> 快速排序 </a>
 *
 * <p> 基本思想 </p>
 * <br> 是对冒泡排序的一种改进。通过一趟排序将要排序的数据分割成独立的两部分，其中一部分的所有数据都比另外一部分的所有数据都要小，
 * 然后再按此方法对这两部分数据分别进行快速排序，整个排序过程可以递归进行，以此达到整个数据变成有序序列
 *
 * <p> 原理</p>
 * <br> 1. 从数列中挑出一个元素，称为 "基准"（pivot）;
 * <br> 2. 重新排序数列，所有元素比基准值小的摆放在基准前面，所有元素比基准值大的摆在基准的后面（相同的数可以到任一边）。
 * 在这个分区退出之后，该基准就处于数列的中间位置。这个称为分区（partition）操作；
 * <br> 3. 比较两个指针所指向的元素，选择相对小的元素放入到合并空间，并移动指针到下一位置；
 * <br>
 * <p> 时间复杂度Times：O(nlogn)
 * <p> 空间复杂度Spaces：O(log2n)
 * <p> 算法稳定性：不稳定
 * <br>
 * <p>
 * <br>
 *
 * @author hehua
 * @date 2021/1/20
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] nums = new int[]{5, 2, 8, 10, 3, 0, 1, 1, 9};
        System.out.println(String.format("原始：%s", PrintUtils.arrayInt(nums)));
        quickSort(nums);
        System.out.println("快速排序结果：" + PrintUtils.arrayInt(nums));
    }

    public static void quickSort(int[] nums) {
        int l = 0, r = nums.length - 1;
        quickSort(nums, l, r);
    }

    public static void quickSort(int[] nums, int l, int r) {
        if (l < r) {
            int pivot = partition(nums, l , r);
            quickSort(nums, pivot+1, r);
            quickSort(nums, l, pivot-1);
        }
    }

    /**
     * 找到基准值
     * @param nums
     * @param l
     * @param r
     * @return
     */
    private static int partition(int[] nums, int l, int r) {
        // 初始基准值
        int p = l;
        int index = p + 1;
        for (int i = index; i <= r; i++) {
            if(nums[i] < nums[p]){
                // 交换
                swap(nums, i, index);
//                System.out.println(PrintUtils.arrayInt(nums)+" i="+i+", index="+index);
                index++;
            }
        }
        // 与基准交换
        swap(nums, p, index - 1);
//        System.out.println(PrintUtils.arrayInt(nums)+" p="+p+", (index-1)="+(index - 1));
        return index-1;
    }

    /**
     * 交换值
     * @param nums
     * @param l
     * @param r
     */
    private static void swap(int[] nums, int l , int r){
        int t = nums[l];
        nums[l] = nums[r];
        nums[r] = t;
    }
}
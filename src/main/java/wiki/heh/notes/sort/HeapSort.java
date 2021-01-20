package wiki.heh.notes.sort;

import wiki.heh.notes.util.PrintUtils;

/**
 * 堆排序
 * 参考：<a href="https://baike.baidu.com/item/%E5%A0%86%E6%8E%92%E5%BA%8F/2840151?fr=aladdin"> 百度百科-堆排序 </a>
 * 参考：<a href="https://www.cnblogs.com/chengxiao/p/6129630.html"> 网友-堆排序。比较容易理解 </a>
 * 参考：<a href="https://www.runoob.com/w3cnote/heap-sort.html"> 菜鸟教程-堆排序 </a>
 *
 * <p> 基本思想 </p>
 * <br> 指利用堆这种数据结构所设计的一种排序算法。堆积是一个近似完全二叉树的结构，
 * 并同时满足堆积的性质：即子结点的键值或索引总是小于（或者大于）它的父节点。
 * 堆排序可以说是一种利用堆的概念来排序的选择排序。分为两种方法：
 * <br> 1. 大顶堆：每个节点的值都大于或等于其子节点的值，在堆排序算法中用于升序排列；
 * <br> 2. 小顶堆：每个节点的值都小于或等于其子节点的值，在堆排序算法中用于降序排列；
 *
 * <p> 原理</p>
 * <br> 1. 创建一个堆 H[0……n-1]；
 * <br> 2.把堆首（最大值）和堆尾互换；
 * <br> 3. 把堆的尺寸缩小 1，并调用 shift_down(0)，目的是把新的数组顶端数据调整到相应位置；
 * <br> 4. 重复步骤 2，直到堆的尺寸为 1。
 * <br>
 * <p> 时间复杂度Times：O(nlogn)
 * <p> 空间复杂度Spaces：O(1)
 * <p> 算法稳定性：不稳定
 * <br>
 * <p>
 * <br>
 * @author heh
 * @date 2021/1/20
 */
public class HeapSort {
    public static void main(String[] args) {
        int[] nums = new int[]{5, 2, 8, 10, 3, 0, 1, 1, 9};
        System.out.println(String.format("原始：%s", PrintUtils.arrayInt(nums)));
        heapSort(nums);
        System.out.println("堆排序结果：" + PrintUtils.arrayInt(nums));
    }

    private static void heapSort(int[] nums) {
        // 1. 构建最大堆
        int len = nums.length;
        buildMaxHeap(nums, len);
        for (int i = len - 1; i >= 0; i--) {
            // 通过交换：将堆顶与最后一个元素交换。因为堆顶最大，也就间接将最大值放到数组最后
            swap(nums, 0, i);
            // len - 1：因为最大值已经在数组最后无需在参与排序。所以只需要对len-1处理即可
            len--;
            // 重新构建最大堆
            heapify(nums, 0, len);

        }
    }

    /**
     * 构建最大堆
     * @param nums
     * @param len
     */
    private static void buildMaxHeap(int[] nums, int len) {
        for (int i = (int)Math.floor(len / 2); i >= 0; i--) {
            heapify(nums, i, len);
        }
    }

    /**
     * 构建堆
     * @param nums
     * @param i
     * @param len
     */
    private static void heapify(int[] nums, int i, int len) {
        int left = 2 * i + 1;
        int right = 2 * i +2;
        int largest = i;
        if(left < len && nums[left] > nums[largest]){
            largest = left;
        }
        if(right < len && nums[right] > nums[largest]){
            largest = right;
        }
        if(largest != i){
            swap(nums, i, largest);
            heapify(nums, largest, len);
        }

    }

    private static void swap(int[] nums, int i, int largest) {
        int t = nums[i];
        nums[i] = nums[largest];
        nums[largest] = t;
    }
}

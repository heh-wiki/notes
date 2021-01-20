package wiki.heh.notes.sort;

import wiki.heh.notes.util.PrintUtils;

/**
 * 计数排序
 * 参考：<a href="https://baike.baidu.com/item/%E8%AE%A1%E6%95%B0%E6%8E%92%E5%BA%8F/8518144?fr=aladdin"> 百度百科-计数排序 </a>
 * 参考：<a href="https://www.runoob.com/w3cnote/counting-sort.html"> 菜鸟教程-计数排序 </a>
 *
 * <p> 基本思想 </p>
 * <br> 是对于给定的输入序列中的每一个元素x，确定该序列中值小于x的元素的个数（此处并非比较各元素的大小，而是通过对元素值的计数和计数值的累加来确定）。
 * 一旦有了这个信息，就可以将x直接存放到最终的输出序列的正确位置上。对输入的数据有附加的限制条件：
 * <br> 1. 输入的线性表的元素属于有限偏序集S；
 * <br> 2. 设输入的线性表的长度为n，|S|=k（表示集合S中元素的总数目为k），则k=O(n)。
 *
 * <p> 原理</p>
 * <br> 1. 找出待排序的数组中最大和最小的元素
 * <br> 2. 统计数组中每个值为i的元素出现的次数，存入数组C的第i项
 * <br> 3. 对所有的计数累加（从C中的第一个元素开始，每一项和前一项相加）
 * <br> 4. 反向填充目标数组：将每个元素i放在新数组的第C(i)项，每放一个元素就将C(i)减去1
 * <br>
 * <p> 时间复杂度Times：O(n+k)：当输入的元素是 n 个 0 到 k 之间的整数，k即数组中的最大值
 * <p> 空间复杂度Spaces：O(k)：需要额外长度=k的数组
 * <p> 算法稳定性：不稳定
 * <br>
 * <p>
 * <br>
 *
 * @author heh
 * @date 2021/1/20
 */
public class CountingSort {
    public static void main(String[] args) {
        int[] nums = new int[]{5, 2, 8, 10, 3, 0, 1, 1, 9};
        System.out.println(String.format("原始：%s", PrintUtils.arrayInt(nums)));
        countingSort(nums);
        System.out.println("计数排序结果：" + PrintUtils.arrayInt(nums));
    }

    private static void countingSort(int[] nums) {
        int len = nums.length;
        int maxVal = getMaxVal(nums);
        int newLen = maxVal + 1;
        int[] arrs = new int[newLen];
        //
        for (int i = 0; i < nums.length; i++) {
            arrs[nums[i]]++;
        }
        int sortIndex = 0;
        for (int i = 0; i < newLen; i++) {
            while (arrs[i] > 0) {
                nums[sortIndex++] = i;
                arrs[i]--;
            }
        }
    }

    /**
     * 找到最大值
     *
     * @param nums
     * @return
     */
    private static int getMaxVal(int[] nums) {
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
        }
        return max;
    }
}
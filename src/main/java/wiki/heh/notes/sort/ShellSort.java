package wiki.heh.notes.sort;

import wiki.heh.notes.util.PrintUtils;

/**
 * 希尔排序
 * 参考：<a href="https://baike.baidu.com/item/%E5%B8%8C%E5%B0%94%E6%8E%92%E5%BA%8F/3229428?fr=aladdin"> 希尔排序 </a>
 *
 * <p> 基本思想 </p>
 * <br> 先将整个待排序的记录序列分割成为若干子序列分别进行直接插入排序，待整个序列中的记录"基本有序"时，再对全体记录进行依次直接插入排序。
 *
 * <p> 原理</p>
 * <br> 1. 选择一个增量序列 t1，t2，……，tk，其中 ti > tj, tk = 1；
 * <br> 2. 按增量序列个数 k，对序列进行 k 趟排序；
 * <br> 3. 每趟排序，根据对应的增量 ti，将待排序列分割成若干长度为 m 的子序列，分别对各子表进行直接插入排序。仅增量因子为 1 时，整个序列作为一个表来处理，表长度即为整个序列的长度。
 * <br>
 * <p> 时间复杂度Times：O(n^(3/2))
 * <p> 空间复杂度Spaces：O(1)
 * <p> 算法稳定性：不稳定
 * <br> 由于多次插入排序，我们知道一次插入排序是稳定的，不会改变相同元素的相对顺序，
 * 但在不同的插入排序过程中，相同的元素可能在各自的插入排序中移动，最后其稳定性就会被打乱，
 * 所以shell排序是不稳定的。
 * <p>
 * <br>
 *
 * @author heh
 * @date 2021/1/20
 */
public class ShellSort {
    public static void main(String[] args) {
        int[] nums = new int[]{5, 2, 8, 10, 3, 0, 1, 1, 9};
        System.out.println(String.format("原始：%s", PrintUtils.arrayInt(nums)));
        shellSort(nums);
        System.out.println("希尔排序结果：" + PrintUtils.arrayInt(nums));
    }

    /**
     * 希尔排序
     * shell sort
     * len = 9
     * <p>
     * 第一大循环：
     * mid = 4
     * 第一步：
     * i = mid = 4
     * j=i-mid=0
     * 判断：j>=0 && j跟i比较，如果 < ,则跳过,j+mid=i的值,走第二步;否则j跟i交换值,同时j-=mid
     * 判断：j>=0 && j跟i比较，如果 < ,则跳过,j+mid=i的值，,走第二步;否则j跟i交换值,同时j-=mid
     * <p>
     * 第二步：
     * i++；
     * j=j-mid=1
     * 判断：j>=0 && j跟i比较，如果 < ,则跳过,j+mid=i的值,走第二步;否则j跟i交换值,同时j-=mid
     * 判断：j>=0 && j跟i比较，如果 < ,则跳过,j+mid=i的值，,走第二步;否则j跟i交换值,同时j-=mid
     * 直到i=9时不满足条件则进行下一个大循环。
     * <p>
     * 第二大循环：
     * mid /=2
     * 如果mid==0，则表示排序继续，return；否则开始第一步。
     * 第一步：
     * i = mid = 2
     * j=i-mid=0
     * 判断：j>=0 && j跟i比较，如果 < ,则跳过,j+mid=i的值,走第二步;否则j跟i交换值,同时j-=mid
     * 判断：j>=0 && j跟i比较，如果 < ,则跳过,j+mid=i的值，,走第二步;否则j跟i交换值,同时j-=mid
     * <p>
     * 第二步：
     * i++；
     * j=j-mid=1
     * 判断：j>=0 && j跟i比较，如果 < ,则跳过,j+mid=i的值,走第二步;否则j跟i交换值,同时j-=mid
     * 判断：j>=0 && j跟i比较，如果 < ,则跳过,j+mid=i的值，,走第二步;否则j跟i交换值,同时j-=mid
     * 直到i=9时不满足条件则重复第二大循环。
     *
     * @param nums
     */
    public static void shellSort(int[] nums) {
        int len = nums.length;
        int tmp;
        for (int m = len / 2; m >= 1; m /= 2) {
            for (int i = m; i < len; i++) {
                tmp = nums[i];
                int j = i - m;
                while (j >= 0 && nums[j] > tmp) {
                    nums[j + m] = nums[j];
                    System.out.println(PrintUtils.arrayInt(nums) + "交换后 j=" + j + "  ,m= " + m + ", j+m=" + (j + m));
                    j -= m;
                }
                nums[j + m] = tmp;
                System.out.println(PrintUtils.arrayInt(nums) + "aaaaaa：本次i=" + i);
            }
        }
    }
}
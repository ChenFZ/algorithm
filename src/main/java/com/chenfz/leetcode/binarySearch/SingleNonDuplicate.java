/**
 * Copyright (C), 2015-2021, 航天广信有限公司
 * FileName: SingleNonDuplicate
 * Author:   Chen FZ
 * Date:     2021/2/12 19:34
 * Description: 540. 有序数组中的单一元素  Single Element in a Sorted Array (Medium)
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.chenfz.leetcode.binarySearch;

/**
 * 〈一句话功能简述〉<br>
 * 〈540. 有序数组中的单一元素  Single Element in a Sorted Array (Medium)〉
 *
 * @author Chen FZ
 * @create 2021/2/12
 * @since 1.0.0
 */
public class SingleNonDuplicate {


    public static void main(String[] args) {
        System.out.println(singleNonDuplicate(new int[]{1, 1, 2}));
    }

    /*
    *   我们首先将 lo 和 hi 指向数组首尾两个元素。然后进行二分搜索将数组搜索空间减半，直到找到单一元素或者仅剩一个元素为止。当搜索空间只剩一个元素，则该元素就是单个元素。
        在每个循环迭代中，我们确定 mid，变量 halvesAreEven = (hi - mid) % 2 == 0。 通过查看中间元素同一元素为哪一个（左侧子数组中的最后一个元素或右侧子数组中的第一个元素），
            我们可以通过变量 halvesAreEven 确定现在哪一侧元素个数为奇数，并更新 lo 和 hi。
        最难的部分是根据 mid 和 halvesAreEven 的值正确更新 lo 和 hi。我们通过下图来帮助我们理解。
    * */
    public static int singleNonDuplicate(int[] nums) {
        int length = nums.length;
        if (length == 1) {
            return nums[0];
        }
        int l = 0, r = length - 1, mid;
        while (l < r) {
            mid = l + (r - l) / 2;
            boolean isEven = (r - mid) % 2 == 0;
            if (nums[mid] == nums[mid + 1]) {
                if (isEven) {
                    l = mid + 2;
                } else {
                    r = mid - 1;
                }
            } else if (nums[mid] == nums[mid - 1]) {
                if (isEven) {
                    r = mid - 2;
                } else {
                    l = mid + 1;
                }
            } else {
                return nums[mid];
            }
        }
        return nums[l];
    }
}

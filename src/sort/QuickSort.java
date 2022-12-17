package src.sort;

import java.util.Arrays;

public class QuickSort {
    public void quickSort(int[] nums) {
        helper(nums, 0, nums.length-1);
    }

    public void helper(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }

        int i = start;
        int j = start;
        for (; j < end; j++) {
            if (nums[j] < nums[end]) {
                swap(nums, i, j);
                i++;
            }
        }
        if (i != j) {
            swap(nums, i, end);
            helper(nums, start, i-1);
            helper(nums, i+1, end);
        } else {
            helper(nums, start, i-1);
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {5, 1, 1, 2, 0, 0};
        new QuickSort().quickSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}

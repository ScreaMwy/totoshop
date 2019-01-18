package org.totoshop.util.algorithm.sortimpl;

import java.util.Arrays;

import org.totoshop.util.algorithm.Sort;

public class MergeSort implements Sort {
    private static final int MAX_NUM = (int) Math.pow(2.00, 10000.00);

    private static final int MIN_MUM = - (int) Math.pow(2.00, 10000.00);

    private static MergeSort MERGE_SORT_INSTANCE;

    private MergeSort() {}

    public static MergeSort getInstance() {
        if (null == MERGE_SORT_INSTANCE) {
            MERGE_SORT_INSTANCE = new MergeSort();
        }
        return MERGE_SORT_INSTANCE;
    }

    private boolean merge_soilder(int[] array, int left, int mid, int right) {
        //
        final int LEFT_ARRAY_SIZE = mid - left + 1;
        final int RIGHT_ARRAY_SIZE = right - mid;
        //
        int[] left_array = new int[LEFT_ARRAY_SIZE + 1];
        int[] right_array = new int[RIGHT_ARRAY_SIZE + 1];
        //
        left_array[LEFT_ARRAY_SIZE] = MAX_NUM;
        right_array[RIGHT_ARRAY_SIZE] = MAX_NUM;

        //
        for (int i = left; i <= mid; i++) {
            left_array[i - left] = array[i];
        }
        for (int i = mid + 1; i <= right; i++) {
            right_array[i - mid -1] = array[i];
        }

        int i = 0;
        int j = 0;
        //
        for (int k = left; k <= right; k++) {
            if (left_array[i] <= right_array[j]) {
                array[k] = left_array[i++];
            } else if (left_array[i] >  right_array[j]) {
                array[k] = right_array[j++];
            }
        }

        display(left_array);
        display(right_array);
        return true;
    }

    public boolean sort_soilder(int[] array, int left, int right) {
        int mid = 0;
        if (left < right) {
            mid = (left + right) / 2;
            sort_soilder(array, left, mid);
            sort_soilder(array, mid + 1, right);
            merge_soilder(array,left, mid, right);
        }
        return true;
    }

    public boolean merge(int[] array, int left, int mid, int right) {
        //
        final int LEFT_ARRAY_SIZE = mid - left + 1;
        final int RIGHT_ARRAY_SIZE = right - mid;
        //
        int[] left_array = new int[LEFT_ARRAY_SIZE];
        int[] right_array = new int[RIGHT_ARRAY_SIZE];

        for (int i = left; i <= mid; i++) {
            left_array[i - left] = array[i];
        }
        for (int i = mid + 1; i <= right; i++) {
            right_array[i - mid - 1] = array[i];
        }

        int i = 0;
        int j = 0;
        int k = left;
        //
        while (i < LEFT_ARRAY_SIZE && j < RIGHT_ARRAY_SIZE) {
            if (left_array[i] <= right_array[j]) {
                array[k++] = left_array[i++];
            } else if (left_array[i] > right_array[j]) {
                array[k++] = right_array[j++];
            }
        }
        //
        while (i < LEFT_ARRAY_SIZE) {
            array[k++] = left_array[i++];
        }
        //
        while (j < RIGHT_ARRAY_SIZE) {
            array[k++] = right_array[j++];
        }

        display(left_array);
        display(right_array);
        return true;
    }

    public boolean sort(int[] array, int left, int right) {
        int mid = 0;
        if (left < right) {
            mid = (left + right) / 2;
            sort(array, left, mid);
            sort(array, mid + 1, right);
            merge(array, left, mid, right);
        }
        return true;
    }

    public String toString(int[] array) {
        if (null == array) {
            return null;
        }

        int lengthMax = array.length - 1;
        if (-1 == lengthMax) {
            return "{}";
        }

        StringBuilder string = new StringBuilder();
        string.append("{");
        for (int i = 0; ; i++) {
            string.append(array[i]);
            if (lengthMax == i) {
                return string.append("}").toString();
            } else {
                string.append(", ");
            }
        }
    }

    @Override
    public void display(int[] array) {
        System.out.printf("%s\n", toString(array));
    }
}

package cn.com.proto;

import org.junit.Assert;
import org.junit.Test;

public class UtilsTest {
    @Test
    public void testGroupCount() {
        Assert.assertEquals(0, calGroupCount(0));
        Assert.assertEquals(1, calGroupCount(2));
        Assert.assertEquals(4, calGroupCount(7));
    }

    @Test
    public void testLastRow() {
        Assert.assertEquals(true, 0 % 2 == 0);
        Assert.assertEquals(true, 6 % 2 == 0);
        Assert.assertEquals(false, 7 % 2 == 0);
    }

    private int calGroupCount(int size) {
        return size % 2 == 0 ? size / 2 : size / 2 + 1;
    }

    //https://www.toptal.com/developers/sorting-algorithms

    @Test
    public void testBubbleSort() {
        int[] arrayEx = {94, 91, 86, 84, 76, 69};
        int[] array = {84, 69, 76, 86, 94, 91};
        for (int i = 0; i < array.length - 1; i++) { // loop length - 1 times
            System.out.println("--------- 第 " + i + " 轮比较 --------- ");
            StringBuilder builderpre = new StringBuilder();
            for (int ipre = 0; ipre < array.length; ipre++) {
                builderpre.append(array[ipre]).append(", ");
            }

            System.out.println(builderpre.toString());

            for (int k = 1; k < array.length; k++) { // compare one by one
                //System.out.println("前一个数是 " + array[k - 1] + " 后一个数是 " + array[k]);
                if (array[k - 1] < array[k]) {                  // check if need to bubble up
                    int c = array[k];
                    array[k] = array[k - 1];
                    array[k - 1] = c;
                    //System.out.println("交换后，前一个数是" + array[k - 1] + " 后一个数是 " + array[k]);
                }

                StringBuilder builderpost = new StringBuilder();
                for (int ipost = 0; ipost < array.length; ipost++) {
                    builderpost.append(array[ipost]).append(", ");
                }

                System.out.println(builderpost.toString());

            }

        }

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            builder.append(array[i]).append(", ");
        }

        System.out.println("排序结果 -----------> " + builder.toString());

        Assert.assertArrayEquals(arrayEx, array);

    }

    @Test
    public void testBubbleSort2() {
        int[] arrayEx = {94, 91, 86, 84, 76, 69};
        int[] array = {84, 69, 76, 86, 94, 91};

        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1; j++) {
                int temp = 0;
                if (array[j] < array[j + 1]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            builder.append(array[i]).append(", ");
        }
        System.out.println("排序结果 -----------> " + builder.toString());
        Assert.assertArrayEquals(arrayEx, array);
    }

    private int[] numbers;
    private int number;

    @Test
    public void testQuickSort2() {
        int[] array = {57, 68, 59, 52, 72, 28, 96, 33, 24, 19};
        int[] arrayEx = {19, 24, 28, 33, 52, 57, 59, 68, 72, 96};

        this.numbers = array;
        number = array.length;
        quickSort(0, number - 1);

        printResult(numbers, arrayEx);
    }

    private void printResult(int[] array, int[] arrayEx) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            builder.append(array[i]).append(", ");
        }
        System.out.println("排序结果 -----------> " + builder.toString());
        Assert.assertArrayEquals(arrayEx, array);
    }

    private void quickSort(int low, int high) {
        int i = low, j = high;
        // Get the pivot element from the middle of the list
        int pivot = numbers[low + (high - low) / 2];

        // Divide into two lists
        while (i <= j) {
            // If the current value from the left list is smaller then the pivot
            // element then get the next element from the left list
            while (numbers[i] < pivot) {
                i++;
            }
            // If the current value from the right list is larger then the pivot
            // element then get the next element from the right list
            while (numbers[j] > pivot) {
                j--;
            }

            // If we have found a values in the left list which is larger then
            // the pivot element and if we have found a value in the right list
            // which is smaller then the pivot element then we exchange the
            // values.
            // As we are done we can increase i and j
            if (i <= j) {
                exchange(numbers, i, j);
                i++;
                j--;
            }
        }
        // Recursion
        if (low < j)
            quickSort(low, j);
        if (i < high)
            quickSort(i, high);
    }

    private void exchange(int[] numbers, int i, int j) {
        int temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
    }

    @Test
    public void testInsertionSort() {
        int[] array = {57, 68, 59, 52, 72, 28, 96, 33, 24, 19};
        int[] arrayEx = {19, 24, 28, 33, 52, 57, 59, 68, 72, 96};

        int temp;
        for (int i = 1; i < array.length; i++) {
            int j = i - 1;
            temp = array[i];
            for (; j >= 0 && temp < array[j]; j--) {
                array[j + 1] = array[j];//将大于temp的值整体后移一个单位
            }
            array[j + 1] = temp;
        }

        printResult(array, arrayEx);
    }

    /**
     * Shellsort, using a sequence suggested by Gonnet.
     * http://www.java-tips.org/java-se-tips-100019/24-java-lang/1893-shell-sort-implementation-in-java.html
     * http://bubkoo.com/2014/01/15/sort-algorithm/shell-sort/
     */
    @Test
    public void shellSort() {
        int[] array = {57, 68, 59, 52, 72, 28, 96, 33, 24};
        int[] arrayEx = {24, 28, 33, 52, 57, 59, 68, 72, 96};
        for (int gap = array.length / 2; gap > 0; gap = gap / 2) {
            for (int i = gap; i < array.length; i++) {
                int tmp = array[i];
                int j = i;

                for (; j >= gap && tmp < array[j - gap]; j -= gap) {
                    array[j] = array[j - gap];
                }
                array[j] = tmp;
            }
        }

        printResult(array, arrayEx);

    }

    @Test
    public void testSelectionSort() {
        int[] array = {57, 68, 59, 52, 72, 28, 96, 33, 24};
        int[] arrayEx = {24, 28, 33, 52, 57, 59, 68, 72, 96};
        for (int i = 0; i < array.length; i++) {
            int j = i + 1;
            int temp = array[i];
            int position = i;
            for (; j < array.length; j++) { // 找出第i个数之后的最小的一个数
                if (array[j] < temp) {
                    temp = array[j];
                    position = j;
                }
            }

            //与第i个数对换
            array[position] = array[i];
            array[i] = temp;
        }

        printResult(array, arrayEx);
    }

    private int N;

    /* Sort Function */
    @Test
    public void testHeapSort() {
        int[] array = {57, 68, 59, 52, 72, 28, 96, 33, 24};
        int[] arrayEx = {24, 28, 33, 52, 57, 59, 68, 72, 96};
        heapify(array);
        for (int i = N; i > 0; i--) {
            swap(array, 0, i);
            N = N - 1;
            maxheap(array, 0);
        }
        printResult(array, arrayEx);
    }

    /* Function to build a heap */
    public void heapify(int arr[]) {
        N = arr.length - 1;
        for (int i = N / 2; i >= 0; i--)
            maxheap(arr, i);
    }

    /* Function to swap largest element in heap */
    public void maxheap(int arr[], int i) {
        int left = 2 * i;
        int right = 2 * i + 1;
        int max = i;
        if (left <= N && arr[left] > arr[i])
            max = left;
        if (right <= N && arr[right] > arr[max])
            max = right;

        if (max != i) {
            swap(arr, i, max);
            maxheap(arr, max);
        }
    }

    /* Function to swap two numbers in an array */
    public void swap(int arr[], int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}

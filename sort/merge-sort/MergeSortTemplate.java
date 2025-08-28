import java.util.Arrays;

public class MergeSortTemplate {
    public static void main(String[] args) {
        int[] arr = {1, 6, 2, 5, 7, 10, 9};

        mergeSort(0, arr.length - 1, arr);

        System.out.println(Arrays.toString(arr));
    }

    private static void mergeSort(int left, int right, int[] arr) {
        if (left < right) {
            int mid = (left + right) / 2;

            mergeSort(left, mid, arr);
            mergeSort(mid + 1, right, arr);
            merge(left, mid, right, arr);
        }
    }

    private static void merge(int left, int mid, int right, int[] arr) {
        int[] temp = new int[arr.length];

        int low = left;
        int high = mid + 1;
        int index = left;

        while (low <= mid && high <= right) {
            if (arr[low] < arr[high]) {
                temp[index++] = arr[low++];
            } else {
                temp[index++] = arr[high++];
            }
        }

        if (low <= mid) {
            while (low <= mid) {
                temp[index++] = arr[low++];
            }
        }

        if (high <= right) {
            while (high <= right) {
                temp[index++] = arr[high++];
            }
        }

        for (int i = left; i <= right; i++) {
            arr[i] = temp[i];
        }
    }
}
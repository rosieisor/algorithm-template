import java.util.Arrays;

public class QuickSortTemplate {
    public static void main(String[] args) {
        int[] arr = {1, 6, 2, 5,7, 10, 9};

        quickSort(0, arr.length - 1, arr);

        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int left, int right, int[] arr) {
        if (left < right) {     // 원소가 2개 이상인 경우 정렬 진행
            int pivot = partition(left, right, arr);

            quickSort(left, pivot, arr);
            quickSort(pivot + 1, right, arr);
        }
    }

    private static int partition(int left, int right, int[] arr) {
        int low = left;         // 왼쪽 포인터
        int high = right;      // 오른쪽 포인터

        int pivot = arr[(left + right) / 2];

        while (true) {
            while (arr[low] < pivot) {
                low++;
            }

            while (arr[high] > pivot) {
                high--;
            }

            if (low >= high) {
                return high;
            }

            swap(low, high, arr);
            low++;
            high--;
        }
    }

    private static void swap(int low, int high, int[] arr) {
        int temp = arr[low];
        arr[low] = arr[high];
        arr[high] = temp;
    }
}
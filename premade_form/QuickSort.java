import java.util.*;

public class QuickSort {

    int N;
    int arr[];

    int partition(int low, int high) {
        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;

                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }

        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;

        return (i + 1);
    }

    void quickSort(int low, int high) {
        if (low < high) {
            int pi = partition(low, high);

            quickSort(low, pi - 1);
            quickSort(pi + 1, high);
        }
    }

    void inputData() {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        arr = new int[N]; // Padded

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        sc.close();
    }

    void solve() {
        quickSort(0, N-1);
        for (int i = 0; i < N; i++) {
            System.out.printf("%d ", arr[i]);
        }
    }
    
	public static void main(String[] args) {
        QuickSort m = new QuickSort();
        m.inputData();
        m.solve();
	}

}
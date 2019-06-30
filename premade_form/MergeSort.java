import java.util.*;

public class MergeSort {

    int N;
    int arr[];

    void merge(int l, int m, int r) {
        int nLeft = m - l + 1;
        int nRight = r - m;

        int L[] = new int[nLeft];
        int R[] = new int[nRight];

        // Copy data
        for (int i = 0; i < nLeft; i++) {
            L[i] = arr[i + l];
        }
        for (int i = 0; i < nRight; i++) {
            R[i] = arr[i + m + 1];
        }

        int i = 0; // Runner for left half
        int j = 0; // Runner for right half
        int k = l; // Runner for original array
        
        while (i < nLeft && j < nRight) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < nLeft) {
            arr[k] = L[i];
            k++;
            i++;
        }
        
        while (i < nRight) {
            arr[k] = R[j];
            k++;
            j++;
        }
    }

    void mergeSort(int l, int r) {
        if (l >= r) {
            return;
        }

        int m = (l + r) / 2;

        mergeSort(l, m);
        mergeSort(m + 1, r);
        merge(l, m, r);
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
        mergeSort(0, N-1);
        for (int i = 0; i < N; i++) {
            System.out.printf("%d ", arr[i]);
        }
    }
    
	public static void main(String[] args) {
        MergeSort m = new MergeSort();
        m.inputData();
        m.solve();
	}

}
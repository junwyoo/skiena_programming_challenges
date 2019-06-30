import java.util.*;

public class Format {

    int N;
    int map[][];

    void dfs(int[][] a, boolean[] visited, int v) {
        Stack<Integer> st = new Stack<Integer>();
        st.push(v);
        visited[v] = true;
        System.out.println(v + " ");

        boolean flag;

        while(!st.empty()) {
            int vv = st.peek();
            flag = false;

            for (int i = 1; 1 <= N; i++) {
                if (a[vv][i] == 1 && !visited[i]) {
                    st.push(i);
                    System.out.println(i + " ");
                    
                    visited[i] = true;
                    flag = true;
                    break;
                }
            }

            if (!flag) {
                st.pop();
            }
        }
    }

    void inputData() {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        map = new int[N+2][N+2]; // Padded

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                map[i][j] = sc.nextInt();
            }
        }
        sc.close();
    }

    void solve() {
    }
    
	public static void main(String[] args) {
        Format format = new Format();
        format.inputData();
        format.solve();
	}

}
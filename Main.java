import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        int values[] = new int[]{10, 6}; // Mảng giá trị
        int weights[] = new int[]{5, 4}; // Mảng khối lượng
        int maxW = 9; // Sức chứa tối đa
        int size = values.length;

        DoWork work = new DoWork();
        work.swap(values, weights, size);

        System.out.print("values[] = {");
        for(int i = 0; i < size; i++) {
            if (i == size - 1) {
                System.out.print(values[i] + "}");
            } else {
                System.out.print(values[i] + ", ");
            }
        }

        System.out.print("\nweights[] = {");
        for (int j = 0; j < size; j++) {
            if (j == size - 1) {
                System.out.print(weights[j] + "}");
            } else {
                System.out.print(weights[j] + ", ");
            }
        }

        System.out.println();
        ArrayList<Integer> items = new ArrayList<>();
        work.getItems(values, weights, items, size, maxW);

    }
}

class DoWork {
    // Sắp xếp danh sách các vật phẩm tăng dần theo khối lượng
    // Thuật toán sắp xếp chèn
    public void swap(int[] val, int wt[], int n) {
        for (int i = 1; i < n; i++) {
            for (int j = i; j > 0; j--) {
                if (val[j] < val[j - 1]) {
                    int temp = val[j];
                    val[j] = val[j - 1];
                    val[j - 1] = temp;

                    int temp2 = wt[j];
                    wt[j] = wt[j - 1];
                    wt[j - 1] = temp2;
                }
            }

        }
    }

    // Lấy ra những vật phẩm có giá trị cáo nhất trở về trước, thêm vào mảng item
    public void getItems(int val[], int wt[], ArrayList<Integer> items, int n, int W) {
        int Wtemp = W;
        for (int i = n - 1; i >= 0; i--) {
            if (wt[i] <= Wtemp) {
                items.add(val[i]);
                Wtemp -= wt[i];
            }

        }

        // In ra tổng items lấy được và các item được lấy
        System.out.print("Giá trị các vật phẩm lần lượt: ");
        int sum = 0;
        for (int j : items) {
            sum += j;
            System.out.print(j + " ");
        }
        System.out.print("\nTổng giá trị cao nhất: " + sum);

    }

}

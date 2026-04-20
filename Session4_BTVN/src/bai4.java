import java.util.*;

public class bai4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập số phần tử của mảng: ");
        int n = sc.nextInt();

        if (n == 0) {
            System.out.println("Mảng không có phần tử");
            return;
        }

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Nhập phần tử thứ " + (i + 1) + ": ");
            arr[i] = sc.nextInt();
        }

        List<Integer> evenList = new ArrayList<>();
        List<Integer> oddList = new ArrayList<>();

        for (int x : arr) {
            if (x % 2 == 0) {
                evenList.add(x);
            } else {
                oddList.add(x);
            }
        }

        int index = 0;

        for (int x : evenList) {
            arr[index++] = x;
        }

        for (int x : oddList) {
            arr[index++] = x;
        }

        System.out.println("Mảng sau khi sắp xếp:");
        for (int x : arr) {
            System.out.print(x + " ");
        }

        sc.close();
    }
}

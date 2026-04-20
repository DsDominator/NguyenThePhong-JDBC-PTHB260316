import java.util.Scanner;

public class bai3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập số phần tử: ");
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Nhập phần tử thứ " + (i + 1) + ": ");
            arr[i] = sc.nextInt();
        }

        for (int i = 0; i < n - 1; i++) {
            int maxIndex = i;

            for (int j = i + 1; j < n; j++) {
                if (arr[j] > arr[maxIndex]) {
                    maxIndex = j;
                }
            }

            int temp = arr[i];
            arr[i] = arr[maxIndex];
            arr[maxIndex] = temp;
        }

        System.out.println("Mảng sau khi sắp xếp giảm dần:");
        for (int x : arr) {
            System.out.print(x + " ");
        }
        System.out.println();

        System.out.print("Nhập số cần tìm: ");
        int target = sc.nextInt();

        int linearIndex = -1;
        for (int i = 0; i < n; i++) {
            if (arr[i] == target) {
                linearIndex = i;
                break;
            }
        }

        int binaryIndex = binarySearchDesc(arr, target);

        if (linearIndex != -1) {
            System.out.println("Tìm tuyến tính: Tìm thấy tại vị trí " + linearIndex);
        } else {
            System.out.println("Tìm tuyến tính: Không tìm thấy");
        }

        if (binaryIndex != -1) {
            System.out.println("Tìm nhị phân: Tìm thấy tại vị trí " + binaryIndex);
        } else {
            System.out.println("Tìm nhị phân: Không tìm thấy");
        }

        sc.close();
    }

    public static int binarySearchDesc(int[] arr, int target) {
        int left = 0, right = arr.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return -1;
    }
}
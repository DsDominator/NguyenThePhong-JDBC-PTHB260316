import java.util.Scanner;

public class bai5 {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Nhập số lượng sinh viên: ");
        int n = sc.nextInt();

        if (n <= 0) {
            System.out.println("Số lượng không hợp lệ!");
            return;
        }

        double[] scores = new double[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Nhập điểm sinh viên " + (i + 1) + ": ");
            scores[i] = sc.nextDouble();
        }

        boolean isSorted = false;

        while (true) {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Xem tất cả điểm");
            System.out.println("2. Sắp xếp điểm");
            System.out.println("3. Tìm kiếm điểm");
            System.out.println("4. Thống kê");
            System.out.println("5. Thoát");
            System.out.print("Chọn chức năng: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    printArray(scores);
                    break;

                case 2:
                    sortScores(scores);
                    isSorted = true;
                    break;

                case 3:
                    searchScore(scores, isSorted);
                    break;

                case 4:
                    statistics(scores);
                    break;

                case 5:
                    System.out.println("Thoát chương trình!");
                    return;

                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        }
    }

    static void printArray(double[] arr) {
        System.out.println("Danh sách điểm:");
        for (double x : arr) {
            System.out.print(x + " ");
        }
        System.out.println();
    }

    static void sortScores(double[] arr) {
        System.out.print("Chọn kiểu sắp xếp (1-Tăng, 2-Giảm): ");
        int type = sc.nextInt();

        for (int i = 0; i < arr.length - 1; i++) {
            int index = i;

            for (int j = i + 1; j < arr.length; j++) {
                if ((type == 1 && arr[j] < arr[index]) ||
                        (type == 2 && arr[j] > arr[index])) {
                    index = j;
                }
            }

            double temp = arr[i];
            arr[i] = arr[index];
            arr[index] = temp;
        }

        System.out.println("Mảng sau khi sắp xếp:");
        printArray(arr);
    }

    static void searchScore(double[] arr, boolean isSorted) {
        System.out.print("Nhập điểm cần tìm: ");
        double target = sc.nextDouble();

        int linearIndex = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                linearIndex = i;
                break;
            }
        }

        if (linearIndex != -1) {
            System.out.println("Tìm tuyến tính: vị trí " + linearIndex);
        } else {
            System.out.println("Tìm tuyến tính: không tìm thấy");
        }

        if (!isSorted) {
            System.out.println("Chưa sắp xếp → không thể tìm nhị phân!");
            return;
        }

        int binaryIndex = binarySearch(arr, target);

        if (binaryIndex != -1) {
            System.out.println("Tìm nhị phân: vị trí " + binaryIndex);
        } else {
            System.out.println("Tìm nhị phân: không tìm thấy");
        }
    }

    static int binarySearch(double[] arr, double target) {
        int left = 0, right = arr.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (arr[mid] == target) return mid;

            if (arr[mid] < target)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return -1;
    }

    static void statistics(double[] arr) {
        double sum = 0;
        double max = arr[0];
        double min = arr[0];

        for (double x : arr) {
            sum += x;
            if (x > max) max = x;
            if (x < min) min = x;
        }

        double avg = sum / arr.length;

        int countAboveAvg = 0;
        for (double x : arr) {
            if (x > avg) countAboveAvg++;
        }

        System.out.println("Điểm trung bình: " + avg);
        System.out.println("Điểm cao nhất: " + max);
        System.out.println("Điểm thấp nhất: " + min);
        System.out.println("Số SV trên trung bình: " + countAboveAvg);
    }
}
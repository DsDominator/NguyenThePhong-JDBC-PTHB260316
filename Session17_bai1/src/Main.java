package ra.run;

import ra.business.MovieManagement;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        MovieManagement movieManagement =
                new MovieManagement();

        while (true) {

            System.out.println("\n===== MOVIE MANAGEMENT =====");
            System.out.println("1. Thêm phim");
            System.out.println("2. Danh sách phim");
            System.out.println("3. Cập nhật phim");
            System.out.println("4. Xóa phim");
            System.out.println("0. Thoát");

            System.out.print("Nhập lựa chọn: ");

            try {

                int choice =
                        Integer.parseInt(sc.nextLine());

                switch (choice) {

                    case 1:

                        System.out.print("Title: ");
                        String title = sc.nextLine();

                        System.out.print("Director: ");
                        String director = sc.nextLine();

                        System.out.print("Year: ");
                        int year =
                                Integer.parseInt(sc.nextLine());

                        movieManagement.addMovie(
                                title,
                                director,
                                year
                        );
                        break;

                    case 2:
                        movieManagement.listMovies();
                        break;

                    case 3:

                        System.out.print("ID: ");
                        int id =
                                Integer.parseInt(sc.nextLine());

                        System.out.print("New Title: ");
                        String newTitle = sc.nextLine();

                        System.out.print("New Director: ");
                        String newDirector = sc.nextLine();

                        System.out.print("New Year: ");
                        int newYear =
                                Integer.parseInt(sc.nextLine());

                        movieManagement.updateMovie(
                                id,
                                newTitle,
                                newDirector,
                                newYear
                        );
                        break;

                    case 4:

                        System.out.print("ID cần xóa: ");

                        int deleteId =
                                Integer.parseInt(sc.nextLine());

                        movieManagement.deleteMovie(deleteId);

                        break;

                    case 0:
                        System.out.println("Thoát!");
                        System.exit(0);

                    default:
                        System.out.println(
                                "Lựa chọn không hợp lệ!"
                        );
                }

            } catch (NumberFormatException e) {

                System.out.println(
                        "Vui lòng nhập đúng kiểu dữ liệu!"
                );

            } catch (Exception e) {

                System.out.println(
                        "Có lỗi xảy ra: "
                                + e.getMessage()
                );
            }
        }
    }
}
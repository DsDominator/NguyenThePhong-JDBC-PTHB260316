import java.time.LocalDate;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        MovieManager<Movie> manager =
                new MovieManager<>();

        int choice = 0;

        do {

            System.out.println("\n===== QUẢN LÝ PHIM =====");
            System.out.println("1. Thêm phim mới");
            System.out.println("2. Sửa phim");
            System.out.println("3. Xóa phim");
            System.out.println("4. Hiển thị phim");
            System.out.println("5. Tìm kiếm phim theo tên");
            System.out.println("6. Lọc phim rating > 8.0");
            System.out.println("0. Thoát");
            System.out.print("Nhập lựa chọn: ");

            try {

                choice =
                        Integer.parseInt(sc.nextLine());

                switch (choice) {

                    // ===== THÊM =====
                    case 1:

                        System.out.print("Nhập ID: ");
                        String id = sc.nextLine();

                        System.out.print("Nhập tên phim: ");
                        String title = sc.nextLine();

                        System.out.print("Nhập đạo diễn: ");
                        String director = sc.nextLine();

                        System.out.print(
                                "Nhập ngày phát hành (yyyy-mm-dd): "
                        );

                        LocalDate releaseDate =
                                LocalDate.parse(sc.nextLine());

                        System.out.print("Nhập rating: ");

                        double rating =
                                Double.parseDouble(sc.nextLine());

                        manager.add(
                                new Movie(
                                        id,
                                        title,
                                        director,
                                        releaseDate,
                                        rating
                                )
                        );

                        break;

                    // ===== SỬA =====
                    case 2:

                        System.out.print(
                                "Nhập ID phim cần sửa: "
                        );

                        String updateId = sc.nextLine();

                        boolean updated = false;

                        for (Movie movie :
                                manager.getMovies()) {

                            if (movie.getId()
                                    .equals(updateId)) {

                                System.out.print(
                                        "Tên phim mới: "
                                );

                                movie.setTitle(
                                        sc.nextLine()
                                );

                                System.out.print(
                                        "Đạo diễn mới: "
                                );

                                movie.setDirector(
                                        sc.nextLine()
                                );

                                System.out.print(
                                        "Ngày phát hành mới (yyyy-mm-dd): "
                                );

                                movie.setReleaseDate(
                                        LocalDate.parse(
                                                sc.nextLine()
                                        )
                                );

                                System.out.print(
                                        "Rating mới: "
                                );

                                movie.setRating(
                                        Double.parseDouble(
                                                sc.nextLine()
                                        )
                                );

                                updated = true;

                                System.out.println(
                                        "Sửa phim thành công!"
                                );

                                break;
                            }
                        }

                        if (!updated) {
                            System.out.println(
                                    "Không tìm thấy phim!"
                            );
                        }

                        break;

                    // ===== XÓA =====
                    case 3:

                        System.out.print(
                                "Nhập ID phim cần xóa: "
                        );

                        String deleteId =
                                sc.nextLine();

                        Movie removeMovie = null;

                        for (Movie movie :
                                manager.getMovies()) {

                            if (movie.getId()
                                    .equals(deleteId)) {

                                removeMovie = movie;
                                break;
                            }
                        }

                        if (removeMovie != null) {

                            manager.getMovies()
                                    .remove(removeMovie);

                            System.out.println(
                                    "Xóa phim thành công!"
                            );

                        } else {

                            System.out.println(
                                    "Không tìm thấy phim!"
                            );
                        }

                        break;

                    // ===== HIỂN THỊ =====
                    case 4:
                        manager.display();
                        break;

                    // ===== TÌM KIẾM =====
                    case 5:

                        System.out.print(
                                "Nhập tên phim cần tìm: "
                        );

                        String keyword =
                                sc.nextLine();

                        boolean found = false;

                        for (Movie movie :
                                manager.getMovies()) {

                            if (movie.getTitle()
                                    .toLowerCase()
                                    .contains(
                                            keyword.toLowerCase()
                                    )) {

                                System.out.println(movie);
                                found = true;
                            }
                        }

                        if (!found) {

                            System.out.println(
                                    "Không tìm thấy phim"
                            );
                        }

                        break;

                    // ===== LỌC RATING =====
                    case 6:

                        System.out.println(
                                "\n===== PHIM CÓ RATING > 8.0 ====="
                        );

                        boolean hasMovie = false;

                        for (Movie movie :
                                manager.getMovies()) {

                            if (movie.getRating() > 8.0) {

                                System.out.println(movie);
                                hasMovie = true;
                            }
                        }

                        if (!hasMovie) {

                            System.out.println(
                                    "Không có phim phù hợp!"
                            );
                        }

                        break;

                    case 0:
                        System.out.println(
                                "Thoát chương trình!"
                        );
                        break;

                    default:
                        System.out.println(
                                "Lựa chọn không hợp lệ!"
                        );
                }

            } catch (NumberFormatException e) {

                System.out.println(
                        "Lỗi: Rating hoặc lựa chọn phải là số!"
                );

            } catch (Exception e) {

                System.out.println(
                        "Lỗi: " + e.getMessage()
                );
            }

        } while (choice != 0);

        sc.close();
    }
}
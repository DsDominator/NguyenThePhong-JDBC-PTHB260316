package ra.run;

import ra.business.BookManager;
import ra.entity.Book;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        BookManager manager =
                new BookManager();

        while (true) {

            System.out.println(
                    "\n===== LIBRARY MANAGEMENT ====="
            );

            System.out.println("1. Thêm sách");
            System.out.println("2. Cập nhật sách");
            System.out.println("3. Xóa sách");
            System.out.println("4. Tìm theo tác giả");
            System.out.println("5. Hiển thị tất cả sách");
            System.out.println("0. Thoát");

            System.out.print("Lựa chọn: ");

            try {

                int choice =
                        Integer.parseInt(
                                sc.nextLine()
                        );

                switch (choice) {

                    case 1:

                        Book newBook =
                                new Book();

                        System.out.print(
                                "Nhập tiêu đề: "
                        );

                        newBook.setTitle(
                                sc.nextLine()
                        );

                        System.out.print(
                                "Nhập tác giả: "
                        );

                        newBook.setAuthor(
                                sc.nextLine()
                        );

                        System.out.print(
                                "Nhập năm XB: "
                        );

                        newBook.setPublishedYear(
                                Integer.parseInt(
                                        sc.nextLine()
                                )
                        );

                        System.out.print(
                                "Nhập giá: "
                        );

                        newBook.setPrice(
                                Double.parseDouble(
                                        sc.nextLine()
                                )
                        );

                        manager.addBook(
                                newBook
                        );

                        break;

                    case 2:

                        System.out.print(
                                "Nhập ID cần sửa: "
                        );

                        int updateId =
                                Integer.parseInt(
                                        sc.nextLine()
                                );

                        Book updateBook =
                                new Book();

                        System.out.print(
                                "Tiêu đề mới: "
                        );

                        updateBook.setTitle(
                                sc.nextLine()
                        );

                        System.out.print(
                                "Tác giả mới: "
                        );

                        updateBook.setAuthor(
                                sc.nextLine()
                        );

                        System.out.print(
                                "Năm XB mới: "
                        );

                        updateBook.setPublishedYear(
                                Integer.parseInt(
                                        sc.nextLine()
                                )
                        );

                        System.out.print(
                                "Giá mới: "
                        );

                        updateBook.setPrice(
                                Double.parseDouble(
                                        sc.nextLine()
                                )
                        );

                        manager.updateBook(
                                updateId,
                                updateBook
                        );

                        break;

                    case 3:

                        System.out.print(
                                "Nhập ID cần xóa: "
                        );

                        int deleteId =
                                Integer.parseInt(
                                        sc.nextLine()
                                );

                        manager.deleteBook(
                                deleteId
                        );

                        break;

                    case 4:

                        System.out.print(
                                "Nhập tác giả cần tìm: "
                        );

                        String author =
                                sc.nextLine();

                        List<Book> books =
                                manager.findBooksByAuthor(
                                        author
                                );

                        if (books.isEmpty()) {

                            System.out.println(
                                    "Không tìm thấy sách!"
                            );

                        } else {

                            books.forEach(
                                    System.out::println
                            );
                        }

                        break;

                    case 5:

                        manager.listAllBooks();

                        break;

                    case 0:

                        System.out.println(
                                "Thoát chương trình!"
                        );

                        System.exit(0);

                    default:

                        System.out.println(
                                "Lựa chọn không hợp lệ!"
                        );
                }

            } catch (NumberFormatException e) {

                System.out.println(
                        "Sai kiểu dữ liệu!"
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
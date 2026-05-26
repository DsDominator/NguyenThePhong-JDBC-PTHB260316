package ra.business;

import ra.db.DBConnection;
import ra.entity.Book;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookManager {

    public void addBook(Book book) {

        if (book.getTitle().trim().isEmpty()
                || book.getAuthor().trim().isEmpty()) {

            System.out.println(
                    "Không được để trống dữ liệu!"
            );

            return;
        }

        String checkSql =
                "SELECT * FROM books " +
                        "WHERE title = ? AND author = ?";

        String insertSql =
                "INSERT INTO books(title, author, published_year, price) " +
                        "VALUES (?, ?, ?, ?)";

        try (Connection conn =
                     DBConnection.getConnection()) {

            PreparedStatement checkPs =
                    conn.prepareStatement(checkSql);

            checkPs.setString(1, book.getTitle());
            checkPs.setString(2, book.getAuthor());

            ResultSet rs =
                    checkPs.executeQuery();

            if (rs.next()) {

                System.out.println(
                        "Sách đã tồn tại!"
                );

                return;
            }

            PreparedStatement insertPs =
                    conn.prepareStatement(insertSql);

            insertPs.setString(1, book.getTitle());
            insertPs.setString(2, book.getAuthor());
            insertPs.setInt(
                    3,
                    book.getPublishedYear()
            );

            insertPs.setDouble(
                    4,
                    book.getPrice()
            );

            int rows =
                    insertPs.executeUpdate();

            if (rows > 0) {

                System.out.println(
                        "Thêm sách thành công!"
                );
            }

        } catch (SQLException e) {

            System.out.println(
                    "Lỗi thêm sách: "
                            + e.getMessage()
            );
        }
    }

    public void updateBook(int id,
                           Book book) {

        String checkSql =
                "SELECT * FROM books WHERE id = ?";

        String updateSql =
                "UPDATE books " +
                        "SET title = ?, " +
                        "author = ?, " +
                        "published_year = ?, " +
                        "price = ? " +
                        "WHERE id = ?";

        try (Connection conn =
                     DBConnection.getConnection()) {

            PreparedStatement checkPs =
                    conn.prepareStatement(checkSql);

            checkPs.setInt(1, id);

            ResultSet rs =
                    checkPs.executeQuery();

            if (!rs.next()) {

                System.out.println(
                        "Không tìm thấy sách!"
                );

                return;
            }

            PreparedStatement updatePs =
                    conn.prepareStatement(updateSql);

            updatePs.setString(1, book.getTitle());

            updatePs.setString(2, book.getAuthor());

            updatePs.setInt(
                    3,
                    book.getPublishedYear()
            );

            updatePs.setDouble(
                    4,
                    book.getPrice()
            );

            updatePs.setInt(5, id);

            int rows =
                    updatePs.executeUpdate();

            if (rows > 0) {

                System.out.println(
                        "Cập nhật thành công!"
                );
            }

        } catch (SQLException e) {

            System.out.println(
                    "Lỗi cập nhật: "
                            + e.getMessage()
            );
        }
    }

    public void deleteBook(int id) {

        String checkSql =
                "SELECT * FROM books WHERE id = ?";

        String deleteSql =
                "DELETE FROM books WHERE id = ?";

        try (Connection conn =
                     DBConnection.getConnection()) {

            PreparedStatement checkPs =
                    conn.prepareStatement(checkSql);

            checkPs.setInt(1, id);

            ResultSet rs =
                    checkPs.executeQuery();

            if (!rs.next()) {

                System.out.println(
                        "Không tìm thấy sách!"
                );

                return;
            }

            PreparedStatement deletePs =
                    conn.prepareStatement(deleteSql);

            deletePs.setInt(1, id);

            int rows =
                    deletePs.executeUpdate();

            if (rows > 0) {

                System.out.println(
                        "Xóa thành công!"
                );
            }

        } catch (SQLException e) {

            System.out.println(
                    "Lỗi xóa sách: "
                            + e.getMessage()
            );
        }
    }

    public List<Book> findBooksByAuthor(
            String author) {

        List<Book> books =
                new ArrayList<>();

        String sql =
                "SELECT * FROM books " +
                        "WHERE author ILIKE ?";

        try (Connection conn =
                     DBConnection.getConnection();

             PreparedStatement ps =
                     conn.prepareStatement(sql)) {

            ps.setString(
                    1,
                    "%" + author + "%"
            );

            ResultSet rs =
                    ps.executeQuery();

            while (rs.next()) {

                Book book = new Book();

                book.setId(
                        rs.getInt("id")
                );

                book.setTitle(
                        rs.getString("title")
                );

                book.setAuthor(
                        rs.getString("author")
                );

                book.setPublishedYear(
                        rs.getInt("published_year")
                );

                book.setPrice(
                        rs.getDouble("price")
                );

                books.add(book);
            }

        } catch (SQLException e) {

            System.out.println(
                    "Lỗi tìm kiếm: "
                            + e.getMessage()
            );
        }

        return books;
    }

    public void listAllBooks() {

        String sql =
                "SELECT * FROM books ORDER BY id";

        try (Connection conn =
                     DBConnection.getConnection();

             PreparedStatement ps =
                     conn.prepareStatement(sql)) {

            ResultSet rs =
                    ps.executeQuery();

            System.out.println(
                    "===== DANH SÁCH SÁCH ====="
            );

            while (rs.next()) {

                System.out.println(
                        "ID: "
                                + rs.getInt("id")
                );

                System.out.println(
                        "Title: "
                                + rs.getString("title")
                );

                System.out.println(
                        "Author: "
                                + rs.getString("author")
                );

                System.out.println(
                        "Published Year: "
                                + rs.getInt(
                                "published_year")
                );

                System.out.println(
                        "Price: "
                                + rs.getDouble("price")
                );

                System.out.println(
                        "----------------------"
                );
            }

        } catch (SQLException e) {

            System.out.println(
                    "Lỗi hiển thị sách: "
                            + e.getMessage()
            );
        }
    }
}

package ra.business;

import ra.db.DBConnection;

import java.sql.*;

public class MovieManagement {

    public void addMovie(String title,
                         String director,
                         int year) {

        if (title.trim().isEmpty()
                || director.trim().isEmpty()) {

            System.out.println("Không được để trống dữ liệu!");
            return;
        }

        String sql = "CALL add_movie(?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             CallableStatement call =
                     conn.prepareCall(sql)) {

            call.setString(1, title);
            call.setString(2, director);
            call.setInt(3, year);

            call.execute();

            System.out.println("Thêm phim thành công!");

        } catch (SQLException e) {
            System.out.println("Lỗi thêm phim: "
                    + e.getMessage());
        }
    }

    public void listMovies() {

        String sql = "SELECT * FROM list_movies()";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps =
                     conn.prepareStatement(sql)) {

            ResultSet rs = ps.executeQuery();

            System.out.println("===== DANH SÁCH PHIM =====");

            while (rs.next()) {

                System.out.println("ID: "
                        + rs.getInt("id"));

                System.out.println("Title: "
                        + rs.getString("title"));

                System.out.println("Director: "
                        + rs.getString("director"));

                System.out.println("Year: "
                        + rs.getInt("year"));

                System.out.println("--------------------");
            }

        } catch (SQLException e) {
            System.out.println("Lỗi hiển thị: "
                    + e.getMessage());
        }
    }

    public void updateMovie(int id,
                            String title,
                            String director,
                            int year) {

        String sql =
                "CALL update_movie(?, ?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             CallableStatement call =
                     conn.prepareCall(sql)) {

            call.setInt(1, id);
            call.setString(2, title);
            call.setString(3, director);
            call.setInt(4, year);

            call.execute();

            System.out.println("Cập nhật thành công!");

        } catch (SQLException e) {
            System.out.println("Lỗi cập nhật: "
                    + e.getMessage());
        }
    }

    public void deleteMovie(int id) {

        String sql = "CALL delete_movie(?)";

        try (Connection conn = DBConnection.getConnection();
             CallableStatement call =
                     conn.prepareCall(sql)) {

            call.setInt(1, id);

            call.execute();

            System.out.println("Xóa thành công!");

        } catch (SQLException e) {
            System.out.println("Lỗi xóa: "
                    + e.getMessage());
        }
    }
}
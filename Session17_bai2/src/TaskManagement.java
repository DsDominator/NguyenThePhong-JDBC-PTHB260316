package ra.business;

import ra.db.DBConnection;

import java.sql.*;

public class TaskManagement {

    public void addTask(String taskName,
                        String status) {

        if (taskName.trim().isEmpty()
                || status.trim().isEmpty()) {

            System.out.println(
                    "Không được để trống dữ liệu!"
            );
            return;
        }

        String sql = "{CALL add_task(?, ?)}";

        try (Connection conn =
                     DBConnection.getConnection();

             CallableStatement call =
                     conn.prepareCall(sql)) {

            call.setString(1, taskName);
            call.setString(2, status);

            call.execute();

            System.out.println(
                    "Thêm công việc thành công!"
            );

        } catch (SQLException e) {

            System.out.println(
                    "Lỗi thêm công việc: "
                            + e.getMessage()
            );
        }
    }

    public void listTasks() {

        String sql = "{CALL list_tasks()}";

        try (Connection conn =
                     DBConnection.getConnection();

             CallableStatement call =
                     conn.prepareCall(sql)) {

            ResultSet rs = call.executeQuery();

            System.out.println(
                    "===== DANH SÁCH CÔNG VIỆC ====="
            );

            while (rs.next()) {

                System.out.println(
                        "ID: " + rs.getInt("id")
                );

                System.out.println(
                        "Task: "
                                + rs.getString("task_name")
                );

                System.out.println(
                        "Status: "
                                + rs.getString("status")
                );

                System.out.println(
                        "----------------------"
                );
            }

        } catch (SQLException e) {

            System.out.println(
                    "Lỗi hiển thị: "
                            + e.getMessage()
            );
        }
    }

    public void updateTaskStatus(int taskId,
                                 String status) {

        String sql =
                "{CALL update_task_status(?, ?)}";

        try (Connection conn =
                     DBConnection.getConnection();

             CallableStatement call =
                     conn.prepareCall(sql)) {

            call.setInt(1, taskId);
            call.setString(2, status);

            int rows = call.executeUpdate();

            if (rows > 0) {

                System.out.println(
                        "Cập nhật thành công!"
                );

            } else {

                System.out.println(
                        "Không tìm thấy ID!"
                );
            }

        } catch (SQLException e) {

            System.out.println(
                    "Lỗi cập nhật: "
                            + e.getMessage()
            );
        }
    }

    public void deleteTask(int taskId) {

        String sql = "{CALL delete_task(?)}";

        try (Connection conn =
                     DBConnection.getConnection();

             CallableStatement call =
                     conn.prepareCall(sql)) {

            call.setInt(1, taskId);

            int rows = call.executeUpdate();

            if (rows > 0) {

                System.out.println(
                        "Xóa thành công!"
                );

            } else {

                System.out.println(
                        "Không tìm thấy ID!"
                );
            }

        } catch (SQLException e) {

            System.out.println(
                    "Lỗi xóa: "
                            + e.getMessage()
            );
        }
    }

    public void searchTaskByName(String taskName) {

        String sql =
                "{CALL search_task_by_name(?)}";

        try (Connection conn =
                     DBConnection.getConnection();

             CallableStatement call =
                     conn.prepareCall(sql)) {

            call.setString(1, taskName);

            ResultSet rs = call.executeQuery();

            System.out.println(
                    "===== KẾT QUẢ TÌM KIẾM ====="
            );

            while (rs.next()) {

                System.out.println(
                        "ID: " + rs.getInt("id")
                );

                System.out.println(
                        "Task: "
                                + rs.getString("task_name")
                );

                System.out.println(
                        "Status: "
                                + rs.getString("status")
                );

                System.out.println(
                        "-------------------"
                );
            }

        } catch (SQLException e) {

            System.out.println(
                    "Lỗi tìm kiếm: "
                            + e.getMessage()
            );
        }
    }

    public void taskStatistics() {

        String sql =
                "{CALL task_statistics()}";

        try (Connection conn =
                     DBConnection.getConnection();

             CallableStatement call =
                     conn.prepareCall(sql)) {

            ResultSet rs = call.executeQuery();

            if (rs.next()) {

                System.out.println(
                        "Đã hoàn thành: "
                                + rs.getInt(
                                "completed_tasks")
                );

                System.out.println(
                        "Chưa hoàn thành: "
                                + rs.getInt(
                                "incomplete_tasks")
                );
            }

        } catch (SQLException e) {

            System.out.println(
                    "Lỗi thống kê: "
                            + e.getMessage()
            );
        }
    }
}
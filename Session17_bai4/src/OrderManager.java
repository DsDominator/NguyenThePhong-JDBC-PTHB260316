package ra.business;

import ra.db.DBConnection;
import ra.entity.Customer;
import ra.entity.Order;
import ra.entity.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderManager {

    public void addProduct(Product product) {

        if (product.getName().trim().isEmpty()) {

            System.out.println(
                    "Tên sản phẩm không được trống!"
            );

            return;
        }

        String checkSql =
                "SELECT * FROM products WHERE name = ?";

        String insertSql =
                "INSERT INTO products(name, price) " +
                        "VALUES (?, ?)";

        try (Connection conn =
                     DBConnection.getConnection()) {

            PreparedStatement checkPs =
                    conn.prepareStatement(checkSql);

            checkPs.setString(
                    1,
                    product.getName()
            );

            ResultSet rs =
                    checkPs.executeQuery();

            if (rs.next()) {

                System.out.println(
                        "Tên sản phẩm đã tồn tại!"
                );

                return;
            }

            PreparedStatement insertPs =
                    conn.prepareStatement(insertSql);

            insertPs.setString(
                    1,
                    product.getName()
            );

            insertPs.setDouble(
                    2,
                    product.getPrice()
            );

            int rows =
                    insertPs.executeUpdate();

            if (rows > 0) {

                System.out.println(
                        "Thêm sản phẩm thành công!"
                );
            }

        } catch (SQLException e) {

            System.out.println(
                    "Lỗi thêm sản phẩm: "
                            + e.getMessage()
            );
        }
    }

    public void updateCustomer(int customerId,
                               Customer customer) {

        String checkSql =
                "SELECT * FROM customers WHERE id = ?";

        String updateSql =
                "UPDATE customers " +
                        "SET name = ?, email = ? " +
                        "WHERE id = ?";

        try (Connection conn =
                     DBConnection.getConnection()) {

            PreparedStatement checkPs =
                    conn.prepareStatement(checkSql);

            checkPs.setInt(1, customerId);

            ResultSet rs =
                    checkPs.executeQuery();

            if (!rs.next()) {

                System.out.println(
                        "Không tìm thấy khách hàng!"
                );

                return;
            }

            PreparedStatement updatePs =
                    conn.prepareStatement(updateSql);

            updatePs.setString(
                    1,
                    customer.getName()
            );

            updatePs.setString(
                    2,
                    customer.getEmail()
            );

            updatePs.setInt(3, customerId);

            int rows =
                    updatePs.executeUpdate();

            if (rows > 0) {

                System.out.println(
                        "Cập nhật thành công!"
                );
            }

        } catch (SQLException e) {

            System.out.println(
                    "Lỗi cập nhật khách hàng: "
                            + e.getMessage()
            );
        }
    }

    public void createOrder(Order order) {

        String checkCustomer =
                "SELECT * FROM customers WHERE id = ?";

        String insertSql =
                "INSERT INTO orders(customer_id, order_date, total_amount) " +
                        "VALUES (?, ?, ?)";

        try (Connection conn =
                     DBConnection.getConnection()) {

            PreparedStatement checkPs =
                    conn.prepareStatement(checkCustomer);

            checkPs.setInt(
                    1,
                    order.getCustomerId()
            );

            ResultSet rs =
                    checkPs.executeQuery();

            if (!rs.next()) {

                System.out.println(
                        "Khách hàng không tồn tại!"
                );

                return;
            }

            PreparedStatement insertPs =
                    conn.prepareStatement(insertSql);

            insertPs.setInt(
                    1,
                    order.getCustomerId()
            );

            insertPs.setDate(
                    2,
                    order.getOrderDate()
            );

            insertPs.setDouble(
                    3,
                    order.getTotalAmount()
            );

            int rows =
                    insertPs.executeUpdate();

            if (rows > 0) {

                System.out.println(
                        "Tạo đơn hàng thành công!"
                );
            }

        } catch (SQLException e) {

            System.out.println(
                    "Lỗi tạo đơn hàng: "
                            + e.getMessage()
            );
        }
    }

    public void listAllOrders() {

        String sql =
                "SELECT o.id, c.name, " +
                        "o.order_date, o.total_amount " +
                        "FROM orders o " +
                        "JOIN customers c " +
                        "ON o.customer_id = c.id";

        try (Connection conn =
                     DBConnection.getConnection();

             PreparedStatement ps =
                     conn.prepareStatement(sql)) {

            ResultSet rs =
                    ps.executeQuery();

            System.out.println(
                    "===== DANH SÁCH ĐƠN HÀNG ====="
            );

            while (rs.next()) {

                System.out.println(
                        "Order ID: "
                                + rs.getInt("id")
                );

                System.out.println(
                        "Customer: "
                                + rs.getString("name")
                );

                System.out.println(
                        "Order Date: "
                                + rs.getDate("order_date")
                );

                System.out.println(
                        "Total: "
                                + rs.getDouble(
                                "total_amount")
                );

                System.out.println(
                        "---------------------"
                );
            }

        } catch (SQLException e) {

            System.out.println(
                    "Lỗi hiển thị đơn hàng: "
                            + e.getMessage()
            );
        }
    }

    public void getOrdersByCustomer(
            int customerId) {

        String sql =
                "SELECT * FROM orders " +
                        "WHERE customer_id = ?";

        try (Connection conn =
                     DBConnection.getConnection();

             PreparedStatement ps =
                     conn.prepareStatement(sql)) {

            ps.setInt(1, customerId);

            ResultSet rs =
                    ps.executeQuery();

            System.out.println(
                    "===== ĐƠN HÀNG KHÁCH HÀNG ====="
            );

            while (rs.next()) {

                System.out.println(
                        "Order ID: "
                                + rs.getInt("id")
                );

                System.out.println(
                        "Order Date: "
                                + rs.getDate("order_date")
                );

                System.out.println(
                        "Total Amount: "
                                + rs.getDouble(
                                "total_amount")
                );

                System.out.println(
                        "----------------------"
                );
            }

        } catch (SQLException e) {

            System.out.println(
                    "Lỗi tìm đơn hàng: "
                            + e.getMessage()
            );
        }
    }
}

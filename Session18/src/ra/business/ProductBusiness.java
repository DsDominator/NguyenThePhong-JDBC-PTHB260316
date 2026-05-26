package ra.business;

import ra.entity.Product;
import ra.util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductBusiness {

    public static List<Product> getAllProducts() {
        Connection conn = null;
        CallableStatement callSt = null;
        List<Product> list = new ArrayList<>();

        try {
            conn = DBConnection.openConnection();

            callSt = conn.prepareCall("{call Get_All_Product()}");

            ResultSet rs = callSt.executeQuery();

            while (rs.next()) {
                Product p = new Product();

                p.setProductId(rs.getInt("Product_Id"));
                p.setProductName(rs.getString("Product_Name"));
                p.setProductPrice(rs.getFloat("Product_Price"));
                p.setProductTitle(rs.getString("Product_Title"));
                p.setProductCreated(rs.getDate("Product_Created"));
                p.setProductCatalog(rs.getString("Product_Catalog"));
                p.setProductStatus(rs.getBoolean("Product_Status"));

                list.add(p);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    public static boolean insertProduct(Product product) {
        Connection conn = null;
        CallableStatement callSt = null;

        try {
            conn = DBConnection.openConnection();

            callSt = conn.prepareCall("{call Insert_Product(?,?,?,?,?,?)}");

            callSt.setString(1, product.getProductName());
            callSt.setFloat(2, product.getProductPrice());
            callSt.setString(3, product.getProductTitle());
            callSt.setDate(4,
                    new java.sql.Date(product.getProductCreated().getTime()));
            callSt.setString(5, product.getProductCatalog());
            callSt.setBoolean(6, product.isProductStatus());

            callSt.executeUpdate();

            return true;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }
}
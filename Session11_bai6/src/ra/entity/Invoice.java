// File: Invoice.java
package ra.entity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Invoice {
    private String invoiceId;
    private String customerName;
    private Date invoiceDate;
    private InvoiceDetail[] invoiceDetails;
    private double totalAmount;

    public Invoice() {
    }

    public Invoice(String invoiceId, String customerName, Date invoiceDate,
                   InvoiceDetail[] invoiceDetails, double totalAmount) {
        this.invoiceId = invoiceId;
        this.customerName = customerName;
        this.invoiceDate = invoiceDate;
        this.invoiceDetails = invoiceDetails;
        this.totalAmount = totalAmount;
    }

    public String getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(String invoiceId) {
        this.invoiceId = invoiceId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Date getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(Date invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public InvoiceDetail[] getInvoiceDetails() {
        return invoiceDetails;
    }

    public void setInvoiceDetails(InvoiceDetail[] invoiceDetails) {
        this.invoiceDetails = invoiceDetails;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public void inputData(Scanner scanner, Product[] arrProd, int prodIndex) {
        while (true) {
            System.out.print("Nhập mã hóa đơn (HDxxxx): ");
            invoiceId = scanner.nextLine();

            if (invoiceId.matches("HD\\d{4}")) {
                break;
            }

            System.out.println("Mã hóa đơn không hợp lệ!");
        }

        System.out.print("Nhập tên khách hàng: ");
        customerName = scanner.nextLine();

        while (true) {
            try {
                System.out.print("Nhập ngày hóa đơn (dd/MM/yyyy): ");
                invoiceDate = new SimpleDateFormat("dd/MM/yyyy")
                        .parse(scanner.nextLine());
                break;
            } catch (ParseException e) {
                System.out.println("Ngày không đúng định dạng!");
            }
        }

        System.out.print("Nhập số lượng sản phẩm trong hóa đơn: ");
        int n = Integer.parseInt(scanner.nextLine());

        invoiceDetails = new InvoiceDetail[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Nhập chi tiết hóa đơn thứ " + (i + 1));

            invoiceDetails[i] = new InvoiceDetail();
            invoiceDetails[i].inputData(scanner, arrProd, prodIndex);
        }

        calculateTotalAmount();
    }

    public void calculateTotalAmount() {
        totalAmount = 0;

        for (InvoiceDetail detail : invoiceDetails) {
            totalAmount += detail.getSubTotal();
        }
    }

    public void displayData() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.println("======================================");
        System.out.println("Mã HĐ: " + invoiceId);
        System.out.println("Khách hàng: " + customerName);
        System.out.println("Ngày lập: " + sdf.format(invoiceDate));

        System.out.println("----- DANH SÁCH SẢN PHẨM -----");

        for (InvoiceDetail detail : invoiceDetails) {
            detail.displayData();
        }

        System.out.printf("Tổng tiền: %.2f\n", totalAmount);
    }
}

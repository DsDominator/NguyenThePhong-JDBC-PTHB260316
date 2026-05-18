public class InvalidPhoneNumberLengthException extends Exception {

    public InvalidPhoneNumberLengthException(String message) {
        super(message);
    }

    // Hàm kiểm tra số điện thoại
    public static void validatePhoneNumber(String phone)
            throws InvalidPhoneNumberLengthException {

        // Kiểm tra khoảng trắng
        if (phone.contains(" ")) {
            throw new InvalidPhoneNumberLengthException(
                    "Không được chứa khoảng trắng"
            );
        }

        // Kiểm tra chỉ chứa số
        if (!phone.matches("[0-9]+")) {
            throw new InvalidPhoneNumberLengthException(
                    "Chứa ký tự không hợp lệ"
            );
        }

        // Kiểm tra độ dài
        if (phone.length() != 10) {
            throw new InvalidPhoneNumberLengthException(
                    "Số điện thoại phải gồm đúng 10 chữ số"
            );
        }
    }
}
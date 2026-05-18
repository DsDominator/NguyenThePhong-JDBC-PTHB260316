import java.util.ArrayList;
import java.util.Optional;

public class SubjectManager<T> {

    private ArrayList<T> subjects = new ArrayList<>();

    // Thêm môn học
    public void add(T subject) {
        subjects.add(subject);
        System.out.println("Thêm môn học thành công!");
    }

    // Hiển thị danh sách
    public void display() {

        if (subjects.isEmpty()) {
            System.out.println("Danh sách môn học trống!");
            return;
        }

        System.out.println("\n===== DANH SÁCH MÔN HỌC =====");

        subjects.forEach(System.out::println);
    }

    // Xóa theo code
    public void deleteByCode(String code) {

        Subject removeSubject = null;

        for (T item : subjects) {

            Subject subject = (Subject) item;

            if (subject.getCode().equalsIgnoreCase(code)) {
                removeSubject = subject;
                break;
            }
        }

        if (removeSubject != null) {

            subjects.remove(removeSubject);

            System.out.println("Xóa môn học thành công!");

        } else {

            System.out.println("Không tìm thấy môn học!");
        }
    }

    // Tìm kiếm theo tên
    public void searchByName(String keyword) {

        Optional<T> result = subjects.stream()
                .filter(item -> ((Subject) item)
                        .getName()
                        .toLowerCase()
                        .contains(keyword.toLowerCase()))
                .findFirst();

        if (result.isPresent()) {

            System.out.println(result.get());

        } else {

            System.out.println(
                    "Không có môn học phù hợp"
            );
        }
    }

    // Lọc theo credits > 3
    public void filterCredits() {

        System.out.println(
                "\n===== MÔN HỌC CÓ CREDITS > 3 ====="
        );

        subjects.stream()
                .map(item -> (Subject) item)
                .filter(subject -> subject.getCredits() > 3)
                .forEach(System.out::println);
    }
}

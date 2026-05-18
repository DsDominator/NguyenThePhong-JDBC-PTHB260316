import java.util.ArrayList;

public class MovieManager<T> {

    private ArrayList<T> movies = new ArrayList<>();

    // Thêm phim
    public void add(T movie) {
        movies.add(movie);
        System.out.println("Thêm phim thành công!");
    }

    // Hiển thị danh sách
    public void display() {

        if (movies.isEmpty()) {
            System.out.println("Danh sách phim trống!");
            return;
        }

        System.out.println("\n===== DANH SÁCH PHIM =====");

        for (T movie : movies) {
            System.out.println(movie);
        }
    }

    // Lấy danh sách
    public ArrayList<T> getMovies() {
        return movies;
    }
}
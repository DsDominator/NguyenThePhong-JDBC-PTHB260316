public class Student {
    private int id;
    private String fullName;
    private int age;
    private double gpa;

    private static int count = 0;

    public final double MIN_GPA = 0.0;
    public final double MAX_GPA = 4.0;

    public Student(int id, String fullName, int age, double gpa) {
        this.id = id;
        this.fullName = fullName;
        this.age = age;

        if (gpa < MIN_GPA) {
            this.gpa = MIN_GPA;
        } else if (gpa > MAX_GPA) {
            this.gpa = MAX_GPA;
        } else {
            this.gpa = gpa;
        }

        count++;
    }

    public void printInfo() {
        System.out.println("ID: " + id +
                ", Name: " + fullName +
                ", Age: " + age +
                ", GPA: " + gpa);
    }

    public static int getCount() {
        return count;
    }
}
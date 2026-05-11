public class PartTimeEmployee extends Employee {

    private double workingHour;
    private double salaryPerHour;

    public PartTimeEmployee(int id, String name,
                            double workingHour,
                            double salaryPerHour) {

        super(id, name);
        this.workingHour = workingHour;
        this.salaryPerHour = salaryPerHour;
    }

    @Override
    double calculateSalary() {
        return workingHour * salaryPerHour;
    }
}
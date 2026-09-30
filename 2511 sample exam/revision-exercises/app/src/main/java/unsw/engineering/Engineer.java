package unsw.engineering;

public class Engineer extends Employee {
    private double bonus;

    public Engineer(String title, String firstName, String lastName, double bonus, double baseSalary) {
        super(title, firstName, lastName, baseSalary);
        this.bonus = bonus;
    }

    @Override
    public double calculateSalary() {
        return super.calculateSalary() + bonus;
    }
}

package unsw.engineering;

public class SalesPerson extends Employee {
    private float commission;

    private double salesTarget;
    private double salesAchieved;

    public SalesPerson(String title, String firstName, String lastName, double salesTarget, double salesAchieved, float commission, double baseSalary) {
        super(title, firstName, lastName, baseSalary);

        this.commission = commission;
        this.salesTarget = salesTarget;
        this.salesAchieved = salesAchieved;
    }

    public double getSalesTarget() {
        return salesTarget;
    }

    public double getSalesAchieved() {
        return salesAchieved;
    }

    public double calculateSalary() {
        return super.calculateSalary() + commission * getSalesAchieved();
    }

    public String getSalesSummary() {
        return getFirstName() + getLastName() + "Sales Target: " + getSalesTarget()
                + "$\n" + "Sales to date: " + getSalesAchieved() + "$";
    }
}

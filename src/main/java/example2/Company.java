package example2;

public class Company {

    private int id;
    private String companyName;
    private String address;
    private int budget;
    private int employeeCount;

    public Company(int id, String companyName, String address, int budget, int employeeCount) {
        this.id = id;
        this.companyName = companyName;
        this.address = address;
        this.budget = budget;
        this.employeeCount = employeeCount;
    }

    public Company(String companyName, String address, int budget, int employeeCount) {
        this.companyName = companyName;
        this.address = address;
        this.budget = budget;
        this.employeeCount = employeeCount;
    }

    public Company() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }

    public int getEmployeeCount() {
        return employeeCount;
    }

    public void setEmployeeCount(int employeeCount) {
        this.employeeCount = employeeCount;
    }

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", companyName='" + companyName + '\'' +
                ", address='" + address + '\'' +
                ", budget=" + budget +
                ", employeeCount=" + employeeCount +
                '}';
    }
}


package streamJava8.example;

public class Employee {
    private String firstName;
    private String lastName;
    private int yearOfService;
    private Employee manger;
    private int numberOfDirectReports;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getYearOfService() {
        return yearOfService;
    }

    public void setYearOfService(int yearOfService) {
        this.yearOfService = yearOfService;
    }

    public Employee getManger() {
        return manger;
    }

    public void setManger(Employee manger) {
        this.manger = manger;
    }

    public int getNumberOfDirectReports() {
        return numberOfDirectReports;
    }

    public void setNumberOfDirectReports(int numberOfDirectReports) {
        this.numberOfDirectReports = numberOfDirectReports;
    }
}

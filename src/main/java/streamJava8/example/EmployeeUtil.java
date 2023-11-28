package streamJava8.example;

import java.util.function.Function;
import java.util.function.Predicate;

public class EmployeeUtil {
    public String getFullName(Employee employee){
        Function<Employee,String> fullName =  e -> e.getFirstName() +" "+e.getLastName();
        return fullName.apply(employee);
    }
    public String getLastManagerLastName(Employee employee){
        Function<Employee,String> managerLastName =  e-> e.getManger()!=null ?employee.getManger().getLastName() : null;
        return managerLastName.apply(employee);
    }
    public boolean hasBeenEmployedLongerThanFiveYears(Employee employee){
        Predicate<Employee> employeeLongerThanFiveYears = e -> e.getYearOfService()>5;
        return employeeLongerThanFiveYears.test(employee);
    }
    public boolean hasMoreThanThreeDirectReports(Employee employee){
        Predicate<Employee> moreThanThreeDirectReports = e -> e.getNumberOfDirectReports() >3;
        return moreThanThreeDirectReports.test(employee);
    }
}

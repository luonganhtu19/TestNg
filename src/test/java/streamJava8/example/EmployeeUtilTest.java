package streamJava8.example;

import org.junit.jupiter.api.Test;

import javax.swing.text.Utilities;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeUtilTest {

    @Test
    void getFullName() {
        Employee employee = new Employee();
        employee.setFirstName("anh");
        employee.setLastName("tu");
        String name = (new EmployeeUtil()).getFullName(employee);
        String expectResult = "anh tu";
        assertEquals(expectResult,name);
    }

    @Test
    void getLastManagerLastName() {
        Employee employee = new Employee();
        Employee employee1 = new Employee();
        employee1.setLastName("vu");
        employee.setManger(employee1);
        String actual = (new EmployeeUtil()).getLastManagerLastName(employee);
        assertEquals(actual,"vu");

    }

    @Test
    void hasBeenEmployedLongerThanFiveYears() {
        Employee employee = new Employee();
        employee.setYearOfService(20);

        Boolean actual = (new EmployeeUtil()).hasBeenEmployedLongerThanFiveYears(employee);

        assertTrue(actual);
    }

    @Test
    void hasMoreThanThreeDirectReports() {
        Employee employee = new Employee();
        employee.setNumberOfDirectReports(10);
        Boolean actual = (new EmployeeUtil()).hasMoreThanThreeDirectReports(employee);
        assertTrue(actual);
    }
}
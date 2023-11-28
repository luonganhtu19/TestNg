package methodRefernce;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class mainTest {

    @Test
    void main() {
        // Arrange: Chuẩn bị dữ liệu đầu vào
        List<Student> students = new ArrayList<>();
        students.add(new Student("Alice", 25));
        students.add(new Student("Bob", 20));
        students.add(new Student("Charlie", 22));

        // Act: Thực hiện hành động cần kiểm thử
        Collections.sort(students, Student::compareByAge);

        // Assert: Kiểm tra kết quả
        List<Integer> sortedAges = students.stream().map(Student::getAge).collect(Collectors.toList());
        List<Integer> expectedAges = List.of(20, 22, 25);
        assertEquals(expectedAges, sortedAges);
    }
}
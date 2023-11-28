package methodRefernce;

import java.util.*;
//import java.util.Collections;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.ReentrantLock;

public class main {
    public static void main(String[] args) {
        Student student = new Student();
        List<Student> students = Arrays.asList(new Student("anhTu",12,"boy",10),
                                                new Student("anhTu1",12,"boy",10));
        Collections.sort(students,Student::compareByAge);
        students.stream().map(Student::getAge).forEach(System.out::println);
        System.out.println("check");

            // Tạo một đối tượng ConcurrentHashMap
            ConcurrentHashMap<String, Integer> concurrentMap = new ConcurrentHashMap<>();

            // Thêm dữ liệu vào ConcurrentHashMap
            concurrentMap.put("A", 1);
            concurrentMap.put("B", 2);
            concurrentMap.put("C", 3);

            // In ra dữ liệu trong ConcurrentHashMap
            System.out.println("ConcurrentHashMap ban đầu: " + concurrentMap);
    }
}

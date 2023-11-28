package testng.Util;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;

public class TestDynamicClass {
    public static void main(String[] args) {
        String className = "GeneratedClass";
        String classCode = generateClassCode(className);

        // Lưu mã nguồn vào một tệp .java
        String fileName = className + ".java";
        saveToFile(fileName, classCode);

        // Biên dịch tệp .java thành tệp .class
        compileClass(fileName);
    }

    private static String generateClassCode(String className) {
        // Tạo mã nguồn cho lớp
        return "public class " + className + " {\n" +
                "    private String name;\n" +
                "    private int age;\n" +
                "}\n";
    }

    private static void saveToFile(String fileName, String code) {
        try (FileWriter fileWriter = new FileWriter(fileName)) {
            fileWriter.write(code);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void compileClass(String fileName) {
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        int compilationResult = compiler.run(null, null, null, fileName);

        if (compilationResult == 0) {
            System.out.println("Compilation is successful.");
            try {
                // Đọc tệp .class thành mảng byte
                byte[] classBytes = Files.readAllBytes(new File("GeneratedClass.class").toPath());

                // Load lớp từ mảng byte
                ClassLoader classLoader = new ClassLoader() {
                    @Override
                    protected Class<?> findClass(String name) throws ClassNotFoundException {
                        return defineClass(name, classBytes, 0, classBytes.length);
                    }
                };

                // Load và sử dụng lớp động
                Class<?> dynamicClass = classLoader.loadClass("GeneratedClass");
                System.out.println("Dynamic class name: " + dynamicClass.getName());

            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Compilation failed.");
        }
    }
}

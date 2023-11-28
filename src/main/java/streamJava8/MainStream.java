package streamJava8;

import java.util.Random;
import java.util.function.IntBinaryOperator;

public class MainStream {
    public static void main(String[] args) {
        Greeting greeting = new HelloGreeting();
        greeting.sayHello();
        Greeting greeting1 = new Greeting() {
            @Override
            public void sayHello() {
                System.out.println("chan vai");
            }
        };
        greeting1.sayHello();
        Greeting greeting2 = () -> System.out.println("check");
        Calculator calculator = (int x, int y) -> {
            return x+y+ (new Random()).nextInt(50);
        };
        IntBinaryOperator calculator1 = (int x, int y) -> {
          return x+y +(new Random().nextInt(50));
        };
        System.out.println("value: "+calculator.calculate(1,2));
        System.out.println("value1: "+calculator1.applyAsInt(1,2));
    }
}

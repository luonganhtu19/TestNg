package stream;

import java.util.Arrays;
import java.util.function.IntPredicate;
import java.util.function.IntUnaryOperator;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CreateStream {
    public static void main(String[] args) {
        // create stream to primitive
        IntStream.range(1,4).forEach(System.out::println);
        IntStream.of(1,2,3).forEach(System.out::println);
        IntStream intStream = IntStream.iterate(0,n-> n+2).limit(6);
        intStream.forEach(System.out::println);
        IntStream fibonacci = generateFibonacci().limit(10);
        IntPredicate hasNext= n -> n<10;
        IntUnaryOperator next = n -> n+2;

        IntStream evenNumbers = IntStream.iterate(0,hasNext,next);

        evenNumbers.forEach(System.out::println);
        fibonacci.forEach(System.out::println);

        IntPredicate isEven = n-> n%2 ==0;
        IntStream num = IntStream.iterate(1,i -> i+1).filter(isEven).takeWhile(i -> i<=10);
        num.forEach(System.out::println);

        // create stream to data structure
        //array
        String[] languages = {"Java", "C", "C++"};

        Stream<String> testStream = Arrays.stream(languages);
//        Stream<String> stream = A
    }
    private static IntStream generateFibonacci(){
        int[] fib = {0,1};
        return IntStream.generate(()->{
            int result = fib[0];
            int next = fib[0]+fib[1];
            fib[0] = fib[1];
            fib[1]= next;
            return result;
        });
    }
}

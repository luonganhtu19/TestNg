package streamJava8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Integer[] scores = new Integer[]{80,66,73,92,43};
        Stream<Integer> scoresStream = Arrays.stream(scores);
        List<String> shoppingList = new ArrayList<>();
        shoppingList.add("c");
        shoppingList.add("a");
        shoppingList.add("v");
        shoppingList.add("e");
        Stream<String> shoppingStream = shoppingList.stream();
        shoppingStream.sorted().forEach(System.out::println);

        Stream<String> test = Stream.of("a1","a2");
    }
}

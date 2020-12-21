package practice;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Test3 {

    private static <E> List<E> reverse(List<E> l){
        return IntStream.range(0, l.size())
                .map(i -> l.size()-1-i)
                .mapToObj(l::get)
                .collect(Collectors.toList());
    }

    private static <E> List<E> sortInDescendingInPlace(List<E> l){
        l.sort(Collections.reverseOrder());
        return l;
    }

    private static <E> List<E> sortInDescending(List<E> l){
        return l.stream().sorted(Collections.reverseOrder()).collect(Collectors.toList());
    }

    public static void main(String... args){
        System.out.println(reverse(Arrays.asList(1,2,3)));
        System.out.println(reverse(Arrays.asList('a','b','c')));
        System.out.println(reverse(Arrays.asList("james","harry","rose")));

        System.out.println(sortInDescendingInPlace(Arrays.asList(1,2,3)));
        System.out.println(sortInDescendingInPlace(Arrays.asList('a','b','c')));
        System.out.println(sortInDescendingInPlace(Arrays.asList("jame","harr","rose")));

        System.out.println(sortInDescending(Arrays.asList(1,2,3)));
        System.out.println(sortInDescending(Arrays.asList('a','b','c')));
        System.out.println(sortInDescending(Arrays.asList("jame","harr","rose")));

    }

}

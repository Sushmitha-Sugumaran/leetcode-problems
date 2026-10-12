package com.streams;
import java.util.*;
import java.util.stream.Stream;

public class StreamsBasic {
    public static void main(String[] args){
        //Arrays to Stream Conversion
       int[] names = {50, 10, 20, 70};
       System.out.println("Arrays to Stream - Sorted Usage");
       Arrays.stream(names).sorted().forEach(name -> System.out.println("Arrays to Stream Conversion : "+ name));
    
        System.out.println("Arrays to Stream - Filter Usage");
        Arrays.stream(names).filter( name -> (name > 10)).forEach(System.out::println);//it print filtered elements

       System.out.println("Arrays to Stream - Distinct Usage");
       Arrays.asList(1,4,4,5,6,8,7,3,4,9,0).stream().distinct().forEach(System.out::println); //it print unique elements

       System.out.println("Arrays to Stream - Limit Usage");
       Arrays.asList(1,4,4,5,6,8,7,3,4,9,0).stream().limit(4).forEach(System.out::println); //it prints first 4 elements

       System.out.println("Arrays to Stream - Skip Usage");
       Arrays.asList(1,4,4,5,6,8,7,3,4,9,0).stream().skip(4).forEach(System.out::println); //it skips first 4 elements and print remaining

       System.out.println("Arrays to Stream - FlatMap Usage");
       int[][] numbers = {{1,2},{3,4},{5,6},{7,8}};
       Stream.of(numbers).flatMapToInt(number -> Arrays.stream(number)).forEach(System.out::println);//it print the overall arrays one by one
//        Note : You need flatMapToInt instead of flatMap
//                because Arrays.stream(int[]) returns an IntStream, not a regular Stream.

    }
}

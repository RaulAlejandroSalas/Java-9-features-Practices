package ml.salastexido.forkjoin;

import java.util.concurrent.ForkJoinPool;
import java.util.stream.Stream;

import ml.salastexido.forkjoin.domain.StringGenerator;


public class ForkJoinTestClass {

    public static void main(String[] args) {

        // new ForkJoinPool();
        // ForkJoinPool pool = ForkJoinPool.commonPool();
        // int value = pool.invoke(new Incrementor(1)); //no paralelism
        // int value2 = new Incrementor(45).compute();
        // System.out.println(value);
        // System.out.println(value2);


    
      
        Stream.generate(StringGenerator::gerateString)
              .filter(s->s.contains("a"))
              .limit(50)
              .forEach(System.out::println);      



    }


}

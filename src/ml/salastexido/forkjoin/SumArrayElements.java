package ml.salastexido.forkjoin;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;
import java.util.stream.IntStream;

import jdk.internal.jline.internal.Log;

public class SumArrayElements extends RecursiveTask<Long> {
 
    private static final long serialVersionUID = 1L;
    private static final int SEQUENTIAL_THRESHOLD = 5000;   
    private  int lower;
    private  int higth;
    private  int[] array; 
    private Long sum;

    public SumArrayElements(int[] array, int l, int h){
        this.array =array;
        this.lower = l;
        this.higth = h;
        this.sum = 0;
    }

    private Long SimpleSum(){
        for (int i = lower; i < higth; i++) {
            sum+=array[i];
        }
        return sum;
    }


    @Override
    protected Long compute() {
        if((higth-lower) <= SEQUENTIAL_THRESHOLD){
            return SimpleSum();
        }else{
            int middle = lower + (higth-lower) /2;
            SumArrayElements leftSume = new SumArrayElements(array, lower, middle);
            SumArrayElements rigthSume = new SumArrayElements(array, middle, higth);
            leftSume.fork(); //dispatch tasks
            Long rightValue= rigthSume.compute();
            Long leftValue = leftSume.join();
            return leftValue + rightValue;
        }
        
    }
    

    public static Long executeSum(){
        return new ForkJoinPool().invoke(new SumArrayElements(IntStream.range(0, 1_000_000).toArray(),0,99_999));
    }
    
}

package ml.salastexido.forkjoin;

import java.util.concurrent.RecursiveTask;

public class Incrementor extends RecursiveTask<Integer>{

    private Integer value;

    Incrementor(final Integer i){
        this.value = i;
    }

    @Override
    protected Integer compute() {
        return this.value+1;
    }
    

    
}

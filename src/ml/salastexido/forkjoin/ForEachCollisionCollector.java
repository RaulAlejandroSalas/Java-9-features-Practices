package ml.salastexido.forkjoin;

import java.util.ArrayList;
import java.util.function.Consumer;

import ml.salastexido.forkjoin.domain.Box;
import ml.salastexido.forkjoin.domain.Collision;

public class ForEachCollisionCollector {
	
	private Consumer<Collision> handler;
	//cache 
	private ArrayList<Box> cache = new ArrayList<>();
	
	public ForEachCollisionCollector(Consumer<Collision> c) {
		this.handler = c;
	}
	
	public void update(Box b) {
		for(Box a: cache) {
			if(Box.areOverlapping(a, b))
				handler.accept(new Collision(a, b));
		}
		cache.add(b);
	}
	
	/*
	 * mezcla las dos cache de otro collector
	 * */
	public void merge(ForEachCollisionCollector other) {
		for(Box a: cache)
			for(Box b: other.cache)
				if(Box.areOverlapping(a, b))
					handler.accept(new Collision(a,b));
		//merge two cache
		cache.addAll(other.cache);
					
	}
	
}

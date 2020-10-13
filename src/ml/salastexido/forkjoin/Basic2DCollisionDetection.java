package ml.salastexido.forkjoin;

import java.util.Collection;
import java.util.function.Consumer;

import ml.salastexido.forkjoin.domain.Box;
import ml.salastexido.forkjoin.domain.Collision;

public class Basic2DCollisionDetection {

	public static void forEachCollisionV1(Collection<Box> cB, Consumer<Collision> collisionHandler) {
		for(Box a: cB)
			for(Box b:cB)
				if(Box.areOverlapping(a, b))
					collisionHandler.accept(new Collision(a, b));
	}
	
	/**
	 * Using parallel Stream
	 * */
	
	public static void forEachCollisionParallel(Collection<Box> c, Consumer<Collision> collisionHandler) {
		c.parallelStream().collect(()-> new ForEachCollisionCollector(collisionHandler),
															ForEachCollisionCollector::update,
															ForEachCollisionCollector::merge);
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}

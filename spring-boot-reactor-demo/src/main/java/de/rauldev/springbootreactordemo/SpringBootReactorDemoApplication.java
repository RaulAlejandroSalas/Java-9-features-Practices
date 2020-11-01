package de.rauldev.springbootreactordemo;

import de.rauldev.springbootreactordemo.models.Comments;
import de.rauldev.springbootreactordemo.models.UserComments;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.CommandLineRunner;

import reactor.core.publisher.Flux;
import de.rauldev.springbootreactordemo.models.User;

import java.time.Duration;
import java.util.*;
import java.util.concurrent.CountDownLatch;
import java.util.function.BiFunction;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import reactor.core.publisher.Mono;

@SpringBootApplication
public class SpringBootReactorDemoApplication  implements CommandLineRunner{

	private static final Logger logger = LoggerFactory.getLogger(SpringBootReactorDemoApplication.class);

	public static <T,U> Flux<U> convertListToFlux(List<T> list){
			return (Flux<U>) Flux.fromIterable(list);
	}


	public static void main(String[] args) {
		SpringApplication.run(SpringBootReactorDemoApplication.class, args);

	}

	public static Mono<List<User>> convertFluxToMonoUser(Flux<User> userFlux){
		return userFlux.collectList();
	}

	public static void exampleFlatMap(){
		List<User> users = Arrays.asList(new User("Raul",29),new User("Diana",10), new User("Verenice",43));

		Flux<User> userFlux = Flux.fromIterable(users)
				                  .flatMap(user->{
									  if (!user.getName().equalsIgnoreCase("Raul")) {
										  String name = user.getName();
										  user.setName(name.toUpperCase());
										  return Mono.just(user);
									  }else{
										  return Mono.empty();
									  }
								  })
				  				  .doOnNext(System.out::println);
		userFlux.subscribe();

	}

	public static void exampleInterval(){
		Flux<Integer> rangeInteger = Flux.range(0,100);
		Flux<Long> intervals = Flux.interval(Duration.ofSeconds(2));
		rangeInteger.zipWith(intervals,(ir,ii)->ii)
				    .doOnNext(System.out::println)
					.blockLast();
	}

	public static void exampleDelayElements(){
		Flux<Integer> rangeInteger = Flux.range(0,100)
										 .delayElements(Duration.ofSeconds(1))
										 .doOnNext(System.out::println);
		rangeInteger.blockLast();


	}
	public static void exampleFluxRange(){
		Flux<Integer> rangeInteger = Flux.range(0,4);

		Flux.just(1, 2, 3, 4,5)
			.map(i->i*i)
			.zipWith(rangeInteger,(a,b)->String.format("First Flow Value : [%d], SecondFlow Value: [%d]",a,b))
			.subscribe(System.out::println);
	}

	public static void exampleInfiniteInterval() throws InterruptedException {
		CountDownLatch latch = new CountDownLatch(1);

		Flux.interval(Duration.ofSeconds(1))
			.doOnTerminate(()->latch.countDown())
			.map(i->"Hola " + i)
			.doOnNext(s->logger.info(s))
			.subscribe();
		latch.await(); //el hilo actual espera a que CountDown sea igual a 0
	}

	public static void exampleIterable(){
		List<User> users = Arrays.asList(new User("Raul",29),new User("Diana",10), new User("Verenice",43));
		Flux<User> userFlux = Flux.fromIterable(users)
								  .doOnNext(System.out::println);
		userFlux.subscribe();
	}

	public static Flux<UserComments> getUserComments(){
		Mono<User> userMono = Mono.fromCallable(()-> new User("Raul",29));
		Mono<Comments> userCommentsMono = Mono.fromCallable(()->{
			Comments comments = new Comments();
			comments.addComment("Hi");
			comments.addComment("How are you");
			comments.addComment("Im fine");
			return comments;
		});
		return userMono.flatMap(user->userCommentsMono.map(comment->new UserComments(user,comment)))
					   .flux();
	}

	public static User getUserInstance(){
		return new User("Raul",29);
	}

	public static Flux<UserComments> getUserCommentsZipWith(){
		Mono<User> userMono2 = Mono.fromCallable(SpringBootReactorDemoApplication::getUserInstance);
		Mono<Comments> userCommentsMono = Mono.fromCallable(()->{
			Comments comments = new Comments();
			comments.addComment("Hi");
			comments.addComment("How are you");
			comments.addComment("Im fine");
			return comments;
		});
		//public final <T2, O> Mono<O> zipWith(Mono<? extends T2> other,
		//			BiFunction<? super T, ? super T2, ? extends O> combinator)
		BiFunction<User,Comments,UserComments> userCommentsBiFunction = UserComments::new;
		return userMono2.zipWith(userCommentsMono,userCommentsBiFunction).flux();
	}

	@Override
	public void run(String ... args) throws InterruptedException {
//		Flux<User> flowString = Flux.just("Raul","Victor","Verenice","Diana")
//									  .map(User::new)
//									  .filter(u->u.getName().startsWith("D"))
//									  .doOnNext(System.out::println);
//		flowString.subscribe();
		//exampleIterable();
		//exampleFlatMap();
//		List<User> users = Arrays.asList(new User("Raul",29),new User("Diana",10), new User("Verenice",43));
//
//		Mono<List<User>> listMono = convertFluxToMonoUser(Flux.fromIterable(users));
//		listMono.subscribe(lisOfUsers->{ lisOfUsers.forEach(System.out::println); });
//		Flux<UserComments> userCommentsFlux = getUserCommentsZipWith();
//		userCommentsFlux.doOnNext(System.out::println).subscribe();
		//exampleFluxRange();
		//exampleInterval();
		//exampleDelayElements();
		exampleInfiniteInterval();
	}



}

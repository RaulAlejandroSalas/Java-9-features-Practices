package de.rauldev.springbootreactordemo;

import de.rauldev.springbootreactordemo.models.Comments;
import de.rauldev.springbootreactordemo.models.UserComments;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.CommandLineRunner;

import reactor.core.publisher.Flux;
import de.rauldev.springbootreactordemo.models.User;
import java.util.*;

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

	@Override
	public void run(String ... args){
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
		Flux<UserComments> userCommentsFlux = getUserComments();
		userCommentsFlux.doOnNext(System.out::println).subscribe();

	}



}

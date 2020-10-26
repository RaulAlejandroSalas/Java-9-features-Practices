package de.rauldev.springbootreactordemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.CommandLineRunner;

import reactor.core.publisher.Flux;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootReactorDemoApplication  implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(SpringBootReactorDemoApplication.class, args);
	}

	@Override
	public void run(String ... args){
		Flux<String> flowString = Flux.just("Raul","Victor","Verenice","Diana")
									  .doOnNext(System.out::println);
		flowString.subscribe();
	}



}

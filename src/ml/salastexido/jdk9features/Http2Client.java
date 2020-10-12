package ml.salastexido.jdk9features;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public class Http2Client {

	public static void main(String[] args)  {
		//JDK 8
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder().uri(URI.create("https://google.com/")).build();
		   
		client.sendAsync(request, BodyHandlers.ofString())
		         .thenApply(HttpResponse::body)
		         .thenAccept(System.out::println);
	}
}

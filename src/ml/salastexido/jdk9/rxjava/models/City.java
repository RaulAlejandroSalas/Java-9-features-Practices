package ml.salastexido.jdk9.rxjava.models;

import java.util.List;

public class City {
	private String name;
	private List<PostCode> postCodes;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<PostCode> getPostCodes() {
		return postCodes;
	}
	public void setPostCodes(List<PostCode> postCodes) {
		this.postCodes = postCodes;
	}
}

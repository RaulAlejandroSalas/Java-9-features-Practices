package de.rauldev.springbootreactordemo.models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Comments {
    List<String> comments;

    public Comments(){
        this.comments = new ArrayList<>();
    }

    public void addComment(String comment){
        this.comments.add(comment);
    }

    public void addComments(String ... comments){
        this.comments.addAll(Arrays.asList(comments));
    }

    public List<String> getComments() {
        return comments;
    }

    @Override
    public String toString() {
        return "Comments{" +
                "comments=" + comments +
                '}';
    }
}

package dev.scarlet.movies;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.List;

@Document(collection= "movies")
@Data //annotation comes from lombok project and takes care of all Setters, getters and to string methods
@AllArgsConstructor //annotation to create constructor that takes all the private fields as arguments
@NoArgsConstructor //to create constructor with no args
public class Movie {
    @Id
    private ObjectId id;
    private String imdbId;
    private String title;
    private String releaseDate;
    private String trailerLink;
    private String poster;
    private List<String> genres;
    private List<String> backdrops;
    @DocumentReference //This will allow database to store only reviews and reviews will be in separate collection
    private List<Review> reviewIds; //embedded relationship. All reviews related to this movie will be added to it.


}

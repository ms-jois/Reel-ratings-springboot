package dev.scarlet.movies;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService { //inside this we will write database access methods

    @Autowired // tells framework to instantiate this class for us
    private MovieRepository movieRepository;
    public List<Movie> allMovies(){
        return movieRepository.findAll();
    }

//    public Optional<Movie> singleMovie(ObjectId id){ //Optional returns null when no id is found
//        return  movieRepository.findById(id);
//    }
    public Optional<Movie> singleMovie(String imdbId){ //Optional returns null when no id is found
        return  movieRepository.findMovieByImdbId(imdbId);
    }
}

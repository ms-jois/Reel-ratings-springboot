package dev.scarlet.movies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {

    @Autowired
    private ReviewRespository reviewRespository;
    @Autowired
    private MongoTemplate mongoTemplate; // use template to create query and connect to db instead of using repository
    public  Review createReview(String reviewBody, String imdbId){
        Review review = reviewRespository.insert(new Review(reviewBody));

        mongoTemplate.update(Movie.class).matching(Criteria.where("imdbId").is(imdbId))
                .apply(new Update().push("reviewIds").value(review)).first();

        return review;
    }
}

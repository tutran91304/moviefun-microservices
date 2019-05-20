package org.superbiz.moviefun.moviesapi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestOperations;

import java.util.*;

public class MoviesClient {
    String moviesUrl;
    RestOperations restOperations;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public MoviesClient(String moviesUrl, RestOperations restOperations) {
        this.moviesUrl = moviesUrl;
        this.restOperations = restOperations;
    }

    public MovieInfo find(Long id) {
        Map<String, String> requestParams = new HashMap<>();
        requestParams.put("field","id");
        requestParams.put("key", ""+id);
        List<MovieInfo> result = this.restOperations.getForObject(this.moviesUrl , List.class, requestParams);
        return result.get(0);
    }

    public void addMovie(MovieInfo movie) {
        logger.debug("Creating movie with title {}, and year {}", movie.getTitle(), movie.getYear());
        this.restOperations.postForEntity(this.moviesUrl, movie, MovieInfo.class);
    }

    public void updateMovie(MovieInfo movie) {
        logger.debug("Updating movie with title {}, and year {}", movie.getTitle(), movie.getYear());
        this.restOperations.put(this.moviesUrl, movie, MovieInfo.class);
    }


    public void deleteMovieId(long id) {
        logger.debug("Delete movie with id", id);
        this.restOperations.delete(moviesUrl + "/" + id);
    }

    public List<MovieInfo> getMovies() {
        Map<String, String> requestParams = new HashMap<>();
        List<MovieInfo> result = this.restOperations.getForObject(this.moviesUrl , List.class, requestParams);
        return result;
    }

    public List<MovieInfo> findAll(int firstResult, int maxResults) {
        List<MovieInfo> result = this.restOperations.getForObject(this.moviesUrl, List.class);
        return result;
    }

    public int countAll() {
        ResponseEntity<Integer> countEntity = this.restOperations.getForEntity(moviesUrl + "/count",  Integer.class);
        return countEntity.getBody();
    }

    public int count(String field, String searchTerm) {
        ResponseEntity<Integer> countEntity = this.restOperations.getForEntity(moviesUrl + "/count?" + field + "="
                + searchTerm,  Integer.class);
        return countEntity.getBody();
    }

    public List<MovieInfo> findRange(String field, String searchTerm, int firstResult, int maxResults) {


        Map<String, String> requestParams = new HashMap<>();
        requestParams.put("field",field);
        requestParams.put("key",searchTerm);
        requestParams.put("start",""+firstResult);
        requestParams.put("pageSize", ""+maxResults);

        List<MovieInfo> result = this.restOperations.getForObject(this.moviesUrl , List.class, requestParams);
        return result;
    }

    public void clean() {

    }
}

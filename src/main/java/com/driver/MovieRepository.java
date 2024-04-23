package com.driver;

import java.util.*;

import org.springframework.stereotype.Repository;

@Repository
public class MovieRepository {

    private HashMap<String, Movie> movieMap;
    private HashMap<String, Director> directorMap;
    private HashMap<String, List<String>> directorMovieMapping;

    public MovieRepository(){
        this.movieMap = new HashMap<String, Movie>();
        this.directorMap = new HashMap<String, Director>();
        this.directorMovieMapping = new HashMap<String, List<String>>();
    }

    public void saveMovie(Movie movie){
        // your code here
        String name=movie.getName();
        movieMap.put(name,movie);
    }

    public void saveDirector(Director director){
        // your code here
        String name=director.getName();
        directorMap.put(name,director);
    }

    public void saveMovieDirectorPair(String movie, String director){
        if(movieMap.containsKey(movie) && directorMap.containsKey(director)){
            // your code here
            List<String> movies = directorMovieMapping.getOrDefault(director, new ArrayList<>());
            movies.add(movie);

            directorMovieMapping.put(director,movies);
        }
    }

    public Movie findMovie(String movie){

//        for(Movie movieObj:movieMap.values()){
//            if(movieObj.getName().equals(movie)){
//                return movieObj;
//            }
//        }
//        return null;
        return movieMap.get(movie);
    }

    public Director findDirector(String director){
        return directorMap.get(director);
    }

    public List<String> findMoviesFromDirector(String director){
        return directorMovieMapping.getOrDefault(director, new ArrayList<>());

    }

    public List<String> findAllMovies(){
        return new ArrayList<>(movieMap.keySet());
    }

    public void deleteDirector(String director){
//        // your code here
//        for(Director dir:directorMap.keys()){
//            if(dir.getName().equals(director)){
//                map.remove(dir);
//            }
//        }
         directorMap.remove(director);
         directorMovieMapping.remove(director);
    }

    public void deleteAllDirector(){
        // your code here
        directorMap.clear();
        directorMovieMapping.clear();
    }
}
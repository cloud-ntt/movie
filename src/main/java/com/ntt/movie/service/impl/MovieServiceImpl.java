package com.ntt.movie.service.impl;

import com.ntt.movie.entity.Movie;
import com.ntt.movie.repository.MovieRepository;
import com.ntt.movie.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class MovieServiceImpl implements MovieService {

    @Value("${server.port}")
    private int port;

    @Autowired
    private MovieRepository movieRepository;
    @Override
    public List<Movie> listarTodos() {
        return movieRepository.findAll();
    }

    @Override
    public Movie crearMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    @Override
    public Movie buscarPorId(Long id) {
        Optional<Movie> movie = movieRepository.findById(id);

        if(movie.isPresent()){
            movie.get().setPort(port);
            return movie.get();
        }

        return null;

        //return movieRepository.findById(id).orElse(null);
    }

    @Override
    public List<Movie> buscarMoviesPorName(String name) {
        return movieRepository.findByNameContaining(name);
    }

    @Override
    public Movie actualizarMovie(Long id, Movie movie) {
        Movie moviebd = movieRepository.findById(id)
                .orElseThrow(()->new RuntimeException("No existe movie en la BD"));

        moviebd.setName(movie.getName());
        moviebd.setDescription(movie.getDescription());
        moviebd.setPremiereDate(new Date());

        return movieRepository.save(moviebd);
    }
}

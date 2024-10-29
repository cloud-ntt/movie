package com.ntt.movie.service;

import com.ntt.movie.entity.Movie;

import java.util.List;
import java.util.Optional;

public interface MovieService {
    List<Movie> listarTodos();

    Movie crearMovie(Movie movie);

    Movie buscarPorId(Long id);

    List<Movie> buscarMoviesPorName(String name);

    Movie actualizarMovie(Long id, Movie movie);
}

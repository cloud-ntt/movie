package com.ntt.movie.service;

import com.ntt.movie.entity.Movie;
import com.ntt.movie.entity.Review;

import java.util.List;

public interface ReviewService {
    List<Review> listarTodos();

    Review crear(Review review);

}

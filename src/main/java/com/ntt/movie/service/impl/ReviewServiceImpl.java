package com.ntt.movie.service.impl;

import com.ntt.movie.entity.Movie;
import com.ntt.movie.entity.Review;
import com.ntt.movie.repository.ReviewRepository;
import com.ntt.movie.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {
    @Autowired
    private ReviewRepository reviewRepository;
    @Override
    public List<Review> listarTodos() {
        return reviewRepository.findAll();
    }

    @Override
    public Review crear(Review review) {
        return reviewRepository.save(review);
    }
}

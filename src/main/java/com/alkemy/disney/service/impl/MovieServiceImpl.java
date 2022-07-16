package com.alkemy.disney.service.impl;

import com.alkemy.disney.dto.MovieDTO;
import com.alkemy.disney.entity.MovieEntity;
import com.alkemy.disney.mapper.MovieMapper;
import com.alkemy.disney.repository.MovieRepository;
import com.alkemy.disney.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieMapper movieMapper;

    @Autowired
    private MovieRepository movieRepository;

    public MovieDTO save(MovieDTO dto) {
        MovieEntity entity = movieMapper.movieDTO2Entity(dto);
        MovieEntity entitySaved = movieRepository.save(entity);
        return movieMapper.movieEntity2DTO(entitySaved);
    }

    public void delete(long id) {
        movieRepository.deleteById(id);
    }

}

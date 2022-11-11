package data.service;

import data.repository.movie.TheaterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TheaterService {

    @Autowired
    TheaterRepository theaterMapper;
}

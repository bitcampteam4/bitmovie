package data.service;

import data.repository.movie.ScreenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScreenService {

    @Autowired
    ScreenRepository screenRepository;
}

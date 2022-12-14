package data.controller.movie;

import data.domain.movie.ScreenTime;
import data.service.movie.ScreenTimeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;

@RestController
@CrossOrigin
@RequestMapping("/screentime")
@RequiredArgsConstructor
@Slf4j
public class ScreenTimeController {

    private final ScreenTimeService screenTimeService;

    @GetMapping("/test")
    public ResponseEntity<ScreenTime> screenTimeByMovie(@RequestParam int movie){

        ScreenTime screenTime=screenTimeService.selectScrTimeByMovie(movie);

        return new ResponseEntity<>(screenTime,HttpStatus.OK);
    }

    /* 예매 - 상영시간  */
    @GetMapping("/screen_times")
    public ResponseEntity screenTimes(@RequestParam int movie,
                                         @RequestParam int theater,
                                         @RequestParam Date date){

        ScreenTime screenTime = ScreenTime.builder()
                                    .movie_pk(movie)
                                    .theater_pk(theater)
                                    .scrt_date(date)
                                    .build();

        return ResponseEntity.ok(screenTimeService.selectScrtForBook(screenTime));
    }
}

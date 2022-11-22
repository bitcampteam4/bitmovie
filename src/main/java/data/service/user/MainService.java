package data.service.user;

import data.domain.movie.*;
import data.repository.movie.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class MainService {

    private final JoinRevwRepository joinRevwRepository;
    private final JoinMovieRepository joinMovieRepository;
    private final PersonRepository personRepository;
    private final JoinCastRepository joinCastRepository;
    private final JoinTimeRepositroy joinTimeRepositroy;

    // 가장 최신 등록된 평점을 'count'갯수 만큼 반환
    public List<JoinRevw> selectRecentRevw(int count) {
        return joinRevwRepository.selectRecentRevw(count);
    }

    public Map<String,Object> selectSearchData(String search) {
        System.out.println("search"+search);
        Map<String, Object> map = new HashMap<>();
        // 영화 정보 출력
        List<JoinMovie> movie_list = joinMovieRepository.selectSearchMovie(search);
        // 인물 정보 출력
        List<Person> people_list = personRepository.selectSearchList(search);
        // 출력되는 첫번째 인물의 상세 정보 출력
        if(people_list.size()!=0){
            int person_pk = people_list.get(0).getPerson_pk();
            List<JoinCast> person_detail = joinCastRepository.selectCastDetail(person_pk);
            map.put("person_detail", person_detail);
        }
        // controller 로 데이터 전달
        map.put("people_list", people_list);
        map.put("movie_list", movie_list);
        return map;
    }

    public List<JoinTime> selectTimeByClick(int movie_pk, int theater_pk, String date){
        Map<String, Object> map = new HashMap<>();
        map.put("movie_pk", movie_pk);
        map.put("date", date);
        map.put("theater_pk", theater_pk);
        return joinTimeRepositroy.selectTimeByClick(map);
    }

    public List<JoinTime> testMovieTime(int movie_pk, int theater_pk, String date) {
        Map<String, Object> map = new HashMap<>();
        map.put("movie_pk", movie_pk);
        map.put("date", date);
        map.put("theater_pk", theater_pk);
        return joinTimeRepositroy.testMovieTime(map);
    }
}
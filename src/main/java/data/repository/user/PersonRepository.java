package data.repository.user;

import data.domain.movie.Person;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PersonRepository {

    Person selectPersonData(int num);
}

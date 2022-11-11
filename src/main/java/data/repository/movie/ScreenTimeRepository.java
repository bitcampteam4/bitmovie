package data.repository.movie;

import data.domain.movie.ScreenTime;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ScreenTimeRepository {
    public ScreenTime selectScrTimeByTheater(int theater_pk);
    public ScreenTime selectScrTimeByScreen(int theater_pk);
    public ScreenTime selectScrTimeByMovie(int theater_pk);
    public void updateScrTimeByPk(ScreenTime screenTime);
    public void deleteScrTime(int scrtime_pk);
}

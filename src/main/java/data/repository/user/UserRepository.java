package data.repository.user;

import data.domain.user.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

@Mapper
public interface UserRepository {
    public int selectLogin (Map<String, String> map); //로그인
    public String selectName (String u_id); //로그인 시 이름 가져오기
    public int searchId (String u_id); //회원가입 아이디 중복 체크
    public void insertUser (User user); //회원가입
}

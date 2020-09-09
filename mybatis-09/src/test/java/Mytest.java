import com.kuang.dao.UserMapper;
import com.kuang.pojo.User;
import com.kuang.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class Mytest {

    @Test
    public void queryUserById(){
        SqlSession sqlSession = MybatisUtils.getSqlsession();

        SqlSession sqlSession2 = MybatisUtils.getSqlsession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.queryUserById(1);
        System.out.println(user);
        sqlSession.close();

        UserMapper mapper2 = sqlSession2.getMapper(UserMapper.class);
        User user2 = mapper2.queryUserById(1);
        System.out.println(user2);
        sqlSession2.close();


        System.out.println(user == user2);
    }
}

import com.kuang.dao.UserMapper;
import com.kuang.pojo.User;
import com.kuang.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class UserMapperTest {

    @Test
    public void test(){
        SqlSession sqlSession = MybatisUtils.getSqlsession();

        //底层只要使用反射
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = mapper.getUsers();

        for (User user : userList) {
            System.out.println(user);

        }

        sqlSession.close();

    }

    @Test
    public void getUserById(){
        SqlSession sqlSession = MybatisUtils.getSqlsession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

       User userById = mapper.getUserById(1);
       System.out.println(userById);

        sqlSession.close();
    }

    @Test
    public void  addUser(){
        SqlSession sqlSession = MybatisUtils.getSqlsession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        mapper.addUser(new User(6, "Hello", "999999"));

        sqlSession.close();
    }

    @Test
    public void updateUser(){
        SqlSession sqlSession = MybatisUtils.getSqlsession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        mapper.updateUser(new User(5, "True", "666666"));

        sqlSession.close();
    }

    @Test
    public void deleteUser(){
        SqlSession sqlSession = MybatisUtils.getSqlsession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        mapper.deleteUser(5);

        sqlSession.close();

    }
}

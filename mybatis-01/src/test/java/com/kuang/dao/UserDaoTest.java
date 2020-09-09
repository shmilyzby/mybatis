package com.kuang.dao;

import com.kuang.pojo.User;
import com.kuang.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class UserDaoTest {
    @Test
    public void getUserLike(){
        SqlSession sqlSession = MybatisUtils.getSqlsession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        List<User> userList = mapper.getUserLike("%li%");

        for (User user : userList) {
            System.out.println(user);
        }

        sqlSession.close();

    }

    @Test
    public void test(){
        //获得sqlSession对象
        SqlSession sqlSession = null;
        //执行sql

        try {
            sqlSession = MybatisUtils.getSqlsession();

            //方式一 getMapper
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            List<User> userList = mapper.getUserList();

            //方式二
            //List<User> userList = sqlSession.selectList("com.kuang.dao.UserDao.getUserList");

            for (User user : userList) {
                System.out.println(user);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //关闭sqlSession
            sqlSession.close();
        }
    }

    @Test
    public void getUserById(){
        SqlSession sqlSession = MybatisUtils.getSqlsession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        User user = mapper.getUserById(1);
        System.out.println(user);

        sqlSession.close();

    }


    //增删改需要提交事务
    @Test
    public void addUser(){

        SqlSession sqlSession = MybatisUtils.getSqlsession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        mapper.addUser(new User(4, "marry", "123334"));

        //提交事务
        sqlSession.commit();

        sqlSession.close();
    }

    @Test
    public void updateUser(){
        SqlSession sqlSession = MybatisUtils.getSqlsession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        mapper.updateUser(new User(4,"呵呵","23454"));

        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void deleteUser(){
        SqlSession sqlSession = MybatisUtils.getSqlsession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        mapper.deleteUser(4);

        sqlSession.commit();
        sqlSession.close();
    }
}

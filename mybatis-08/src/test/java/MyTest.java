import com.kuang.dao.BlogMapper;
import com.kuang.pojo.Blog;
import com.kuang.utils.IDutils;
import com.kuang.utils.MybatisUtils;
import org.apache.ibatis.cache.Cache;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.sql.Array;
import java.util.*;

public class MyTest {

    @Test
    public void addBlogTest() {
        SqlSession sqlSession = MybatisUtils.getSqlsession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        Blog blog = new Blog();
        blog.setId(IDutils.getId());
        blog.setTitle("Mybatis");
        blog.setAuthor("狂神说");
        blog.setCreateTime(new Date());
        blog.setViews(9999);

        mapper.addBlog(blog);

        blog.setId(IDutils.getId());
        blog.setTitle("Java");
        mapper.addBlog(blog);

        blog.setId(IDutils.getId());
        blog.setTitle("Spring");
        mapper.addBlog(blog);

        blog.setId(IDutils.getId());
        blog.setTitle("微服务");
        mapper.addBlog(blog);

        sqlSession.close();
    }

    @Test
    public void queryBlogChose(){
        SqlSession sqlSession = MybatisUtils.getSqlsession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);

        HashMap map = new HashMap();

        map.put("title","Spring");
        map.put("author","狂神说");


        List<Blog> blogs = mapper.queryBlogIF(map);

        for (Blog blog : blogs) {
            System.out.println(blog);
        }

        sqlSession.close();
    }

    @Test
    public void queryBlogIF(){
        SqlSession sqlSession = MybatisUtils.getSqlsession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);

        HashMap map = new HashMap();

        map.put("title","Spring");
        map.put("author","狂神说");

        map.put("views","9999");


        List<Blog> blogs = mapper.queryBlogChose(map);

        for (Blog blog : blogs) {
            System.out.println(blog);
        }

        sqlSession.close();
    }

    @Test
    public void updateBlog(){
        SqlSession sqlSession = MybatisUtils.getSqlsession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);

        HashMap map = new HashMap();

//        map.put("title","Spring111");
        map.put("author","狂神说");
//        map.put("id","6f2f867fe4cf4ae4868dc43c90c0c93d");

//        map.put("views","9999");

        mapper.queryBlogIF(map);

        sqlSession.close();
    }

    @Test
    public void queryBlogForeach(){
        SqlSession sqlSession = MybatisUtils.getSqlsession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);

        HashMap map = new HashMap();

        List<Integer> ids = new ArrayList<Integer>();

        ids.add(1);
        ids.add(2);


        System.out.println(ids);

        map.put("ids",ids);

        List<Blog> blogList = mapper.queryBlogForeach(map);

        for (Blog blog : blogList) {
            System.out.println(blog);
        }

        sqlSession.close();
    }
}

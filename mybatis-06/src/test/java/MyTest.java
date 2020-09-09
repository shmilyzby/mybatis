import com.kuang.dao.StudentMapper;
import com.kuang.dao.TeacherMapper;
import com.kuang.pojo.Student;
import com.kuang.pojo.Teacher;
import com.kuang.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class MyTest {


    public static void main(String[] args) {

        SqlSession sqlSession = MybatisUtils.getSqlsession();
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);

        Teacher teacher = mapper.getTeacher(1);

        System.out.println(teacher);

        sqlSession.close();
    }

    @Test
    public void testStudent(){
        SqlSession sqlSession = MybatisUtils.getSqlsession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> studentList = mapper.getStudent();

        for (Student student  : studentList) {
            System.out.println(student);
        }

        sqlSession.close();

    }

    @Test
    public void testStudent2(){
        SqlSession sqlSession = MybatisUtils.getSqlsession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> studentList = mapper.getStudent2();

        for (Student student  : studentList) {
            System.out.println(student);
        }


        sqlSession.close();

    }
}

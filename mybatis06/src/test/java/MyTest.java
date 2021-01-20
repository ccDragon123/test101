import com.ccl.dao.UserMapper;
import com.ccl.pojo.User;
import com.ccl.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import javax.naming.Name;
import java.util.HashMap;
import java.util.List;

public class MyTest {
    @Test
    public void  test(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        SqlSession sqlSession2 = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        UserMapper mapper2 = sqlSession2.getMapper(UserMapper.class);

        List<User> users = mapper.queryUserId(1);

//        HashMap map = new HashMap();
//
//        map.put("name","ccl");
//        map.put("pwd","ccl123");
//        map.put("id",2);
//        mapper.updateUser(map);
//
//        sqlSession.clearCache();


        System.out.println(users);
        sqlSession.close();

        System.out.println("=================");
        List<User> users2 = mapper2.queryUserId(1);
        System.out.println(users2);

        sqlSession2.close();
    }
}

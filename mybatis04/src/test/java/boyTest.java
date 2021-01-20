import com.ccl.dao.BoysMapper;
import com.ccl.pojo.Boys;
import com.ccl.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class boyTest {
    public static void main(String[] args) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BoysMapper mapper = sqlSession.getMapper(BoysMapper.class);

        Boys boy = mapper.getBoyId(2);
        System.out.println(boy);

        sqlSession.close();
    }
    @Test
    public void getBoysTest(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BoysMapper mapper = sqlSession.getMapper(BoysMapper.class);

        Boys boys = mapper.getBoys(2);

        System.out.println(boys);

        sqlSession.close();
    }
}

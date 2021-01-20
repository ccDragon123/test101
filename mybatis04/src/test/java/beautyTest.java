import com.ccl.dao.BeautyMapper;
import com.ccl.pojo.Beauty;
import com.ccl.pojo.Boys;
import com.ccl.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class beautyTest {
    public static void main(String[] args) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        BeautyMapper mapper = sqlSession.getMapper(BeautyMapper.class);

        Boys beauty = mapper.getBeautyId(2);

        System.out.println(beauty);
        sqlSession.close();
    }

    @Test
    public void test1(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        BeautyMapper mapper = sqlSession.getMapper(BeautyMapper.class);

        List<Beauty> beauty = mapper.getBeauty();

        for (Beauty beauty1 : beauty) {
            System.out.println(beauty1);
        }

        sqlSession.close();

    }
}

import com.ccl.dao.BlogMapper;
import com.ccl.pojo.Blog;
import com.ccl.utils.IDUtil;
import com.ccl.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.sql.SQLOutput;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class myTest {

    @Test
    public void test(){
        SqlSession session = MybatisUtils.getSqlSession();
        BlogMapper mapper = session.getMapper(BlogMapper.class);

        Blog blog = new Blog();
        blog.setId(IDUtil.gteId());
        blog.setTitle("Mybatis如此简单");
        blog.setAuthor("狂神说");
        blog.setCreateTime(new Date());
        blog.setViews(9999);

        mapper.addBlog(blog);

        blog.setId(IDUtil.gteId());
        blog.setTitle("Java如此简单");
        mapper.addBlog(blog);

        blog.setId(IDUtil.gteId());
        blog.setTitle("Spring如此简单");
        mapper.addBlog(blog);

        blog.setId(IDUtil.gteId());
        blog.setTitle("微服务如此简单");
        mapper.addBlog(blog);

        session.close();
    }

    @Test
    public void queryBlogIF(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);

        HashMap map = new HashMap();

        //map.put("title","Java如此简单");
        //map.put("author","狂神说");
        map.put("views",700);

        //List<Blog> blogs = mapper.queryBlogIF(map);
        List<Blog> blogs1 = mapper.queryBlogChoose(map);

//        for (Blog blog : blogs) {
//            System.out.println(blog);
//        }

        for (Blog blogs11 : blogs1) {
            System.out.println(blogs11);
        }

        sqlSession.close();
    }

    @Test
    public void test1(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);

        HashMap map = new HashMap();

        //map.put("title","Java如此简单");
        //map.put("author","狂神说");
        map.put("views",676);
        map.put("id","49bf81443993448ebe5a46fd66a7fb45");

        mapper.updateBlog(map);

        sqlSession.close();
    }

}

package com.xhs.www.mybatis;

import com.xhs.www.mapper.UserMapper;
import com.xhs.www.model.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.ArrayList;

/**
 * @author xuhan  build  2018/8/30
 */
public class MybatisDemo {



    public static SqlSessionFactory getSqlSessionFactory(){
        return Holder.getSqlSessionFactory();

    }

    private static class Holder{
        private static SqlSessionFactory sqlSessionFactory= null;
        static{
            try {
                String resource = "mybatis/mybatis-config.xml";
                InputStream inputStream = Resources.getResourceAsStream(resource);
                sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        public static SqlSessionFactory getSqlSessionFactory(){
            return sqlSessionFactory;
        }

    }

    public static void main(String[] args) {
        System.out.println(MybatisDemo.getSqlSessionFactory());
        System.out.println(MybatisDemo.getSqlSessionFactory());
        SqlSession sqlSession = MybatisDemo.getSqlSessionFactory().openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        ArrayList<User> users =  userMapper.getAllUser();
        System.out.println(users);
        ArrayList<User> users2 =  userMapper.getAllUser();
        System.out.println(users2);
//        for(User u:users){
//            System.out.println(u.getName()+u.getNickName()+u.getAge());
//        }
//        User u = userMapper.selectByPrimaryKey(10);
//        System.out.println(u);
//        User uu = new User();
//        uu.setName("2222");
//        uu.setNickName("123123");
//        uu.setAge(27);
//        System.out.println(userMapper.insert(uu));
        sqlSession.commit();
        sqlSession.close();
    }
}

package cn.rusth.dao;

import cn.rusth.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by rusth on 2017/7/13.
 */
@Mapper
@Repository
public interface UserDao {

    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKey(User record);

    User login(@Param("username") String username, @Param("password") String password);
}

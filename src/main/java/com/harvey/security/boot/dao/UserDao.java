package com.harvey.security.boot.dao;

import com.harvey.security.boot.pojo.entity.PermissionDto;
import com.harvey.security.boot.pojo.entity.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

/**
 * TODO
 *
 * @author <a href="mailto:harvey.blocks@outlook.com">Harvey Blocks</a>
 * @version 1.0
 * @date 2023-12-18 20:41
 */
@Repository
public class UserDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;// 好用的模板工具类


    /**根据用户的id查找用户的权限
     *
     * @param userId 用户的ID
     * @return 权限列表
     */
    public List<String> findPermissionsByUserId(String userId){
        String sql =
                "select *\n" +
                "from t_permission\n" +
                "where id in (select permission_id\n" +
                "from t_role_permission\n" +
                "where role_id in (select role_id\n" +
                "from t_user_role\n" +
                "where user_id = ?));";

        List<PermissionDto> query = jdbcTemplate
                .query(sql, new Object[]{userId},
                        new BeanPropertyRowMapper<>(PermissionDto.class));

        if(query==null){
            return null;
        }
        return query.stream()
                .map(PermissionDto::getCode).collect(Collectors.toList());
    }


    public UserDTO getUserByUsername(String username) {
        String sql = "select id, " +
                "       username, " +
                "       password, " +
                "       fullname, " +
                "       mobile " +
                "from t_user " +
                "where username = ? ";
        // 连接数据库
        List<UserDTO> users = jdbcTemplate.query(sql, new Object[]{username},
                new BeanPropertyRowMapper<>(UserDTO.class));
        if (users != null && users.size() == 1) {
            return users.get(0);
        }
        return null;
    }
}

package com.ruoyi.utrain.service;

import java.util.List;
import com.ruoyi.utrain.domain.User;

/**
 * userService接口
 * 
 * @author sx
 * @date 2022-04-06
 */
public interface IUserService 
{
    /**
     * 查询user
     * 
     * @param id user主键
     * @return user
     */
    public User selectUserById(Long id);

    /**
     * 查询user列表
     * 
     * @param user user
     * @return user集合
     */
    public List<User> selectUserList(User user);

    /**
     * 新增user
     * 
     * @param user user
     * @return 结果
     */
    public int insertUser(User user);

    /**
     * 修改user
     * 
     * @param user user
     * @return 结果
     */
    public int updateUser(User user);

    /**
     * 批量删除user
     * 
     * @param ids 需要删除的user主键集合
     * @return 结果
     */
    public int deleteUserByIds(Long[] ids);

    /**
     * 删除user信息
     * 
     * @param id user主键
     * @return 结果
     */
    public int deleteUserById(Long id);
}

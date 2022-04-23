package com.ruoyi.utrain.service;

import java.util.List;
import com.ruoyi.utrain.domain.Ap;

/**
 * apService接口
 * 
 * @author sx
 * @date 2022-04-06
 */
public interface IApService 
{
    /**
     * 查询ap
     * 
     * @param id ap主键
     * @return ap
     */
    public Ap selectApById(String id);

    /**
     * 查询ap列表
     * 
     * @param ap ap
     * @return ap集合
     */
    public List<Ap> selectApList(Ap ap);

    /**
     * 新增ap
     * 
     * @param ap ap
     * @return 结果
     */
    public int insertAp(Ap ap);

    /**
     * 修改ap
     * 
     * @param ap ap
     * @return 结果
     */
    public int updateAp(Ap ap);

    /**
     * 批量删除ap
     * 
     * @param ids 需要删除的ap主键集合
     * @return 结果
     */
    public int deleteApByIds(String[] ids);

    /**
     * 删除ap信息
     * 
     * @param id ap主键
     * @return 结果
     */
    public int deleteApById(String id);
}

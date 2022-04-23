package com.ruoyi.utrain.service;

import java.util.List;
import com.ruoyi.utrain.domain.Advise;

/**
 * adviseService接口
 * 
 * @author sx
 * @date 2022-04-06
 */
public interface IAdviseService 
{
    /**
     * 查询advise
     * 
     * @param id advise主键
     * @return advise
     */
    public Advise selectAdviseById(Long id);

    /**
     * 查询advise列表
     * 
     * @param advise advise
     * @return advise集合
     */
    public List<Advise> selectAdviseList(Advise advise);

    /**
     * 新增advise
     * 
     * @param advise advise
     * @return 结果
     */
    public int insertAdvise(Advise advise);

    /**
     * 修改advise
     * 
     * @param advise advise
     * @return 结果
     */
    public int updateAdvise(Advise advise);

    /**
     * 批量删除advise
     * 
     * @param ids 需要删除的advise主键集合
     * @return 结果
     */
    public int deleteAdviseByIds(Long[] ids);

    /**
     * 删除advise信息
     * 
     * @param id advise主键
     * @return 结果
     */
    public int deleteAdviseById(Long id);
}

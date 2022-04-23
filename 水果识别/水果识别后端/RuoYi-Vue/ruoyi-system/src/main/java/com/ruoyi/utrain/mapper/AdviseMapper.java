package com.ruoyi.utrain.mapper;

import java.util.List;
import com.ruoyi.utrain.domain.Advise;

/**
 * adviseMapper接口
 * 
 * @author sx
 * @date 2022-04-06
 */
public interface AdviseMapper 
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
     * 删除advise
     * 
     * @param id advise主键
     * @return 结果
     */
    public int deleteAdviseById(Long id);

    /**
     * 批量删除advise
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteAdviseByIds(Long[] ids);
}

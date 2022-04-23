package com.ruoyi.utrain.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.utrain.mapper.AdviseMapper;
import com.ruoyi.utrain.domain.Advise;
import com.ruoyi.utrain.service.IAdviseService;

/**
 * adviseService业务层处理
 * 
 * @author sx
 * @date 2022-04-06
 */
@Service
public class AdviseServiceImpl implements IAdviseService 
{
    @Autowired
    private AdviseMapper adviseMapper;

    /**
     * 查询advise
     * 
     * @param id advise主键
     * @return advise
     */
    @Override
    public Advise selectAdviseById(Long id)
    {
        return adviseMapper.selectAdviseById(id);
    }

    /**
     * 查询advise列表
     * 
     * @param advise advise
     * @return advise
     */
    @Override
    public List<Advise> selectAdviseList(Advise advise)
    {
        return adviseMapper.selectAdviseList(advise);
    }

    /**
     * 新增advise
     * 
     * @param advise advise
     * @return 结果
     */
    @Override
    public int insertAdvise(Advise advise)
    {
        return adviseMapper.insertAdvise(advise);
    }

    /**
     * 修改advise
     * 
     * @param advise advise
     * @return 结果
     */
    @Override
    public int updateAdvise(Advise advise)
    {
        return adviseMapper.updateAdvise(advise);
    }

    /**
     * 批量删除advise
     * 
     * @param ids 需要删除的advise主键
     * @return 结果
     */
    @Override
    public int deleteAdviseByIds(Long[] ids)
    {
        return adviseMapper.deleteAdviseByIds(ids);
    }

    /**
     * 删除advise信息
     * 
     * @param id advise主键
     * @return 结果
     */
    @Override
    public int deleteAdviseById(Long id)
    {
        return adviseMapper.deleteAdviseById(id);
    }
}

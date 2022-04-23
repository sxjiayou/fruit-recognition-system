package com.ruoyi.utrain.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.utrain.mapper.ApMapper;
import com.ruoyi.utrain.domain.Ap;
import com.ruoyi.utrain.service.IApService;

/**
 * apService业务层处理
 * 
 * @author sx
 * @date 2022-04-06
 */
@Service
public class ApServiceImpl implements IApService 
{
    @Autowired
    private ApMapper apMapper;

    /**
     * 查询ap
     * 
     * @param id ap主键
     * @return ap
     */
    @Override
    public Ap selectApById(String id)
    {
        return apMapper.selectApById(id);
    }

    /**
     * 查询ap列表
     * 
     * @param ap ap
     * @return ap
     */
    @Override
    public List<Ap> selectApList(Ap ap)
    {
        return apMapper.selectApList(ap);
    }

    /**
     * 新增ap
     * 
     * @param ap ap
     * @return 结果
     */
    @Override
    public int insertAp(Ap ap)
    {
        return apMapper.insertAp(ap);
    }

    /**
     * 修改ap
     * 
     * @param ap ap
     * @return 结果
     */
    @Override
    public int updateAp(Ap ap)
    {
        return apMapper.updateAp(ap);
    }

    /**
     * 批量删除ap
     * 
     * @param ids 需要删除的ap主键
     * @return 结果
     */
    @Override
    public int deleteApByIds(String[] ids)
    {
        return apMapper.deleteApByIds(ids);
    }

    /**
     * 删除ap信息
     * 
     * @param id ap主键
     * @return 结果
     */
    @Override
    public int deleteApById(String id)
    {
        return apMapper.deleteApById(id);
    }
}

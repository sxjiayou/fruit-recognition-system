package com.ruoyi.utrain.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.utrain.mapper.SportdataMapper;
import com.ruoyi.utrain.domain.Sportdata;
import com.ruoyi.utrain.service.ISportdataService;

/**
 * sportdataService业务层处理
 * 
 * @author sx
 * @date 2022-04-06
 */
@Service
public class SportdataServiceImpl implements ISportdataService 
{
    @Autowired
    private SportdataMapper sportdataMapper;

    /**
     * 查询sportdata
     * 
     * @param qid sportdata主键
     * @return sportdata
     */
    @Override
    public Sportdata selectSportdataByQid(Long qid)
    {
        return sportdataMapper.selectSportdataByQid(qid);
    }

    /**
     * 查询sportdata列表
     * 
     * @param sportdata sportdata
     * @return sportdata
     */
    @Override
    public List<Sportdata> selectSportdataList(Sportdata sportdata)
    {
        return sportdataMapper.selectSportdataList(sportdata);
    }

    /**
     * 新增sportdata
     * 
     * @param sportdata sportdata
     * @return 结果
     */
    @Override
    public int insertSportdata(Sportdata sportdata)
    {
        return sportdataMapper.insertSportdata(sportdata);
    }

    /**
     * 修改sportdata
     * 
     * @param sportdata sportdata
     * @return 结果
     */
    @Override
    public int updateSportdata(Sportdata sportdata)
    {
        return sportdataMapper.updateSportdata(sportdata);
    }

    /**
     * 批量删除sportdata
     * 
     * @param qids 需要删除的sportdata主键
     * @return 结果
     */
    @Override
    public int deleteSportdataByQids(Long[] qids)
    {
        return sportdataMapper.deleteSportdataByQids(qids);
    }

    /**
     * 删除sportdata信息
     * 
     * @param qid sportdata主键
     * @return 结果
     */
    @Override
    public int deleteSportdataByQid(Long qid)
    {
        return sportdataMapper.deleteSportdataByQid(qid);
    }
}

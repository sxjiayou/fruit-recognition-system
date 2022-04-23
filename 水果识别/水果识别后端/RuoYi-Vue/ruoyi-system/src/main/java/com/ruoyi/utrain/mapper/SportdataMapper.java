package com.ruoyi.utrain.mapper;

import java.util.List;
import com.ruoyi.utrain.domain.Sportdata;

/**
 * sportdataMapper接口
 * 
 * @author sx
 * @date 2022-04-06
 */
public interface SportdataMapper 
{
    /**
     * 查询sportdata
     * 
     * @param qid sportdata主键
     * @return sportdata
     */
    public Sportdata selectSportdataByQid(Long qid);

    /**
     * 查询sportdata列表
     * 
     * @param sportdata sportdata
     * @return sportdata集合
     */
    public List<Sportdata> selectSportdataList(Sportdata sportdata);

    /**
     * 新增sportdata
     * 
     * @param sportdata sportdata
     * @return 结果
     */
    public int insertSportdata(Sportdata sportdata);

    /**
     * 修改sportdata
     * 
     * @param sportdata sportdata
     * @return 结果
     */
    public int updateSportdata(Sportdata sportdata);

    /**
     * 删除sportdata
     * 
     * @param qid sportdata主键
     * @return 结果
     */
    public int deleteSportdataByQid(Long qid);

    /**
     * 批量删除sportdata
     * 
     * @param qids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSportdataByQids(Long[] qids);
}

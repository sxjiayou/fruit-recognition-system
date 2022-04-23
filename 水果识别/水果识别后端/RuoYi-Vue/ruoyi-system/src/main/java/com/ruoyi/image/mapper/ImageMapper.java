package com.ruoyi.image.mapper;

import java.util.List;
import com.ruoyi.image.domain.Image;

/**
 * imageMapper接口
 * 
 * @author sx
 * @date 2022-04-11
 */
public interface ImageMapper 
{
    /**
     * 查询image
     * 
     * @param id image主键
     * @return image
     */
    public Image selectImageById(Long id);

    /**
     * 查询image列表
     * 
     * @param image image
     * @return image集合
     */
    public List<Image> selectImageList(Image image);

    /**
     * 新增image
     * 
     * @param image image
     * @return 结果
     */
    public int insertImage(Image image);

    /**
     * 修改image
     * 
     * @param image image
     * @return 结果
     */
    public int updateImage(Image image);

    /**
     * 删除image
     * 
     * @param id image主键
     * @return 结果
     */
    public int deleteImageById(Long id);

    /**
     * 批量删除image
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteImageByIds(Long[] ids);
}

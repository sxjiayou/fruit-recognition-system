package com.ruoyi.image.service;

import java.util.List;
import com.ruoyi.image.domain.Image;

/**
 * imageService接口
 * 
 * @author sx
 * @date 2022-04-11
 */
public interface IImageService 
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
     * 批量删除image
     * 
     * @param ids 需要删除的image主键集合
     * @return 结果
     */
    public int deleteImageByIds(Long[] ids);

    /**
     * 删除image信息
     * 
     * @param id image主键
     * @return 结果
     */
    public int deleteImageById(Long id);
}

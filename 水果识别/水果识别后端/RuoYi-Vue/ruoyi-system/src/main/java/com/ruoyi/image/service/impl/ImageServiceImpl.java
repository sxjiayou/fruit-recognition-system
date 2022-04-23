package com.ruoyi.image.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.image.mapper.ImageMapper;
import com.ruoyi.image.domain.Image;
import com.ruoyi.image.service.IImageService;

/**
 * imageService业务层处理
 * 
 * @author sx
 * @date 2022-04-11
 */
@Service
public class ImageServiceImpl implements IImageService 
{
    @Autowired
    private ImageMapper imageMapper;

    /**
     * 查询image
     * 
     * @param id image主键
     * @return image
     */
    @Override
    public Image selectImageById(Long id)
    {
        return imageMapper.selectImageById(id);
    }

    /**
     * 查询image列表
     * 
     * @param image image
     * @return image
     */
    @Override
    public List<Image> selectImageList(Image image)
    {
        return imageMapper.selectImageList(image);
    }

    /**
     * 新增image
     * 
     * @param image image
     * @return 结果
     */
    @Override
    public int insertImage(Image image)
    {
        return imageMapper.insertImage(image);
    }

    /**
     * 修改image
     * 
     * @param image image
     * @return 结果
     */
    @Override
    public int updateImage(Image image)
    {
        return imageMapper.updateImage(image);
    }

    /**
     * 批量删除image
     * 
     * @param ids 需要删除的image主键
     * @return 结果
     */
    @Override
    public int deleteImageByIds(Long[] ids)
    {
        return imageMapper.deleteImageByIds(ids);
    }

    /**
     * 删除image信息
     * 
     * @param id image主键
     * @return 结果
     */
    @Override
    public int deleteImageById(Long id)
    {
        return imageMapper.deleteImageById(id);
    }
}

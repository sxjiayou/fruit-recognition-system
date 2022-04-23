package com.ruoyi.image.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * image对象 image
 * 
 * @author sx
 * @date 2022-04-11
 */
public class Image extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 水果id */
    @Excel(name = "水果id")
    private Long id;

    /** 水果名称 */
    @Excel(name = "水果名称")
    private String name;

    /** 水果图片路径 */
    @Excel(name = "水果图片路径")
    private String image;

    /** 变化 */
    @Excel(name = "变化")
    private String mark;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setImage(String image) 
    {
        this.image = image;
    }

    public String getImage() 
    {
        return image;
    }
    public void setMark(String mark) 
    {
        this.mark = mark;
    }

    public String getMark() 
    {
        return mark;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("name", getName())
            .append("image", getImage())
            .append("mark", getMark())
            .toString();
    }
}

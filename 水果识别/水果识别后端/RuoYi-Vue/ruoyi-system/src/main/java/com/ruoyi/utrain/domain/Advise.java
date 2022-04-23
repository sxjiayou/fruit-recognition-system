package com.ruoyi.utrain.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * advise对象 advise
 * 
 * @author sx
 * @date 2022-04-06
 */
public class Advise extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 建议id */
    @Excel(name = "建议id")
    private Long id;

    /** 内容  */
    @Excel(name = "内容 ")
    private String data;

    /** 图片  */
    @Excel(name = "图片 ")
    private String cimage;

    /** 联系人 */
    @Excel(name = "联系人")
    private String name;

    /** 联系方式 */
    @Excel(name = "联系方式")
    private String phone;

    /** 省 */
    @Excel(name = "省")
    private String province;

    /** 市 */
    @Excel(name = "市")
    private String city;

    /** 区 */
    @Excel(name = "区")
    private String district;

    /** 球馆名称 */
    @Excel(name = "球馆名称")
    private String qname;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setData(String data) 
    {
        this.data = data;
    }

    public String getData() 
    {
        return data;
    }
    public void setCimage(String cimage) 
    {
        this.cimage = cimage;
    }

    public String getCimage() 
    {
        return cimage;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setPhone(String phone) 
    {
        this.phone = phone;
    }

    public String getPhone() 
    {
        return phone;
    }
    public void setProvince(String province) 
    {
        this.province = province;
    }

    public String getProvince() 
    {
        return province;
    }
    public void setCity(String city) 
    {
        this.city = city;
    }

    public String getCity() 
    {
        return city;
    }
    public void setDistrict(String district) 
    {
        this.district = district;
    }

    public String getDistrict() 
    {
        return district;
    }
    public void setQname(String qname) 
    {
        this.qname = qname;
    }

    public String getQname() 
    {
        return qname;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("data", getData())
            .append("cimage", getCimage())
            .append("name", getName())
            .append("phone", getPhone())
            .append("province", getProvince())
            .append("city", getCity())
            .append("district", getDistrict())
            .append("qname", getQname())
            .toString();
    }
}

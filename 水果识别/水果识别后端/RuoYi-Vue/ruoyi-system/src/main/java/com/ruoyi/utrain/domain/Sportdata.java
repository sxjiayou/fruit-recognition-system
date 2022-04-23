package com.ruoyi.utrain.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * sportdata对象 sportdata
 * 
 * @author sx
 * @date 2022-04-06
 */
public class Sportdata extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 球馆id */
    @Excel(name = "球馆id")
    private Long qid;

    /** 种类  */
    @Excel(name = "种类 ")
    private String qkind;

    /** 球馆名称 */
    @Excel(name = "球馆名称")
    private String qname;

    /** 省 */
    @Excel(name = "省")
    private String province;

    /** 市 */
    @Excel(name = "市")
    private String city;

    /** 区  */
    @Excel(name = "区 ")
    private String district;

    /** 路 */
    @Excel(name = "路")
    private String street;

    /** 环境  */
    @Excel(name = "环境 ")
    private String environ;

    /** 实时人数  */
    @Excel(name = "实时人数 ")
    private String pnumber;

    /** 球馆图片  */
    @Excel(name = "球馆图片 ")
    private String qimage;

    /** 预约人数 */
    @Excel(name = "预约人数")
    private String appointment;

    /** 场地数量 */
    @Excel(name = "场地数量")
    private String qnumber;

    public void setQid(Long qid) 
    {
        this.qid = qid;
    }

    public Long getQid() 
    {
        return qid;
    }
    public void setQkind(String qkind) 
    {
        this.qkind = qkind;
    }

    public String getQkind() 
    {
        return qkind;
    }
    public void setQname(String qname) 
    {
        this.qname = qname;
    }

    public String getQname() 
    {
        return qname;
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
    public void setStreet(String street) 
    {
        this.street = street;
    }

    public String getStreet() 
    {
        return street;
    }
    public void setEnviron(String environ) 
    {
        this.environ = environ;
    }

    public String getEnviron() 
    {
        return environ;
    }
    public void setPnumber(String pnumber) 
    {
        this.pnumber = pnumber;
    }

    public String getPnumber() 
    {
        return pnumber;
    }
    public void setQimage(String qimage) 
    {
        this.qimage = qimage;
    }

    public String getQimage() 
    {
        return qimage;
    }
    public void setAppointment(String appointment) 
    {
        this.appointment = appointment;
    }

    public String getAppointment() 
    {
        return appointment;
    }
    public void setQnumber(String qnumber) 
    {
        this.qnumber = qnumber;
    }

    public String getQnumber() 
    {
        return qnumber;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("qid", getQid())
            .append("qkind", getQkind())
            .append("qname", getQname())
            .append("province", getProvince())
            .append("city", getCity())
            .append("district", getDistrict())
            .append("street", getStreet())
            .append("environ", getEnviron())
            .append("pnumber", getPnumber())
            .append("qimage", getQimage())
            .append("appointment", getAppointment())
            .append("qnumber", getQnumber())
            .toString();
    }
}

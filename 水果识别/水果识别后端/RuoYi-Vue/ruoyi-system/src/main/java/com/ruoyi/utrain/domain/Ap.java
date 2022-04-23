package com.ruoyi.utrain.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * ap对象 ap
 * 
 * @author sx
 * @date 2022-04-06
 */
public class Ap extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 约球id */
    @Excel(name = "约球id")
    private String id;

    /** 昵称  */
    @Excel(name = "昵称 ")
    private String name;

    /** 省 */
    @Excel(name = "省")
    private String province;

    /** 市  */
    @Excel(name = "市 ")
    private String city;

    /** 区 */
    @Excel(name = "区")
    private String district;

    /** 时间  */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "时间 ", width = 30, dateFormat = "yyyy-MM-dd")
    private Date time;

    /** 说明  */
    @Excel(name = "说明 ")
    private String state;

    /** 当前预约人数  */
    @Excel(name = "当前预约人数 ")
    private String appointment;

    /** 种类  */
    @Excel(name = "种类 ")
    private String kind;

    /** 球馆名称  */
    @Excel(name = "球馆名称 ")
    private String qname;

    /** 联系方式 */
    @Excel(name = "联系方式")
    private String phone;

    public void setId(String id) 
    {
        this.id = id;
    }

    public String getId() 
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
    public void setTime(Date time) 
    {
        this.time = time;
    }

    public Date getTime() 
    {
        return time;
    }
    public void setState(String state) 
    {
        this.state = state;
    }

    public String getState() 
    {
        return state;
    }
    public void setAppointment(String appointment) 
    {
        this.appointment = appointment;
    }

    public String getAppointment() 
    {
        return appointment;
    }
    public void setKind(String kind) 
    {
        this.kind = kind;
    }

    public String getKind() 
    {
        return kind;
    }
    public void setQname(String qname) 
    {
        this.qname = qname;
    }

    public String getQname() 
    {
        return qname;
    }
    public void setPhone(String phone) 
    {
        this.phone = phone;
    }

    public String getPhone() 
    {
        return phone;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("name", getName())
            .append("province", getProvince())
            .append("city", getCity())
            .append("district", getDistrict())
            .append("time", getTime())
            .append("state", getState())
            .append("appointment", getAppointment())
            .append("kind", getKind())
            .append("qname", getQname())
            .append("phone", getPhone())
            .toString();
    }
}

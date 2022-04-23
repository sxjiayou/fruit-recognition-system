package com.ruoyi.utrain.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * user对象 user
 * 
 * @author sx
 * @date 2022-04-06
 */
public class User extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 用户id */
    @Excel(name = "用户id")
    private Long id;

    /** 昵称 */
    @Excel(name = "昵称")
    private String name;

    /** 登录时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "登录时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date loginTime;

    /** 头像 */
    @Excel(name = "头像")
    private String image;

    /** 小黑屋 */
    @Excel(name = "小黑屋")
    private String blackRoom;

    /** 身份 */
    @Excel(name = "身份")
    private String status;

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
    public void setLoginTime(Date loginTime) 
    {
        this.loginTime = loginTime;
    }

    public Date getLoginTime() 
    {
        return loginTime;
    }
    public void setImage(String image) 
    {
        this.image = image;
    }

    public String getImage() 
    {
        return image;
    }
    public void setBlackRoom(String blackRoom) 
    {
        this.blackRoom = blackRoom;
    }

    public String getBlackRoom() 
    {
        return blackRoom;
    }
    public void setStatus(String status) 
    {
        this.status = status;
    }

    public String getStatus() 
    {
        return status;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("name", getName())
            .append("loginTime", getLoginTime())
            .append("image", getImage())
            .append("blackRoom", getBlackRoom())
            .append("status", getStatus())
            .toString();
    }
}

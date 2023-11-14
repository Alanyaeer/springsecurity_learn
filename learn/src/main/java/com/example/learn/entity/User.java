package com.example.learn.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;


/**
 * 用户表(User)实体类
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {
    public static final long serialVersionUID = -40356785423868312L;
    
    /**
    * 主键
    */
    @TableId
    public Long id;
    /**
    * 用户名
    */
    public String userName;
    /**
    * 昵称
    */
    public String nickName;
    /**
    * 密码
    */
    public String password;
    /**
    * 账号状态（0正常 1停用）
    */
    public String status;
    /**
    * 邮箱
    */
    public String email;
    /**
    * 手机号
    */
    public String phonenumber;
    /**
    * 用户性别（0男，1女，2未知）
    */
    public String sex;
    /**
    * 头像
    */
    public String avatar;
    /**
    * 用户类型（0管理员，1普通用户）
    */
    public String userType;
    /**
    * 创建人的用户id
    */
    public Long createBy;
    /**
    * 创建时间
    */
    public Date createTime;
    /**
    * 更新人
    */
    public Long updateBy;
    /**
    * 更新时间
    */
    public Date updateTime;
    /**
    * 删除标志（0代表未删除，1代表已删除）
    */
    public Integer delFlag;
}

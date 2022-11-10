package com.gjq.generator.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author gjq
 * @since 2022-11-08
 */
@TableName("t_user")
@ApiModel(value = "User对象", description = "用户表")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("用户id,手机号")
    private Long id;

    @ApiModelProperty("用户名")
    private String username;

    @ApiModelProperty("密码")
    private String password;

    @ApiModelProperty("解密密钥")
    private String slat;

    @ApiModelProperty("头像")
    private String head;

    @ApiModelProperty("注册时间")
    private LocalDateTime registerDate;

    @ApiModelProperty("最后登录时间")
    private LocalDateTime lastLoginDate;

    @ApiModelProperty("登录次数")
    private Integer loginCount;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public String getSlat() {
        return slat;
    }

    public void setSlat(String slat) {
        this.slat = slat;
    }
    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }
    public LocalDateTime getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(LocalDateTime registerDate) {
        this.registerDate = registerDate;
    }
    public LocalDateTime getLastLoginDate() {
        return lastLoginDate;
    }

    public void setLastLoginDate(LocalDateTime lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
    }
    public Integer getLoginCount() {
        return loginCount;
    }

    public void setLoginCount(Integer loginCount) {
        this.loginCount = loginCount;
    }

    @Override
    public String toString() {
        return "User{" +
            "id=" + id +
            ", username=" + username +
            ", password=" + password +
            ", slat=" + slat +
            ", head=" + head +
            ", registerDate=" + registerDate +
            ", lastLoginDate=" + lastLoginDate +
            ", loginCount=" + loginCount +
        "}";
    }
}

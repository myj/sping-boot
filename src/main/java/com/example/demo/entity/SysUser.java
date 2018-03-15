

package com.example.demo.entity;

import javax.persistence.*;

@Entity
@Table(name = "SYS_USER")
public class SysUser {


    //可以直接使用: @Length(max=50,message="用户名长度不能大于50")显示错误消息
    //columns START
    /**
     * sysUserId       db_column: SYS_USER_ID 
     */

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "SYS_USER_ID", unique = false, nullable = false, insertable = true, updatable = true, length = 10)
    private Integer sysUserId;
    /**
     * loginId       db_column: LOGIN_ID 
     */
//	@Index(name="IDX_ENT_ID_LOGIN_NM") 已有唯一索引
    @Column(name = "LOGIN_ID", unique = true, nullable = false, insertable = true, updatable = true, length = 32)
    private String loginId;
    /**
     * userName       db_column: USER_NAME 
     */
    @Column(name = "USER_NAME", unique = false, nullable = false, insertable = true, updatable = true, length = 48)
    private String userName;

    public SysUser(){

    }

    public Integer getSysUserId() {
        return sysUserId;
    }

    public void setSysUserId(Integer sysUserId) {
        this.sysUserId = sysUserId;
    }

    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}


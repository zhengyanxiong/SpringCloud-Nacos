

package io.agilefast.authserver.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.security.core.userdetails.UserDetails;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 系统用户
 * 
 * @author
 * @email
 * @date 2016年9月18日 上午9:28:55
 */
@TableName("sys_user")
public class SysUserEntity implements UserDetails,Serializable {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 用户ID
	 */
	@TableId(type = IdType.AUTO)
	private Long userId;

	/**
	 * 用户名
	 */
	private String username;

	/**
	 * 密码
	 */
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private String password;

	/**
	 * 密码（用于微服务密码存储）
	 */
	private String passwordplus;

	/**
	 * 盐
	 */
	private String salt;

	/**
	 * 邮箱
	 */
	private String email;

	/**
	 * 手机号
	 */
	private String mobile;

	/**
	 * 状态  0：禁用   1：正常
	 */
	private Integer status;
	
	/**
	 * 角色ID列表
	 */
	@TableField(exist=false)
	private List<Long> roleIdList;
	/**
	 * 项目列表
	 */
	@TableField(exist=false)
	private List<Long> projectIdList;

	/**
	 * 创建时间
	 */
	private Date createTime;

	/**
	 * 部门ID
	 */
	private Long deptId;

	/**
	 * 部门名称
	 */
	@TableField(exist=false)
	private String deptName;

	/**
	 * 中文名称
	 */
	private String chineseName;
	/**
	 * 最后登录时间
	 */
	private Date dateLastLogin;
	/**
	 * 默认UI皮肤
	 */
	private String skin;
	/**
	 * 用户头像
	 */
	private String userPhoto;
	/**
	 * 组织机构ID
	 */
	private String levelMarkId;
	/**
	 * 性别
	 */
	private String sex;
	/**
	 * 预留字段1
	 */
	private String userExtValue1;
	/**
	 * 预留字段2
	 */
	private String userExtValue2;
	/**
	 * 预留字段3
	 */
	private String userExtValue3;
	/**
	 * 预留字段4
	 */
	private String userExtValue4;
	/**
	 * 预留字段5
	 */
	private String userExtValue5;
	/**
	 * 下拉列表选中状态
	 */
	@TableField(exist=false)
	private String selected;

	/**
	 * 设置：
	 * @param userId 
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}

	/**
	 * 获取：
	 * @return Long
	 */
	public Long getUserId() {
		return userId;
	}
	
	/**
	 * 设置：用户名
	 * @param username 用户名
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * 获取：用户名
	 * @return String
	 */
	public String getUsername() {
		return username;
	}
	
	/**
	 * 设置：密码
	 * @param password 密码
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * 获取：密码
	 * @return String
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * 设置：微服务密码
	 * @param passwordplus 密码
	 */
	public void setPasswordplus(String passwordplus) {
		this.passwordplus = passwordplus;
	}

	/**
	 * 获取：微服务密码
	 * @return String
	 */
	public String getPasswordplus() {
		return passwordplus;
	}
	
	/**
	 * 设置：邮箱
	 * @param email 邮箱
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * 获取：邮箱
	 * @return String
	 */
	public String getEmail() {
		return email;
	}
	
	/**
	 * 设置：手机号
	 * @param mobile 手机号
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	/**
	 * 获取：手机号
	 * @return String
	 */
	public String getMobile() {
		return mobile;
	}
	
	/**
	 * 设置：状态  0：禁用   1：正常
	 * @param status 状态  0：禁用   1：正常
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}

	/**
	 * 获取：状态  0：禁用   1：正常
	 * @return Integer
	 */
	public Integer getStatus() {
		return status;
	}
	
	/**
	 * 设置：创建时间
	 * @param createTime 创建时间
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	/**
	 * 获取：创建时间
	 * @return Date
	 */
	public Date getCreateTime() {
		return createTime;
	}

	/**
	 * 设置：中文名称
	 */
	public void setChineseName(String chineseName) {
		this.chineseName = chineseName;
	}
	/**
	 * 获取：中文名称
	 */
	public String getChineseName() {
		return chineseName;
	}
	/**
	 * 设置：最后登录时间
	 */
	public void setDateLastLogin(Date dateLastLogin) {
		this.dateLastLogin = dateLastLogin;
	}
	/**
	 * 获取：最后登录时间
	 */
	public Date getDateLastLogin() {
		return dateLastLogin;
	}
	/**
	 * 设置：默认UI皮肤
	 */
	public void setSkin(String skin) {
		this.skin = skin;
	}
	/**
	 * 获取：默认UI皮肤
	 */
	public String getSkin() {
		return skin;
	}
	/**
	 * 设置：用户头像
	 */
	public void setUserPhoto(String userPhoto) {
		this.userPhoto = userPhoto;
	}
	/**
	 * 获取：用户头像
	 */
	public String getUserPhoto() {
		return userPhoto;
	}
	/**
	 * 设置：组织机构ID
	 */
	public void setLevelMarkId(String levelMarkId) {
		this.levelMarkId = levelMarkId;
	}
	/**
	 * 获取：组织机构ID
	 */
	public String getLevelMarkId() {
		return levelMarkId;
	}
	/**
	 * 设置：性别
	 */
	public void setSex(String sex) {
		this.sex = sex;
	}
	/**
	 * 获取：性别
	 */
	public String getSex() {
		return sex;
	}
	/**
	 * 设置：预留字段1
	 */
	public void setUserExtValue1(String userExtValue1) {
		this.userExtValue1 = userExtValue1;
	}
	/**
	 * 获取：预留字段1
	 */
	public String getUserExtValue1() {
		return userExtValue1;
	}
	/**
	 * 设置：预留字段2
	 */
	public void setUserExtValue2(String userExtValue2) {
		this.userExtValue2 = userExtValue2;
	}
	/**
	 * 获取：预留字段2
	 */
	public String getUserExtValue2() {
		return userExtValue2;
	}
	/**
	 * 设置：预留字段3
	 */
	public void setUserExtValue3(String userExtValue3) {
		this.userExtValue3 = userExtValue3;
	}
	/**
	 * 获取：预留字段3
	 */
	public String getUserExtValue3() {
		return userExtValue3;
	}
	/**
	 * 设置：预留字段4
	 */
	public void setUserExtValue4(String userExtValue4) {
		this.userExtValue4 = userExtValue4;
	}
	/**
	 * 获取：预留字段4
	 */
	public String getUserExtValue4() {
		return userExtValue4;
	}
	/**
	 * 设置：预留字段5
	 */
	public void setUserExtValue5(String userExtValue5) {
		this.userExtValue5 = userExtValue5;
	}
	/**
	 * 获取：预留字段5
	 */
	public String getUserExtValue5() {
		return userExtValue5;
	}



	@TableField(exist=false)
	private List<Long> menuIdList;

	public List<Long> getRoleIdList() {
		return roleIdList;
	}

	public void setRoleIdList(List<Long> roleIdList) {
		this.roleIdList = roleIdList;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public Long getDeptId() {
		return deptId;
	}

	public void setDeptId(Long deptId) {
		this.deptId = deptId;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public List<Long> getMenuIdList() {
		return menuIdList;
	}

	public void setMenuIdList(List<Long> menuIdList) {
		this.menuIdList = menuIdList;
	}

	/**
	 * 设置：下拉列表选中状态
	 * @param selected 下拉列表选中状态
	 */
	public void setSelected(String selected) {
		this.selected = selected;
	}

	/**
	 * 获取：下拉列表选中状态
	 * @return String
	 */
	public String getSelected() {
		return selected;
	}

	public List<Long> getProjectIdList() {
		return projectIdList;
	}

	public void setProjectIdList(List<Long> projectIdList) {
		this.projectIdList = projectIdList;
	}

	@TableField(exist=false)
    private List<Role> authorities;
    @Override
    public List<Role> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(List<Role> authorities) {
        this.authorities = authorities;
    }

    /**
     * 用户账号是否过期
     */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /**
     * 用户账号是否被锁定
     */
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    /**
     * 用户密码是否过期
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /**
     * 用户是否可用
     */
    @Override
    public boolean isEnabled() {
        return true;
    }
}

package com.xiexin.shiro;

import com.xiexin.bean.Admin;
import com.xiexin.bean.AdminExample;
import com.xiexin.service.AdminService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

/**
 * 自定义 的 和  mybatis 数据库 结合的 realm
 * <p>
 * realm 中，包含 认证（登录） 和 授权 2个部分
 */
public class MybatisRealm extends AuthorizingRealm {
    @Autowired
    private AdminService adminService;

    // 授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //写授权！！！查询3表 可得到角色和权限
        //第一个  拿到account
        String principal = (String) principalCollection.getPrimaryPrincipal();
        Map map=new HashMap();
        map.put("adminAccount",principal);
        List<Map> maps = adminService.selectMore(map);
        //maps包含了角色名称 ,权限名称
        Set<String> roleNames=new HashSet<>();
        List perms=new ArrayList();
        for (Map map1 : maps) {
            String roleName = (String) map1.get("roleName");
            String qxPerms = (String) map1.get("qxPerms");
            //String qxPerms = (String) map1.get("qxName");
            //把他循环遍历到 rolename集合中
            roleNames.add(roleName);
            perms.add(qxPerms);



        }
        //把角色和权限给与登录的账户
        SimpleAuthorizationInfo info=new SimpleAuthorizationInfo();
        info.addRoles(roleNames);
        info.addStringPermissions(perms);
        return info;
        //触发投权、1，界面UI触发，适用于单体项目﹒.2.java方法注解触发，适用于前后端分离，3，不常用的﹐自己硬编码
        //界面出发要用到 aop 和jar包支持


    }

    // 认证 登录
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        // AuthenticationToken 这个参数是啥 》》？？？？ 其实 就是  UsernamePasswordToken（“账号”，“密码”）
        String account = (String) authenticationToken.getPrincipal();//拿到 剩男的账户名
        // 拿到账户名后， 能否拿到 数据库中的 密码 ？？？？？
        // select * from admin where username=“admin”
        AdminExample example = new AdminExample();
        AdminExample.Criteria criteria = example.createCriteria();
        criteria.andAdminAccountEqualTo(account);
        List<Admin> admins = adminService.selectByExample(example);
        Admin dbAdmin = null;
        if (admins != null && admins.size() > 0) {
            dbAdmin = admins.get(0);
            // 获取账户名和密码
            String pwd = dbAdmin.getAdminPwd();
            System.out.println("pwd = " + pwd);
            String salt = dbAdmin.getSalt();
            System.out.println("salt = " + salt);
            // 进行  token认证
            SimpleAuthenticationInfo simpleAuthenticationInfo =
                    new SimpleAuthenticationInfo(account, pwd, ByteSource.Util.bytes(salt), this.getName());
            System.out.println("ByteSource.Util.bytes(salt) = " + ByteSource.Util.bytes(salt));
            return simpleAuthenticationInfo;
        }
        return null;
    }
}

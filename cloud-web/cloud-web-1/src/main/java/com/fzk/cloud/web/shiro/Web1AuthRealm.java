package com.fzk.cloud.web.shiro;

import com.fzk.cloud.account.entity.Web1Account;
import com.fzk.cloud.account.service.Web1AccountService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

public class Web1AuthRealm extends AuthorizingRealm
{
    @Autowired private Web1AccountService web1AccountService;

    /**
     * 用户权限设置：先查库获取当前用户权限列表，然后将权限添加到shiro管理引擎。
     * @param arg0
     * @return
     */
    @Override protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection arg0)
    {
        //        Subject subject=SecurityUtils.getSubject();
        //        Web1Account user=(Web1Account) subject.getPrincipal();
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        //todo 目前未给当前用户添加任何权限，后续补充，参考注释代码
        return simpleAuthorizationInfo;
        //        UserPrincipal principal = (UserPrincipal) getAvailablePrincipal(principals);
        //        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        //        List<RoleInfo> roles = principal.getRoles();
        //        if (ListUtils.isNotNull(roles))
        //        {
        //            for (RoleInfo role : roles)
        //            {
        //                authorizationInfo.addRole(role.getRoleCode());
        //                List<Resources> resources = role.getResources();
        //                if (ListUtils.isNotNull(roles))
        //                {
        //                    for (Resources res : resources)
        //                    {
        //                        authorizationInfo.addStringPermission(res.getResCode());
        //                    }
        //                }
        //            }
        //        }
        //        return authorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException
    {
        // TODO Auto-generated method stub
        //获取前端传来的认证参数，例如用户名，密码
        UsernamePasswordToken token1 = (UsernamePasswordToken) token;
        //根据前端传来的用户名查库
        Web1Account account = web1AccountService.selectByName(token1.getUsername());
        if (null == account)
        {
            //shiro会抛出UnknownAccountException异常,因此我们不做处理
            return null;
        }
        return new SimpleAuthenticationInfo(account, account.getPassword(), "");
    }
}

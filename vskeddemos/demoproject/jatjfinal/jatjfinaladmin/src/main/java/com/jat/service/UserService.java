package com.jat.service;

import java.util.LinkedList;
import java.util.List;
import com.jat.model.IJwtAble;
import com.jat.model.JwtUser;
import com.jat.model.Resource;
import com.jat.model.Role;
import com.jat.model.User;
import com.jat.util.JwtKit;

public class UserService implements IJwtUserService {
	public static final UserService me = new UserService();

    private UserService() {
    }

    @Override
    public IJwtAble login(String userName, String password) {
    	User webUser=User.dao.findFirst("select a.id,a.`name`,a.phone,a.state from `user` a left join `userAccount` b on a.id=b.userId left join `account` c on b.accountId=c.id where c.`name`=? and c.pass=? and a.state=0 and a.isDel=0 and b.isDel=0 and c.isDel=0",userName,password);

    	if (webUser != null) {

			List<String> roleIds=new LinkedList<>();
			StringBuffer roleStringBuffer=new StringBuffer();
			List<Role> roles=Role.dao.find("select a.id,a.`name`,a.descript from role a left join userRole b on a.id=b.roleId where b.userId=? and a.isDel=0 and b.isDel=0",webUser.getId());
			for(Role role:roles){
				roleIds.add(role.getId()+"");
				roleStringBuffer.append(role.getId());
				roleStringBuffer.append(",");
			}

			List<String> resourceIds = new LinkedList<>();

            if(roleStringBuffer.length()>1){
				roleStringBuffer.setLength(roleStringBuffer.length()-1);
				List<Resource> resourceList = Resource.dao.find("select a.* from resource a left join roleResource b on a.id=b.resId where b.roleId in("+roleStringBuffer.toString()+") and a.isDel=0 and b.isDel=0 ");

				for (Resource resource : resourceList) {
					resourceIds.add(resource.getId()+"");
				}
			}

        	return new JwtUser().setUserId(
        			webUser.getId()+"")
        			.setForces(resourceIds)
        			.setRoles(roleIds);
        }
    	return  null;
    }

	public void logout(String token) {
		JwtKit.removeToken(token);
	}

}

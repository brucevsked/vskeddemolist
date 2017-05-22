package com.vsked.service;

import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.github.pagehelper.PageHelper;
import com.vsked.common.BaseJson;
import com.vsked.common.Page;
import com.vsked.dao.SysUserDao;
import com.vsked.service.BaseService;

@Service
@Transactional
public class SysUserSer extends BaseService{
	
	private static final Logger log = Logger.getLogger(SysUserSer.class);
	
	@Autowired
	private SysUserDao sysUserDao;
	
	/**
	 * 登录业务逻辑
	 * @param req
	 * @return
	 */
	public String login(HttpServletRequest req){
		try{
			Map<String, Object> m=getMaps(req);
			String suName=(String)m.get("suName");
			String suPass=(String)m.get("suPass");
			if(StringUtils.isNotEmpty(suName) && StringUtils.isNotEmpty(suPass) ){
				suPass=DigestUtils.md5Hex(suPass.getBytes());
				AuthenticationToken token=new UsernamePasswordToken(suName, suPass);
				//使用shiro管理登录
				SecurityUtils.getSubject().login(token);
				return "redirect:index";
			}else{
				getSession().setAttribute("backMsg", "用户名或密码为空！");
				return "login";
			}
		}catch(Exception e){
			log.error(e.getMessage());
			getSession().setAttribute("backMsg", "用户名或密码错误请重新输入！");
			return "login";
		}
	}
	
	/**
	 * 根据用户名获取记录
	 * @param suName
	 * @return
	 */
	public Map<String, Object> getSysUserBySuName(String suName) {
		Map<String, Object> m=null;
		try{
			m=sysUserDao.getSysUserBySuName(suName);
		}catch(Exception e){
			log.error(e.getMessage());
		}
		return m;
	}
	
	/**
	 * 根据主键获取记录
	 * @param suId
	 * @return
	 */
	public Map<String, Object> getSysUserBySuId(String suId) {
		Map<String, Object> m=null;
		try{
			m=sysUserDao.getSysUserBySuId(suId);
		}catch(Exception e){
			log.error(e.getMessage());
		}
		return m;
	}
	
	/**
	 * 获取用户数量
	 * @param m
	 * @return
	 */
	public int getSysUserCount(Map<String, Object> m){
		int sysUserCount=0;
		try{
			sysUserCount=sysUserDao.getSysUserCount(m);
		}catch(Exception e){
			log.error(e.getMessage());
		}
		return sysUserCount;
	}

	
	public String sysUserList(HttpServletRequest req){
		StringBuilder sb=new StringBuilder();
		try{
		Map<String, Object> m=getMaps(req); //封装前台参数为map
		Page p=getPage(m);//提取分页参数
		int total=getSysUserCount(m);
		p.setCount(total);
		int pageNum=p.getCurrentPage();
		int pageSize=p.getPageSize();
		
		sb.append("{");
		sb.append(""+getKey("total")+":"+total+",");
		sb.append(""+getKey("rows")+":"+"");
		
		PageHelper.startPage(pageNum, pageSize);//mybatis分页插件
		List<Map<String, Object>> dataList=sysUserDao.getSysUserList(m);
		String dataListJson=BaseJson.listToJson(dataList);
		sb.append(dataListJson);
		sb.append("}");
		}catch(Exception e){
			log.error(e.getMessage());
		}
		
		return sb.toString();
	}
	
	public String userAddProc(HttpServletRequest req){
		String result="";
		try{
			Map<String, Object> data=getMaps(req);
			
			if(data.containsKey("suPass")){
				String suPass=(String) data.get("suPass");
				suPass=DigestUtils.md5Hex(suPass.getBytes());
				data.put("suPass", suPass);
			}
			
			int effectLine=sysUserDao.sysUserAdd(data);
			if(effectLine<=0){
				result="用户添加失败。";
			}else{
				result="用户:"+data.get("suName")+"添加成功.";
			}
		}catch(Exception e){
			log.error(e.getMessage());
			result="用户添加出现异常,请联系管理员.";
		}
		return result;
	}
	
	public String userEditProc(HttpServletRequest req){
		String result="";
		try{
			Map<String, Object> data=getMaps(req);
			int effectLine=sysUserDao.sysUserEdit(data);
			if(effectLine<=0){
				result="用户修改失败。";
			}else{
				result="用户:"+data.get("suNick")+"修改成功.";
			}
		}catch(Exception e){
			log.error(e.getMessage());
			result="用户修改出现异常,请联系管理员.";
		}
		return result;
	}
	
	public String userEditPage(HttpServletRequest req){
		String result="userListPage";
		try{
			Map<String, Object> parMap=getMaps(req);
			if(parMap.containsKey("suId")){
			Map<String, Object> data=sysUserDao.getSysUserBySuId((String) parMap.get("suId"));
			getSession().setAttribute("data", data);
			result="userEdit";
			}
		}catch(Exception e){
			log.error(e.getMessage());
		}
		return result;
	}
	
	public String userPassPage(HttpServletRequest req){
		String result="userPass";
		try{
			Map<String, Object> parMap=getMaps(req);
			if(parMap.containsKey("suId")){
			getSession().setAttribute("data", parMap.get("suId"));
			}
		}catch(Exception e){
			log.error(e.getMessage());
		}
		return result;
	}
	
	/**
	 * 密码修改(当suId为空时修改当前用户密码有suId参数时修改用户suId的密码)
	 * @param req
	 * @return
	 */
	public String userPassProc(HttpServletRequest req){
		String result="";
		try{
			Map<String, Object> data=getMaps(req);
			if(data.containsKey("suPass")){
				String suPass=(String) data.get("suPass");
				suPass=DigestUtils.md5Hex(suPass.getBytes());
				data.put("suPass", suPass);
			}
			if(data.containsKey("suId")){
				String suId=(String) data.get("suId");
				if("".equals(suId)){
					suId=getCurrentUserId();
					data.put("suId", suId);
				}
			}
			
			int effectLine=sysUserDao.sysUserPassChange(data);
			if(effectLine<=0){
				result="密码修改失败。";
			}else{
				result="密码修改成功.";
			}
		}catch(Exception e){
			log.error(e.getMessage());
			result="密码修改出现异常,请联系管理员.";
		}
		return result;
	}
	
}

package com.xinfang.web.eat.modules.login.action;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.xinfang.web.eat.constant.SessionKey;
import com.xinfang.web.eat.modules.base.action.BaseAction;

/**
 * ÁôªÂΩï
 * 
 * @author hk
 *
 */
public class LoginAction extends BaseAction {

	
	// ÃÌº”µ„¥˙¬Î
	/*-------------------------------------------
	 |             C O N S T A N T S             |
	 ============================================*/

	private static final long serialVersionUID = 1L;
	
	static final Logger LOG = LoggerFactory.getLogger(LoginAction.class);
	
	/*-------------------------------------------
	  |    I N S T A N C E   V A R I A B L E S    |
	  ============================================*/
	
	private String userName, password;
	

	/*-------------------------------------------
	  |               M E T H O D S               |
	  ============================================*/

	/**
	 * ÁôªÂΩïÈ™åËØÅ
	 * @return
	 */
	public String login(){
		
		if(null != getCurrentUser()){
			return SUCCESS;
		}
		// Ê†°È™å
		boolean isSuccessLogin = loginService.validateLogin(userName, password);
		if(isSuccessLogin){
			// ËÆ∞ÂΩïsession
			getSession().setAttribute(SessionKey.LOGIN_USER_SESSION_KEY, userName);
			return SUCCESS;
		}else{
			return INPUT;
		}
	}
	
	/**
	 * Ê≥®ÈîÄ
	 * @return
	 */
	public String logout(){
			
		getSession().removeAttribute(SessionKey.LOGIN_USER_SESSION_KEY);
		return SUCCESS;
	}
	
	
	/*-------------------------------------------
	 |        G E T T E R && S E T T E R          |
	 ============================================*/
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}

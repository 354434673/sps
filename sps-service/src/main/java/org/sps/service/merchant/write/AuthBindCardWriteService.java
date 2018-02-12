package org.sps.service.merchant.write;

import org.sps.entity.account.AuthRequest;
import org.sps.entity.account.AuthResponse;

/***
 *  绑卡请求
 * @author cailing
 *
 */

public interface AuthBindCardWriteService{
	/**
	 * 
	 * @param request
	 * @return
	 */
	 public AuthResponse.AuthResult request(AuthRequest.AuthParam request); 
	 /**
	  * 短信确认方法
	  * @param confirmParam
	  * @return
	  */
	 public AuthResponse.ConfirmResult confirm(AuthRequest.ConfirmParam confirmParam) ;
	 /***
	  * 重新发短信
	  * @param resendParam
	  * @return
	  */
	  public AuthResponse.ResendResult resend(AuthRequest.ResendParam resendParam) ;
	
	
}

package org.sps.entity.account;

import org.sps.entity.merchant.SpsChannelBank;
import org.sps.entity.merchant.SpsChannelBankTrans;



public class Converter {
	 public static SpsChannelBankTrans toDealRecord(AuthRequest.AuthParam authParam){
		 	SpsChannelBankTrans authDealRecord = new SpsChannelBankTrans();
	        authDealRecord.setBankCode(authParam.getCardno());
	        authDealRecord.setBankName(authParam.getBankName());
	        authDealRecord.setUserId(authParam.getUserId());
	        authDealRecord.setName(authParam.getUsername());
	        authDealRecord.setIdentity(authParam.getIdcardno());
	        authDealRecord.setMerchantNo(authParam.getMerchantno());
	        authDealRecord.setAuthType(authParam.getAuthtype());
	       // authDealRecord.setName(authParam.getUsername());
	        authDealRecord.setPhone(authParam.getPhone());
	        authDealRecord.setSerialSh(authParam.getRequestno());
	        return authDealRecord;
	    }
	    public static SpsChannelBank toBankCard(AuthResponse.AuthResult authResult){
	    	SpsChannelBank bankCard = new SpsChannelBank();
	        return bankCard;
	    }

	    public static SpsChannelBank toBankCard(AuthResponse.ConfirmResult confirmResult) {
	        return null;
	    }

	    public static SpsChannelBank toBankCard(AuthResponse.ResendResult resendResult) {
	        return null;
	    }
}



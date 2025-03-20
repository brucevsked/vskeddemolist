package com.vsked.auth.service;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.vsked.auth.infrastructure.persistence.jpa.AccountDTO;
import com.vsked.auth.infrastructure.persistence.jpa.AccountRepository;
import com.vsked.auth.web.model.LoginInfoVO;

@Service
public class TestService {

	private static final Logger log = LoggerFactory.getLogger(TestService.class);

	@Autowired
	AccountRepository accountRepository;

	public void add(LoginInfoVO loginInfo) {
		log.info("TestService add start");
		Long accountId = new Long(1);
		List<AccountDTO> list = new ArrayList<AccountDTO>();
		list = accountRepository.findAllBy();
		if (list.size() > 0) {
			for (AccountDTO accountDTO : list) {
				if (accountId < accountDTO.getId()) {
					accountId = accountDTO.getId();
				}
			}
			accountId = accountId +1;
		}
		AccountDTO inputdto = new AccountDTO();
		inputdto.setId(accountId);
		inputdto.setName(loginInfo.getUsername());
		inputdto.setPass(loginInfo.getPassword());
		AccountDTO account = accountRepository.save(inputdto);
		log.debug(account.toString());
		log.info("TestService add end");
	}
	
	public void update(LoginInfoVO loginInfo) {
		log.info("TestService update start");
		AccountDTO inputdto = new AccountDTO();
		inputdto.setId(loginInfo.getId());
		inputdto.setName(loginInfo.getUsername());
		inputdto.setPass(loginInfo.getPassword());
		AccountDTO account = accountRepository.save(inputdto);
		log.debug(account.toString());
		log.info("TestService update end");
	}
	
	public int delete(Long accountId) {
		log.info("TestService delete start");
		int effectRow = accountRepository.deleteUserById(accountId);
		log.debug(" "+ effectRow);
    	log.info("TestService delete end");
    	return effectRow ;
	}
	
	public AccountDTO search(Long accountId) {
		log.info("TestService search start");
		AccountDTO account = accountRepository.findByid(accountId);
		log.debug("|"+account.toString()+"|");
		log.info("TestService search end");
		return account;
	}
	
}

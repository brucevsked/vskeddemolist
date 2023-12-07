package com.vsked.auth.domain.repository;

import com.vsked.auth.domain.PO.AccountPO;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

public interface IAccountRepository {

    AccountPO findOne(Specification<AccountPO> spec);

    List<AccountPO> find(Specification<AccountPO> spec);

    void delete(AccountPO accountPO);

}

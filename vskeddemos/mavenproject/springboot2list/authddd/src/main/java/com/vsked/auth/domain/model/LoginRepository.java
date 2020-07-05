package com.vsked.auth.domain.model;

import com.vsked.auth.infrastructure.persistence.jpa.AccountDTO;

public interface LoginRepository {

    AccountDTO findByName(String name);
}

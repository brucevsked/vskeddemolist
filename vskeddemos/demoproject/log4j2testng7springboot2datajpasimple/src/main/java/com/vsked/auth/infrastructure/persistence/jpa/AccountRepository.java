package com.vsked.auth.infrastructure.persistence.jpa;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

public interface AccountRepository extends JpaRepository<AccountDTO,Long> {

	public List<AccountDTO> findAllBy();
	
    public AccountDTO findByid(long id);
    
    @Modifying
    @Transactional
    public int deleteUserById(long id);
    
}

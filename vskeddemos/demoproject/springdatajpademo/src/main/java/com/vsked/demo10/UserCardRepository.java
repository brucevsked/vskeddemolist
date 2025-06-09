package com.vsked.demo10;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserCardRepository extends JpaRepository<UserCardPO,UserCardPOPK> {
}

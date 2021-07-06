package com.vsked.repository;

import com.vsked.entity.SystemObjectAction;
import com.vsked.entity.SystemObjectActionPK;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SystemObjectActionRepository extends JpaRepository<SystemObjectAction, SystemObjectActionPK> {

    List<SystemObjectAction> findBySystemObjectId(Long systemObjectId);

    List<SystemObjectAction> findByObjectActionId(Long objectActionId);


}

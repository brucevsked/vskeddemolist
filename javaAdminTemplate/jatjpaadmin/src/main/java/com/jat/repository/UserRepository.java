package com.jat.repository;

import com.jat.repository.model.UserPO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserPO,Integer> {

    Page<UserPO> findByNameLikeAndPhoneLikeAndIsDelIsLikeAndUserAccountAccountNameLike(String userName, String phone, int isDel, String accountName, Pageable pageable);
    Page<UserPO> findByNameLikeAndPhoneLikeAndIsDelIs(String userName, String phone, int isDel, Pageable pageable);

}

package com.mmm.corebanking.daos.jpa;

import com.mmm.corebanking.entites.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository <Account,Long>{

    Account findByAccountId(Long accountId);
}

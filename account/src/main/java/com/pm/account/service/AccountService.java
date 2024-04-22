package com.pm.account.service;

import com.pm.account.entity.AccountEntity;
import com.pm.account.repository.AccountRepository;
import com.pm.common.dto.Account;
import com.pm.common.dto.response.Response;
import com.pm.common.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.pm.common.status.Message.SUCCESS;

@Service
public class AccountService {
    @Autowired
    AccountRepository accountRepository;

    @Autowired
    Utils<Account> accountUtils;

    public Response<Account> addAccount(Account account) {
        AccountEntity accountEntity = new AccountEntity();
        accountEntity.setBalance(account.getBalance());
        accountEntity.setName(account.getName());
        accountEntity.setEmail(account.getEmail());
        accountRepository.save(accountEntity);
        return accountUtils.generateSuccessResponse();
    }
}

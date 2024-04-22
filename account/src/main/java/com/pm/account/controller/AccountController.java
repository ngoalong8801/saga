package com.pm.account.controller;

import com.pm.account.service.AccountService;
import com.pm.common.dto.Account;
import com.pm.common.dto.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path = "/account")
public class AccountController {
    @Autowired
    AccountService accountService;

    @PostMapping(path = "/add")
    public @ResponseBody Response<Account> addAccount(@RequestBody  Account account) {
        return accountService.addAccount(account);
    }
}

package com.codegym.service.impl;

import com.codegym.entity.Account;
import com.codegym.entity.MyAccountDetail;
import com.codegym.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImpl implements UserDetailsService {
    @Autowired
    AccountRepository accountRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = this.accountRepository.findByUserName(username);
        if (account==null){
            throw new UsernameNotFoundException("user name not found"+username);
        }
        return new MyAccountDetail(account);
    }
}

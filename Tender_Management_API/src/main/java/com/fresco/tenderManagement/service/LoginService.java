package com.fresco.tenderManagement.service;

import com.fresco.tenderManagement.model.UserModel;
import com.fresco.tenderManagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;


public class LoginService implements UserDetailsService {

    
    private UserRepository userRepository;

    
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        
        return null;
    }
    
    private UserDetails buildUserForAuthentication(UserModel user,List<GrantedAuthority>authorities) {
        return null;
    }
        
    private List<GrantedAuthority>buildUserAuthority(String userRole){
	   return null;
   }
    
}

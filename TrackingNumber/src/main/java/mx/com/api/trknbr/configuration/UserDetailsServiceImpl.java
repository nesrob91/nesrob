/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.api.trknbr.configuration;

/**
 *
 * @author nroblerol
 */
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Collections;
import mx.com.api.trknbr.beans.User;
import mx.com.api.trknbr.service.GeneralServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

@Component
public class UserDetailsServiceImpl implements UserDetailsService{
    @Autowired
    private GeneralServiceImpl generalService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
    {
        User user = generalService.findByUsername(username);
        if(user == null)
        {
            throw new UsernameNotFoundException(username);
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getAuth(), Collections.emptyList());
    }
}

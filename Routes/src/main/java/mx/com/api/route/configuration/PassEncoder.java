/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.api.route.configuration;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 *
 * @author hibarra
 */
@Component
public class PassEncoder implements PasswordEncoder{

    @Override
    public String encode(CharSequence cs) {
        return new StringEncrypter("AX643kt$#").encrypt(cs.toString());
    }

    @Override
    public boolean matches(CharSequence cs, String string) {
        return string.equals(new StringEncrypter("AX643kt$#").encrypt(cs.toString()));
    }
    
}

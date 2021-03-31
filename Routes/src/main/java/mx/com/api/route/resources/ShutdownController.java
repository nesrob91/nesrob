/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.api.route.resources;

import io.swagger.v3.oas.annotations.Hidden;
import javax.validation.Valid;
import mx.com.api.route.beans.User;
import mx.com.api.route.service.GeneralService;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author nroblerol
 */
@RestController
@RequestMapping("/server")
@Hidden
public class ShutdownController implements ApplicationContextAware {
    
    private ApplicationContext context;
    
    @Autowired
    private PasswordEncoder passEncoder;
    @Autowired
    private GeneralService generalService;
    
    @PostMapping("/management/shutdownContext")
    public void shutdownContext() {
        ((ConfigurableApplicationContext) context).close();
    }

    @Override
    public void setApplicationContext(ApplicationContext ctx) throws BeansException {
        this.context = ctx;
    }
    
    @PostMapping("/management/registerUser")
    public ResponseEntity<Object> register(@Valid @RequestBody(required = true) User auth) {
        try{
            auth.setPassword(passEncoder.encode(auth.getPassword()));
            if(generalService.saveByUsername(auth))
                return ResponseEntity.status(HttpStatus.CREATED).build();
            else
                return ResponseEntity.status(HttpStatus.ACCEPTED).build();
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}

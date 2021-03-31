/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.api.route.beans;

import javax.validation.constraints.NotNull;
import lombok.Data;

/**
 *
 * @author nroblerol
 */
@Data
public class User {
    @NotNull
    private String username;
    @NotNull
    private String password;
}

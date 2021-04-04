package mx.com.elektra.mso.cb.common;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class BrmsCommon implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    @Value("${brms.url}")
    private String uri;
    @Value("${brms.ambiente}")
    private String ambiente;
    @Value("${brms.user}")
    private String usrBrms;
    @Value("${brms.psdbrms}")
    private String psdBrms;
    @Value("${sistemas.user}")
    private String usrSys;
    @Value("${sistemas.psdbrms}")
    private String psdSys;
    
    
    @Value("${app.write.console}")
    private boolean writeConsole;

}

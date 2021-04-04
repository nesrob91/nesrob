package mx.com.elektra.msd.qb.common;

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
    
    @Value("${app.write.console}")
    boolean writeConsole;
    
}

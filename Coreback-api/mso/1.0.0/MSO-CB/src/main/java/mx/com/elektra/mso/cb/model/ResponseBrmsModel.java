package mx.com.elektra.mso.cb.model;

import java.io.Serializable;

import lombok.Data;

@Data
public class ResponseBrmsModel implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private ResultBrmsModel result;
    private String log_message;
}

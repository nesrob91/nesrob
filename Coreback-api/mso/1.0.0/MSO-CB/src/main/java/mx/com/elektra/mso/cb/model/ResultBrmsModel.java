package mx.com.elektra.mso.cb.model;

import java.io.Serializable;

import lombok.Data;

@Data
public class ResultBrmsModel implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private String codigo;
    private String mensaje;
    private Object respuesta;
}

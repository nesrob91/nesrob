package mx.com.elektra.msd.qb.model;

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

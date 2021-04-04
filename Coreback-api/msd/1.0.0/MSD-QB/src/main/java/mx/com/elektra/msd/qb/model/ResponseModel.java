package mx.com.elektra.msd.qb.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseModel implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private String codigo;
    private String mensaje;
    private String folio;
    private Object detalles;
}

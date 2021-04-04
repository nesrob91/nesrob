package mx.com.elektra.msd.qb.common;

import mx.elektra.dependencias.contenedorresponse.codigosrespuesta.CodigosRespuesta;

import org.springframework.http.HttpStatus;

public enum CodigosResponseCommon implements CodigosRespuesta {

    CODIGO_200(String.valueOf(HttpStatus.OK.value()), ConstantesCommon.SUCCESS_OPERATION, HttpStatus.OK),

    CODIGO_400(String.valueOf(HttpStatus.BAD_REQUEST.value()), HttpStatus.BAD_REQUEST.getReasonPhrase(), HttpStatus.BAD_REQUEST),

    CODIGO_401(String.valueOf(HttpStatus.UNAUTHORIZED.value()), HttpStatus.UNAUTHORIZED.getReasonPhrase(), HttpStatus.UNAUTHORIZED),

    CODIGO_404(String.valueOf(HttpStatus.NOT_FOUND.value()), HttpStatus.NOT_FOUND.getReasonPhrase(), HttpStatus.NOT_FOUND),

    CODIGO_500(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()), HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(), HttpStatus.INTERNAL_SERVER_ERROR),

    CODIGO_500_CUSTOMIZED(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()), HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(), HttpStatus.INTERNAL_SERVER_ERROR),
    CODIGO_400_CUSTOMIZED(String.valueOf(HttpStatus.BAD_REQUEST.value()), HttpStatus.BAD_REQUEST.getReasonPhrase(), HttpStatus.BAD_REQUEST);;

    private String codigo;
    private String descripcion;
    private HttpStatus httpStatus;

    CodigosResponseCommon(String codigo, String descripcion, HttpStatus httpStatus) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.httpStatus = httpStatus;
    }

    public String getCodigo() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.getHttpStatus().value());
        stringBuilder.append(".");
        stringBuilder.append(ConstantesCommon.NOMBRE_MSD);
        stringBuilder.append(".");
        stringBuilder.append(ConstantesCommon.ID_MSD);
        stringBuilder.append(codigo);
        return stringBuilder.toString();
    }

    public String getDescripcion() {
        return descripcion;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    /**
     * Gets by code.
     *
     * @param codigo the codigo
     * @return the by code
     */
    public static CodigosResponseCommon getByCode(String codigo) {
        for (CodigosResponseCommon code : CodigosResponseCommon.values()) {
            if (code.codigo.equals(codigo)) {
                return code;
            }
        }
        return CODIGO_500;
    }

    public CodigosResponseCommon getCustomizedCodigo500(String codigo) {
        CodigosResponseCommon error = CODIGO_500_CUSTOMIZED;
        error.setCodigo(codigo);
        return error;
    }

    public CodigosResponseCommon getCustomizedCodigo400(String codigo) {
        CodigosResponseCommon error = CODIGO_400_CUSTOMIZED;
        error.setCodigo(codigo);
        return error;
    }

}

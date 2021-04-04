package mx.com.elektra.mso.cb.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import mx.com.elektra.mso.cb.common.CodigosResponseCommon;
import mx.com.elektra.mso.cb.common.ConstantesCommon;
import mx.com.elektra.mso.cb.common.FolioCommon;
import mx.com.elektra.mso.cb.configuration.ApplicationSetup;
import mx.com.elektra.mso.cb.service.TestService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import mx.elektra.dependencias.contenedorresponse.issues.ExceptionGenerica;
import mx.elektra.dependencias.contenedorresponse.model.ResponseService;

@RestController
@RequestMapping("/Test")
public class TestController {

    @Value("${info.app.version}")
    private String appVersion;

    @Autowired
    FolioCommon folio;

    @Autowired
    ApplicationSetup applicationSetup;

    @Autowired
    TestService testService;

    @ApiOperation(nickname = "Test de monitoreo", value = "monitoreo", notes = "Regla: Obtener la informaci�n del JAR.", response = List.class)
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Micro-Service working fine.", response = List.class),
        @ApiResponse(code = 401, message = "Unauthorized user.", response = ExceptionGenerica.class),
        @ApiResponse(code = 400, message = "Bad request.", response = ExceptionGenerica.class),
        @ApiResponse(code = 404, message = "Resource not found.", response = ExceptionGenerica.class),
        @ApiResponse(code = 500, message = "Internal Server Error.", response = ExceptionGenerica.class)})
    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public Object test() {
        Map<String, String> testMap = Map.of("Aplicacion", ConstantesCommon.NOMBRE_MSO, "App Version:", appVersion);
        return new ResponseService(CodigosResponseCommon.CODIGO_200, folio.getFolio(), testMap);
    }
}

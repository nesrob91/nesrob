package mx.com.elektra.msd.qb.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.com.elektra.msd.qb.common.CodigosResponseCommon;
import mx.com.elektra.msd.qb.common.ConstantesCommon;
import mx.com.elektra.msd.qb.common.FolioCommon;
import mx.com.elektra.msd.qb.service.TestService;

import mx.elektra.dependencias.contenedorresponse.model.ResponseService;

@RestController
@RequestMapping("/Test")
public class TestController {

    @Value("${info.app.version}")
    private String appVersion;

    @Autowired
    private FolioCommon folioCommon;

    @Autowired
    private TestService testService;

    @GetMapping
    public ResponseService test() {
        Map<String, String> testMap = Map.of("Aplicacion", ConstantesCommon.NOMBRE_MSD, "App Version:", appVersion, "TestDB:", testService.getTest());
        return new ResponseService(CodigosResponseCommon.CODIGO_200, folioCommon.getFolio(), testMap);
    }
}

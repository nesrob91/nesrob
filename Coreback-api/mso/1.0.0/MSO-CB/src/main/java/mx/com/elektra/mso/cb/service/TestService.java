package mx.com.elektra.mso.cb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import mx.grupoelektra.helpersecure.DelegateCipher;
import mx.com.elektra.mso.cb.configuration.ApplicationSetup;

@Service
public class TestService {

    @Autowired
    DelegateCipher delegateCipher;

    @Autowired
    ApplicationSetup applicationSetup;

    public String getOther() {
        try {
            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            headers.add("MasterKey", delegateCipher.generateKey(applicationSetup.getGenerateKey()));
            HttpEntity<String> entity = new HttpEntity<String>(null, headers);
            ResponseEntity<String> result = restTemplate.exchange("http://localhost:10443/MSO-CB/v1/ejemplo", HttpMethod.GET, entity, String.class);
            return result.getBody();
        } catch (Exception e) {
            return "Fallo el consumo de el mso";
        }

    }

}

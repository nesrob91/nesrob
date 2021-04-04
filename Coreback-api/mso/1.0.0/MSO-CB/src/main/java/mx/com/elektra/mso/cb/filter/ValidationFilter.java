package mx.com.elektra.mso.cb.filter;

import java.io.IOException;
import java.security.SecureRandom;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.ThreadContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import mx.com.elektra.mso.cb.common.FolioCommon;
import mx.com.elektra.mso.cb.configuration.ApplicationSetup;
import com.gobierno.apis.seguridad.JsonWebToken;

import mx.grupoelektra.helpersecure.DelegateCipher;

@Component
public class ValidationFilter extends OncePerRequestFilter {

    @Autowired
    DelegateCipher delegateCipher;

    @Autowired
    FolioCommon folioCommon;

    @Autowired
    FlagFilter flagFilter;

    @Autowired
    ApplicationSetup applicationSetup;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        if (!flagFilter.isActive()) {
            filterChain.doFilter(request, response);
            return;
        }

        if (request.getPathInfo().contains("/Test") || request.getPathInfo().contains("/test")) {
            filterChain.doFilter(request, response);
            return;
        }

        String bearerJwt = (request.getHeader("Bearer") != null ? request.getHeader("Bearer") : "");
        String masterKey = (request.getHeader("MasterKey") != null ? request.getHeader("MasterKey") : "");

        boolean validatorJWT = (!bearerJwt.isEmpty() && masterKey.isEmpty());
        boolean validadorMasrter = (bearerJwt.isEmpty() && !masterKey.isEmpty());

        if (validadorMasrter && !validatorJWT) {
            try {
                if (delegateCipher.descifrar(masterKey).equals(applicationSetup.getGenerateKey())) {
                    filterChain.doFilter(request, response);
                }
            } catch (Exception e) {
                throw new ServletException("Error masrteskey");
            }
        } else {
            try {
                JsonWebToken.validarToken(request, response, filterChain, applicationSetup.getGenerateKey());
            } catch (Exception e) {
                SecureRandom rand = new SecureRandom();
                int id = rand.nextInt(999999999);
                ThreadContext.put("id", id + "");
                ThreadContext.put("inicioTiempoT", System.currentTimeMillis() + "");
                throw e;
            }
        }

    }

}

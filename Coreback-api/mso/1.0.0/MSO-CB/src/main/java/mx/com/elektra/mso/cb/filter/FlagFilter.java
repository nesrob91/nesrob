package mx.com.elektra.mso.cb.filter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class FlagFilter {

    @Value("${jwt.active}")
    private boolean active;
}

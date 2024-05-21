package hr.riteh.praksafakture.utils;

import com.nimbusds.jose.*;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jose.crypto.MACVerifier;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;
import hr.riteh.praksafakture.config.ServiceConfiguration;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Date;

@Component
@Log4j2
public class JWTUtils {

    private final ServiceConfiguration serviceConfig;

    @Autowired
    public JWTUtils(ServiceConfiguration serviceConfig) {
        this.serviceConfig = serviceConfig;
    }

    public String generateToken(String username) throws JOSEException {
        JWSSigner signer = new MACSigner(serviceConfig.getSecret());

        JWTClaimsSet claimsSet = new JWTClaimsSet.Builder()
                .subject(username)
                .issueTime(new Date())
                .expirationTime(new Date(new Date().getTime() + 3600 * 1000)) // 1 hour
                .build();

        SignedJWT signedJWT = new SignedJWT(new JWSHeader(JWSAlgorithm.HS256), claimsSet);

        signedJWT.sign(signer);

        return signedJWT.serialize();
    }

    public boolean validateToken(String token, String username) {
    try {
        SignedJWT signedJWT = SignedJWT.parse(token);

        JWSVerifier verifier = new MACVerifier(serviceConfig.getSecret());

        if (!signedJWT.verify(verifier)) {
            return false;
        }

        JWTClaimsSet claimsSet = signedJWT.getJWTClaimsSet();

        return username.equals(claimsSet.getSubject()) && new Date().before(claimsSet.getExpirationTime());
    } catch (JOSEException | ParseException e) {
        log.error("Error while validating token", e);
        return false;
    }
}

public String getUsernameFromToken(String token) {
    try {
        SignedJWT signedJWT = SignedJWT.parse(token);
        JWTClaimsSet claimsSet = signedJWT.getJWTClaimsSet();
        return claimsSet.getSubject();
    } catch (ParseException e) {
        log.error("Error while getting username from token", e);
        return null;
    }
}
}
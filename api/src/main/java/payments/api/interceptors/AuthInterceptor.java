
package payments.api.interceptors;
/*
 * import java.io.IOException;
 * 
 * import javax.annotation.PostConstruct; import javax.inject.Inject; import
 * javax.ws.rs.container.ContainerRequestContext; import
 * javax.ws.rs.container.ContainerRequestFilter; import
 * javax.ws.rs.container.PreMatching; import javax.ws.rs.core.Response; import
 * javax.ws.rs.core.Response.Status; import javax.ws.rs.ext.Provider;
 * 
 * import org.slf4j.Logger; import org.slf4j.LoggerFactory;
 * 
 * import com.nimbusds.oauth2.sdk.ParseException; import
 * com.okta.jwt.JoseException; import com.okta.jwt.Jwt; import
 * com.okta.jwt.JwtHelper; import com.okta.jwt.JwtVerifier;
 * 
 * import payments.api.utils.AppConfig;
 * 
 * @Provider
 * 
 * @PreMatching public class AuthInterceptor implements ContainerRequestFilter {
 * 
 * private Logger logger = LoggerFactory.getLogger(getClass());
 * 
 * private JwtVerifier jwtVerifier;
 * 
 * @Inject AppConfig appConfig;
 * 
 * @PostConstruct public void init() { String clientId =
 * appConfig.getConfigValue("app.okta.client.id"); String issuerUrl =
 * appConfig.getConfigValue("app.okta.issuer.url"); try { jwtVerifier = new
 * JwtHelper().setClientId(clientId).setIssuerUrl(issuerUrl).build();
 * logger.info("JWT verifier constructed"); } catch (ParseException |
 * IOException e) { throw new
 * RuntimeException("Failed to configure JWT verifier"); } }
 * 
 * @Override public void filter(ContainerRequestContext requestContext) {
 * 
 * Response unauthorizedResponse = Response.status(Status.UNAUTHORIZED).build();
 * 
 * String authHeader = requestContext.getHeaderString("authorization");
 * 
 * if (authHeader == null) { requestContext.abortWith(unauthorizedResponse);
 * return; }
 * 
 * String accessToken = authHeader.substring(authHeader.indexOf("Bearer ") + 7);
 * 
 * try { Jwt jwt = jwtVerifier.decodeAccessToken(accessToken);
 * logger.info("Hello, " + jwt.getClaims().get("sub")); } catch (JoseException
 * joseException) { joseException.printStackTrace();
 * logger.error("Failed to decode access token ");
 * requestContext.abortWith(unauthorizedResponse); } }
 * 
 * }
 */
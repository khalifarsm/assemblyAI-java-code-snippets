import java.net.URLEncoder;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.Signature;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Base64;

public class GivingTemporaryAccessGCS {
    static final String CLIENT_ACCOUNT = "user@user.iam.gserviceaccount.com";
    static final String PRIVATE_KEY = "-----BEGIN PRIVATE KEY-----\nMIIEvgIB0Bzx0sGhA\n-----END PRIVATE KEY-----\n";
    static final String BASE_GCS_URL = "https://storage.googleapis.com";
    static final String OBJECT_PATH = "/bucket/file_path.mp4";
    static final String FULL_OBJECT_URL = BASE_GCS_URL + OBJECT_PATH;

    public String createPreSignedURL() throws Exception {
        String expiryTime = getExpiryTimeInEpoch();
        String stringToSign = getSignInput(expiryTime);
        PrivateKey pk = getPrivateKey();
        String signedString = getSignedString(stringToSign, pk);
        signedString = URLEncoder.encode(signedString, "UTF-8");
        String signedUrl = getSignedUrl(signedString, expiryTime);

        return signedUrl;
    }

    private static String getExpiryTimeInEpoch() {
        long now = System.currentTimeMillis();
        long expiredTimeInSeconds = (now + 60 * 1000L) / 1000;
        String expiryTime = expiredTimeInSeconds + "";
        return expiryTime;
    }

    // The signed URL format as required by Google.
    private static String getSignedUrl(String signedString, String expiryTime) {
        String signedUrl = FULL_OBJECT_URL
                + "?GoogleAccessId=" + CLIENT_ACCOUNT
                + "&Expires=" + expiryTime
                + "&Signature=" + signedString;
        return signedUrl;
    }

    // We sign the expiry time and bucket object path
    private static String getSignInput(String expiryTime) {
        return "GET" + "\n"
                + "" + "\n"
                + "" + "\n"
                + expiryTime + "\n"
                + OBJECT_PATH;
    }

    private static String getSignedString(String input, PrivateKey pk) throws Exception {
        Signature privateSignature = Signature.getInstance("SHA256withRSA");
        privateSignature.initSign(pk);
        privateSignature.update(input.getBytes("UTF-8"));
        byte[] s = privateSignature.sign();
        return Base64.getEncoder().encodeToString(s);
    }

    private static PrivateKey getPrivateKey() throws Exception {
        String realPK = PRIVATE_KEY.replaceAll("-----END PRIVATE KEY-----", "")
                .replaceAll("-----BEGIN PRIVATE KEY-----", "").replaceAll("\n", "");
        byte[] b1 = Base64.getDecoder().decode(realPK);
        PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(b1);
        KeyFactory kf = KeyFactory.getInstance("RSA");
        return kf.generatePrivate(spec);
    }
}

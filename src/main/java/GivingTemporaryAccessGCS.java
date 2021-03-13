import java.net.URLEncoder;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.Signature;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Base64;

public class GivingTemporaryAccessGCS {
    static final String CLIENT_ACCOUNT = "axentless@axentless.iam.gserviceaccount.com";
    static final String PRIVATE_KEY = "-----BEGIN PRIVATE KEY-----\nMIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQC6wipg3WhNd3fp\nAEWNExbkpld9AVFngfsTz9r8vNzPgmHIvqYEZV67jv9BNG50f04vAWiIeni2ro5B\nOX55cxYfrxxpiUiYaabCRWEBZMjphZTlAMvCkxsTcDEAuXedtV/Terzx8v50k09b\n3MOxRxJupw6jD3LE6aJ8mAjt+Dy9vUA1+BAJH9TcPJ4HZlmHNYuGmWHa4PH3X6c3\nvi2Qtg+AfCe98QZg1G5BSQew0VoHhyEHHLTyiTmjlM12sAThXCd+z93yJ1yYLMxM\neZV7Okle14E/p9c3glMCRRfSeViKSQoskRJnEJJjbl7LMp2Bv+1Q+Fao325M2HjG\nyKi6SYy9AgMBAAECggEABogq+5yoJ2l3HVmf6nQRTWmkpAp17T+xEeYnsRuZQigR\nFniAjaUj/+hbn3gKKEiZlJr2gSt+FFmc6nAXLyqUyq07ulSNtZ2gXP7DNU1v73xM\nvbOzl2MWGS3H26V2UbhEbpJGOyogtzVocFHo2vGdlewsNAzNb/tXQ7H87KHNh2Sg\nntRhtgzKMnR/WTggE5klPb+FlSafm4rWAMMnYDAIc1fyYzEo5Zj5snerqZYnV5lM\ncYbBE72cUPYuLXD5X+IcLz8qkbMIXlqei02hWWvMnbdYmGei5xfuh4Ml97ziNcMm\nNGHV3DjSEbYIP/R5DJ6o+sESMlZqpt6Vd1MSnjQYOwKBgQDpvwDkZrivCu44Eb5w\n47m422G0QMRFpYyr9ltCyMyzCCqxJg9p97h1YuzPTwnU9Q4pbG5ldyuPo2PWSOrq\nkSCTEAZWcZJarxUjqbqDap7Q6Fi4BmHJDy6mANhDNJj2QSxggSGiBC1hdbdjcZwC\nNLWGLzWVI08rXTXZL73S6tYocwKBgQDMifOhFBkNcWc213d6n3AwPDq2Z+L/Dzqo\nNPQJNs5a9Rmh380NElz1VpqGm2RaC5tXv0ESPfSeRApFFXrtbpzZgdPX7ibqfO1X\ncxfmEu+js6WZUfejC3mPeKDzyhoE4dtGamlmSoBa2BLnGWaLZOYv81mg/pRzaZsa\nYQUSPPiaDwKBgQCVLYOCQVSo0k8Klbh3D79eDRUkFxmsYWWP8iB4VPLfZ9znRiUc\nOi8NK996xzS9JtCs+zjRpOa2O07iWZMjtQ+XC+kfjkgbfBX/trkEWi2VolPMzrXl\nvbzF0VA0RANDVoDd7kvqvMPBqYErBDzO45jeVI7b6bcDM+/D9sYtMBcRpQKBgBFi\nQCSWkrKDyuPsWClB18UhuVO7bJ2E69VT+tG1qMAuSKlrXgAYaXIolCWQm2zTw7Yn\neR5Vya6R1dWdR79aQVZzJFAb247eY0WlcIiLX3aoVBC92LAwz3oUJInTyXZUw9Au\nRxr8hgAykRi3HfIG91Fn+1wlhvRwK1CIome0auSdAoGBAIKPXJHb42WadRUkOspi\n6Lylfj2V9arycBRZQmEiCs3SFm1Wp7gqrDlWah/My2jBmnVFBkuPtozLVz2qEFPj\n62zjSz29W5jD+tZ6k6RU/yeQvOOMhOrg6JeTlbTcxWF2Mv4J1TLAk5yrrNUY2gKu\nlpC5oeVmTNnly7b0Bzx0sGhA\n-----END PRIVATE KEY-----\n";
    static final String BASE_GCS_URL = "https://storage.googleapis.com";
    static final String OBJECT_PATH = "/users_videos/u59_v3_e1_t1606393372086.csv";
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

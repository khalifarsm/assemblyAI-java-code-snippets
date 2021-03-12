import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import java.io.File;
import java.nio.file.Files;
import java.util.Base64;

public class SynchronousTranscription {

    private static final String YOUR_API_TOKEN = "615d6b6573404fa9a1d7cc340b4023fb";

    public void synchronousAPICall() throws Exception {

        // --------------------------------------- START OF CODE SNIPPET -----------------------------------------
        byte[] fileContent = Files.readAllBytes(new File("path/to/foo.wav").toPath());
        String base64Encoded = Base64.getEncoder().encodeToString(fileContent);

        String responseJson = Unirest
                .post("https://api.assemblyai.com/v2/stream")
                .header("authorization", YOUR_API_TOKEN)
                .header("content-type", "application/json")
                .body("{\"audio_data\":\"" + base64Encoded + "\"}")
                .asString()
                .getBody();
        // --------------------------------------- END OF CODE SNIPPET -----------------------------------------

        System.out.println(responseJson);
    }
}

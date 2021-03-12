import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class RedactPIIFromText {

    private static final String YOUR_API_TOKEN = "615d6b6573404fa9a1d7cc340b4023fb";
    private static final String YOUR_TRANSCRIPT_ID_HERE = "ihtczepza-8f3a-4e78-bb2c-eef88b3a4f2d";

    public void redactPIIFromTranscription() throws UnirestException {

        // --------------------------------------- START OF CODE SNIPPET -----------------------------------------
        String responseJson = Unirest
                .post("https://api.assemblyai.com/v2/transcript")
                .header("authorization", YOUR_API_TOKEN)
                .header("content-type", "application/json")
                .body("{\"audio_url\": \"https://app.assemblyai.com/static/media/phone_demo_clip_1.wav\"," +
                        " \"redact_pii\": true," +
                        " \"redact_pii_policies\": [\"all\"]}")
                .asString()
                .getBody();
        // --------------------------------------- END OF CODE SNIPPET -----------------------------------------

        System.out.println(responseJson);
    }

    public void customizeHowRedactedPIIIsReplaced() throws UnirestException {

        // --------------------------------------- START OF CODE SNIPPET -----------------------------------------
        String responseJson = Unirest
                .post("https://api.assemblyai.com/v2/transcript")
                .header("authorization", YOUR_API_TOKEN)
                .header("content-type", "application/json")
                .body("{\"audio_url\": \"https://app.assemblyai.com/static/media/phone_demo_clip_1.wav\"," +
                        " \"redact_pii\": true," +
                        " \"redact_pii_policies\": [\"all\"]," +
                        " \"redact_pii_sub\": \"entity_name\"}")
                .asString()
                .getBody();
        // --------------------------------------- END OF CODE SNIPPET -----------------------------------------

        System.out.println(responseJson);
    }

    public void redactPIIFromAudio() throws UnirestException {

        // --------------------------------------- START OF CODE SNIPPET -----------------------------------------
        String responseJson = Unirest
                .post("https://api.assemblyai.com/v2/transcript")
                .header("authorization", YOUR_API_TOKEN)
                .header("content-type", "application/json")
                .body("{\"audio_url\": \"https://app.assemblyai.com/static/media/phone_demo_clip_1.wav\"," +
                        " \"redact_pii\": true," +
                        " \"redact_pii_audio\": true}")
                .asString()
                .getBody();
        // --------------------------------------- END OF CODE SNIPPET -----------------------------------------

        System.out.println(responseJson);
    }
}

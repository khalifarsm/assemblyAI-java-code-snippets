import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class GettingSpeakerLabels {

    private static final String YOUR_API_TOKEN = "615d6b6573404fa9a1d7cc340b4023fb";
    private static String YOUR_TRANSCRIPT_ID_HERE = "ic0lal4kp-6d46-4d1c-9e64-4f53f6434035";

    public void submitAudioFileWithSpeakerLabel() throws UnirestException {

        // --------------------------------------- START OF CODE SNIPPET -----------------------------------------
        String responseJson = Unirest
                .post("https://api.assemblyai.com/v2/transcript")
                .header("authorization", YOUR_API_TOKEN)
                .header("content-type", "application/json")
                .body("{\"audio_url\": \"https://app.assemblyai.com/static/media/phone_demo_clip_1.wav\"," +
                        " \"speaker_labels\": true}")
                .asString()
                .getBody();
        // --------------------------------------- END OF CODE SNIPPET -----------------------------------------

        YOUR_TRANSCRIPT_ID_HERE = responseJson.split("\"")[3];
        System.out.println(responseJson);
    }

    public void getTranscriptionResult() throws UnirestException {

        // --------------------------------------- START OF CODE SNIPPET -----------------------------------------
        String responseJson = Unirest
                .get("https://api.assemblyai.com/v2/transcript/" + YOUR_TRANSCRIPT_ID_HERE)
                .header("authorization", YOUR_API_TOKEN)
                .header("content-type", "application/json")
                .asString()
                .getBody();
        // --------------------------------------- END OF CODE SNIPPET -----------------------------------------

        System.out.println(responseJson);
    }
}

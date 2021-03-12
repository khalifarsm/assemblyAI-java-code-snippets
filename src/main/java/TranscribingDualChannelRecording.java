import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class TranscribingDualChannelRecording {

    private static final String YOUR_API_TOKEN = "615d6b6573404fa9a1d7cc340b4023fb";
    private static final String YOUR_TRANSCRIPT_ID_HERE = "ihdj06xgc-1a9b-41b6-b2a8-868542aae347";

    public void submitDualChannelAudioFileForTranscription() throws UnirestException {

        // --------------------------------------- START OF CODE SNIPPET -----------------------------------------
        String responseJson = Unirest
                .post("https://api.assemblyai.com/v2/transcript")
                .header("authorization", YOUR_API_TOKEN)
                .header("content-type", "application/json")
                .body("{\"audio_url\": \"https://app.assemblyai.com/static/media/phone_demo_clip_1.wav\",\"dual_channel\": true}")
                .asString()
                .getBody();
        // --------------------------------------- END OF CODE SNIPPET -----------------------------------------

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

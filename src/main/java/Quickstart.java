import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class Quickstart {

    private static final String YOUR_API_TOKEN = "615d6b6573404fa9a1d7cc340b4023fb";
    private static final String YOUR_TRANSCRIPT_ID_HERE = "ihtczepza-8f3a-4e78-bb2c-eef88b3a4f2d";

    public void submitAudioFileForTranscription() throws UnirestException {

        String responseJson = Unirest
                .post("https://api.assemblyai.com/v2/transcript")
                .header("authorization", YOUR_API_TOKEN)
                .header("content-type", "application/json")
                .body("{\"audio_url\":\"https://s3-us-west-2.amazonaws.com/blog.assemblyai.com/audio/8-7-2018-post/7510.mp3\"}")
                .asString()
                .getBody();

        System.out.println(responseJson);
    }

    public void getTranscriptionResult() throws UnirestException {

        String responseJson = Unirest
                .get("https://api.assemblyai.com/v2/transcript/" + YOUR_TRANSCRIPT_ID_HERE)
                .header("authorization", YOUR_API_TOKEN)
                .header("content-type", "application/json")
                .asString()
                .getBody();

        System.out.println(responseJson);
    }
}

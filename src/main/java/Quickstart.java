import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import java.util.HashMap;
import java.util.Map;

public class Quickstart {

    private static final String YOUR_API_TOKEN = "615d6b6573404fa9a1d7cc340b4023fb";

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
}

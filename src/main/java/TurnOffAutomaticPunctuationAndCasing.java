import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class TurnOffAutomaticPunctuationAndCasing {

    private static final String YOUR_API_TOKEN = "615d6b6573404fa9a1d7cc340b4023fb";

    public void submitAudioFileForTranscription() throws UnirestException {

        // --------------------------------------- START OF CODE SNIPPET -----------------------------------------
        String responseJson = Unirest
                .post("https://api.assemblyai.com/v2/transcript")
                .header("authorization", YOUR_API_TOKEN)
                .header("content-type", "application/json")
                .body("{\"audio_url\": \"https://s3-us-west-2.amazonaws.com/blog.assemblyai.com/audio/8-7-2018-post/7510.mp3\"," +
                        " \"punctuate\": false," +
                        " \"format_text\": false}")
                .asString()
                .getBody();
        // --------------------------------------- END OF CODE SNIPPET -----------------------------------------

        System.out.println(responseJson);
    }
}

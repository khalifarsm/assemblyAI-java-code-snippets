import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class BoostingAccuracyOfKeyworlds {

    private static final String YOUR_API_TOKEN = "615d6b6573404fa9a1d7cc340b4023fb";

    public void boostKeywords() throws UnirestException {

        // --------------------------------------- START OF CODE SNIPPET -----------------------------------------
        String responseJson = Unirest
                .post("https://api.assemblyai.com/v2/transcript")
                .header("authorization", YOUR_API_TOKEN)
                .header("content-type", "application/json")
                .body("{\"audio_url\": \"https://app.assemblyai.com/static/media/phone_demo_clip_1.wav\"," +
                        " \"word_boost\": [\"sally mcmanus\", \"the IQEZ iPhone app\"]}")
                .asString()
                .getBody();
        // --------------------------------------- END OF CODE SNIPPET -----------------------------------------

        System.out.println(responseJson);
    }

    public void controlTheWeightOfBoost() throws UnirestException {

        // --------------------------------------- START OF CODE SNIPPET -----------------------------------------
        String responseJson = Unirest
                .post("https://api.assemblyai.com/v2/transcript")
                .header("authorization", YOUR_API_TOKEN)
                .header("content-type", "application/json")
                .body("{\"audio_url\": \"https://app.assemblyai.com/static/media/phone_demo_clip_1.wav\"," +
                        " \"word_boost\": [\"sally mcmanus\", \"the IQEZ iPhone app\"]," +
                        " \"boost_param\": \"high\"}")
                .asString()
                .getBody();
        // --------------------------------------- END OF CODE SNIPPET -----------------------------------------

        System.out.println(responseJson);
    }
}

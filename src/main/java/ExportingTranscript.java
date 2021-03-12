import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class ExportingTranscript {

    private static final String YOUR_API_TOKEN = "615d6b6573404fa9a1d7cc340b4023fb";
    private static final String YOUR_TRANSCRIPT_ID_HERE = "ihtczepza-8f3a-4e78-bb2c-eef88b3a4f2d";

    public void checkStatus() throws UnirestException {

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

    public void exportAsVTT() throws UnirestException {

        // --------------------------------------- START OF CODE SNIPPET -----------------------------------------
        String responseJson = Unirest
                .get("https://api.assemblyai.com/v2/transcript/" + YOUR_TRANSCRIPT_ID_HERE + "/vtt")
                .header("authorization", YOUR_API_TOKEN)
                .header("content-type", "application/json")
                .asString()
                .getBody();
        // --------------------------------------- END OF CODE SNIPPET -----------------------------------------

        System.out.println(responseJson);
    }

    public void exportAsSRT() throws UnirestException {

        // --------------------------------------- START OF CODE SNIPPET -----------------------------------------
        String responseJson = Unirest
                .get("https://api.assemblyai.com/v2/transcript/" + YOUR_TRANSCRIPT_ID_HERE + "/srt")
                .header("authorization", YOUR_API_TOKEN)
                .header("content-type", "application/json")
                .asString()
                .getBody();
        // --------------------------------------- END OF CODE SNIPPET -----------------------------------------

        System.out.println(responseJson);
    }
}

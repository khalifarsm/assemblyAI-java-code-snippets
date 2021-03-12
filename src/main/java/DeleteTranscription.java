import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class DeleteTranscription {

    private static final String YOUR_API_TOKEN = "615d6b6573404fa9a1d7cc340b4023fb";
    private static final String YOUR_TRANSCRIPT_ID_HERE = "ip29ik8ud-c155-4402-b658-ec9ee61ab849";

    public void delete() throws UnirestException {

        // --------------------------------------- START OF CODE SNIPPET -----------------------------------------
        String responseJson = Unirest
                .delete("https://api.assemblyai.com/v2/transcript/" + YOUR_TRANSCRIPT_ID_HERE)
                .header("authorization", YOUR_API_TOKEN)
                .asString()
                .getBody();
        // --------------------------------------- END OF CODE SNIPPET -----------------------------------------

        System.out.println(responseJson);
    }
}

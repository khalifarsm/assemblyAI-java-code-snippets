import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class UploadingAudioFileForTranscription {

    private static final String YOUR_API_TOKEN = "615d6b6573404fa9a1d7cc340b4023fb";
    private static final String YOUR_TRANSCRIPT_ID_HERE = "ihtczepza-8f3a-4e78-bb2c-eef88b3a4f2d";

    public void uploadAudioFile() throws UnirestException, IOException {

        String responseJson = Unirest
                .post("https://api.assemblyai.com/v2/upload")
                .header("authorization", YOUR_API_TOKEN)
                .body(Files.readAllBytes(new File("path/to/foo.wav").toPath()))
                .asString()
                .getBody();

        System.out.println(responseJson);
    }

    public void submitUploadForTranscription() throws UnirestException {

        String responseJson = Unirest
                .post("https://api.assemblyai.com/v2/transcript")
                .header("authorization", YOUR_API_TOKEN)
                .header("content-type", "application/json")
                .body("{\"audio_url\":\"https://cdn.assemblyai.com/upload/ccbbbfaf-f319-4455-9556-272d48faaf7f\"}")
                .asString()
                .getBody();

        System.out.println(responseJson);
    }
}

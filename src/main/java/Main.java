import com.mashape.unirest.http.Unirest;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class Main {

    private static void prepareHttpClient() {
        CloseableHttpClient httpClient = HttpClients
                .custom()
                .setDefaultRequestConfig(RequestConfig.custom().setCookieSpec(CookieSpecs.STANDARD).build())
                .build();
        Unirest.setHttpClient(httpClient);
    }

    public static void main(String[] args) throws Exception {
        prepareHttpClient();

        Quickstart quickstart = new Quickstart();
        quickstart.submitAudioFileForTranscription();
        quickstart.getTranscriptionResult();

        UploadingAudioFileForTranscription uploadingAudioFileForTranscription = new UploadingAudioFileForTranscription();
        uploadingAudioFileForTranscription.uploadAudioFile();
        uploadingAudioFileForTranscription.submitUploadForTranscription();

        TranscribingDualChannelRecording transcribingDualChannelRecording = new TranscribingDualChannelRecording();
        transcribingDualChannelRecording.submitDualChannelAudioFileForTranscription();
        transcribingDualChannelRecording.getTranscriptionResult();

        BoostingAccuracyOfKeywords boostingAccuracyOfKeywords = new BoostingAccuracyOfKeywords();
        boostingAccuracyOfKeywords.boostKeywords();
        boostingAccuracyOfKeywords.controlTheWeightOfBoost();

        SelectingModelThatBetterMatchesData selectingModelThatBetterMatchesData = new SelectingModelThatBetterMatchesData();
        selectingModelThatBetterMatchesData.choosingAnAcousticModel();
        selectingModelThatBetterMatchesData.choosingLanguageModel();

        GettingSpeakerLabels gettingSpeakerLabels = new GettingSpeakerLabels();
        gettingSpeakerLabels.submitAudioFileWithSpeakerLabel();
        gettingSpeakerLabels.getTranscriptionResult();

        GettingWebhooksWhenTranscriptionAreDone gettingWebhooksWhenTranscriptionAreDone = new GettingWebhooksWhenTranscriptionAreDone();
        gettingWebhooksWhenTranscriptionAreDone.specifyWebhookURL();
        gettingWebhooksWhenTranscriptionAreDone.getTranscriptionResult();

        TurnOffAutomaticPunctuationAndCasing turnOffAutomaticPunctuationAndCasing = new TurnOffAutomaticPunctuationAndCasing();
        turnOffAutomaticPunctuationAndCasing.submitAudioFileForTranscription();

        RedactPIIFromText redactPIIFromText = new RedactPIIFromText();
        redactPIIFromText.redactPIIFromTranscription();
        redactPIIFromText.customizeHowRedactedPIIIsReplaced();
        redactPIIFromText.redactPIIFromAudio();

        ExportingTranscript exportingTranscript = new ExportingTranscript();
        exportingTranscript.checkStatus();
        exportingTranscript.exportAsVTT();
        exportingTranscript.exportAsSRT();

        AutoDetectingKeyWords autoDetectingKeyWords = new AutoDetectingKeyWords();
        autoDetectingKeyWords.submitAudioFileForTranscriptionAndEnableAutoHighlight();
        autoDetectingKeyWords.getTranscriptionResultAndHighLights();

        SynchronousTranscription synchronousTranscription = new SynchronousTranscription();
        synchronousTranscription.synchronousAPICall();

        DeleteTranscription deleteTranscription = new DeleteTranscription();
        deleteTranscription.delete();

//        GivingTemporaryAccessGCS givingTemporaryAccessGCS = new GivingTemporaryAccessGCS();
//        String url = givingTemporaryAccessGCS.createPreSignedURL();
//        System.out.println(url);
    }
}

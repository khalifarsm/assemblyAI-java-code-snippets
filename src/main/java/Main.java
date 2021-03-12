import com.mashape.unirest.http.exceptions.UnirestException;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws UnirestException, IOException {
//        Quickstart quickstart = new Quickstart();
//        quickstart.submitAudioFileForTranscription();
//        quickstart.getTranscriptionResult();

//        UploadingAudioFileForTranscription uploadingAudioFileForTranscription = new UploadingAudioFileForTranscription();
//        uploadingAudioFileForTranscription.uploadAudioFile();
//        uploadingAudioFileForTranscription.submitUploadForTranscription();

//        TranscribingDualChannelRecording transcribingDualChannelRecording = new TranscribingDualChannelRecording();
//        transcribingDualChannelRecording.submitDualChannelAudioFileForTranscription();
//        transcribingDualChannelRecording.getTranscriptionResult();

//        BoostingAccuracyOfKeyworlds boostingAccuracyOfKeyworlds = new BoostingAccuracyOfKeyworlds();
//        boostingAccuracyOfKeyworlds.boostKeywords();
//        boostingAccuracyOfKeyworlds.controlTheWeightOfBoost();

//        SelectingModelThatBetterMatchesData selectingModelThatBetterMatchesData=new SelectingModelThatBetterMatchesData();
//        selectingModelThatBetterMatchesData.choosingAnAcousticModel();
//        selectingModelThatBetterMatchesData.choosingLanguageModel();

//        GettingSpeakerLabels gettingSpeakerLabels=new GettingSpeakerLabels();
//        gettingSpeakerLabels.submitAudioFileWithSpeakerLabel();
//        gettingSpeakerLabels.getTranscriptionResult();

//        GettingWebhooksWhenTranscriptionAreDone gettingWebhooksWhenTranscriptionAreDone=new GettingWebhooksWhenTranscriptionAreDone();
//        gettingWebhooksWhenTranscriptionAreDone.specifyWebhookURL();
//        gettingWebhooksWhenTranscriptionAreDone.getTranscriptionResult();

//        TurnOffAutomaticPunctuationAndCasing turnOffAutomaticPunctuationAndCasing =new TurnOffAutomaticPunctuationAndCasing();
//        turnOffAutomaticPunctuationAndCasing.submitAudioFileForTranscription();

        RedactPIIFromText redactPIIFromText=new RedactPIIFromText();
        redactPIIFromText.redactPIIFromTranscription();
        redactPIIFromText.customizeHowRedactedPIIIsReplaced();
        redactPIIFromText.redactPIIFromAudio();
    }
}

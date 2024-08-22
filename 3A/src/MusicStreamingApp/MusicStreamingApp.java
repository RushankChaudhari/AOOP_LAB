package MusicStreamingApp;

public class MusicStreamingApp {
    public static void main(String[] args) {
    	
        MusicSource localFile = new LocalFileAdapter(new LocalFilePlayer());
        MusicSource onlineStream = new OnlineStreamingAdapter(new OnlineStreamingPlayer());
        MusicSource radioStation = new RadioStationAdapter(new RadioStationPlayer());

        MusicSource localFileWithEqualizer = new EqualizerDecorator(localFile);
        MusicSource onlineStreamWithVolumeControl = new VolumeControlDecorator(onlineStream);
        MusicSource radioStationWithAllFeatures = new VolumeControlDecorator(new EqualizerDecorator(radioStation));

        localFileWithEqualizer.play();
        onlineStreamWithVolumeControl.play();
        radioStationWithAllFeatures.play();
    }
}


class LocalFilePlayer {
    public void playLocalFile() {
        System.out.println("Playing local file.");
    }
}

class OnlineStreamingPlayer {
    public void playOnlineStream() {
        System.out.println("Playing online stream.");
    }
}

class RadioStationPlayer {
    public void playRadioStation() {
        System.out.println("Playing radio station.");
    }
}


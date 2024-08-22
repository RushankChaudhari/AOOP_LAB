package MusicApp;

public class MusicStreamingApp {
    public static void main(String[] args) {

    	MusicSource localFile = new LocalFileAdapter(new LocalFilePlayer());
        MusicSource onlineStream = new OnlineStreamingAdapter(new OnlineStreamingPlayer());
        MusicSource radioStation = new RadioStationAdapter(new RadioStationPlayer());

        MusicPlayer localFilePlayer = new BasicMusicPlayer(localFile);
        MusicPlayer onlineStreamPlayer = new BasicMusicPlayer(onlineStream);
        MusicPlayer radioStationPlayer = new BasicMusicPlayer(radioStation);

        MusicPlayer localFileWithEqualizer = new EqualizerDecorator(localFilePlayer);
        MusicPlayer onlineStreamWithVolumeControl = new VolumeControlDecorator(onlineStreamPlayer);
        MusicPlayer radioStationWithAllFeatures = new VolumeControlDecorator(new EqualizerDecorator(radioStationPlayer));

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


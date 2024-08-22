package MusicApp;

public class LocalFileAdapter implements MusicSource {
    private LocalFilePlayer localFilePlayer;

    public LocalFileAdapter(LocalFilePlayer localFilePlayer) {
        this.localFilePlayer = localFilePlayer;
    }

    @Override
    public void play() {
        localFilePlayer.playLocalFile();
    }
}

class OnlineStreamingAdapter implements MusicSource {
    private OnlineStreamingPlayer onlineStreamingPlayer;

    public OnlineStreamingAdapter(OnlineStreamingPlayer onlineStreamingPlayer) {
        this.onlineStreamingPlayer = onlineStreamingPlayer;
    }

    @Override
    public void play() {
        onlineStreamingPlayer.playOnlineStream();
    }
}

class RadioStationAdapter implements MusicSource {
    private RadioStationPlayer radioStationPlayer;

    public RadioStationAdapter(RadioStationPlayer radioStationPlayer) {
        this.radioStationPlayer = radioStationPlayer;
    }

    @Override
    public void play() {
        radioStationPlayer.playRadioStation();
    }
}

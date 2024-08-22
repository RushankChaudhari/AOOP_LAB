package MusicApp;

abstract class MusicPlayer {
    protected MusicSource musicSource;

    public MusicPlayer(MusicSource musicSource) {
        this.musicSource = musicSource;
    }

    public abstract void play();
}

class BasicMusicPlayer extends MusicPlayer {
    public BasicMusicPlayer(MusicSource musicSource) {
        super(musicSource);
    }

    @Override
    public void play() {
        musicSource.play();
    }
}


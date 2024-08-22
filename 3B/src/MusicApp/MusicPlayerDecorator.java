package MusicApp;

abstract class MusicPlayerDecorator extends MusicPlayer {
    protected MusicPlayer decoratedMusicPlayer;

    public MusicPlayerDecorator(MusicPlayer decoratedMusicPlayer) {
        super(decoratedMusicPlayer.musicSource);
        this.decoratedMusicPlayer = decoratedMusicPlayer;
    }

    @Override
    public void play() {
        decoratedMusicPlayer.play();
    }
}

class EqualizerDecorator extends MusicPlayerDecorator {
    public EqualizerDecorator(MusicPlayer decoratedMusicPlayer) {
        super(decoratedMusicPlayer);
    }

    @Override
    public void play() {
        super.play();
        setEqualizer();
    }

    private void setEqualizer() {
        System.out.println("Equalizer settings applied.");
    }
}

class VolumeControlDecorator extends MusicPlayerDecorator {
    public VolumeControlDecorator(MusicPlayer decoratedMusicPlayer) {
        super(decoratedMusicPlayer);
    }

    @Override
    public void play() {
        super.play();
        setVolume();
    }

    private void setVolume() {
        System.out.println("Volume control applied.");
    }
}

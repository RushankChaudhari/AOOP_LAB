package MusicStreamingApp;

abstract class MusicSourceDecorator implements MusicSource {
    protected MusicSource decoratedMusicSource;

    public MusicSourceDecorator(MusicSource decoratedMusicSource) {
        this.decoratedMusicSource = decoratedMusicSource;
    }

    @Override
    public void play() {
        decoratedMusicSource.play();
    }
}

class EqualizerDecorator extends MusicSourceDecorator {
    public EqualizerDecorator(MusicSource decoratedMusicSource) {
        super(decoratedMusicSource);
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

class VolumeControlDecorator extends MusicSourceDecorator {
    public VolumeControlDecorator(MusicSource decoratedMusicSource) {
        super(decoratedMusicSource);
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


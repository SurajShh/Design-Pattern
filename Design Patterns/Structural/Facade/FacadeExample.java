class TV {
    void on() { System.out.println("TV is on"); }
    void off() { System.out.println("TV is off"); }
}

class SoundSystem {
    void setVolume(int level) { System.out.println("Setting volume to " + level); }
}

class MediaPlayer {
    void play() { System.out.println("Playing media"); }
}

// Facade
class HomeTheaterFacade {
    private final TV tv;
    private final SoundSystem soundSystem;
    private final MediaPlayer player;

    public HomeTheaterFacade(TV tv, SoundSystem soundSystem, MediaPlayer player) {
        this.tv = tv;
        this.soundSystem = soundSystem;
        this.player = player;
    }

    public void startMovie() {
        tv.on();
        soundSystem.setVolume(5);
        player.play();
    }

    public void endMovie() {
        player.play();
        tv.off();
    }
}

// Client code
public class FacadeExample {
    public static void main(String[] args) {
        HomeTheaterFacade homeTheater = new HomeTheaterFacade(new TV(), new SoundSystem(), new MediaPlayer());
        homeTheater.startMovie();
        homeTheater.endMovie();
    }
}


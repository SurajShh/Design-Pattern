import java.util.ArrayList;
import java.util.List;

// Observable (Subject)
class WeatherStation {
    private List<Observer> observers = new ArrayList<>();
    private int temperature;

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
        notifyObservers();
    }

    public int getTemperature() {
        return temperature;
    }

    private void notifyObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }
}

// Observer interface
interface Observer {
    void update();
}

// Concrete Observer 1
class PhoneDisplay implements Observer {
    private final WeatherStation station;

    public PhoneDisplay(WeatherStation station) {
        this.station = station;
    }

    @Override
    public void update() {
        System.out.println("Phone Display: Temperature updated to " + station.getTemperature() + "°C");
    }
}

// Concrete Observer 2
class ComputerDisplay implements Observer {
    private final WeatherStation station;

    public ComputerDisplay(WeatherStation station) {
        this.station = station;
    }

    @Override
    public void update() {
        System.out.println("Computer Display: Temperature updated to " + station.getTemperature() + "°C");
    }
}

// Client code
public class ObserverExample {
    public static void main(String[] args) {
        WeatherStation station = new WeatherStation();

        // Create observers
        Observer phoneDisplay = new PhoneDisplay(station);
        Observer computerDisplay = new ComputerDisplay(station);

        // Register observers with the WeatherStation
        station.addObserver(phoneDisplay);
        station.addObserver(computerDisplay);

        // Change temperature, triggering updates to all displays
        station.setTemperature(25);
        station.setTemperature(30);
    }
}

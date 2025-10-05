package com.shivam.design_patterns;


import java.util.*;

interface Observer { void update(float temp); }

interface Subject {
    void add(Observer o);
    void remove(Observer o);
    void notifyObservers();
}

class WeatherStation implements Subject {
    private List<Observer> observers = new ArrayList<>();
    private float temperature;

    public void add(Observer o) { observers.add(o); }
    public void remove(Observer o) { observers.remove(o); }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
        notifyObservers();
    }

    public void notifyObservers() {
        for (Observer o : observers) o.update(temperature);
    }
}

class MobileDisplay implements Observer {
    public void update(float temp) {
        System.out.println("Mobile App: Temp updated to " + temp + "°C");
    }
}

class WebDisplay implements Observer {
    public void update(float temp) {
        System.out.println("Web Dashboard: Temp updated to " + temp + "°C");
    }
}

// ---------- USAGE ----------
public class ObserverDemo {
    public static void main(String[] args) throws InterruptedException {
        WeatherStation station = new WeatherStation();
        station.add(new MobileDisplay());
        station.add(new WebDisplay());
        station.setTemperature(29.5f);
        station.setTemperature(32.0f);
        station.setTemperature(30.0f);
    }
}

package kata7.model;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import java.util.List;

public class Block {
    public static final int MAX = 7;
    private int x;
    private int y;
    private final List<Observer> observers = new ArrayList<>();
    
    public Block(int x, int y) {
        this.x = x;
        this.y = y;
        Timer timer = new Timer();
        timer.schedule(task(), 1000, 500);
    }

    public int x() {
        return this.x;
    }

    public int y() {
        return this.y;
    }
    
    public void left() {
        if (this.x == 1) return;
        this.x--;
        changed();
    }
    
    public void right() {
        if (this.x == MAX) return;
        this.x++;
        changed();
    }
    
    public void up() {
        if (this.y == MAX) return;
        this.y++;
        changed();
    }
    
    public void down() {
        if (this.y == 1) return;
        this.y--;
        changed();
    }

    public void moveTo(int x, int y) {
        this.x = x;
        this.y = y;
        changed();
    }

    private TimerTask task() {
        return new TimerTask() {
            @Override
            public void run() {
                double r = Math.random();
                if (r < 0.75) return;
                if (r < 0.80) left();
                else if (r < 0.85) right();
                else if (r < 0.90) up();
                else if (r < 0.95) down();
            }
        };
    }

    private void changed() {
        for (Observer observer: observers) observer.changed();
    }

    public void register(Observer observer) {
        observers.add(observer);
    }

    public interface Observer {
        void changed();
    }

}

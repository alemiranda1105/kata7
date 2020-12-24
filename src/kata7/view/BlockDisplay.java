package kata7.view;

public interface BlockDisplay {
    int SIZE = 100;

    void paintBlock(int x, int y);
    void on(Moved moved);

    interface Moved {
        void to(int x, int y);
    }
}

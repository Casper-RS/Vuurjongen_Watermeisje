package dev.eindopdracht;

public interface ICollidable {
    int test1 = 0;
    int test2 = 1;
    int test3 = 1;


    public default int getTest1() {
        return test1;
    }

    public default void jeMoeder(){
        System.out.println("1");
    }
}

package ru.ranepa.v16;

public interface Actor {

    String name();

    void process(TrainingCar item);

    void escalate(TrainingCar item);

    void comment(TrainingCar item);

    void notify(TrainingCar item);

    void close(TrainingCar item);
}

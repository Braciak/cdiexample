package pl.ddl.todo.example;

import pl.ddl.todo.ApplicationView;

public interface ExampleView extends ApplicationView<ExampleViewPresenter> {

    public static final String ID = "example";

    void setMessage(String message);

}

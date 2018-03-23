package pl.ddl.todo.example;

import java.util.Date;

import com.vaadin.cdi.UIScoped;

import pl.ddl.todo.AbstractPresenter;

@UIScoped
public class ExampleViewPresenter extends AbstractPresenter<ExampleView> {

    @Override
    protected void onViewEnter() {

    }

    public void doSomething() {
        getView().setMessage("We did something at " + new Date());
    }

}

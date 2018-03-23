package pl.ddl.todo.login;

import pl.ddl.todo.ApplicationView;

public interface LoginView extends ApplicationView<LoginViewPresenter> {

    public static final String ID = "";

    void showInvalidLoginNotification();

}

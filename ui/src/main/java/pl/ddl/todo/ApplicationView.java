package pl.ddl.todo;

public interface ApplicationView<P extends AbstractPresenter> {

    P getPresenter();

    String getName();

    String getId();
}

package pl.ddl.todo.customer;

import java.util.Collection;

import org.vaadin.example.backend.entity.Customer;

import pl.ddl.todo.ApplicationView;

public interface CustomerView extends ApplicationView<CustomerViewPresenter> {

    public static final String ID = "customers";

    void removeTableSelection();

    void populateCustomers(Collection<Customer> customers);

    void openEditorFor(Customer customer);

    void closeEditor();

    void showPasswordDontMatchNotification();
}

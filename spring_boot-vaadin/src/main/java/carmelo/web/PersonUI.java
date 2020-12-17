package carmelo.web;

import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@SpringUI(path = "/person")
public class PersonUI extends UI {

    @Override
    protected void init(VaadinRequest request) {

        PersonForm form = new PersonForm();
        VerticalLayout root = new VerticalLayout(form);

        setContent(root);
    }

}

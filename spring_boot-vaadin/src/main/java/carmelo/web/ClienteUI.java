package carmelo.web;

import carmelo.data.model.Cliente;
import carmelo.data.service.ClienteService;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Button;
import com.vaadin.ui.Grid;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import org.springframework.beans.factory.annotation.Autowired;

@Theme("valo")
@Title("Mis Clientes")
@SpringUI(path = "/clientes")
public class ClienteUI extends UI {

    @Autowired
    private ClienteService clientes;

    private Grid<Cliente> grid;

    @Override
    protected void init(VaadinRequest request) {
        
        ClienteForm form = new ClienteForm();

        Button add = new Button("Agregar");
        add.addClickListener(e -> {
            grid.getSelectionModel().deselectAll();
            form.setCliente(new Cliente());
        });

        grid = new Grid<>(Cliente.class);
        grid.setColumns("nombre", "apellido", "email", "fecha");
        grid.addSelectionListener(c -> {
            c.getFirstSelectedItem().ifPresent(form::setCliente);
        });

        VerticalLayout layout = new VerticalLayout(grid, add);
        HorizontalLayout root = new HorizontalLayout(layout, form);

        setContent(root);
        reloadData();
    }

    public void reloadData() {
        grid.setItems(clientes.findAll());
    }

    public ClienteService getService() {
        return clientes;
    }
}

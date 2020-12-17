package carmelo.web;

import carmelo.data.model.Cliente;
import com.vaadin.data.Binder;
import com.vaadin.data.ValidationException;
import com.vaadin.event.ShortcutAction;
import com.vaadin.ui.Button;
import com.vaadin.ui.CheckBox;
import com.vaadin.ui.DateField;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.TextField;
import com.vaadin.ui.themes.ValoTheme;

public class ClienteForm extends FormLayout {

    private final Binder<Cliente> binder = new Binder<>();
    private Cliente cliente;

    public ClienteForm() {
        initUI();
    }

    private void initUI() {

        TextField nombre = new TextField("Nombre");
        TextField apellido = new TextField("Apellido");
        TextField correo = new TextField("Correo");
        DateField fecha = new DateField("Fecha");
        CheckBox activo = new CheckBox("Activo");
        TextArea descripcion = new TextArea("Desc.");

        Button save = new Button("Guardar");
        save.addClickListener(this::save);
        save.setStyleName(ValoTheme.BUTTON_PRIMARY);
        save.setClickShortcut(ShortcutAction.KeyCode.ENTER);

        Button cancel = new Button("Cancelar");
        cancel.addClickListener(this::cancel);
        cancel.setStyleName(ValoTheme.BUTTON_DANGER);

        HorizontalLayout buttons = new HorizontalLayout(save, cancel);

        addComponents(nombre, apellido, correo, fecha, activo, descripcion, buttons);

        binder.bind(nombre, Cliente::getNombre, Cliente::setNombre);
        binder.bind(apellido, Cliente::getApellido, Cliente::setApellido);
        binder.bind(correo, Cliente::getEmail, Cliente::setEmail);
        binder.bind(fecha, Cliente::getFecha, Cliente::setFecha);
        binder.bind(activo, Cliente::getActivo, Cliente::setActivo);
        binder.bind(descripcion, Cliente::getDescripcion, Cliente::setDescripcion);
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
        this.binder.readBean(cliente);
    }

    public void cancel(Button.ClickEvent event) {
        binder.readBean(cliente);
    }

    public void save(Button.ClickEvent event) {
        try {
            binder.writeBean(cliente);

            getUI().getService().save(cliente);
            getUI().reloadData();
            
        } catch (ValidationException ex) {
            Notification.show("Error al guardar cliente.", Notification.Type.ERROR_MESSAGE);
        }
    }

    @Override
    public ClienteUI getUI() {
        return (ClienteUI) super.getUI();
    }

}

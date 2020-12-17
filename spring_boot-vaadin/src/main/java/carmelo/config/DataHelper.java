package carmelo.config;

import carmelo.data.model.Cliente;
import carmelo.data.service.ClienteServiceImpl;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DataHelper {

    @Autowired
    private ClienteServiceImpl clientes;

    @PostConstruct
    public void init() {

        List<Cliente> lc = new ArrayList<>();

        lc.add(new Cliente("Juan", "Perez", "juanp@mail.com"));
        lc.add(new Cliente("Anna", "Maria", "anam@mail.com"));
        lc.add(new Cliente("Laura", "Lopez", "l2l@mail.com"));
        lc.add(new Cliente("Danny", "Garcia", "dang@mail.com"));
        lc.add(new Cliente("Lucia", "Mendez", "lume@mail.com"));

        clientes.saveAll(lc);
    }
}

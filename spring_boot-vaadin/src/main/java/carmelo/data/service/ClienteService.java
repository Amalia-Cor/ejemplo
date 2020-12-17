package carmelo.data.service;

import carmelo.data.model.Cliente;
import java.util.List;

public interface ClienteService {

    List<Cliente> findAll();

    void save(Cliente cliente);

    void saveAll(List<Cliente> cliente);
    
}

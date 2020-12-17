package carmelo.data.service;

import java.util.List;

import carmelo.data.model.Cliente;
import carmelo.data.repo.ClienteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository clientes;

    @Override
    public List<Cliente> findAll() {
        return clientes.findAll();
    }

    @Override
    public void saveAll(List<Cliente> cliente) {
        clientes.save(cliente);
    }

    @Override
    public void save(Cliente cliente) {
        clientes.saveAndFlush(cliente);
    }
}

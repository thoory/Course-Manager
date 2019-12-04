package fr.utbm.lo54.tp.scheduler.service;

import fr.utbm.lo54.tp.scheduler.entity.ClientEntity;
import fr.utbm.lo54.tp.scheduler.repository.ClientDAO;

import java.util.List;

public class ClientService {
    public List<ClientEntity> getAll() {
        List<ClientEntity> client;
        ClientDAO cDAO = new ClientDAO();

        client = cDAO.getAll();
        return client;
    }

    public ClientEntity getById(int id) {
        ClientEntity client;
        ClientDAO cDAO = new ClientDAO();

        client = cDAO.get(id);
        return client;
    }

    public void update(ClientEntity course) {
        ClientDAO cDAO = new ClientDAO();
        cDAO.save(course);
    }

    public void save(ClientEntity course) {
        ClientDAO cDAO = new ClientDAO();
        cDAO.update(course);
    }

    public void deleteById(int id) {
        ClientDAO cDAO = new ClientDAO();
        cDAO.delete(id);
    }
}

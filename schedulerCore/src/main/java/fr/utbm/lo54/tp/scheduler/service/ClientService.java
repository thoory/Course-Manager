package fr.utbm.lo54.tp.scheduler.service;

import fr.utbm.lo54.tp.scheduler.entity.ClientEntity;
import fr.utbm.lo54.tp.scheduler.repository.ClientDAO;

public class ClientService {

    public void save(ClientEntity course) {
        ClientDAO cDAO = new ClientDAO();
        cDAO.update(course);
    }
}

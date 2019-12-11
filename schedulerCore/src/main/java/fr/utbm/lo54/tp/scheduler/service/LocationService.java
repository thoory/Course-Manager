package fr.utbm.lo54.tp.scheduler.service;

import fr.utbm.lo54.tp.scheduler.entity.LocationEntity;
import fr.utbm.lo54.tp.scheduler.repository.LocationDAO;

import java.util.List;

public class LocationService {
    public List<LocationEntity> getAll() {
        List<LocationEntity> client;
        LocationDAO lDAO = new LocationDAO();
        client = lDAO.getAll();
        return client;
    }

    public LocationEntity getById(int id) {
        LocationEntity client;
        LocationDAO lDAO = new LocationDAO();
        client = lDAO.get(id);
        return client;
    }
}

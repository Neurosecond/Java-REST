package com.sample.repo.dao;

import java.util.List;

import com.sample.repo.domain.Client;

public interface ClientDAO {

    public void create(Client c);
    public void update(Client c);
    public List<Client> listClients();
    public Client getClientById(long id);
    public void removeClient(long id);
}


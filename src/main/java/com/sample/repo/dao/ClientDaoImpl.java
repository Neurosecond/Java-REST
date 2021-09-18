package com.sample.repo.dao;

import java.util.List;

import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;

import com.sample.repo.domain.Client;

@Repository
public class ClientDAOImpl implements ClientDAO {

    private static final Logger logger = LoggerFactory.getLogger(ClientDAOImpl.class);
    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    public void create(Client c) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        session.persist(c);
        logger.info("Client saved successfully, Client Details=" + c);
    }

    @Override
    public void update(Client c) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        session.saveOrUpdate(c);
        logger.info("Client updated successfully, Client Details=" + c);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Client> listClients() {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        List<Client> clientList = session.createQuery("from Client").list();
        for (Client c : clientList) {
            logger.info("Client List::" + c);
        }
        return clientList;
    }

    @Override
    public Client getClientById(long id) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        Client c = (Client) session.get(Client.class, new Long(id));
        logger.info("Client loaded successfully, Client details=" + c);
        //check null first
        if (c != null) {
            //detach your first entity from session - session.evict(myEntity)
            session.evict(c);
        }
        return c;
    }

    @Override
    public void removeClient(long id) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        Client c = (Client) session.load(Client.class, new Long(id));
        if (null != c) {
            session.delete(c);
        }
        logger.info("Client deleted successfully, Client details=" + c);
    }

}

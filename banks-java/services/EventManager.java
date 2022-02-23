package services;


import models.Client;

import java.util.*;

public class EventManager {
    Map<String, List<Client>> listeners = new HashMap<>();

    public EventManager(String... operations) {
        for (String operation : operations) {
            this.listeners.put(operation, new ArrayList<>());
        }
    }

    public void subscribe(String eventType, Client listener) {
        List<Client> users = listeners.get(eventType);
        users.add(listener);
    }

    public void unsubscribe(String eventType, Client listener) {
        List<Client> users = listeners.get(eventType);
        users.remove(listener);
    }

    public void notify(String event) {
        List<Client> users = listeners.get(event);
        for (Client listener : users) {
            listener.update(event);
        }
    }
}

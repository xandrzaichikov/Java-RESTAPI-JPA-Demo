package demo.zaichikov.service;

import demo.zaichikov.entity.EventEntity;

public interface EventEntityService {
    void save(EventEntity eventEntity);

    EventEntity get(Integer id);

    void delete(Integer id);
}

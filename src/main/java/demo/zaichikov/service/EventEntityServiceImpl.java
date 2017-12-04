package demo.zaichikov.service;

import demo.zaichikov.entity.EventEntity;
import demo.zaichikov.repository.EventEntityRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.Optional;

@Service("eventEntityService")
@Transactional
public class EventEntityServiceImpl implements EventEntityService {
    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    EventEntityRepository eventEntityRepository;

    @Override
    public void save(EventEntity eventEntity) {
        eventEntity.setCreationTime(new Timestamp(System.currentTimeMillis()));
        eventEntityRepository.save(eventEntity);
        logger.debug("saved {}", eventEntity);
    }

    @Override
    public EventEntity get(Integer id) {
        Optional<EventEntity> optional = eventEntityRepository.findById(id);
        EventEntity eventEntity = optional.isPresent() ? optional.get() : null;
        logger.debug("loaded {} for id={}", eventEntity, id);
        return eventEntity;
    }

    @Override
    public void delete(Integer id) {
        Optional<EventEntity> optional = eventEntityRepository.findById(id);
        if (optional.isPresent()) {
            eventEntityRepository.deleteById(id);
            logger.debug("deleted EventEntity with id={}", id);
        } else {
            logger.debug("no EventEntity with id={} found", id);
        }
    }

}

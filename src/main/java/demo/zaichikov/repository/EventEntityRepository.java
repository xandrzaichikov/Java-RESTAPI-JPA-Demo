package demo.zaichikov.repository;

import demo.zaichikov.entity.EventEntity;
import org.springframework.data.repository.CrudRepository;

public interface EventEntityRepository extends CrudRepository<EventEntity, Integer> {
}

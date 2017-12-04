package demo.zaichikov.web;

import demo.zaichikov.entity.EventEntity;
import demo.zaichikov.service.EventEntityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class RestApiController {
    @Autowired
    EventEntityService eventEntityService;

    @RequestMapping(method = RequestMethod.GET, value = "/event/{id}")
    public
    @ResponseBody
    ResponseEntity<EventEntity> get(@PathVariable("id") Integer id) {
        EventEntity eventEntity = eventEntityService.get(id);
        return new ResponseEntity<EventEntity>(eventEntity, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/event/{id}")
    public
    @ResponseBody
    ResponseEntity<Void> delete(@PathVariable("id") int id) {
        eventEntityService.delete(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/event/")
    public
    @ResponseBody
    ResponseEntity<Void> create(@RequestBody EventEntity eventEntity) {
        eventEntityService.save(eventEntity);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/event/")
    public
    @ResponseBody
    ResponseEntity<Void> update(@RequestBody EventEntity eventEntity) {
        eventEntityService.save(eventEntity);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}

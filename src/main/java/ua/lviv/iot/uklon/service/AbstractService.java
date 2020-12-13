package ua.lviv.iot.uklon.service;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.jpa.repository.JpaRepository;

public abstract class AbstractService<E> implements Service<E> {
    private final JpaRepository<E, Integer> repository;

    public AbstractService(JpaRepository<E, Integer> repository) {
        this.repository = repository;
    }

    public List<E> getAllObjects() {
        return repository.findAll();
    }

    public E getObjectById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    public E createObject(E object) {
        return repository.saveAndFlush(object);
    }

    public E updateObject(Integer id, E object, E oldObject) {
        E foundObject = repository.findById(id).orElse(null);
        if (foundObject != null) {
            BeanUtils.copyProperties(foundObject, oldObject);
            repository.saveAndFlush(object);
        } else {
            oldObject = null;
        }
        return oldObject;
    }

    public boolean deleteObject(Integer id) {
        try {
            repository.deleteById(id);
            return true;
        } catch (EmptyResultDataAccessException e) {
            return false;
        }
    }
}
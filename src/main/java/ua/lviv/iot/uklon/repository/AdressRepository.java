package ua.lviv.iot.uklon.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.lviv.iot.uklon.domain.Adress;

@Repository
public interface AdressRepository extends JpaRepository<Adress, Integer> {
}

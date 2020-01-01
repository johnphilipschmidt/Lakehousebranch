package net.jpschmidt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RentalService {

    @Autowired
    private RentalRepository repo;

    public List<Rental> listAll () {
        return repo.findAll ();
    }

    public void save (Rental rental) {
        repo.save (rental);
    }

    public Rental get (long id) {
        return repo.findById (id).get ();
    }

    public void delete (long id) {
        repo.deleteById (id);
    }
}

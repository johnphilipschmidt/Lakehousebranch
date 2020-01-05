package net.jpschmidt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RatesService {

    @Autowired
    private RatesRepository repo;

    public List<Rates> listAll () {
        return repo.findAll ();
    }

    public void save (Rates rates) {
        repo.save (rates);
    }

    public Rates get (long id) {
        return repo.findById (id).get ();
    }

    public void delete (long id) {
        repo.deleteById (id);
    }

}

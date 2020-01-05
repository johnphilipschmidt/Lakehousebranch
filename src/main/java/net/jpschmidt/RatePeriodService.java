package net.jpschmidt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RatePeriodService {

    @Autowired
    private RatePeriodRepository repo;

    public List<RatePeriod> listAll () {
        return repo.findAll ();
    }

    public void save (RatePeriod ratePeriod) {
        repo.save (ratePeriod);
    }


    public RatePeriod get (long id) {
        return repo.findById (id).get ();
    }

    public void delete (long id) {
        repo.deleteById (id);
    }

}

package net.jpschmidt;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Service
public class BootstrapDataPopulator implements InitializingBean {

    private final Logger LOG = LoggerFactory.getLogger (BootstrapDataPopulator.class);
    RatePeriod ratePeriod;
    Rates rates;

    @Autowired
    RatePeriodRepository ratePeriodRepository;
    @Autowired
    RatesRepository ratesRepository;


    @Override
    @Transactional()
    public void afterPropertiesSet () throws Exception {
        LOG.info ("Bootstrapping data...");
        try {
            createRatePeriods ();
            createRateData ();
        } catch (Exception e) {
            LOG.info (e.getMessage ());
        }


        LOG.info ("...Bootstrapping completed");
    }

    private void createRatePeriod (RatePeriod ratePeriod) {


        LOG.info (ratePeriod.name + "... creating rate period");
        ratePeriodRepository.saveAndFlush (ratePeriod);
        ratePeriodRepository.flush ();

    }

    private void createRatePeriods () {
        if (ratesRepository.count () > 0) {
            return;
        }

        LOG.info ("... creating Rates ");

        List<RatePeriod> ratePeriods = new ArrayList<> ();
        ratePeriods.add (new RatePeriod (1L, "Spring", new Date ("04/01/2020"), new Date ("05/30/2020")));
        ratePeriods.add (new RatePeriod (2L, "Summer", new Date ("06/01/2020"), new Date ("09/02/2020")));
        ratePeriods.add (new RatePeriod (3L, "Fall", new Date ("09/01/2020"), new Date ("11/30/2020")));
        ratePeriods.add (new RatePeriod (4L, "Winter", new Date ("12/01/2020"), new Date ("03/30/2020")));

        //ratePeriods.forEach(ratePeriod -> createRatePeriod (ratePeriod));
        Iterator ratePeriodIterator = ratePeriods.iterator ();

        while (ratePeriodIterator.hasNext ()) {

            RatePeriod ratePeriod = (RatePeriod) ratePeriodIterator.next ();
            System.out.println ("The RatePeriod:" + ratePeriod.getName ());
            createRatePeriod (ratePeriod);
        }
    }

    private void createRatesObject (Rates rates) {


        //LOG.info (rates.name+"... creating rate period");
        ratesRepository.saveAndFlush (rates);
        ratesRepository.flush ();

    }

    private void createRateData () {
        if (ratesRepository.count () > 0) {
            return;
        }

        LOG.info ("... creating Ratess codes");

        List<Rates> ratesList = new ArrayList<> ();
        ratesList.add (new Rates (1L, "Spring", new Date ("04/01/2020"), new Date ("05/30/2020"), 150.00));
        ratesList.add (new Rates (2L, "Summer", new Date ("06/01/2020"), new Date ("09/02/2020"), 200.00));
        ratesList.add (new Rates (3L, "Fall", new Date ("09/01/2020"), new Date ("11/30/2020"), 300.00));
        ratesList.add (new Rates (4L, "Winter", new Date ("12/01/2020"), new Date ("03/30/2020"), 400.00));


        Iterator ratesIterator = ratesList.iterator ();

        while (ratesIterator.hasNext ()) {

            Rates ratesObject = (Rates) ratesIterator.next ();
            System.out.println ("The ArrayList elements are:" + ratesObject.getName ());
            createRatesObject (ratesObject);
        }
    }
}

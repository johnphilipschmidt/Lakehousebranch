package net.jpschmidt;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;


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
//        LocalDateTime myDateObj = LocalDateTime.now();
//        System.out.println("Before formatting: " + myDateObj);
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd/MM/yyyy");



        List<RatePeriod> ratePeriods = new ArrayList<> ();
        ratePeriods.add (new RatePeriod (1L, "Spring", LocalDate.of(2020,05,01),LocalDate.of(2020,05,01)));
        ratePeriods.add (new RatePeriod (2L, "Summer", LocalDate.of(2020,05,01),LocalDate.of(2020,05,01)));
        ratePeriods.add (new RatePeriod (3L, "Fall", LocalDate.of(2020,05,01),LocalDate.of(2020,05,01)));
        ratePeriods.add (new RatePeriod (4L, "Winter", LocalDate.of(2020,05,01),LocalDate.of(2020,05,01)));

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
        ratesList.add (new Rates (1L, "Spring", LocalDate.of(2020,05,01),LocalDate.of(2020,05,01), 150.00));
        ratesList.add (new Rates (2L, "Summer", LocalDate.of(2020,05,01),LocalDate.of(2020,05,01), 200.00));
        ratesList.add (new Rates (3L, "Fall", LocalDate.of(2020,05,01),LocalDate.of(2020,05,01), 300.00));
        ratesList.add (new Rates (4L, "Winter", LocalDate.of(2020,05,01),LocalDate.of(2020,05,01), 400.00));


        Iterator ratesIterator = ratesList.iterator ();

        while (ratesIterator.hasNext ()) {

            Rates ratesObject = (Rates) ratesIterator.next ();
            System.out.println ("The ArrayList elements are:" + ratesObject.getName ());
            createRatesObject (ratesObject);
        }
    }
}

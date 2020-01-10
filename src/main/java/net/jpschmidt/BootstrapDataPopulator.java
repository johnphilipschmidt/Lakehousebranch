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

//Todo Add Master detail form

@Service
public class BootstrapDataPopulator implements InitializingBean {

    private final Logger LOG = LoggerFactory.getLogger (BootstrapDataPopulator.class);
    RatePeriod ratePeriod;
    Rates rates;

    @Autowired
    RatePeriodRepository ratePeriodRepository;
    @Autowired
    RatesRepository ratesRepository;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    ProductDetailRepository productDetailRepository;


    @Override
    @Transactional()
    public void afterPropertiesSet () throws Exception {
        LOG.info ("Bootstrapping data...");
        try {
            createRatePeriods ();
            createRateData ();
            createProductData ();
            createProductDetailData ();
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

    ///////////

    private void createProductObject (Product Product) {


        //LOG.info (Products.name+"... creating Product period");
        productRepository.saveAndFlush (Product);
        productRepository.flush ();

    }

    private void createProductData () {
        if (productRepository.count () > 0) {
            return;
        }

        LOG.info ("... creating Product Detail codes");

        List<Product> ProductsList = new ArrayList<> ();
        ProductsList.add (new Product (1L, "Product1", "Brand1", "USA", 1));
        ProductsList.add (new Product (2L, "Product2", "Brand1", "USA", 1));
        ProductsList.add (new Product (3L, "Product3", "Brand2", "USA", 5));
        ProductsList.add (new Product (4L, "Product4", "Brand3", "USA", 5));
        ProductsList.add (new Product (5L, "Product5", "Brand4", "USA", 5));


        Iterator ProductsIterator = ProductsList.iterator ();

        while (ProductsIterator.hasNext ()) {

            Product ProductsObject = (Product) ProductsIterator.next ();
            System.out.println ("The ArrayList product are:" + ProductsObject.getName ());
            createProductObject (ProductsObject);
        }
    }

    ///////
    private void createProductDetailObject (ProductDetail productDetail) {


        //LOG.info (productDetails.name+"... creating productDetail period");
        productDetailRepository.saveAndFlush (productDetail);
        productDetailRepository.flush ();

    }

    private void createProductDetailData () {
        if (productDetailRepository.count () > 0) {
            return;
        }

        LOG.info ("... creating productDetail ");

        List<ProductDetail> productDetailsList = new ArrayList<> ();
        productDetailsList.add (new ProductDetail (1L, "productDetail1", "Brand1", "USA", 1, new Product (1L, "l", "g", "l", 2)));
        productDetailsList.add (new ProductDetail (1L, "productDetail1", "Brand1", "USA", 1, new Product (1L, "l", "g", "l", 2)));
        productDetailsList.add (new ProductDetail (1L, "productDetail1", "Brand1", "USA", 1, new Product (1L, "l", "g", "l", 2)));
        productDetailsList.add (new ProductDetail (2L, "productDetail2", "Brand1", "USA", 1, new Product (2L, "m", "g", "l", 2)));
        productDetailsList.add (new ProductDetail (1L, "productDetail1", "Brand1", "USA", 1, new Product (2L, "l", "g", "l", 2)));
        productDetailsList.add (new ProductDetail (1L, "productDetail1", "Brand1", "USA", 1, new Product (2L, "l", "g", "l", 2)));
        productDetailsList.add (new ProductDetail (1L, "productDetail1", "Brand1", "USA", 1, new Product (2L, "l", "g", "l", 2)));
        productDetailsList.add (new ProductDetail (3L, "productDetail3", "Brand2", "USA", 5, new Product (3L, "n", "g", "l", 2)));
        productDetailsList.add (new ProductDetail (4L, "productDetail4", "Brand3", "USA", 5, new Product (4L, "o", "g", "l", 2)));
        productDetailsList.add (new ProductDetail (5L, "productDetail5", "Brand4", "USA", 5, new Product (5L, "p", "g", "l", 2)));


        Iterator productDetailsIterator = productDetailsList.iterator ();

        while (productDetailsIterator.hasNext ()) {

            ProductDetail productDetailsObject = (ProductDetail) productDetailsIterator.next ();
            System.out.println ("The ArrayList productDetail are:" + productDetailsObject.getName ());
            createProductDetailObject (productDetailsObject);
        }
    }
    
}

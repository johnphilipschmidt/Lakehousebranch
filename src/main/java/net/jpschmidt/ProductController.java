package net.jpschmidt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.thymeleaf.extras.java8time.dialect.Java8TimeDialect;
import org.thymeleaf.spring5.ISpringTemplateEngine;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.templateresolver.ITemplateResolver;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

@Controller
public class ProductController {

    @Autowired
    private ProductService service;

    @Autowired
    private ProductDetailService detailService;

    @RequestMapping("/product")
    public String viewProductPage (Model model) {

        Long val;
        List<Product> listAllProducts = service.listAll ();
        Iterator iterator = listAllProducts.iterator ();
        while (iterator.hasNext ()) {
            Product prod = (Product) iterator.next ();
            Iterator detailIterator = prod.getProductDetails ().iterator ();
            while (detailIterator.hasNext ()) {
                ProductDetail pdtl = (ProductDetail) detailIterator.next ();
                System.out.println ("Prod:" + prod.getProductId () + " " + "Detail:" + pdtl.getId ());
            }
        }


        System.out.println ("Products:" + listAllProducts);
        //List<ProductDetail> productDetails = detailService.listAll ();

        model.addAttribute ("listAllProducts", listAllProducts);
        //model.addAttribute("standardDate", new Date());
//		model.addAttribute("localDateTime", LocalDateTime.now());
        //model.addAttribute("fromDate", LocalDate.now());
        //model.addAttribute("toDate", LocalDate.now());
//		model.addAttribute("timestamp", Instant.now());
        //listActivities.forEach(act -> System.out.println(" list controller:"+act.getFromDate()));


        return "product";
    }

    @RequestMapping("/product/new")
    public String showNewProductPage (Model model) {
        //System.out.println ("A controller act new");
        Product product = new Product ();
        model.addAttribute ("product", product);

        return "new_product";
    }


    @RequestMapping(value = "/product/save", method = RequestMethod.POST)
    public String saveProduct (@ModelAttribute("product") Product product) {
        //System.out.println("save:+"+product.getFromDate());
        service.save (product);


        return "redirect:/product";

    }

    @RequestMapping("/product/edit/{productId}")
    public ModelAndView showEditProductPage (@PathVariable(name = "productId") Long productId) {
        System.out.println ("Calling edit product");
        ModelAndView mav = new ModelAndView ("edit_product");
        Product product = service.get (productId);
        System.out.println (product.getProductId ());
        mav.addObject ("product", product);

        return mav;
    }

    @RequestMapping("/product/delete/{productId}")
    public String deleteProduct (@PathVariable(name = "productId") Long productId) {
        service.delete (productId);
        return "redirect:/product";
    }


}

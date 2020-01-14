package net.jpschmidt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.Iterator;
import java.util.List;

@Controller
public class ProductDetailController {

    @Autowired
    private ProductDetailService productDetailService;


    @RequestMapping("/productDetail")
    public String viewProductDetailPage (Model model) {
        List<ProductDetail> listAllProductDetails = productDetailService.listAll ();
        System.out.println ("ProductDetails:" + listAllProductDetails);
        model.addAttribute ("listAllProductDetails", listAllProductDetails);
        return "productDetail";
    }

    @RequestMapping("/productDetail/new")
    public String showNewProductDetailPage (Model model) {

        ProductDetail productDetail = new ProductDetail ();
        model.addAttribute ("productDetail", productDetail);

        return "new_productDetail";
    }


    @RequestMapping(value = "/productDetail/save", method = RequestMethod.POST)
    public String saveProductDetail (@ModelAttribute("productDetail") ProductDetail productDetail) {

        productDetailService.save (productDetail);
        return "redirect:/productDetail";

    }

    @RequestMapping("/productDetail/edit/{productDetailId}")
    public ModelAndView showEditProductDetailPage (@PathVariable(name = "productDetailId") Long productDetailId) {
        System.out.println ("Calling edit productDetail");
        ModelAndView mav = new ModelAndView ("edit_product_detail");
        ProductDetail productDetail = productDetailService.get (productDetailId);
        System.out.println (productDetail.getId ());
        mav.addObject ("productDetail", productDetail);

        return mav;
    }

    @RequestMapping("/productDetail/delete/{productDetailId}")
    public String deleteProductDetail (@PathVariable(name = "productDetailId") Long productDetailId) {
        productDetailService.delete (productDetailId);
        return "redirect:/productDetail";
    }


}

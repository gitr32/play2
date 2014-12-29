package controllers;

import play.mvc.Controller;
import play.mvc.Result;
import play.data.Form;

import java.util.List;
import java.util.ArrayList;

import models.Product;

import views.html.products.list;
import views.html.products.details;


/**
 * Created by r128 on 28/12/14.
 */
public class Products extends Controller{

    private static final Form<Product> productForm = Form.form(Product.class);

    public static Result list() {
        List<Product> products = Product.findAll();
        return ok(list.render(products));
    }

    public static Result newProduct() {
       return ok(details.render(productForm));
    }

    public static Result details(String ean) {
        return TODO;
    }

    public static Result save() {
        Form<Product> boundForm = productForm.bindFromRequest();
        Product product = boundForm.get();
        product.save();
        return ok(String.format("Saved product %s", product));
    }

}

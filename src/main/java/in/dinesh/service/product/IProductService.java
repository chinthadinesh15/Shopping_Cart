package in.dinesh.service.product;

import in.dinesh.model.Product;
import in.dinesh.request.AddProductRequest;
import in.dinesh.request.ProductUpdateRequest;

import java.util.List;

public interface IProductService {

    Product addProduct(AddProductRequest product);
    Product getProductById(Long id);
    Product updateProduct(ProductUpdateRequest product, Long productId);
    void deleteProduct(Long id);
    Long countProductsByBrandAndName(String brand, String name);

    List<Product> getAllProducts();
    List<Product> getProductsByCategory(String category);
    List<Product> getProductsByBrand(String brand);
    List<Product> getProductsByCategoryAndBrand(String category, String brand);
    List<Product> getProductsByName(String name);
    List<Product> getProductsByBrandAndName(String brand, String name);



}

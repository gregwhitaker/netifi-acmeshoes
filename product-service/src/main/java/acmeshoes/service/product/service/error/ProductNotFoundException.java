package acmeshoes.service.product.service.error;

/**
 * Exception thrown when a product cannot be found.
 */
public class ProductNotFoundException extends RuntimeException {

    private String productId;

    public ProductNotFoundException(final String productId) {
        super("Product not found: " + productId);
    }

    public String getProductId() {
        return productId;
    }
}

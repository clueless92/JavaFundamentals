package Pr02Shop1Lv.Exceptions;

public class ProductOutOfStockException extends Exception {
    public ProductOutOfStockException (String msg) {
        super(msg);
    }
}

package exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "No products found under this category.")
public class SellerNotFoundException extends RuntimeException {

    public SellerNotFoundException(String message) {
        super(message);
    }

}

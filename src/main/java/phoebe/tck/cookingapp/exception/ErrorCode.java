package phoebe.tck.cookingapp.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

@Getter
public enum ErrorCode {
    UNCATEGORIZED_EXCEPTION(9999, "Uncategorized error!", HttpStatus.INTERNAL_SERVER_ERROR),
    KEY_INVALID(1001, "Uncategorized error!", HttpStatus.BAD_REQUEST),
    USER_EXISTED(1002, "User existed!", HttpStatus.BAD_REQUEST),
    USERNAME_INVALID(1003, "Username must be at least 3 characters", HttpStatus.BAD_REQUEST),
    PASSWORD_INVALID(1004, "Password must be at least 8 characters", HttpStatus.BAD_REQUEST),
    USER_NOT_FOUND(1005, "User not found!", HttpStatus.NOT_FOUND),
    UNAUTHENTICATED(1006, "Unauthenticated", HttpStatus.UNAUTHORIZED),
    UNAUTHORIZED(1007, "You do not have permission", HttpStatus.FORBIDDEN),
    DISH_EXISTED(1008, "Dish existed!", HttpStatus.BAD_REQUEST),
    CATEGORY_EXISTED(1009, "Category existed!", HttpStatus.BAD_REQUEST),
    CATEGORY_INVALID(1010, "Category invalid!", HttpStatus.BAD_REQUEST),
    DISH_NOT_FOUND(1011, "Dish not found!", HttpStatus.NOT_FOUND)

    ;

    private int code;
    private String message;
    private HttpStatusCode statusCode;

    ErrorCode(int code, String message, HttpStatusCode statusCode) {
        this.code = code;
        this.message = message;
        this.statusCode = statusCode;
    }
}
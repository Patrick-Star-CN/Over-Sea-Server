package team.over_sea.handle;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import team.over_sea.apiException.EmBusinessError;
import team.over_sea.apiException.TransactionException;
import team.over_sea.util.RespJson;


/**
 * @author Patrick_Star
 * @version 1.0
 */
@ControllerAdvice
@Slf4j
public class ApiExceptionAdvice {

    @ResponseBody
    @ExceptionHandler(Exception.class)
    public RespJson doException(Exception ex) {
        if (ex instanceof TransactionException) {
            TransactionException businessException = (TransactionException)ex;
            return new RespJson(businessException.getErrorCode(), businessException.getErrorMsg());
        }
        else {
            log.error(ex.getMessage(), ex);
            return new RespJson(EmBusinessError.UNKNOWN_ERROR.getErrorCode(), EmBusinessError.UNKNOWN_ERROR.getErrorMsg());
        }
    }
}

package rest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author ArvikV
 * @version 1.0
 * @since 12.03.2022
 */
@ControllerAdvice
public class EmployeeGlobalExceptionHandler {
    /**
     * назначаем ответственного за обработку исключений
     * ResponseEntity обертка над HTTPresponse
     * в обощении тип объекта который добавляется в HTTP response body, когдавы брасывается наш ексепшн
     * EmployeeIncorrectData NoEmployeeException создать для обработки исключения
     */
    @ExceptionHandler
    public ResponseEntity<EmployeeIncorrectData> handleExcepltion(NoEmployeeException exception) {
        EmployeeIncorrectData data = new EmployeeIncorrectData();
        data.setInfo(exception.getMessage());
        return new ResponseEntity<>(data, HttpStatus.NOT_FOUND);
    }

    /**
     * обрабатываем остальные ексепшены
     * @param exception ексепшн
     * @return на выходе ответ ексепшена
     */
    @ExceptionHandler
    public ResponseEntity<EmployeeIncorrectData> handleExcepltion(Exception exception) {
        EmployeeIncorrectData data = new EmployeeIncorrectData();
        data.setInfo(exception.getMessage());
        return new ResponseEntity<>(data, HttpStatus.BAD_REQUEST);
    }
}

package route.bus.busrouteapp.network;

/**
 * Created by NOBLE on 07-01-2018.
 */

public class APIException extends Exception {

    private Throwable throwable;
    private int statusCode;
    private String errorMessage;

    public APIException(String message, Throwable throwable, int statusCode) {
        super(message);
        this.throwable = throwable;
        this.statusCode = statusCode;
    }

    public APIException(String message, Throwable throwable) {
        super(message);
        this.throwable = throwable;
    }

    public APIException(int statusCode, Throwable throwable) {
        super(throwable);
        this.throwable = throwable;
        this.statusCode = statusCode;
    }

    public Throwable getThrowable() {
        return throwable;
    }

    public void setThrowable(Throwable throwable) {
        this.throwable = throwable;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}

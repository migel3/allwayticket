package by.alex.allwayticket.exceptions;

public class ExceptionUtil {
    public ExceptionUtil() {
    }

    public static String getRootMessage(Throwable throwable) {
        if(throwable == null) {
            return null;
        } else {
            String error = throwable.getMessage();

            for(Throwable nested = throwable; nested.getCause() != null; error = nested.getMessage()) {
                nested = nested.getCause();
            }

            return error;
        }
    }
}

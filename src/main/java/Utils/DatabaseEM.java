package Utils;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
import org.hibernate.exception.ConstraintViolationException;

@Provider
public class DatabaseEM implements ExceptionMapper<Throwable> {

    @Override
    public Response toResponse(Throwable exception) {
        Throwable cause = exception;
        while (cause != null) {
            if (cause instanceof ConstraintViolationException) {
                return handleConstraintViolation((ConstraintViolationException) cause);
            }
            cause = cause.getCause();
        }
        return Response.status(500)
                .entity(new ErrorInfo("Internal Server Error", exception.getMessage()))
                .build();
    }

    private Response handleConstraintViolation(ConstraintViolationException e) {
        String message = "Cannot delete object. FK in use.";

        return Response.status(Response.Status.CONFLICT) // 409 Conflict
                .entity(new ErrorInfo("DATABASE_CONSTRAINT", message))
                .build();
    }

    public static record ErrorInfo(String code, String message) {}
}

package Utils;

import jakarta.persistence.PersistenceException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

import java.util.Map;

@Provider
public class PersistenceEM implements ExceptionMapper<PersistenceException> {

    @Override
    public Response toResponse(PersistenceException e) {

        Throwable t = e.getCause();
        while (t != null) {
            if (t instanceof org.hibernate.exception.ConstraintViolationException cve) {
                // Postgres / FK violation
                return Response.status(Response.Status.CONFLICT)
                        .entity(Map.of(
                                "code", "ENTITY_IN_USE",
                                "message", "Resource is referenced by other entities and cannot be deleted"
                        ))
                        .build();
            }
            t = t.getCause();
        }

        return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                .entity(Map.of(
                        "code", "PERSISTENCE_ERROR",
                        "message", e.getMessage()
                ))
                .build();
    }
}
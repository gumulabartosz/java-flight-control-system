package Utils;

import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.Provider;
import jakarta.ws.rs.ext.ReaderInterceptor;
import jakarta.ws.rs.ext.ReaderInterceptorContext;

import java.io.ByteArrayInputStream;
import java.io.IOException;

@Provider
public class EmptyBodyReaderInterceptor implements ReaderInterceptor {

    @Override
    public Object aroundReadFrom(ReaderInterceptorContext context)
            throws IOException, WebApplicationException {

        if (context.getHeaders().containsKey("Content-Length")
                && "0".equals(context.getHeaders().getFirst("Content-Length"))) {

            throw new WebApplicationException(
                    Response.status(Response.Status.BAD_REQUEST)
                            .entity("Request body cannot be empty")
                            .build()
            );
        }

        var inputStream = context.getInputStream();
        byte[] bytes = inputStream.readAllBytes();

        if (bytes.length == 0) {
            throw new WebApplicationException(
                    Response.status(Response.Status.BAD_REQUEST)
                            .entity("Request body cannot be empty")
                            .build()
            );
        }

        context.setInputStream(new ByteArrayInputStream(bytes));

        return context.proceed();
    }
}

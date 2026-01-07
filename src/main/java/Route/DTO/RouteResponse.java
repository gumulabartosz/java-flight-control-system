package Route.DTO;

import Airport.Airport;
import Route.Route;

public class RouteResponse {
    public Long id;
    public Airport source;
    public Airport destination;
    public int estimatedTime;

    public static RouteResponse fromEntity(Route route) {
        RouteResponse dto = new RouteResponse();
        dto.id = route.id;
        dto.source = route.source;
        dto.destination = route.destination;
        dto.estimatedTime = route.estimatedTime;
        return dto;
    }

}
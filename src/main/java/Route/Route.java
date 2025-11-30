package Route;

import Airport.Airport;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.Path;

import java.util.Random;



public class Route {
    int id;
    Airport source;
    Airport destination;
    public int estimatedTime;


    public Route(Airport source, Airport destination, int estimatedTime){
        Random rand = new Random();
        // 100000–999999
        this.id = 100000 + rand.nextInt(900000);
        this.source = source;
        this.destination = destination;
        this.estimatedTime = estimatedTime;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("---ROUTE---\n")
                .append("Source: "+source).append("\n")
                .append("Destination: "+destination).append("\n");

        return sb.toString();
    }
}

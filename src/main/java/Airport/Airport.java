package Airport;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class Airport extends PanacheEntity {

    @Column(nullable = false, unique = true)
    public String code;   // POZ, WAW, GDN itd.


    public Airport() {
    }

    public Airport(String code) {
        this.code = code.toUpperCase();
    }

}


/*
POZ,
BGY,
GDN,
KTW,
WAW,
RDO,
BZG,
IED,
LCJ*/

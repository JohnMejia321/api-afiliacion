package com.solicitud.afiliacion.repositories;

import com.solicitud.afiliacion.entities.Afiliacion;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
public interface AfiliacionRepository  extends CassandraRepository<Afiliacion, UUID> {
}

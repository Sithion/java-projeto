package br.edu.infnet.raphael_torres.model.domain;

import java.util.UUID;

import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
public abstract class BaseModel {
    @PrePersist
    private void ensureIdIsSet() {
        if (id == null) {
            id = UUID.randomUUID();
        }
    }
    
    @Id
    private UUID id;
}

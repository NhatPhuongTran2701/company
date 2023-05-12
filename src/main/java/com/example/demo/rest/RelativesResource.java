package com.example.demo.rest;
import com.example.demo.entity.Relatives;
import com.example.demo.service.RelativesService;
import com.example.demo.service.dto.RelativesDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class RelativesResource implements RelativesAPI{
    private final RelativesService relativesService;
    @Override
    public ResponseEntity<List<Relatives>> getAllRelatives() {
        return ResponseEntity.ok(relativesService.getAllRelatives());
    }

    @Override
    public ResponseEntity<Relatives> createRelatives(RelativesDTO relativesDTO, Long employeeId) {
        Relatives relatives = relativesService.createRelatives(relativesDTO, employeeId);
        return ResponseEntity.created(URI.create("/api/relatives/" + relatives.getId())).body(relatives);
    }

    @Override
    public ResponseEntity<Relatives> getRelativesById(Long relativesId) {
        return ResponseEntity.ok(relativesService.getRelativesById(relativesId));
    }

    @Override
    public ResponseEntity<Relatives> updateRelativesById(Long relativesId, RelativesDTO relativesDTO) {
        Relatives result = relativesService.updateRelativesById(relativesId, relativesDTO);
        return ResponseEntity.ok().body(result);
    }

    @Override
    public ResponseEntity<Void> deleteRelativesById(Long relativesId) {
        relativesService.deleteRelativesById(relativesId);
        return ResponseEntity.noContent().build();
    }
}

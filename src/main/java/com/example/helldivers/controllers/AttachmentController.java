package com.example.helldivers.controllers;

import com.example.helldivers.domain.Attachment;
import com.example.helldivers.domain.WeaponAttachment;
import com.example.helldivers.service.AttachmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/attachments")
public class AttachmentController {

    private final AttachmentService attachmentService;

    public AttachmentController(AttachmentService attachmentService) {
        this.attachmentService = attachmentService;
    }

    @GetMapping
    public ResponseEntity<?> getAttachments(@RequestParam(required = false) String category) {
        List<Attachment> attachments = attachmentService.getAllAttachments(category);
        if (attachments.isEmpty())
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        return ResponseEntity.ok(attachments);
    }

    @GetMapping("/{attachmentId}")
    public ResponseEntity<?> getAttachmentById(@PathVariable Integer attachmentId) {
        return attachmentService.getAttachmentById(attachmentId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PostMapping("")
    public ResponseEntity<?> createAttachment(@RequestBody Attachment attachment) {
        Attachment created = attachmentService.createAttachment(attachment);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(created.getAttachmentId()).toUri();
        return ResponseEntity.created(location).body(created);
    }

    @PutMapping("/{attachmentId}")
    public ResponseEntity<?> updateAttachment(@PathVariable Integer attachmentId,
                                               @RequestBody Attachment attachment) {
        return ResponseEntity.ok(attachmentService.updateAttachment(attachmentId, attachment));
    }

    @DeleteMapping("/{attachmentId}")
    public ResponseEntity<?> deleteAttachment(@PathVariable Integer attachmentId) {
        if (attachmentService.deleteAttachment(attachmentId))
            return ResponseEntity.ok("Attachment with ID [" + attachmentId + "] deleted successfully");
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Attachment with ID [" + attachmentId + "] not found");
    }

    @PostMapping("/{attachmentId}/weapons/{weaponId}")
    public ResponseEntity<?> linkToWeapon(@PathVariable Integer attachmentId,
                                           @PathVariable Integer weaponId,
                                           @RequestBody Map<String, Object> body) {
        Integer weaponUnlockLevel = (Integer) body.get("weapon_unlock_level");
        Integer unlockCost = (Integer) body.get("unlock_cost");
        String effect = (String) body.get("effect");

        WeaponAttachment wa = attachmentService.linkAttachmentToWeapon(weaponId, attachmentId,
                weaponUnlockLevel, unlockCost, effect);
        return ResponseEntity.status(HttpStatus.CREATED).body(wa);
    }

    @DeleteMapping("/{attachmentId}/weapons/{weaponId}")
    public ResponseEntity<?> unlinkFromWeapon(@PathVariable Integer attachmentId,
                                               @PathVariable Integer weaponId) {
        attachmentService.unlinkAttachmentFromWeapon(weaponId, attachmentId);
        return ResponseEntity.ok("Attachment [" + attachmentId + "] unlinked from weapon [" + weaponId + "]");
    }
}

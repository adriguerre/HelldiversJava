package com.example.helldivers.domain;

import jakarta.persistence.*;
import org.hibernate.annotations.BatchSize;

@Entity
@BatchSize(size = 25)
public class Attachment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "attachment_id")
    private Integer attachmentId;

    private String name;

    private String category;

    public Attachment() {
    }

    public Integer getAttachmentId() { return attachmentId; }
    public void setAttachmentId(Integer attachmentId) { this.attachmentId = attachmentId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }
}

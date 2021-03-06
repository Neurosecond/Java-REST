package com.sample.repo.domain;

import java.io.Serializable;
import javax.persistence.*;

@Entity
public class Form implements Serializable {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer formId;
    @Column
    private String organizationForm;

    //arg-constructor to initialize fields
    public Form(Integer formId, String organizationForm)
    {
        this.formId = formId;
        this.organizationForm = organizationForm;
    }

    public Integer getFormId() { return formId; }

    public void setFormId(Integer formId) {
        this.formId = formId;
    }

    public String getOrganizationForm() { return organizationForm; }

    public void setOrganizationForm(String organizationForm) {
        this.organizationForm = organizationForm;
    }
}

package com.melik.redis.model;

import java.io.Serializable;

/**
 * @Author mselvi
 * @Created 06.12.2023
 */

public class Programmer implements Serializable {

    private Long id;
    private String company;
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;

        if (obj == null) return false;

        if (getClass() != obj.getClass()) return false;

        Programmer other = (Programmer) obj;

        if (company == null) {
            if (other.company != null) return false;

        } else if (!company.equals(other.company)) {
            return false;
        }

        if (id != other.id) return false;

        if (name == null) {
            if (other.name != null) return false;

        } else if (!name.equals(other.name)) {
            return false;
        }

        return true;
    }
}

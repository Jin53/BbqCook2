package entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Table(name = "admin")
@NamedQueries({
    @NamedQuery(
        name = "checkRegisteredId",
        query = "SELECT COUNT(e) FROM Admin AS e WHERE e.id = :id"
    ),
    @NamedQuery(
        name = "checkLoginIdAndAdminPassword",
        query = "SELECT e FROM Admin AS e WHERE e.id = :id AND e.adminPassword = :adminpass"
    )
})

@Entity
public class Admin implements Serializable {
    @Id
    @Column(name = "admin_id",nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer admin_id;


    @Column(name = "id", nullable = false)
    private String id;

    @Column(name = "adminPassword", length = 64, nullable = false)
    private String adminPassword;
    public Integer getAdmin_id() {
        return admin_id;
    }

    public void setAdmin_id(Integer admin_id) {
        this.admin_id = admin_id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
    }
}

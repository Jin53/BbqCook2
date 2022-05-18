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

@Table(name = "user")
@NamedQueries({
    @NamedQuery(
        name = "checkRegisteredCode",
        query = "SELECT COUNT(e) FROM User AS e WHERE e.mail = :mail"
    ),
    @NamedQuery(
        name = "checkLoginCodeAndPassword",
        query = "SELECT e FROM User AS e WHERE e.mail = :mail AND e.password = :pass"
    )
})
/**
 * Entity implementation class for Entity: User
 *
 */
@Entity
public class User implements Serializable {
    @Id
    @Column(name = "user_id",nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer user_id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "mail", nullable = false)
    private String mail;

    @Column(name = "password", length = 64, nullable = false)
    private String password;

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}


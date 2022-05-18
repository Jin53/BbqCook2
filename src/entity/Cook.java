package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@NamedQueries({
    @NamedQuery(
        name = "selectCookId",
        query = "SELECT c FROM Cook AS c WHERE c.cook_id = :cook_id"
    )
})
@Table(name="Cook")
public class Cook {
    @Id
    @Column(name = "cook_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cook_id;

    @Column(name = "cook_name")
    private String cook_name;

    @Column(name = "cook_cost")
    private Integer cook_cost;

    @Column(name = "cook_make")
    private String cook_make;

    public Integer getCook_id() {
        return cook_id;
    }

    public void setCook_id(Integer cook_id) {
        this.cook_id = cook_id;
    }

    public String getCook_name() {
        return cook_name;
    }

    public void setCook_name(String cook_name) {
        this.cook_name = cook_name;
    }

    public Integer getCook_cost() {
        return cook_cost;
    }

    public void setCook_cost(Integer cook_cost) {
        this.cook_cost = cook_cost;
    }

    public String getCook_make() {
        return cook_make;
    }

    public void setCook_make(String cook_make) {
        this.cook_make = cook_make;
    }

}

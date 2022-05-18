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
        name = "selectToolId",
        query = "SELECT m FROM Tools_cook AS m WHERE m.tools_id = :tools_id"
    )
})
@Table(name="tools_cook")
public class Tools_cook {
    @Id
    @Column(name = "tools_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer tools_id;

    @Column(name = "cook_id")
    private Integer cook_id;

    public Integer getTools_id() {
        return tools_id;
    }

    public void setTools_id(Integer tools_id) {
        this.tools_id = tools_id;
    }

    public Integer getCook_id() {
        return cook_id;
    }

    public void setCook_id(Integer cook_id) {
        this.cook_id = cook_id;
    }
}

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
        name = "selectFoodId",
        query = "SELECT m FROM Foods_cook AS m WHERE m.foods_id = :foods_id"
    )
})
@Table(name="foods_cook")
public class Foods_cook {
    @Id
    @Column(name = "foods_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer foods_id;

    @Column(name = "cook_id")
    private Integer cook_id;

    public Integer getFood_id() {
        return foods_id;
    }

    public void setFood_id(Integer food_id) {
        this.foods_id = food_id;
    }

    public Integer getCook_id() {
        return cook_id;
    }

    public void setCook_id(Integer cook_id) {
        this.cook_id = cook_id;
    }
}

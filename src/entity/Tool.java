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
        name = "getAllTool",
        query = "SELECT m FROM Tool AS m ORDER BY m.tool_id"
    ),
    @NamedQuery(
            name = "getToolCount",
            query = "SELECT COUNT(t) FROM Tool AS t"
        ),

    @NamedQuery(
            name = "getTool",
            query = "SELECT m FROM Tool AS m ORDER BY m.tool_id"
        )
})

@Table(name="tool")
public class Tool {
    @Id
    @Column(name = "Tool_id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer tool_id;

    @Column(name = "Tool_name")
    private String tool_name;

    @Column(name = "Tool_image")
    private String tool_image;

    public String getTool_image() {
        return tool_image;
    }

    public void setTool_image(String tool_image) {
        this.tool_image = tool_image;
    }

    public Integer getTool_id() {
        return tool_id;
    }

    public void setTool_id(Integer tool_id) {
        this.tool_id = tool_id;
    }

    public String getTool_name() {
        return tool_name;
    }

    public void setTool_name(String tool_name) {
        this.tool_name = tool_name;
    }

}

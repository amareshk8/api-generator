package <%= packageName %>.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="<%= tableName %>")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class <%= entityName %> {

    @Id
<%_ if (databaseType === 'mysql' || databaseType === 'mariadb') { _%>
    @GeneratedValue(strategy = GenerationType.AUTO)
<%_ } _%>
<%_ if (databaseType !== 'mysql' && databaseType !== 'mariadb') { _%>
    @SequenceGenerator(name = "<%= entityName %>_id_generator", sequenceName = "<%= entityName %>_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "<%= entityName %>_id_generator")
<%_ } _%>
    private Long id;

    @Column(nullable = false)
    @NotEmpty(message = "Text cannot be empty")
    private String text;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

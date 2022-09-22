package software.sigma.logsforuniversityapi.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "parameter")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Parameter {
    @Id
    private String content;

    @ManyToMany(mappedBy = "params", cascade = CascadeType.ALL)
    private List<LogRecord> logRecords;
}

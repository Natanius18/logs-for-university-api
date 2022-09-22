package software.sigma.logsforuniversityapi.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "log_record")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LogRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "log_record_seq_gen")
    @SequenceGenerator(name = "log_record_seq_gen", sequenceName = "log_record_id_seq", allocationSize=1)
    private Long id;
    private String principal;
    private String method;

    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(name = "parameter_to_log_record",
            joinColumns = @JoinColumn(name = "log_record_id"),
            inverseJoinColumns = @JoinColumn(name = "parameter_content"))
    private List<Parameter> params;
    private Date date;

}

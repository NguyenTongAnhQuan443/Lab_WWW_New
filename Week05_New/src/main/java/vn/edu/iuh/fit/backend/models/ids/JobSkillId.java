package vn.edu.iuh.fit.backend.models.ids;

import lombok.*;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
@ToString
public class JobSkillId implements Serializable {
    private long job;
    private long skill;
}


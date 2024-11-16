package vn.edu.iuh.fit.backend.models.ids;

import lombok.*;

import java.io.Serializable;


@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
@ToString
public class CandidateSkillId implements Serializable {
    private long skill;
    private long candidate;

}

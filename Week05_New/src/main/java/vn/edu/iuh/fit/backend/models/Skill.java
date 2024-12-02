package vn.edu.iuh.fit.backend.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import vn.edu.iuh.fit.backend.enums.SkillType;

import java.util.List;

@Entity
@Table(name = "skill")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Skill {
    @Id
    @Column(name = "skill_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "skill_type", columnDefinition = "tinyint(4)", nullable = false)
    private SkillType type;
    @Column(name = "skill_name", columnDefinition = "varchar(150)", nullable = false)
    private String skillName;
    @Column(name = "skill_desc", columnDefinition = "varchar(300)", nullable = false)
    private String skillDescription;
    @OneToMany(mappedBy = "skill", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<JobSkill> jobSkills;
    @OneToMany(mappedBy = "skill", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<CandidateSkill> candidateSkills;

    public Skill(long id) {
        this.id = id;
    }

    public Skill(SkillType type, String skillName, String skillDescription) {
        this.type = type;
        this.skillName = skillName;
        this.skillDescription = skillDescription;
    }

    @Override
    public String toString() {
        return "Skill{" +
                "id=" + id +
                ", type=" + type +
                ", skillName='" + skillName + '\'' +
                ", skillDescription='" + skillDescription + '\'' +
                '}';
    }

    public Skill(String skillDescription, String skillName, SkillType type, long id, List<JobSkill> jobSkills, List<CandidateSkill> candidateSkills) {
        this.skillDescription = skillDescription;
        this.skillName = skillName;
        this.type = type;
        this.id = id;
        this.jobSkills = jobSkills;
        this.candidateSkills = candidateSkills;
    }
}

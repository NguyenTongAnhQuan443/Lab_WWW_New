package vn.edu.iuh.fit.backend.converters;

import jakarta.persistence.AttributeConverter;
import vn.edu.iuh.fit.backend.enums.SkillType;

public class SkillTypeConverter implements AttributeConverter<SkillType, Integer> {
    @Override
    public Integer convertToDatabaseColumn(SkillType attribute) {
        return attribute.getNumValue();
    }

    @Override
    public SkillType convertToEntityAttribute(Integer dbData) {
        return SkillType.getSkillType(dbData);
    }
}

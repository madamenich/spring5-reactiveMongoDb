package com.advance.springwebflux.mapper;

import com.advance.springwebflux.dto.StudentDto;
import com.advance.springwebflux.model.Student;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface StudentMapper {
    @Mapping(target = "id",ignore = true)
    Student toModel(StudentDto studentDto);
}

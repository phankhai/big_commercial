package com.example.big_commercial.service.mapper;

import com.example.big_commercial.common.mapper.EntityMapper;
import com.example.big_commercial.dto.UserDTO;
import com.example.big_commercial.entity.UserEntity;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring", uses = {})
@Component
public interface UserMapper extends EntityMapper<UserDTO, UserEntity> {

}

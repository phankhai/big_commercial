package com.example.big_commercial.service.impl;

import com.example.big_commercial.config.BadRequestException;
import com.example.big_commercial.dto.UserDTO;
import com.example.big_commercial.entity.UserEntity;
import com.example.big_commercial.enums.ErrorCodeMap;
import com.example.big_commercial.repository.UserRepository;
import com.example.big_commercial.service.UserService;
import com.example.big_commercial.service.mapper.UserMapper;
import com.example.big_commercial.service.specification.GenericSpecificationBuilder;
import com.example.big_commercial.service.specification.SearchCriteria;
import com.example.big_commercial.utils.MapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserMapper userMapper;

    @Override
    public Page<UserDTO> findPaging(Pageable pageable, UserDTO userDTO) {
        // filter
        SearchCriteria searchCriteria = new SearchCriteria("firstName", "=", userDTO.getFirstName());
        Page<UserEntity> userEntityPage = userRepository.findAll(Specification.where(new GenericSpecificationBuilder<UserEntity>(searchCriteria)), pageable);
        Page<UserDTO> userDTOS = userEntityPage.map(userMapper::toDto);
        return userDTOS;
    }

    @Override
    public Iterable<UserDTO> findAll() {
        return null;
    }

    @Override
    public Optional<UserDTO> findById(Long id) {
        Optional<UserEntity> findId = userRepository.findById(id);
        if (!findId.isPresent()) {
            throw new BadRequestException(ErrorCodeMap.FAILURE_USER_NOT_EXISTED.name());
        }
        UserDTO userDTO = userMapper.toDto(findId.get());
        return userDTO != null ? Optional.of(userDTO) : null;
    }

    @Override
    public UserDTO save(UserDTO userDTO) {
        UserEntity userEntity = userMapper.toEntity(userDTO);
        userEntity.setJoinDate(Calendar.getInstance().getTime());
        userRepository.save(userEntity);
        return userDTO;
    }

    @Override
    public UserDTO update(Long id, UserDTO userDTO) {
        Optional<UserEntity> userEntity = userRepository.findById(id);
        if (!userEntity.isPresent()) {
            throw new BadRequestException(ErrorCodeMap.FAILURE_USER_NOT_EXISTED.name());
        }
        MapperUtils.dto2Entity(userDTO, userEntity.get());
        userRepository.save(userEntity.get());
        return userDTO;
    }

    @Override
    public void remove(Long id) {
        Optional<UserEntity> userExist = userRepository.findById(id);
        if (userExist.isPresent()) {
            userRepository.delete(userExist.get());
        } else {
            throw new BadRequestException(ErrorCodeMap.FAILURE_USER_NOT_EXISTED.name());
        }
    }


}

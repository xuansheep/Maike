package com.john.order.dao;

import com.john.order.domain.dto.UserDTO;
import org.mapstruct.Mapper;
import org.springframework.data.jpa.repository.JpaRepository;

@Mapper
public interface UserRepository extends JpaRepository<UserDTO, Long> {

    UserDTO findByUsername(String username);
}

package projectSpringboot.service;

import java.util.List;

import projectSpringboot.entity.UserEntity;

public interface IUser {
	UserEntity save(UserEntity userDTO);
	List<UserEntity> findAllUser();
	UserEntity findById(Long id);
	UserEntity findByGmail(String gmail);
	
}

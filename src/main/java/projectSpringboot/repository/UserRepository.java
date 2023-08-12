package projectSpringboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import projectSpringboot.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
	UserEntity findByGmail(String mailUser);
}

package com.app;

import com.app.percistence.entity.PermissionEntity;
import com.app.percistence.entity.RoleEntity;
import com.app.percistence.entity.RoleEnum;
import com.app.percistence.entity.UserEntity;
import com.app.percistence.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Set;

@SpringBootApplication
public class SpringSecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityApplication.class, args);
	}

	@Bean
	CommandLineRunner initData(UserRepository userRepository){
		return args -> {

			//Permissions
			PermissionEntity createPermission = PermissionEntity.builder().name("CREATE").build();
			PermissionEntity readPermission = PermissionEntity.builder().name("READ").build();
			PermissionEntity updatePermission = PermissionEntity.builder().name("UPDATE").build();
			PermissionEntity deletePermission = PermissionEntity.builder().name("DELETE").build();
			PermissionEntity refactorPermission = PermissionEntity.builder().name("REFACTOR").build();

			//Roles
			RoleEntity roleAdmin = RoleEntity.builder()
					.role(RoleEnum.ADMIN)
					.permissions(Set.of(createPermission, readPermission, updatePermission, deletePermission))
					.build();

			RoleEntity roleUser = RoleEntity.builder()
					.role(RoleEnum.USER)
					.permissions(Set.of(createPermission, readPermission))
					.build();

			//Users
			UserEntity userKevin = UserEntity.builder()
					.username("Kevin")
					.password("1234")
					.roles(Set.of(roleAdmin))
					.isEnabled(true)
					.isAccountNonExpired(true)
					.isAccountNonLocked(true)
					.isCredentialsNonExpired(true)
					.build();

			UserEntity userJohn = UserEntity.builder()
					.username("John")
					.password("1234")
					.roles(Set.of(roleUser))
					.isEnabled(true)
					.isAccountNonExpired(true)
					.isAccountNonLocked(true)
					.isCredentialsNonExpired(true)
					.build();

			userRepository.saveAll(Set.of(userKevin, userJohn));
		};
	}

}

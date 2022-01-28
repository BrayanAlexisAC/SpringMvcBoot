package com.company.springBootApp.repositoies;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.company.springBootApp.objects.Users;
import com.company.springBootApp.objects.classId.UsersId;

public interface UsersRepository extends JpaRepository<Users, UsersId> {
//	we can use annotation @Param("{variable}") by specify name of variable at query or use of same name of variable
	@Query("select case when (count(user) > 0) then true else false end from SEC_USERS user where user.name = :name")
	public boolean existUserByName(String name);
	
	public Optional<Users> findByName(String name);
}

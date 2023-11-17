package com.glca.app.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.glca.app.entity.Ticket;

@Repository
public interface ITicketRepo extends JpaRepository<Ticket, Integer> {

	@Query("SELECT t FROM Ticket t WHERE t.title LIKE %:name%")
	List<Ticket> searchByName(@Param("name") String name);
}

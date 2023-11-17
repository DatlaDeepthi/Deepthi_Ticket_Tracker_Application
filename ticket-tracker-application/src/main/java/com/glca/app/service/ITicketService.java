package com.glca.app.service;

import java.util.List;

import com.glca.app.entity.Ticket;

public interface ITicketService {
	public Ticket addTicket(Ticket ticket);

	public Ticket getTicket(int ticketId);

	public List<Ticket> getAllTickets();

	public Ticket updateTicket(Ticket ticket);

	public boolean deleteTicket(int ticketId);

	public List<Ticket> searchTicketsByName(String name);
}

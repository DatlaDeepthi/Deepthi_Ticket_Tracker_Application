package com.glca.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.glca.app.entity.Ticket;
import com.glca.app.repo.ITicketRepo;

@Service
public class TicketServiceImple implements ITicketService {
	@Autowired
	private ITicketRepo ticketDao;

	@Override
	public Ticket addTicket(Ticket ticket) {
		// TODO Auto-generated method stub
		Ticket t = ticketDao.save(ticket);
		return t;
	}

	@Override
	public Ticket getTicket(int ticketId) {
		// TODO Auto-generated method stub
		return ticketDao.findById(ticketId).get();
	}

	@Override
	public List<Ticket> getAllTickets() {
		// TODO Auto-generated method stub
		return ticketDao.findAll();
	}

	@Override
	public Ticket updateTicket(Ticket ticket) {
		// TODO Auto-generated method stub
		Ticket t = getTicket(ticket.getId());
		t.setTitle(ticket.getTitle());
		t.setTicketShortDescription(ticket.getTicketShortDescription());
		t.setTicketCreatedOn(ticket.getTicketCreatedOn());
		ticketDao.save(t);
		return t;
	}

	@Override
	public boolean deleteTicket(int ticketId) {
		// TODO Auto-generated method stub
		ticketDao.deleteById(ticketId);
		return true;
	}

	public List<Ticket> searchTicketsByName(String name) {
		return ticketDao.searchByName(name);
	}
}

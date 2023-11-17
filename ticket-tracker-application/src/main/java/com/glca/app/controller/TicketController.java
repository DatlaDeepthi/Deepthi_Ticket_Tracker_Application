package com.glca.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.glca.app.entity.Ticket;
import com.glca.app.service.ITicketService;

@Controller
public class TicketController {
	@Autowired
	private ITicketService ticketService;

	@RequestMapping("/")
	public String listOfTickets(Model model) {
		List<Ticket> ticketList = ticketService.getAllTickets();
		System.out.println(ticketList);
		model.addAttribute("tickets", ticketList);
		return "list-of-tickets";
	}

	@GetMapping("/createTicket")
	public String showTicketForm(Model model) {
		model.addAttribute("tickets", new Ticket());
		return "create-tickets";
	}

	@PostMapping("/createTicket")
	public String createTicket(@ModelAttribute Ticket ticket) {
		ticketService.addTicket(ticket);
		return "redirect:/";
	}

	@RequestMapping("/listOfTickets")
	public String listOfTicket(Model model) {
		List<Ticket> ticketList = ticketService.getAllTickets();
		System.out.println(ticketList);
		model.addAttribute("tickets", ticketList);
		return "list-of-tickets";
	}

	@RequestMapping("/showUpdateForm")
	public String showUpdateForm(@RequestParam("id") int ticketId, Model model) {
		Ticket ticketInfo = ticketService.getTicket(ticketId);
		model.addAttribute("tickets", ticketInfo);
		return "update-ticket";
	}

	@RequestMapping("/updateTicket")
	public String updateTicket(@ModelAttribute("ticket") Ticket tic) {
		Ticket t = ticketService.updateTicket(tic);
		return "redirect:/listOfTickets";
	}

	@RequestMapping("/deleteTicket")
	public String deleteTicket(@RequestParam("id") int ticketId) {
		ticketService.deleteTicket(ticketId);
		return "redirect:/listOfTickets";
	}

	@RequestMapping("/viewTicket")
	public String viewTicket(@RequestParam("id") int ticketId, Model model) {
		Ticket ticket = ticketService.getTicket(ticketId);
		model.addAttribute("tickets", ticket);
		return "view-ticket";
	}

	@GetMapping("/search")
	public String searchTickets(@RequestParam("name") String name, Model model) {
		List<Ticket> tickets = ticketService.searchTicketsByName(name);
		model.addAttribute("tickets", tickets);
		return "search";
	}

	@RequestMapping("/Tickets")
	public String TicketList(Model model) {
		List<Ticket> ticketList = ticketService.getAllTickets();
		System.out.println(ticketList);
		model.addAttribute("tickets", ticketList);
		return "ticket-list";
	}
}

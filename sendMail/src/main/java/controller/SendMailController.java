package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import service.SendMailService;

@Controller
public class SendMailController {
	
	@Autowired
	private SendMailService sendMailService;
	
	@GetMapping
	public String index() {
		return "send_mail_view";
	}
	
	@PostMapping("/sendMail")
	public String sendMail(@RequestParam("name") String name, @RequestParam("mail") String mail, @RequestParam("subject") String subject, @RequestParam("body") String body) {
		String message = body + "\n\n Datos del contacto: " + "\nNombre: " + name + "\nEmail: " + mail + "\nAsunto: " + subject;
		
		sendMailService.sendMail("enzogabrielguido5@gmail.com", "enzogabrielguido3@hotmail.com", subject, body);
		
		return "send_mail_view";
	}
}

/*
 * package br.projeto.virtualdealer.controllers;
 * 
 * import javax.mail.internet.MimeMessage;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.mail.javamail.JavaMailSender; import
 * org.springframework.mail.javamail.MimeMessageHelper; import
 * org.springframework.web.bind.annotation.RequestMapping; import
 * org.springframework.web.bind.annotation.RequestMethod; import
 * org.springframework.web.bind.annotation.RestController;
 * 
 * import br.projeto.virtualdealer.model.Cliente;
 * 
 * @RestController public class EmailController {
 * 
 * @Autowired private JavaMailSender mailSender;
 * 
 * @RequestMapping(path = "/salvarFormularioCliente", method =
 * RequestMethod.GET) public String emailConfirmacao(Cliente cliente) {
 * 
 * try {
 * 
 * MimeMessage mail = mailSender.createMimeMessage();
 * 
 * MimeMessageHelper helper = new MimeMessageHelper(mail);
 * helper.setTo(cliente.getEmailCliente()); helper.setSubject("teste de envio");
 * helper.setText("<h1>Ola Mundo</h1>"); mailSender.send(mail); return "ok";
 * 
 * } catch (Exception e) {
 * 
 * e.printStackTrace(); return "erro ao enviar";
 * 
 * } } }
 */
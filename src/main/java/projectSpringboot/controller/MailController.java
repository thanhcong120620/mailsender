package projectSpringboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import projectSpringboot.algorithms.GmailProcess;
import projectSpringboot.algorithms.NameProcess;
import projectSpringboot.entity.UserEntity;
import projectSpringboot.service.IUser;
import projectSpringboot.service.implement.MailServiceOneRiver;
import projectSpringboot.service.implement.MailServiceVictoria;
import projectSpringboot.service.implement.MailServiceVictoria2;

@Controller
public class MailController {

	
	 @Autowired MailServiceOneRiver mailServiceOneRiver; 
	 

		
//		  @Autowired MailServiceVictoria2 mailServiceVictoria;
	 
	 @Autowired 
	 MailServiceVictoria2 mailServiceVictoria;
		 

	@Autowired
	private IUser userService;

	/*
	 * Display all data
	 */
	@GetMapping("/mail-home")
	public String home(Model model) {

		List<UserEntity> userResponse = userService.findAllUser();
		model.addAttribute("userResponse", userResponse);

		return "trang-chu";
	}

	/*
	 * Send Draft
	 */
	@PostMapping("/send-draft")
	public String sendDraft(Model model, @RequestParam(value = "subjectD", required = false) String subject,
			@RequestParam(value = "mailCheck", required = false) String mailCheck) {

		System.out.println("Subject: " + subject);
		System.out.println("Mail: " + mailCheck);
		GmailProcess processedMail = new GmailProcess();
		String[] mailArray = processedMail.splitMail(mailCheck);
		for (int i = 0; i < mailArray.length; i++) {
			String mail = mailArray[i];
			mailServiceVictoria.sendMail(subject, mail, "Mr. Công", "anh Công", "Anh Công", "anh", 1L);
		}

		return "redirect:/mail-home";
	}

	/*
	 * Send All
	 */
	@PostMapping("/send-all")
	public String sendAll(Model model, @RequestParam(value = "subjectA", required = false) String subject) {
		System.out.println("Subject: " + subject);
		List<UserEntity> userList = userService.findAllUser();
		for (int i = 0; i < userList.size(); i++) {
			UserEntity user = userList.get(i);
			// Xử lý user mail
			GmailProcess processedMail = new GmailProcess();
			String mail = processedMail.deleteBlank(user.getGmail());
			Long id = user.getId();
			// Xử lý user name
			if (userList.get(i).getFullName().isEmpty() || userList.get(i).getFullName().equals("")) {
				// Send mail
				mailServiceVictoria.sendMail(subject, mail, "Quý khách hàng", "anh/chị", "Anh/Chị", "fm", id);
			} else {
				NameProcess nameProcess = new NameProcess();
				String headerName = nameProcess.NameHeader(user.getFullName(), user.getGenderUser());
				String normalName = nameProcess.NameUserN(user.getFullName(), user.getGenderUser());
				String caplockName = nameProcess.NameUserC(user.getFullName(), user.getGenderUser());
				String gender = nameProcess.GenderUser(user.getGenderUser());

				// Send mail
				mailServiceVictoria.sendMail(subject, mail, headerName, normalName, caplockName, gender, id);
			}
			System.out.println(">>> Đã gửi đến user có id: "+ user.getId());
		}

		return "redirect:/mail-home";
	}

	/*------------------------------------User Controller------------------------------------*/

	/*
	 * Send update result
	 */
	@PutMapping("/update-result")
	public String updateResult(@RequestBody List<UserEntity> userRequestList) {
		for (int i = 0; i < userRequestList.size(); i++) {
			UserEntity userRequest = userRequestList.get(i);
			UserEntity updateUser = userService.save(userRequest);
			System.out.println(updateUser.toString());
		}

		return "redirect:/mail-home";
	}

	@GetMapping("/get-onedata")
	public UserEntity getOneData(@RequestBody Long id) {
		UserEntity userResponse = userService.findById(id);
		return userResponse;
	}

	@GetMapping("/get-alldata")
	public String getAll() {
		List<UserEntity> userList = userService.findAllUser();
		for (int i = 0; i < userList.size(); i++) {
			UserEntity user = userList.get(i);
			// Xử lý user name
			if (userList.get(i).getFullName().isEmpty() || userList.get(i).getFullName().equals("")) {
				// Send mail
				System.out.println("User " + i + ": " + userList.get(i).toString());
			} else {
				NameProcess nameProcess = new NameProcess();
				String headerName = nameProcess.NameHeader(user.getFullName(), user.getGenderUser());
				String normalName = nameProcess.NameUserN(user.getFullName(), user.getGenderUser());
				String caplockName = nameProcess.NameUserC(user.getFullName(), user.getGenderUser());
				String gender = nameProcess.GenderUser(user.getGenderUser());

				// Send mail
				System.out.println("User " + i + ": " + userList.get(i).toString());
			}

		}

		return "redirect:/mail-home";
	}

}

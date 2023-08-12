package projectSpringboot.service.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Service;

import projectSpringboot.entity.UserEntity;
import projectSpringboot.service.IUser;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import java.io.File;
import java.util.Properties;

@Service
public class MailServiceOneRiver {
	private static final String CONTENT_TYPE_TEXT_HTML = "text/html;charset=\"utf-8\"";

	@Value("${config.mail.host}")
	private String host;
	@Value("${config.mail.port}")
	private String port;
	@Value("${config.mail.username}")
	private String email;
	@Value("${config.mail.password}")
	private String password;

	@Autowired
	ThymeleafService thymeleafService;
	
	@Autowired
	private IUser userService;

	public void sendMail(String subjectMail, String mailUser, String headerName, String normalName, String caplockName,
			String gender, Long id) {
		Properties props = new Properties();
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", port);

		Session session = Session.getInstance(props, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(email, password);
			}
		});
		Message message = new MimeMessage(session);
		try {
			//
			MimeMultipart multipart = new MimeMultipart("related");
			BodyPart textPart = new MimeBodyPart();
			String htmlText = 
					"<html><head>"
					+ "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">"
					+"<style>\r\n"
					+ "    .gmail {\r\n"
					+ "        padding: 10px;\r\n"
					+ "        position: center;\r\n"
					+ "        width: 100%;\r\n"
					+ "        justify-content: center;\r\n"
					+ "\r\n"
					+ "\r\n"
					+ "    }\r\n"
					+ "  p {\r\n"
					+ "        font-size: 13px;\r\n"
					+ "    }"
					+"      @media only screen and (min-width: 786px) {\r\n"
					+ "        .grimg1 {\r\n"
					+ "          width: 70%;\r\n"
					+ "          display: block;\r\n"
					+ "          margin-left: auto;\r\n"
					+ "          margin-right: auto;\r\n"
					+ "        }\r\n"
					+ "        .grimg2 {\r\n"
					+ "          width: 80%;\r\n"
					+ "          display: block;\r\n"
					+ "          margin-left: auto;\r\n"
					+ "          margin-right: auto;\r\n"
					+ "        }"
					+ "		   .sign {\r\n"
					+ "          display: inline-block;\r\n"
					+ "        }\r\n"
					+ "        .signimg {\r\n"
					+ "          width: 30%;\r\n"
					+ "          float: left;\r\n"
					+ "        }\r\n"
					+ "        .my-contact {\r\n"
					+ "          float: right;\r\n"
					+ "          width: 60%;\r\n"
					+ "        }"
					+ "      }\r\n"
					+ "      @media only screen and (min-width: 992px) {\r\n"
					+ "        .grimg1 {\r\n"
					+ "          width: 50%;\r\n"
					+ "          display: block;\r\n"
					+ "          margin-left: auto;\r\n"
					+ "          margin-right: auto;\r\n"
					+ "        }\r\n"
					+ "        .grimg2 {\r\n"
					+ "          width: 70%;\r\n"
					+ "          display: block;\r\n"
					+ "          margin-left: auto;\r\n"
					+ "          margin-right: auto;\r\n"
					+ "        }"
					+ "        .sign {\r\n"
					+ "          display: inline-block;\r\n"
					+ "        }\r\n"
					+ "        .signimg {\r\n"
					+ "          width: 30%;\r\n"
					+ "          float: left;\r\n"
					+ "        }\r\n"
					+ "        .my-contact {\r\n"
					+ "          float: right;\r\n"
					+ "          width: 60%;\r\n"
					+ "        }"
					+ "      }"
					+ "</style>\r\n"
					+ "\r\n"
					+ "</head>\r\n"
					+ "<body>\r\n"
					+ "\r\n"
					+ "    <div class=\"gmail\">\r\n"
					+ "        <h3 style=\"font-size:16px;\">Kính gửi "+headerName+" ! </h3>\r\n"
					+ "        <p>Tôi là Nguyễn Thành Công – Chuyên viên kinh doanh từ tập đoàn Regal Group.</p>\r\n"
					+ "        <p>Regal Group (tiền thân là Đất xanh Miền Trung thành lập năm 2012) là đơn vị Tiên Phong trong hạng mục phát triển \r\n"
					+ "            Bất Động Sản Hạng Sang được hình thành và khẳng định vị thế riêng theo chuỗi “Regal Homes” kinh doanh cao cấp.</p>\r\n"
					+ "\r\n"
					+ "<p>\r\n"
					+ "    Regal group giới thiệu đến "+normalName+" dự án biệt thự 5 sao One River sở hữu mặt sông Cổ Cò của Đà Nẵng – Dự án được trao giải thưởng danh giá “Dự án Đáng sống 2020” ( https://www.nguoiduatin.vn/giai-thuong-danh-gia-du-an-dang-song-2020-goi-ten-one-river-villas-cua-dat-xanh-mien-trung-a482600.html )..\r\n"
					+ "</p>\r\n"
					+ "<div class=\"grimg1\">\r\n"
					+ "    <img src=\"cid:image1\" style=\"width: 100%;height: auto;\" />\r\n"
					+ "    <img src=\"cid:image2\" style=\"width: 100%;height: auto;\" />\r\n"
					+ "    <img src=\"cid:image3\" style=\"width: 100%;height: auto;\" />\r\n"
					+ "</div>\r\n"
					+ "\r\n"
					+ "\r\n"
					+ "<p>\r\n"
					+ "    Chủ đầu tư dự án là Regal group, đã có sổ hồng lâu dài. Hiện tại, dự án đã đi vào hoạt động (35/36) căn, dự án chỉ còn 1 căn\r\n"
					+ "     mà chúng tôi muốn giới thiệu đến "+normalName+".\r\n"
					+ "</p>\r\n"
					+ "<p>\r\n"
					+ "    Dự án One River nằm trong khu vực biển Non Nước Đà Nẵng, sông Cổ Cò và khu du lịch núi Ngũ Hành Sơn. Trên tu yến du lịch \r\n"
					+ "    trung tâm Đà Nẵng – Hội An. Vị trí độc tôn nằm giữa khu du lịch biển Đà Nẵng và phố cổ Hội An.\r\n"
					+ "</p>\r\n"
					+ "\r\n"
					+ "<div class=\"grimg2\">"
					+ "<img src=\"cid:image4\" style=\"width: 100%;height: auto;\"  />\r\n"
					+ "</div>\r\n"
					
					+ "<p>\r\n"
					+ "    Đây là dự án duy nhất tại Đà Nẵng sở hữu trực tiếp mặt sông, mỗi căn sở hữu một khuôn viên lối đi bộ riêng trước mặt sông. \r\n"
					+ "</p>\r\n"
					+ "\r\n"
					+ "<div class=\"grimg1\">"
					+ "<img src=\"cid:image5\" style=\"width: 100%;height: auto;\"  />\r\n"
					+ "</div>\r\n"					
					+ "<p>\r\n"
					
					+ "    Dự án có quy mô 36 căn, diện tích sử dụng 591,8m2. Thiết kế 3 tầng, bao gồm: 4PN, phòng khách thông tầng, gara, hồ bơi… Hệ vật liệu xa xỉ, \r\n"
					+ "    đá khổ to Marble, kính hộp kibbing (2 lớp Low-e cản UV). Thiết kế theo quy chuẩn 5 sao của Regal Homes – Trường tồn theo thời gian.\r\n"
					+ "</p>\r\n"
					+ "\r\n"
					+ "<div class=\"grimg1\" >\r\n"
					+ "    <img src=\"cid:image6\" style=\"width: 100%;height: auto;\" />\r\n"
					+ "    <img src=\"cid:image7\" style=\"width: 100%;height: auto;\" />\r\n"
					+ "    <img src=\"cid:image8\" style=\"width: 100%;height: auto;\" />\r\n"
					+ "</div>\r\n"
					+ "<p>\r\n"
					+ "    Lấy sự hài lòng của khách hàng là hàng đầu, đội ngũ chăm sóc khách hàng hỗ trợ 24/7. \r\n"
					+ "</p>\r\n"
					+ "<p>\r\n"
					+ "    Xin cảm ơn "+normalName+" đã dành thời gian đọc hết thư này, hy vọng chúng tôi có cơ hội được hợp tác làm việc với "+gender+". \r\n"
					+ "    Chúc "+normalName+" một ngày vui vẻ và có những chuỗi công việc hiệu quả. \r\n"
					+ "</p>\r\n"
					+ "<hr/>\r\n"
					+ "<p>\r\n"
					+ "    <b>Mọi thông tin chi tiết xin liên hệ:</b> \r\n"
					+ "</p>\r\n"
					+ "\r\n"
					+ "<div class=\"sign\" style=\"display: inline-block ;\">\r\n"
					+ "    <div class=\"signimg\">\r\n"
					+ "    		<img src=\"cid:imagesign\" style=\""
					+ "				 width: 300px;\r\n"
					+ "              height: auto;\r\n"
					+ "              margin-top: -20px;\r\n"
					+ "              display: block;\r\n"
					+ "              margin-left: auto;\r\n"
					+ "              margin-right: auto;\" />\r\n"
					+ "    </div>\r\n"
					+ "    <div class=\"my-contact\" style=\"margin-top: 30px;\">\r\n"
					+ "        <p><b>NGUYỄN THÀNH CÔNG – CHUYÊN VIÊN KINH DOANH CAO CẤP</b></p>\r\n"
					+ "        <p>Mobile/<b>Zalo</b>: 0368 279 613 </p>\r\n"
					+ "        <p style=\"margin-top: -10px;\">Email: chuyenvientuvan.regalgroup@gmail.com</p>\r\n"
					+ "        <hr/>\r\n"
					+ "        <p><b>CÔNG TY CỔ PHẦN REGAL GROUP</b></p>\r\n"
					+ "        <p>Địa chỉ: 52-54 Võ Văn Kiệt, Đà Nẵng</p>\r\n"
					+ "        <p style=\"margin-top: -10px;\">Tel: (0236) 6266266 | Ext: 1251 | Web: datxanhmientrung.com</p>\r\n"
					+ "    </div>\r\n"
					+ "</div>\r\n"
					+ "\r\n"
					+ "\r\n"
					+ "\r\n"
					+ "    </div>"
					
					+ "</body></html>";

			textPart.setContent(htmlText, "text/html;charset=\"utf-8\"");
			multipart.addBodyPart(textPart);
			
			BodyPart imagePart1 = new MimeBodyPart();
			DataSource fds1 = new FileDataSource("D:\\My data\\My work\\Regal group\\Marketing\\E-Mail(6r-7h)\\Giới thiệu One River\\img\\1.jpg");
			imagePart1.setDataHandler(new DataHandler(fds1));
			imagePart1.setHeader("Content-ID", "<image1>");
			imagePart1.setDisposition(MimeBodyPart.INLINE);
			multipart.addBodyPart(imagePart1);
			
			BodyPart imagePart2 = new MimeBodyPart();
			DataSource fds2 = new FileDataSource("D:\\My data\\My work\\Regal group\\Marketing\\E-Mail(6r-7h)\\Giới thiệu One River\\img\\2.jpg");
			imagePart2.setDataHandler(new DataHandler(fds2));
			imagePart2.setHeader("Content-ID", "<image2>");
			imagePart2.setDisposition(MimeBodyPart.INLINE);
			multipart.addBodyPart(imagePart2);
			
			BodyPart imagePart3 = new MimeBodyPart();
			DataSource fds3 = new FileDataSource("D:\\My data\\My work\\Regal group\\Marketing\\E-Mail(6r-7h)\\Giới thiệu One River\\img\\3.jpg");
			imagePart3.setDataHandler(new DataHandler(fds3));
			imagePart3.setHeader("Content-ID", "<image3>");
			imagePart3.setDisposition(MimeBodyPart.INLINE);
			multipart.addBodyPart(imagePart3);
			
			BodyPart imagePart4 = new MimeBodyPart();
			DataSource fds4 = new FileDataSource("D:\\My data\\My work\\Regal group\\Marketing\\E-Mail(6r-7h)\\Giới thiệu One River\\img\\4.jpg");
			imagePart4.setDataHandler(new DataHandler(fds4));
			imagePart4.setHeader("Content-ID", "<image4>");
			imagePart4.setDisposition(MimeBodyPart.INLINE);
			multipart.addBodyPart(imagePart4);
			
			BodyPart imagePart5 = new MimeBodyPart();
			DataSource fds5 = new FileDataSource("D:\\My data\\My work\\Regal group\\Marketing\\E-Mail(6r-7h)\\Giới thiệu One River\\img\\5.jpg");
			imagePart5.setDataHandler(new DataHandler(fds5));
			imagePart5.setHeader("Content-ID", "<image5>");
			imagePart5.setDisposition(MimeBodyPart.INLINE);
			multipart.addBodyPart(imagePart5);
			
			BodyPart imagePart6 = new MimeBodyPart();
			DataSource fds6 = new FileDataSource("D:\\My data\\My work\\Regal group\\Marketing\\E-Mail(6r-7h)\\Giới thiệu One River\\img\\6.jpg");
			imagePart6.setDataHandler(new DataHandler(fds6));
			imagePart6.setHeader("Content-ID", "<image6>");
			imagePart6.setDisposition(MimeBodyPart.INLINE);
			multipart.addBodyPart(imagePart6);
			
			BodyPart imagePart7 = new MimeBodyPart();
			DataSource fds7 = new FileDataSource("D:\\My data\\My work\\Regal group\\Marketing\\E-Mail(6r-7h)\\Giới thiệu One River\\img\\7.jpg");
			imagePart7.setDataHandler(new DataHandler(fds7));
			imagePart7.setHeader("Content-ID", "<image7>");
			imagePart7.setDisposition(MimeBodyPart.INLINE);
			multipart.addBodyPart(imagePart7);
			
			BodyPart imagePart8 = new MimeBodyPart();
			DataSource fds8 = new FileDataSource("D:\\My data\\My work\\Regal group\\Marketing\\E-Mail(6r-7h)\\Giới thiệu One River\\img\\8.jpg");
			imagePart8.setDataHandler(new DataHandler(fds8));
			imagePart8.setHeader("Content-ID", "<image8>");
			imagePart8.setDisposition(MimeBodyPart.INLINE);
			multipart.addBodyPart(imagePart8);
			
			BodyPart imagePartsign = new MimeBodyPart();
			DataSource fdssign = new FileDataSource("D:\\My data\\My work\\Regal group\\Marketing\\E-Mail(6r-7h)\\Giới thiệu One River\\img\\sign.png");
			imagePartsign.setDataHandler(new DataHandler(fdssign));
			imagePartsign.setHeader("Content-ID", "<imagesign>");
			imagePartsign.setDisposition(MimeBodyPart.INLINE);
			multipart.addBodyPart(imagePartsign);
			
			
			
			
			message.setContent(multipart);
			//
			message.setRecipients(Message.RecipientType.TO, new InternetAddress[] { new InternetAddress(mailUser) });

			message.setFrom(new InternetAddress(email));
			message.setSubject(subjectMail);
//          message.setContent(thymeleafService.getContent(nameUser, passwordUser), CONTENT_TYPE_TEXT_HTML);
			message.setContent(multipart);
			
			//Set status
			UserEntity user = userService.findById(id);
			user.setStatus("Đã gửi");
			userService.save(user);

			//Send
			Transport.send(message);
		} catch (MessagingException e) {
			System.out.println("===>Lỗi e: " + e);
			//Set status
			UserEntity user = userService.findById(id);
			user.setStatus("Error");
			userService.save(user);
			e.printStackTrace();
		}
	}
}

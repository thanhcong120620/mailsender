package projectSpringboot.service.implement;

import java.util.Properties;

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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import projectSpringboot.entity.UserEntity;
import projectSpringboot.service.IUser;

@Service
public class MailServiceVictoria {
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
					
					+ "<link\r\n"
					+ "      rel=\"stylesheet\"\r\n"
					+ "      href=\"https://pro.fontawesome.com/releases/v5.15.4/css/all.css?fbclid=IwAR1YsW4Cd3uJltNc6k1kJ8R9VzNjmSXk9rjmW32BPoA6LWxNrZBCUY-D4i8\"\r\n"
					+ "    />\r\n"
					+ "\r\n"
					+ "    <style>\r\n"
					+ "      body {\r\n"
					+ "        padding: 10px;\r\n"
					+ "      }"
					+ "      .centerP {\r\n"
					+ "        text-align: center;\r\n"
					+ "      }\r\n"
					+ "      ul.myUL {\r\n"
					+ "        display: inline-block;\r\n"
					+ "        text-align: left;\r\n"
					+ "        list-style-type: none;\r\n"
					+ "        margin-top: -12px;\r\n"
					+ "      }\r\n"
					+ "      .gmail p {\r\n"
					+ "        font-size: 15px;\r\n"
					+ "      }\r\n"
					+ "      .gmail {\r\n"

					+ "        position: center;\r\n"
					+ "        width: 98%;\r\n"
					+ "        justify-content: center;\r\n"
					+ "      }\r\n"
					+ "\r\n"
					+ "      @media only screen and (min-width: 786px) {\r\n"
					+ "        .grimg1 {\r\n"
					+ "          width: 80%;\r\n"
					+ "          display: block;\r\n"
					+ "          margin-left: auto;\r\n"
					+ "          margin-right: auto;\r\n"
					+ "        }\r\n"
					+ "        .grimg2 {\r\n"
					+ "          width: 90%;\r\n"
					+ "          display: block;\r\n"
					+ "          margin-left: auto;\r\n"
					+ "          margin-right: auto;\r\n"
					+ "        }\r\n"
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
					+ "        }\r\n"
					+ "      }\r\n"
					+ "      @media only screen and (min-width: 992px) {\r\n"
					+ "        .grimg1 {\r\n"
					+ "          width: 60%;\r\n"
					+ "          display: block;\r\n"
					+ "          margin-left: auto;\r\n"
					+ "          margin-right: auto;\r\n"
					+ "        }\r\n"
					+ "        .grimg2 {\r\n"
					+ "          width: 80%;\r\n"
					+ "          display: block;\r\n"
					+ "          margin-left: auto;\r\n"
					+ "          margin-right: auto;\r\n"
					+ "        }\r\n"
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
					+ "        }\r\n"
					+ "      }\r\n"
					+ "    </style>\r\n"
					+ "  </head>\r\n"
					+ "  <body>\r\n"
					+ "    <div class=\"gmail\">\r\n"
					+ "      <div class=\"begin\">\r\n"
					+ "        <h3>Kính gửi "+headerName+" !</h3>\r\n"
					+ "        <p>\r\n"
					+ "          Tôi là Thành Công – Chuyên viên kinh doanh từ tập đoàn Regal\r\n"
					+ "          Group. Tiền thân là Đất xanh Miền Trung thành lập năm 2011, là đơn vị\r\n"
					+ "          Tiên Phong trong hạng mục phát triển Bất Động Sản Hạng Sang khu vực\r\n"
					+ "          miền trung.\r\n"
					+ "        </p>\r\n"
					+ "      </div>\r\n"
					+ "\r\n"
					+ "      <!------------------------------------------------------------------------------------------------------------------------------------------->\r\n"
					+ "      <!--GIỚI THIỆU TỔNG QUAN DỰ ÁN-->\r\n"
					+ "      <div class=\"overview\">\r\n"
					+ "        <p>\r\n"
					+ "          <i class=\"fab fa-galactic-senate\"></i>\r\n"
					+ "          Chúng tôi (Regal group) hiện tại đã tất toán hoàn tất dự án Regal One\r\n"
					+ "          River, tiếp theo chúng tôi mong muốn giới thiệu đến "+normalName+" cơ\r\n"
					+ "          hội sở hữu những căn Villa hạng sang, trong giỏ hàng tất toán Dự án\r\n"
					+ "          Đảo Ngọc sao ven sông Cổ Cò – Nằm trên tuyến du lịch biển Đà Nẵng và\r\n"
					+ "          Hội An với mức giá chiết khấu lên đến\r\n"
					+ "          <span style=\"font-size: 20px; font-weight: bold; color: #058947\"\r\n"
					+ "            >28%</span\r\n"
					+ "          >\r\n"
					+ "          chưa từng có trong dòng sản phẩm Regal Homes.\r\n"
					+ "        </p>\r\n"
					+ "        <div class=\"grimg1\">\r\n"
					+ "          <img src=\"cid:image1.1\" style=\"width: 100%; height: auto\" />\r\n"
					+ "        </div>\r\n"
					+ "      </div>\r\n"
					+ "\r\n"
					+ "      <!--GIỚI THIỆU VILLA B-->\r\n"
					+ "      <div class=\"villaB\" style=\"margin-top: 50px\">\r\n"
					+ "        <hr />\r\n"
					+ "        <div class=\"centerP\">\r\n"
					+ "          <p>\r\n"
					+ "            <i class=\"fas fa-jedi\"></i> Mẫu Villa hồ bơi 3.5 tầng – Villa kiểu\r\n"
					+ "            Anh:\r\n"
					+ "          </p>\r\n"
					+ "          <ul class=\"myUL\">\r\n"
					+ "            <li>Tổng quy mô 16 căn.</li>\r\n"
					+ "            <li>Diện tích 400 m2, diện tích sử dụng 725.8 m2.</li>\r\n"
					+ "            <li>Khu đảo BT6.</li>\r\n"
					+ "          </ul>\r\n"
					+ "        </div>\r\n"
					+ "\r\n"
					+ "        <div class=\"grimg1\">\r\n"
					+ "          <img src=\"cid:image6.1\" style=\"width: 100%; height: auto\" />\r\n"
					+ "          <img src=\"cid:image6.2\" style=\"width: 100%; height: auto\" />\r\n"
					+ "          <img src=\"cid:image6.3\" style=\"width: 100%; height: auto\" />\r\n"
					+ "          <img src=\"cid:image6.4\" style=\"width: 100%; height: auto\" />\r\n"
					+ "          <img src=\"cid:image6.5\" style=\"width: 100%; height: auto\" />\r\n"
					+ "          <img src=\"cid:image6.6\" style=\"width: 100%; height: auto\" />\r\n"
					+ "          <img src=\"cid:image6.7\" style=\"width: 100%; height: auto\" />\r\n"
					+ "          <img src=\"cid:image6.8\" style=\"width: 100%; height: auto\" />\r\n"
					+ "          <img src=\"cid:image6.9\" style=\"width: 100%; height: auto\" />\r\n"
					+ "        </div>\r\n"
					+ "      </div>\r\n"
					+ "\r\n"
					+ "      <!--GIỚI THIỆU VILLA A-->\r\n"
					+ "      <div class=\"villaA\" style=\"margin-top: 50px\">\r\n"
					+ "        <hr />\r\n"
					+ "        <div class=\"centerP\">\r\n"
					+ "          <p>\r\n"
					+ "            <i class=\"fas fa-jedi\"></i> Mẫu Villa sân vườn 2.5 tầng – Villa kiểu\r\n"
					+ "            Mỹ:\r\n"
					+ "          </p>\r\n"
					+ "          <ul class=\"myUL\">\r\n"
					+ "            <li>Tổng quy mô 49 căn.</li>\r\n"
					+ "            <li>Diện tích từ 352 m2 đến 494 m2 (2.5 tầng).</li>\r\n"
					+ "            <li>\r\n"
					+ "              Khu đảo BT5 và BT4, an ninh 2 lớp và khu Boulevard mặt đường\r\n"
					+ "              BT603.\r\n"
					+ "            </li>\r\n"
					+ "          </ul>\r\n"
					+ "        </div>\r\n"
					+ "        <div class=\"grimg1\">\r\n"
					+ "          <img src=\"cid:image5.1\" style=\"width: 100%; height: auto\" />\r\n"
					+ "          <img src=\"cid:image5.2\" style=\"width: 100%; height: auto\" />\r\n"
					+ "          <img src=\"cid:image5.3\" style=\"width: 100%; height: auto\" />\r\n"
					+ "          <img src=\"cid:image5.4\" style=\"width: 100%; height: auto\" />\r\n"
					+ "          <img src=\"cid:image5.5\" style=\"width: 100%; height: auto\" />\r\n"
					+ "          <img src=\"cid:image5.7\" style=\"width: 100%; height: auto\" />\r\n"
					+ "        </div>\r\n"
					+ "      </div>\r\n"
					+ "\r\n"
					+ "      <!--MÔ TẢ VỊ TRÍ-->\r\n"
					+ "      <div class=\"position\" style=\"margin-top: 50px\">\r\n"
					+ "        <p class=\"centerP\">\r\n"
					+ "          Nằm trên vị trí độc tôn, tuyến du lịch biển trung tâm Đà Nẵng Hội An,\r\n"
					+ "          đối diện 2 sân Golf BRG và Montgomerie Links. Cách biển 800m, tại đại\r\n"
					+ "          lộ nối trung tâm Đà Nẵng và du lịch biển Đà Nẵng. Cách trung tâm Đà\r\n"
					+ "          Nẵng và phố cổ Hội An 15p. Nằm trung tâm đô thị One Word và giáp đô\r\n"
					+ "          thị FPT. "+caplockName+" có thể xem vị trí của dự án qua bản đồ sau đây:\r\n"
					+ "        </p>\r\n"
					+ "        <div class=\"grimg2\">\r\n"
					+ "          <img src=\"cid:image2.2\" style=\"width: 100%; height: auto\" />\r\n"
					+ "        </div>\r\n"
					+ "      </div>\r\n"
					+ "\r\n"
					+ "      <!--MÔ TẢ TIỆN ÍCH NỘI KHU & MẶT BẰNG TỔNG QUAN-->\r\n"
					+ "      <div class=\"tink\" style=\"margin-top: 50px; text-align: center\">\r\n"
					+ "        <p>\r\n"
					+ "          <b>Tiện ích nội khu đẳng cấp Quốc tế:</b> Nhà hàng Bistro, siêu thị\r\n"
					+ "          châu âu Regal Deli, Wine & Cigar, sân tennis, sân bóng chuyền, thuyền\r\n"
					+ "          kayak, công viên…\r\n"
					+ "        </p>\r\n"
					+ "        <div class=\"grimg1\">\r\n"
					+ "          <img src=\"cid:image3.1\" style=\"width: 100%; height: auto\" />\r\n"
					+ "          <img src=\"cid:image3.2\" style=\"width: 100%; height: auto\" />\r\n"
					+ "          <img src=\"cid:image3.3\" style=\"width: 100%; height: auto\" />\r\n"
					+ "        </div>\r\n"
					+ "      </div>\r\n"
					+ "\r\n"
					
					+ "      <!--GIỚI THIỆU VẬT LIỆU-->\r\n"
					+ "      <div class=\"materia\" style=\"margin-top: 50px\">\r\n"
					+ "        <p>\r\n"
					+ "          Hệ vật liệu cực kỳ xa xỉ, tạo sự khác biệt với các dự án nam Đà Nẵng -\r\n"
					+ "          Khẳng định vị thế chủ nhân sở hữu:\r\n"
					+ "        </p>\r\n"
					+ "        <ul>\r\n"
					+ "          <li>\r\n"
					+ "            Hệ kính hộp Malaysia phủ 2 lớp Low-E cản tia UV lên đến 95%, tối đa\r\n"
					+ "            ánh sáng tự nhiên vào nhà. Kính cong khổ lớn lên đến 7m, chỉ có duy\r\n"
					+ "            nhất Villa của Regal Victoria sử dụng loại kính khổ lớn này\r\n"
					+ "          </li>\r\n"
					+ "          <li>\r\n"
					+ "            Hệ nhôm Hunter Douglas Hà Lan. Kính cong (Thụy Sĩ) khổ lớn vượt trên\r\n"
					+ "            7m - Rất hiếm biệt thự nào ở Việt Nam có được.\r\n"
					+ "          </li>\r\n"
					+ "          <li>\r\n"
					+ "            Cửa gỗ Hồng Đàn chống cháy 30p, hệ phụ kiện cửa CMech Mỹ và các linh\r\n"
					+ "            kiện cao cấp từ Đức.\r\n"
					+ "          </li>\r\n"
					+ "          <li>\r\n"
					+ "            Đá khổ lớp ốp tường Marble Pelato Ý, sơn 2 lớp chống bụi và giảm\r\n"
					+ "            nhiệt.\r\n"
					+ "          </li>\r\n"
					+ "          <li>\r\n"
					+ "            Hệ sơn Dryvit Mỹ, sơn bột tĩnh điện PPG Mỹ, sơn giả đá Kikusui Nhật\r\n"
					+ "            Bản.\r\n"
					+ "          </li>\r\n"
					+ "          <li>\r\n"
					+ "            Thiết bị chiếu sáng thông minh tùy biến, hàng chục kịch bản ánh sáng\r\n"
					+ "            đa dạng, tuổi thọ lên đến 50000h, CRI 97. Đến từ các thương hiệu nổi\r\n"
					+ "            tiếng: Orbit (Bỉ), Unios(Úc) và Koizumi (Nhật Bản).\r\n"
					+ "          </li>\r\n"
					+ "        </ul>\r\n"
					+ "        <img src=\"cid:image7.1\" style=\"width: 100%; height: auto\" />\r\n"
					+ "        <img src=\"cid:image7.2\" style=\"width: 100%; height: auto\" />\r\n"
					+ "      </div>\r\n"
					+ "\r\n"
					+ "      <!--KẾT-->\r\n"
					+ "      <div class=\"end\" style=\"margin-top: 50px\">\r\n"
					+ "        <p>\r\n"
					+ "          <i class=\"fab fa-galactic-senate\"></i>\r\n"
					+ "          Hiện tại dự án chỉ còn số lượng rất ít, đang đi vào giai đoạn tất toán\r\n"
					+ "          nên mức giá cực kỳ hiếm trong thị trường hiện tại. Sở hữu căn biệt thự\r\n"
					+ "          cao cấp đạt tiêu chuẩn 5 sao với mức giá tất toán này là cơ hội có 1\r\n"
					+ "          không 2 mà tôi muốn giới thiệu đến "+normalName+".\r\n"
					+ "        </p>\r\n"
					+ "        <p>\r\n"
					+ "          <i class=\"fab fa-galactic-senate\"></i>\r\n"
					+ "          Sắp đến chúng tôi ra mắt sự kiện tất toán mở bán những căn cuối cùng\r\n"
					+ "          của dự án Regal Victoria tại sân Golf BRG Đà Nẵng. Nếu có thể, chúng\r\n"
					+ "          tôi trân trọng kính mời "+normalName+" sắp xếp thời gian để tham gia sự\r\n"
					+ "          kiện này cùng chúng tôi.\r\n"
					+ "        </p>\r\n"
					+ "        <p>\r\n"
					+ "          Lấy sự hài lòng của khách hàng là hàng đầu, đội ngũ chăm sóc khách\r\n"
					+ "          hàng hỗ trợ 24/7.\r\n"
					+ "        </p>\r\n"
					+ "        <p>\r\n"
					+ "          Xin cảm ơn "+normalName+" đã dành thời gian đọc hết thư này, hy vọng\r\n"
					+ "          chúng tôi có cơ hội được hợp tác làm việc với "+gender+". Chúc\r\n"
					+ "          "+normalName+" một ngày vui vẻ và có những chuỗi công việc hiệu quả.\r\n"
					+ "        </p>\r\n"
					+ "      </div>\r\n"
					+ "\r\n"
					+ "      <!------------------------------------------------------------------------------------------------------------------------------------------->\r\n"
					+ "\r\n"
					+ "      <hr />\r\n"
					+ "      <p>\r\n"
					+ "        <b>Mọi thông tin chi tiết xin liên hệ:</b>\r\n"
					+ "      </p>\r\n"
					+ "\r\n"
					+ "      <div class=\"sign\">\r\n"
					+ "        <span class=\"signimg\">\r\n"
					+ "          <img\r\n"
					+ "            src=\"cid:imagesign\"\r\n"
					+ "            style=\"\r\n"
					+ "              width: 300px;\r\n"
					+ "              height: auto;\r\n"
					+ "              margin-top: -20px;\r\n"
					+ "              display: block;\r\n"
					+ "              margin-left: auto;\r\n"
					+ "              margin-right: auto;\r\n"
					+ "            \"\r\n"
					+ "          />\r\n"
					+ "        </span>\r\n"
					+ "        <span class=\"my-contact\" style=\"margin-top: 30px\">\r\n"
					+ "          <p><b>NGUYỄN THÀNH CÔNG – CHUYÊN VIÊN KINH DOANH CAO CẤP</b></p>\r\n"
					+ "          <p><b>Mobile</b>: 0368 279 613</p>\r\n"
					+ "          <p style=\"margin-top: -10px\">\r\n"
					+ "            <b>Zalo:</b> <i>https://zalo.me/0368279613</i>\r\n"
					+ "          </p>\r\n"
					+ "          <hr />\r\n"
					+ "          <p><b>CÔNG TY CỔ PHẦN REGAL GROUP</b></p>\r\n"
					+ "          <p>Địa chỉ: 52-54 Võ Văn Kiệt, Đà Nẵng</p>\r\n"
					+ "          <p style=\"margin-top: -10px\">\r\n"
					+ "            Tel: (0236) 6266266 | Ext: 1251 | Web: datxanhmientrung.com\r\n"
					+ "          </p>\r\n"
					+ "        </span>\r\n"
					+ "      </div>\r\n"
					+ "    </div>"
					
					+ "</body></html>";

			textPart.setContent(htmlText, "text/html;charset=\"utf-8\"");
			multipart.addBodyPart(textPart);
			
			BodyPart imagePart11 = new MimeBodyPart();
			DataSource fds11 = new FileDataSource("D:\\My data\\My work\\Regal group\\Marketing\\E-Mail(6r-7h)\\Giới thiệu Victoria\\img\\1.1.JPEG");
			imagePart11.setDataHandler(new DataHandler(fds11));
			imagePart11.setHeader("Content-ID", "<image1.1>");
			imagePart11.setDisposition(MimeBodyPart.INLINE);
			multipart.addBodyPart(imagePart11);
			
			BodyPart imagePart22 = new MimeBodyPart();
			DataSource fds22 = new FileDataSource("D:\\My data\\My work\\Regal group\\Marketing\\E-Mail(6r-7h)\\Giới thiệu Victoria\\img\\2.2.jpg");
			imagePart22.setDataHandler(new DataHandler(fds22));
			imagePart22.setHeader("Content-ID", "<image2.2>");
			imagePart22.setDisposition(MimeBodyPart.INLINE);
			multipart.addBodyPart(imagePart22);	
			
			BodyPart imagePart31 = new MimeBodyPart();
			DataSource fds31 = new FileDataSource("D:\\My data\\My work\\Regal group\\Marketing\\E-Mail(6r-7h)\\Giới thiệu Victoria\\img\\3.1.jpg");
			imagePart31.setDataHandler(new DataHandler(fds31));
			imagePart31.setHeader("Content-ID", "<image3.1>");
			imagePart31.setDisposition(MimeBodyPart.INLINE);
			multipart.addBodyPart(imagePart31);	
			
			BodyPart imagePart32 = new MimeBodyPart();
			DataSource fds32 = new FileDataSource("D:\\My data\\My work\\Regal group\\Marketing\\E-Mail(6r-7h)\\Giới thiệu Victoria\\img\\3.2.jpg");
			imagePart32.setDataHandler(new DataHandler(fds32));
			imagePart32.setHeader("Content-ID", "<image3.2>");
			imagePart32.setDisposition(MimeBodyPart.INLINE);
			multipart.addBodyPart(imagePart32);
			
			BodyPart imagePart33 = new MimeBodyPart();
			DataSource fds33 = new FileDataSource("D:\\My data\\My work\\Regal group\\Marketing\\E-Mail(6r-7h)\\Giới thiệu Victoria\\img\\3.3.jpg");
			imagePart33.setDataHandler(new DataHandler(fds33));
			imagePart33.setHeader("Content-ID", "<image3.3>");
			imagePart33.setDisposition(MimeBodyPart.INLINE);
			multipart.addBodyPart(imagePart33);
			
			BodyPart imagePart51 = new MimeBodyPart();
			DataSource fds51 = new FileDataSource("D:\\My data\\My work\\Regal group\\Marketing\\E-Mail(6r-7h)\\Giới thiệu Victoria\\img\\5.1.jpg");
			imagePart51.setDataHandler(new DataHandler(fds51));
			imagePart51.setHeader("Content-ID", "<image5.1>");
			imagePart51.setDisposition(MimeBodyPart.INLINE);
			multipart.addBodyPart(imagePart51);
			
			BodyPart imagePart52 = new MimeBodyPart();
			DataSource fds52 = new FileDataSource("D:\\My data\\My work\\Regal group\\Marketing\\E-Mail(6r-7h)\\Giới thiệu Victoria\\img\\5.2.jpg");
			imagePart52.setDataHandler(new DataHandler(fds52));
			imagePart52.setHeader("Content-ID", "<image5.2>");
			imagePart52.setDisposition(MimeBodyPart.INLINE);
			multipart.addBodyPart(imagePart52);
			
			BodyPart imagePart53 = new MimeBodyPart();
			DataSource fds53 = new FileDataSource("D:\\My data\\My work\\Regal group\\Marketing\\E-Mail(6r-7h)\\Giới thiệu Victoria\\img\\5.3.jpg");
			imagePart53.setDataHandler(new DataHandler(fds53));
			imagePart53.setHeader("Content-ID", "<image5.3>");
			imagePart53.setDisposition(MimeBodyPart.INLINE);
			multipart.addBodyPart(imagePart53);
			
			BodyPart imagePart54 = new MimeBodyPart();
			DataSource fds54 = new FileDataSource("D:\\My data\\My work\\Regal group\\Marketing\\E-Mail(6r-7h)\\Giới thiệu Victoria\\img\\5.4.jpg");
			imagePart54.setDataHandler(new DataHandler(fds54));
			imagePart54.setHeader("Content-ID", "<image5.4>");
			imagePart54.setDisposition(MimeBodyPart.INLINE);
			multipart.addBodyPart(imagePart54);
			
			BodyPart imagePart55 = new MimeBodyPart();
			DataSource fds55 = new FileDataSource("D:\\My data\\My work\\Regal group\\Marketing\\E-Mail(6r-7h)\\Giới thiệu Victoria\\img\\5.5.jpg");
			imagePart55.setDataHandler(new DataHandler(fds55));
			imagePart55.setHeader("Content-ID", "<image5.5>");
			imagePart55.setDisposition(MimeBodyPart.INLINE);
			multipart.addBodyPart(imagePart55);
			
			BodyPart imagePart57 = new MimeBodyPart();
			DataSource fds57 = new FileDataSource("D:\\My data\\My work\\Regal group\\Marketing\\E-Mail(6r-7h)\\Giới thiệu Victoria\\img\\5.7.jpg");
			imagePart57.setDataHandler(new DataHandler(fds57));
			imagePart57.setHeader("Content-ID", "<image5.7>");
			imagePart57.setDisposition(MimeBodyPart.INLINE);
			multipart.addBodyPart(imagePart57);
			
			BodyPart imagePart61 = new MimeBodyPart();
			DataSource fds61 = new FileDataSource("D:\\My data\\My work\\Regal group\\Marketing\\E-Mail(6r-7h)\\Giới thiệu Victoria\\img\\6.1.jpg");
			imagePart61.setDataHandler(new DataHandler(fds61));
			imagePart61.setHeader("Content-ID", "<image6.1>");
			imagePart61.setDisposition(MimeBodyPart.INLINE);
			multipart.addBodyPart(imagePart61);
			
			BodyPart imagePart62 = new MimeBodyPart();
			DataSource fds62 = new FileDataSource("D:\\My data\\My work\\Regal group\\Marketing\\E-Mail(6r-7h)\\Giới thiệu Victoria\\img\\6.2.jpg");
			imagePart62.setDataHandler(new DataHandler(fds62));
			imagePart62.setHeader("Content-ID", "<image6.2>");
			imagePart62.setDisposition(MimeBodyPart.INLINE);
			multipart.addBodyPart(imagePart62);
			
			BodyPart imagePart63 = new MimeBodyPart();
			DataSource fds63 = new FileDataSource("D:\\My data\\My work\\Regal group\\Marketing\\E-Mail(6r-7h)\\Giới thiệu Victoria\\img\\6.3.jpg");
			imagePart63.setDataHandler(new DataHandler(fds63));
			imagePart63.setHeader("Content-ID", "<image6.3>");
			imagePart63.setDisposition(MimeBodyPart.INLINE);
			multipart.addBodyPart(imagePart63);
			
			BodyPart imagePart64 = new MimeBodyPart();
			DataSource fds64 = new FileDataSource("D:\\My data\\My work\\Regal group\\Marketing\\E-Mail(6r-7h)\\Giới thiệu Victoria\\img\\6.4.jpeg");
			imagePart64.setDataHandler(new DataHandler(fds64));
			imagePart64.setHeader("Content-ID", "<image6.4>");
			imagePart64.setDisposition(MimeBodyPart.INLINE);
			multipart.addBodyPart(imagePart64);
			
			BodyPart imagePart65 = new MimeBodyPart();
			DataSource fds65 = new FileDataSource("D:\\My data\\My work\\Regal group\\Marketing\\E-Mail(6r-7h)\\Giới thiệu Victoria\\img\\6.5.jpg");
			imagePart65.setDataHandler(new DataHandler(fds65));
			imagePart65.setHeader("Content-ID", "<image6.5>");
			imagePart65.setDisposition(MimeBodyPart.INLINE);
			multipart.addBodyPart(imagePart65);
			
			BodyPart imagePart66 = new MimeBodyPart();
			DataSource fds66 = new FileDataSource("D:\\My data\\My work\\Regal group\\Marketing\\E-Mail(6r-7h)\\Giới thiệu Victoria\\img\\6.6.jpg");
			imagePart66.setDataHandler(new DataHandler(fds66));
			imagePart66.setHeader("Content-ID", "<image6.6>");
			imagePart66.setDisposition(MimeBodyPart.INLINE);
			multipart.addBodyPart(imagePart66);
			
			BodyPart imagePart67 = new MimeBodyPart();
			DataSource fds67 = new FileDataSource("D:\\My data\\My work\\Regal group\\Marketing\\E-Mail(6r-7h)\\Giới thiệu Victoria\\img\\6.7.png");
			imagePart67.setDataHandler(new DataHandler(fds67));
			imagePart67.setHeader("Content-ID", "<image6.7>");
			imagePart67.setDisposition(MimeBodyPart.INLINE);
			multipart.addBodyPart(imagePart67);
			
			BodyPart imagePart68 = new MimeBodyPart();
			DataSource fds68 = new FileDataSource("D:\\My data\\My work\\Regal group\\Marketing\\E-Mail(6r-7h)\\Giới thiệu Victoria\\img\\6.8.jpeg");
			imagePart68.setDataHandler(new DataHandler(fds68));
			imagePart68.setHeader("Content-ID", "<image6.8>");
			imagePart68.setDisposition(MimeBodyPart.INLINE);
			multipart.addBodyPart(imagePart68);
			
			BodyPart imagePart69 = new MimeBodyPart();
			DataSource fds69 = new FileDataSource("D:\\My data\\My work\\Regal group\\Marketing\\E-Mail(6r-7h)\\Giới thiệu Victoria\\img\\6.9.png");
			imagePart69.setDataHandler(new DataHandler(fds69));
			imagePart69.setHeader("Content-ID", "<image6.9>");
			imagePart69.setDisposition(MimeBodyPart.INLINE);
			multipart.addBodyPart(imagePart69);
			
			BodyPart imagePart71 = new MimeBodyPart();
			DataSource fds71 = new FileDataSource("D:\\My data\\My work\\Regal group\\Marketing\\E-Mail(6r-7h)\\Giới thiệu Victoria\\img\\7.1.jpg");
			imagePart71.setDataHandler(new DataHandler(fds71));
			imagePart71.setHeader("Content-ID", "<image7.1>");
			imagePart71.setDisposition(MimeBodyPart.INLINE);
			multipart.addBodyPart(imagePart71);
			
			BodyPart imagePart72 = new MimeBodyPart();
			DataSource fds72 = new FileDataSource("D:\\My data\\My work\\Regal group\\Marketing\\E-Mail(6r-7h)\\Giới thiệu Victoria\\img\\7.2.jpg");
			imagePart72.setDataHandler(new DataHandler(fds72));
			imagePart72.setHeader("Content-ID", "<image7.2>");
			imagePart72.setDisposition(MimeBodyPart.INLINE);
			multipart.addBodyPart(imagePart72);
			
			
			
			BodyPart imagePartsign = new MimeBodyPart();
			DataSource fdssign = new FileDataSource("D:\\My data\\My work\\Regal group\\Marketing\\E-Mail(6r-7h)\\Giới thiệu Victoria\\img\\sign.png");
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

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
public class MailServiceVictoria2 {
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
					+ "<p>\r\n"
					+ "          Tôi là Thu Hà - Chuyên viên kinh doanh Tập Đoàn Regal Group. Hiện tại,\r\n"
					+ "          công ty chúng tôi đang có dòng sản phẩm giới hạn villa compound\r\n"
					+ "          <b>Regal Victoria</b>. Tôi xin gửi "+gender+" một số thông tin về dự án\r\n"
					+ "          "+gender+" tham khảo ạ\r\n"
					+ "        </p>\r\n"
					+ "        <div class=\"list-content\">\r\n"
					+ "          <p>Thông tin bao gồm</p>\r\n"
					+ "          <ul>\r\n"
					+ "            <li>Thông tin tổng quan</li>\r\n"
					+ "            <li>Hệ thống tiện ích ngoại khu và nội khu</li>\r\n"
					+ "            <li>Mặt bằng dự án</li>\r\n"
					+ "            <li>Mẫu villa A,B</li>\r\n"
					+ "            <li>Pháp lý dự án</li>\r\n"
					+ "          </ul>\r\n"
					+ "        </div>\r\n"
					+ "      </div>\r\n"
					+ "\r\n"
					+ "      <!------------------------------------------------------------------------------------------------------------------------------------------->\r\n"
					+ "      <!--GIỚI THIỆU TỔNG QUAN DỰ ÁN-->\r\n"
					+ "      <div class=\"overview\">\r\n"
					+ "        <p><b>TỔNG QUAN DỰ ÁN:</b></p>\r\n"
					+ "        <ul>\r\n"
					+ "          <li>Tên thương mại: <b>Regal Victoria</b></li>\r\n"
					+ "          <li>\r\n"
					+ "            (Dự án nằm trong quần thể khu đô thị One World Regency rộng 22ha –\r\n"
					+ "            Regal Victoria là phân khu cao cấp nhất và biệt lập so với phần còn\r\n"
					+ "            lại của dự án).\r\n"
					+ "          </li>\r\n"
					+ "          <li>\r\n"
					+ "            Vị trí: Khu đô thị mới Điện Ngọc – thị xã Điện Bàn, tỉnh Quảng Nam.\r\n"
					+ "          </li>\r\n"
					+ "          <li>Chủ đầu tư: Tập Đoàn Regal Group</li>\r\n"
					+ "          <li>\r\n"
					+ "            Loại hình sản phẩm: bản giới hạn gồm duy nhất căn Villas (Biệt thự\r\n"
					+ "            nghỉ dưỡng siêu sang)\r\n"
					+ "          </li>\r\n"
					+ "          <li>Pháp lý: <b>Sở hữu lâu dài – vĩnh viễn.</b></li>\r\n"
					+ "        </ul>\r\n"
					+ "        <div class=\"grimg1\">\r\n"
					+ "          <img src=\"cid:image1.1\" style=\"width: 100%; height: auto\" />\r\n"
					+ "          <img src=\"cid:image1.2\" style=\"width: 100%; height: auto\" />\r\n"
					+ "        </div>\r\n"
					+ "      </div>\r\n"
					+ "\r\n"
					+ "      <!--MÔ TẢ TIỆN ÍCH NỘI KHU & MẶT BẰNG TỔNG QUAN-->\r\n"
					+ "      <div class=\"tink\" style=\"margin-top: 50px; text-align: center\">\r\n"
					+ "        <p>\r\n"
					+ "          <b>TIỆN ÍCH NỘI KHU:</b>\r\n"
					+ "        </p>\r\n"
					+ "\r\n"
					+ "        <div class=\"grimg1\">\r\n"
					+ "          <p>\r\n"
					+ "            Hệ thống công viên trung tâm, công viên dạo bộ ven sông, bến du\r\n"
					+ "            thuyền\r\n"
					+ "          </p>\r\n"
					+ "          <img src=\"cid:image3.1\" style=\"width: 100%; height: auto\" />\r\n"
					+ "          <p style=\"margin-top: 40px; text-align: center\">\r\n"
					+ "            <b>Tiện ích khu thể thao phức hợp:</b> Sân tennis, Sân bóng rổ, Sân\r\n"
					+ "            bóng chuyền\r\n"
					+ "          </p>\r\n"
					+ "          <img src=\"cid:image3.3\" style=\"width: 100%; height: auto\" />\r\n"
					+ "          <p style=\"margin-top: 40px; text-align: center\">\r\n"
					+ "            <b>Regal Food:</b> nhà hàng, cà phê, siêu thị, khu giải trí Wine\r\n"
					+ "            Cigar thiết kế cao cấp cho cộng đồng cư dân sử dụng\r\n"
					+ "          </p>\r\n"
					+ "          <img src=\"cid:image3.2\" style=\"width: 100%; height: auto\" />\r\n"
					+ "          <p style=\"margin-top: 40px; text-align: center\">\r\n"
					+ "            <b>Dịch vụ 5 sao: </b> Dịch vụ đưa đón từ sân bay – Hội An và ngược\r\n"
					+ "            lại, dịch vụ xe điện từ Clubhouse đến bãi biển, Du thuyền hạng sang\r\n"
					+ "            từ Regal One River – Regal Victoria.\r\n"
					+ "          </p>\r\n"
					+ "        </div>\r\n"
					+ "      </div>\r\n"
					+ "\r\n"
					+ "      <!--TIỆN ÍCH NGOẠI KHU:-->\r\n"
					+ "      <div class=\"position\" style=\"margin-top: 50px\">\r\n"
					+ "        <p><b>TIỆN ÍCH NGOẠI KHU:</b></p>\r\n"
					+ "        <p>\r\n"
					+ "          Nằm trên tuyến đường du lịch tỷ đô Đà Nẵng – Hội An, thuộc khu đô thị\r\n"
					+ "          mới, cư dân tại Regal Victoria sẽ kết nối dễ dàng đến mọi tiện ích cao\r\n"
					+ "          cấp trong vòng bán kính chỉ 1km:\r\n"
					+ "        </p>\r\n"
					+ "        <ul>\r\n"
					+ "          <li>Đi bộ ra biển, bãi tắm: 700m</li>\r\n"
					+ "          <li>Sân golf: 500m</li>\r\n"
					+ "          <li>Trường Quốc tế: 500m</li>\r\n"
					+ "          <li>Bệnh viện Quốc tế: 800m</li>\r\n"
					+ "          <li>Cụm resort 5 sao: 500m</li>\r\n"
					+ "          <li>Chợ: 800m</li>\r\n"
					+ "        </ul>\r\n"
					+ "        <div class=\"grimg2\">\r\n"
					+ "          <img src=\"cid:image2.1\" style=\"width: 100%; height: auto\" />\r\n"
					+ "          <img src=\"cid:image2.2\" style=\"width: 100%; height: auto\" />\r\n"
					+ "        </div>\r\n"
					+ "\r\n"
					+ "        <p><b>MẶT BẰNG DỰ ÁN:</b></p>\r\n"
					+ "        <img src=\"cid:image2.3\" style=\"width: 100%; height: auto\" />\r\n"
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
					+ "        </div>\r\n"
					+ "      </div>\r\n"
					+ "\r\n"
					+ "      <!--PHÁP LÝ-->\r\n"
					+ "      <div class=\"materia\" style=\"margin-top: 50px\">\r\n"
					+ "        <hr />\r\n"
					+ "        <p>\r\n"
					+ "          <b>Pháp lý hoàn thiện:</b> Regal Victoria là một trong số rất ít các\r\n"
					+ "          dự án ra hàng thời điểm này với pháp lý hoàn thiện đã có sổ hồng từng\r\n"
					+ "          căn.\r\n"
					+ "        </p>\r\n"
					+ "        <img src=\"cid:image7.1\" style=\"width: 100%; height: auto\" />\r\n"
					+ "\r\n"
					+ "        <ul>\r\n"
					+ "          <li>\r\n"
					+ "            <b>Vị trí đắc địa:</b> Regal Victoria nằm trên quỹ đất cuối cùng khu\r\n"
					+ "            vực gianh giới Đà Nẵng – Quảng Nam mà có khoảng cách tới biển chỉ\r\n"
					+ "            700m mà đang trong giai đoạn đầu mở bán. Regal Victoria nằm bên dòng\r\n"
					+ "            sông Cổ Cò ( sông Hàn nối dài ) – là tuyến du lịch đường thủy vào\r\n"
					+ "            Hội An. Cùng với việc khơi thông sông Cổ Cò, phát triển cảnh quan\r\n"
					+ "            ven sông và xây dựng các bến du thuyền thì trong tương lai với số\r\n"
					+ "            lượng giới hạn các bất động sản ven sông thì khách hàng sở hữu các\r\n"
					+ "            bất động sản tại Regal Victoria sẽ là những người nắm trong tay\r\n"
					+ "            những bất động sản giá trị nhất. Hơn nữa, dự án cách biển chỉ 700m,\r\n"
					+ "            nằm liền kề cung đường du lịch tỷ đô Võ Nguyên Giáp,thuộc quy hoạch\r\n"
					+ "            khu đô thị nghỉ dưỡng liên kết thuận lợi tới các tiện ích 5 sao hàng\r\n"
					+ "            đầu như sân golf, resort, bệnh viện quốc tế, trường học quốc tế,…\r\n"
					+ "          </li>\r\n"
					+ "          <li>\r\n"
					+ "            <b>Thanh khoản:</b> theo thống kê gần đây, trên trục quy hoạch từ Đà\r\n"
					+ "            Nẵng vào Hội An, bao gồm cả các dự án đã hình thành và đang cấp phép\r\n"
					+ "            thì chỉ có khoảng 1340 lô biệt thự, số lượng cực kỳ hạn chế so với\r\n"
					+ "            nhu cầu của một thành phố đáng sống như Đà Nẵng. Và bản thân dự án\r\n"
					+ "            cũng chỉ có duy nhất 67 chủ nhân có cơ hội sở hữu. Nên việc thanh\r\n"
					+ "            khoản của khách về sau cũng rất thuận lợi.\r\n"
					+ "          </li>\r\n"
					+ "          <li>\r\n"
					+ "            Ngoài việc giá trị căn biệt thự của khách hàng sẽ tăng không ngừng\r\n"
					+ "            theo thời gian vì vị trí đắc địa và số lượng hạn chế. Khách hàng đầu\r\n"
					+ "            tư lâu dài cũng có thể khai thác dòng tiền từ việc cho thuê hoặc hợp\r\n"
					+ "            tác cho thuê. Hiện tại với các dự án biệt thự gần đó, điển hình như\r\n"
					+ "            Nam An Retreat đang cho thuê trong thời điểm trước dịch với giá từ\r\n"
					+ "            10 – 25 triệu/ đêm.\r\n"
					+ "          </li>\r\n"
					+ "        </ul>\r\n"
					+ "      </div>"        
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
					+ "          <p><b>PHÙNG THỊ THU HÀ – CHUYÊN VIÊN KINH DOANH CAO CẤP</b></p>\r\n"
					+ "          <p><b>Mobile</b>: 0907 398 157</p>\r\n"
					+ "          <p style=\"margin-top: -10px\">\r\n"
					+ "            <b>Zalo:</b> <i>https://zalo.me/0907398157</i>\r\n"
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
			DataSource fds11 = new FileDataSource("D:\\My data\\My work\\Regal group\\Marketing\\E-Mail(6r-7h)\\Giới thiệu Victoria\\img2\\1.1.png");
			imagePart11.setDataHandler(new DataHandler(fds11));
			imagePart11.setHeader("Content-ID", "<image1.1>");
			imagePart11.setDisposition(MimeBodyPart.INLINE);
			multipart.addBodyPart(imagePart11);
			
			BodyPart imagePart12 = new MimeBodyPart();
			DataSource fds12 = new FileDataSource("D:\\My data\\My work\\Regal group\\Marketing\\E-Mail(6r-7h)\\Giới thiệu Victoria\\img2\\1.2.png");
			imagePart12.setDataHandler(new DataHandler(fds12));
			imagePart12.setHeader("Content-ID", "<image1.2>");
			imagePart12.setDisposition(MimeBodyPart.INLINE);
			multipart.addBodyPart(imagePart12);
			
			BodyPart imagePart21 = new MimeBodyPart();
			DataSource fds21 = new FileDataSource("D:\\My data\\My work\\Regal group\\Marketing\\E-Mail(6r-7h)\\Giới thiệu Victoria\\img2\\2.1.png");
			imagePart21.setDataHandler(new DataHandler(fds21));
			imagePart21.setHeader("Content-ID", "<image2.1>");
			imagePart21.setDisposition(MimeBodyPart.INLINE);
			multipart.addBodyPart(imagePart21);	
			
			BodyPart imagePart22 = new MimeBodyPart();
			DataSource fds22 = new FileDataSource("D:\\My data\\My work\\Regal group\\Marketing\\E-Mail(6r-7h)\\Giới thiệu Victoria\\img2\\2.2.png");
			imagePart22.setDataHandler(new DataHandler(fds22));
			imagePart22.setHeader("Content-ID", "<image2.2>");
			imagePart22.setDisposition(MimeBodyPart.INLINE);
			multipart.addBodyPart(imagePart22);	
			
			BodyPart imagePart23 = new MimeBodyPart();
			DataSource fds23 = new FileDataSource("D:\\My data\\My work\\Regal group\\Marketing\\E-Mail(6r-7h)\\Giới thiệu Victoria\\img2\\2.3.png");
			imagePart23.setDataHandler(new DataHandler(fds23));
			imagePart23.setHeader("Content-ID", "<image2.3>");
			imagePart23.setDisposition(MimeBodyPart.INLINE);
			multipart.addBodyPart(imagePart23);	
			
			BodyPart imagePart31 = new MimeBodyPart();
			DataSource fds31 = new FileDataSource("D:\\My data\\My work\\Regal group\\Marketing\\E-Mail(6r-7h)\\Giới thiệu Victoria\\img2\\3.1.png");
			imagePart31.setDataHandler(new DataHandler(fds31));
			imagePart31.setHeader("Content-ID", "<image3.1>");
			imagePart31.setDisposition(MimeBodyPart.INLINE);
			multipart.addBodyPart(imagePart31);	
			
			BodyPart imagePart32 = new MimeBodyPart();
			DataSource fds32 = new FileDataSource("D:\\My data\\My work\\Regal group\\Marketing\\E-Mail(6r-7h)\\Giới thiệu Victoria\\img2\\3.2.png");
			imagePart32.setDataHandler(new DataHandler(fds32));
			imagePart32.setHeader("Content-ID", "<image3.2>");
			imagePart32.setDisposition(MimeBodyPart.INLINE);
			multipart.addBodyPart(imagePart32);
			
			BodyPart imagePart33 = new MimeBodyPart();
			DataSource fds33 = new FileDataSource("D:\\My data\\My work\\Regal group\\Marketing\\E-Mail(6r-7h)\\Giới thiệu Victoria\\img2\\3.3.jpg");
			imagePart33.setDataHandler(new DataHandler(fds33));
			imagePart33.setHeader("Content-ID", "<image3.3>");
			imagePart33.setDisposition(MimeBodyPart.INLINE);
			multipart.addBodyPart(imagePart33);
			
			BodyPart imagePart51 = new MimeBodyPart();
			DataSource fds51 = new FileDataSource("D:\\My data\\My work\\Regal group\\Marketing\\E-Mail(6r-7h)\\Giới thiệu Victoria\\img2\\5.1.png");
			imagePart51.setDataHandler(new DataHandler(fds51));
			imagePart51.setHeader("Content-ID", "<image5.1>");
			imagePart51.setDisposition(MimeBodyPart.INLINE);
			multipart.addBodyPart(imagePart51);
			
			
			BodyPart imagePart61 = new MimeBodyPart();
			DataSource fds61 = new FileDataSource("D:\\My data\\My work\\Regal group\\Marketing\\E-Mail(6r-7h)\\Giới thiệu Victoria\\img2\\6.1.png");
			imagePart61.setDataHandler(new DataHandler(fds61));
			imagePart61.setHeader("Content-ID", "<image6.1>");
			imagePart61.setDisposition(MimeBodyPart.INLINE);
			multipart.addBodyPart(imagePart61);
			
			BodyPart imagePart62 = new MimeBodyPart();
			DataSource fds62 = new FileDataSource("D:\\My data\\My work\\Regal group\\Marketing\\E-Mail(6r-7h)\\Giới thiệu Victoria\\img2\\6.2.png");
			imagePart62.setDataHandler(new DataHandler(fds62));
			imagePart62.setHeader("Content-ID", "<image6.2>");
			imagePart62.setDisposition(MimeBodyPart.INLINE);
			multipart.addBodyPart(imagePart62);
			
			
			BodyPart imagePart71 = new MimeBodyPart();
			DataSource fds71 = new FileDataSource("D:\\My data\\My work\\Regal group\\Marketing\\E-Mail(6r-7h)\\Giới thiệu Victoria\\img2\\7.1.png");
			imagePart71.setDataHandler(new DataHandler(fds71));
			imagePart71.setHeader("Content-ID", "<image7.1>");
			imagePart71.setDisposition(MimeBodyPart.INLINE);
			multipart.addBodyPart(imagePart71);
			
			
			
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

package healthcare.process;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;

import jakarta.servlet.http.HttpSession;

import java.util.Date;
import java.text.SimpleDateFormat;

import healthcare.objects.AppointmentObject;
import healthcare.objects.UserObject;
/**
 * Servlet implementation class BookAppointment
 */
public class BookAppointment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookAppointment() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
        HttpSession session = request.getSession();
        UserObject loggedInUser = (UserObject) session.getAttribute("loggedInUser");
	    int user_Id = loggedInUser.getUser_id();
	    
		Date currentDate = new Date();
		 
        // Tạo đối tượng SimpleDateFormat để định dạng ngày và giờ 
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");

        String formattedDate = dateFormat.format(currentDate);
        String formattedTime = timeFormat.format(currentDate);
       
		// Nhận dữ liệu từ form
        String notes = request.getParameter("notes");
        
        AppointmentObject newAppointment = new AppointmentObject();
		Appointment app = new Appointment();
		
		newAppointment.setApp_date(formattedDate);
		newAppointment.setApp_time(formattedTime);
		String appStatusAdd = "Confirmed";
		newAppointment.setApp_status(appStatusAdd);
		newAppointment.setApp_created_date(formattedDate);
		newAppointment.setApp_modified_date(formattedDate);
		newAppointment.setApp_deleted(false);
		newAppointment.setApp_notes(notes);
		newAppointment.setApp_user_id(user_Id);
    	String doctorName = request.getParameter("doctorNameHidden");
    	String selectedDate = request.getParameter("selectedTimingHidden");
    	String selectedTiming = request.getParameter("selectedDateHidden");
    	String imgpath = request.getParameter("doctorImageSrcHidden");
    	newAppointment.setApp_doctor_image(imgpath);
    	newAppointment.setApp_doctor_name(doctorName);
        // Đặt lịch thành công, thêm cuộc hẹn vào cơ sở dữ liệu
        boolean bookingSuccess = app.addAppointment(newAppointment);
    	System.out.print(imgpath);
        if (bookingSuccess) {
            // Chuyển hướng đến trang thông báo đặt lịch thành công

//        	System.out.print(doctorName);
//        	System.out.print(selectedDate);
//        	System.out.print(selectedTiming);
        	// Chuyển hướng tới trang booking-success.jsp và truyền các thông tin
            String redirectURL = "booking-success.jsp" +
                    "?registration_success=true" +
                    "&doctorName=" + URLEncoder.encode(doctorName, "UTF-8") +
                    "&selectedDate=" + URLEncoder.encode(selectedDate, "UTF-8") +
                    "&selectedTiming=" + URLEncoder.encode(selectedTiming, "UTF-8");
//            System.out.print(redirectURL);
            response.sendRedirect(redirectURL);
//        	response.sendRedirect("booking-success.jsp?success=true");
        } else {
            // Đăng ký thất bại, chuyển hướng đến trang đăng ký lại và hiển thị thông báo lỗi
            response.sendRedirect("sign.jsp?error=registration_failure");
        }
		doGet(request, response);
	}
}
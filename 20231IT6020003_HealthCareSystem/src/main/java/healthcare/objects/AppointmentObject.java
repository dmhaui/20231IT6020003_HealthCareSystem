package healthcare.objects;

import java.io.Serializable;

public class AppointmentObject implements Serializable {
	 	private int app_id;
	    private String app_date;
	    private String app_time;
	    private String app_status;
	    private String app_created_date;
	    private String app_modified_date;
	    private String app_notes;
	    private boolean app_deleted;
	    private int app_user_id;
	    private String app_doctor_image;
		private String app_doctor_name;

	    // Constructors, getters, and setters

	    public AppointmentObject() {
	    }

	    public AppointmentObject(int app_id, String app_date, String app_time, String app_status,
	                              String app_created_date, String app_modified_date, String app_notes,
	                              boolean app_deleted, int app_user_id, String app_doctor_image,String app_doctor_name) {
	        this.app_id = app_id;
	        this.app_date = app_date;
	        this.app_time = app_time;
	        this.app_status = app_status;
	        this.app_created_date = app_created_date;
	        this.app_modified_date = app_modified_date;
	        this.app_notes = app_notes;
	        this.app_deleted = app_deleted;
	        this.app_user_id = app_user_id;
	        this.app_doctor_image = app_doctor_image;
	        this.app_doctor_name = app_doctor_name;
	    }
	    public String getApp_doctor_name() {
			return app_doctor_name;
		}

		public void setApp_doctor_name(String app_doctor_name) {
			this.app_doctor_name = app_doctor_name;
		}
	    public int getApp_id() {
	        return app_id;
	    }

	    public void setApp_id(int app_id) {
	        this.app_id = app_id;
	    }

	    public String getApp_date() {
	        return app_date;
	    }

	    public void setApp_date(String app_date) {
	        this.app_date = app_date;
	    }

	    public String getApp_time() {
	        return app_time;
	    }

	    public void setApp_time(String app_time) {
	        this.app_time = app_time;
	    }

	    public String getApp_status() {
	        return app_status;
	    }

	    public void setApp_status(String app_status) {
	        this.app_status = app_status;
	    }

	    public String getApp_created_date() {
	        return app_created_date;
	    }

	    public void setApp_created_date(String app_created_date) {
	        this.app_created_date = app_created_date;
	    }

	    public String getApp_modified_date() {
	        return app_modified_date;
	    }

	    public void setApp_modified_date(String app_modified_date) {
	        this.app_modified_date = app_modified_date;
	    }

	    public String getApp_notes() {
	        return app_notes;
	    }

	    public void setApp_notes(String app_notes) {
	        this.app_notes = app_notes;
	    }

	    public boolean isApp_deleted() {
	        return app_deleted;
	    }

	    public void setApp_deleted(boolean app_deleted) {
	        this.app_deleted = app_deleted;
	    }

		public int getApp_user_id() {
			return app_user_id;
		}

		public void setApp_user_id(int app_user_id) {
			this.app_user_id = app_user_id;
		}


		public String getApp_doctor_image() {
			return app_doctor_image;
		}

		public void setApp_doctor_image(String app_doctor_image) {
			this.app_doctor_image = app_doctor_image;
		}
	    @Override
	    public String toString() {
	        return String.format("AppointmentObject[id=%d, date=%s, time=%s, status=%s, " +
	                        "created_date=%s, modified_date=%s, notes=%s, deleted=%s, user_id=%s, doctor_image=%s, doctor_name=%b]",
	                app_id, app_date, app_time, app_status, app_created_date, app_modified_date,
	                app_notes, app_deleted, app_user_id, app_doctor_image, app_doctor_name);
	    }

}


import java.io.Serializable;
import java.util.Date;

public class Users implements Serializable {
	private String username;
	private String passw;
	private String type;
	private String name;
	private String email;
	private String sex;
	private Date dateofbirth;
	private String country;

	public Users(String username, String passw, String type, String name, String email, String sex, Date dateofbirth,
			String country) {
		super();
		this.username = username;
		this.passw = passw;
		this.type = type;
		this.name = name;
		this.email = email;
		this.sex = sex;
		this.dateofbirth = dateofbirth;
		this.country = country;

	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return passw;
	}

	public String getTipus() {
		return type;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getSex() {
		return sex;
	}

	public Date getDateofbirth() {
		return dateofbirth;
	}

	public String getCountry() {
		return country;
	}

}

package Main.Dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "user", catalog = "restapi")
public class User implements java.io.Serializable {
	
	private Integer idUser;
	private String firstName;
	private String lastName;
	private String password;
	private String email;

	public User() {
	}
	
	public User(Integer idUser, String firstName, String lastName, String password, String email) {
		
		this.idUser = idUser;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.email = email;
	}
	
	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "iduser", unique = true, nullable = false)
	public Integer getIdUser() {
		return idUser;
	}
	
	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
	}
	@Column(name = "First_Name", length = 45)
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	@Column(name = "Last_Name", length = 45)
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	@Column(name = "password", length = 45)
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	@Column(name = "email", length = 45)
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}

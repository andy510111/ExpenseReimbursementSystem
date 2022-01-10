package projectone.model;

import javax.persistence.*;


@Entity
@Table(name="rmuser", schema="public")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="userid")
	private int userId;
	
	@Column(name="userRole")
	private String userRole;
	
	@Column(name="email")
	private String email;
	
	@Column(name="firstName")
	private String firstName;
	
	@Column(name="lastName")
	private String lastName;
	
	@Column(name="username")
	private String username;
	
	@Column(name="password")
	private String password;
	
	public User(int userId, String userRole, String email, String firstName, String lastName, String username,
			String password) {
		super();
		this.userId = userId;
		this.userRole = userRole;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
	}
	
	public User() {
		
	}
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserRole() {
		return userRole;
	}
	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getUsername() {
		return username;
	}
	public void setUserName(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userRole=" + userRole + ", email=" + email + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", userName=" + username + ", password=" + password + "]";
	}
	
}

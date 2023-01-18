package vo;

import org.springframework.web.multipart.MultipartFile;

public class MemberinfoVO {
	private String id ;
	private String password;
	private MultipartFile image;
	private String email;
	private String my_words;
	private String pwdchk;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public MultipartFile getImage() {
		return image;
	}
	public void setImage(MultipartFile image) {
		this.image = image;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMy_words() {
		return my_words;
	}
	public void setMy_words(String my_words) {
		this.my_words = my_words;
	}
	public String getPwdchk() {
		return pwdchk;
	}
	public void setPwdchk(String pwdchk) {
		this.pwdchk = pwdchk;
	}	
	
}

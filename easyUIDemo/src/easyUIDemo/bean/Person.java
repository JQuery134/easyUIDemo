package easyUIDemo.bean;

public class Person{
	private String num;
	private String name;
	private String sex;
	private String age;
	private String idcard;
	private String phone;
	private String address;
	private String email;
	private String time;
	private String imageData;//图片的base64编码字符�?
	private String img_path;//图片路径
	private String finalCode;//条形码�?
	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Person(String num, String name, String sex, String age, String idcard, String phone, String address,
			String email, String time, String imageData, String img_path, String finalCode) {
		super();
		this.num = num;
		this.name = name;
		this.sex = sex;
		this.age = age;
		this.idcard = idcard;
		this.phone = phone;
		this.address = address;
		this.email = email;
		this.time = time;
		this.imageData = imageData;
		this.img_path = img_path;
		this.finalCode = finalCode;
	}
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getIdcard() {
		return idcard;
	}
	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getImageData() {
		return imageData;
	}
	public void setImageData(String imageData) {
		this.imageData = imageData;
	}
	public String getImg_path() {
		return img_path;
	}
	public void setImg_path(String img_path) {
		this.img_path = img_path;
	}
	public String getFinalCode() {
		return finalCode;
	}
	public void setFinalCode(String finalCode) {
		this.finalCode = finalCode;
	}
	@Override
	public String toString() {
		return "Person [num=" + num + ", name=" + name + ", sex=" + sex + ", age=" + age + ", idcard=" + idcard
				+ ", phone=" + phone + ", address=" + address + ", email=" + email + ", time=" + time + ", imageData="
				+ imageData + ", img_path=" + img_path + ", finalCode=" + finalCode + "]";
	}
	
}

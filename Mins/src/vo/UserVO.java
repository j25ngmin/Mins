package vo;

public class UserVO {

	private int userNo;
	private String userId;
	private String userPw;
	private String userEmail;
	private String userBirth;
	private int joinPath;
	private int userGrade;
	private String userPhoneNum;
	
	public int getUserNo() {
		return userNo;
	}
	public UserVO setUserNo(int userNo) {
		this.userNo = userNo;
		return this;
	}
	public String getUserId() {
		return userId;
	}
	public UserVO setUserId(String userId) {
		this.userId = userId;
		return this;
	}
	public String getUserPw() {
		return userPw;
	}
	public UserVO setUserPw(String userPw) {
		this.userPw = userPw;
		return this;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public UserVO setUserEmail(String userEmail) {
		this.userEmail = userEmail;
		return this;
	}
	public String getUserBirth() {
		return userBirth;
	}
	public UserVO setUserBirth(String userBirth) {
		this.userBirth = userBirth;
		return this;
	}
	public int getJoinPath() {
		return joinPath;
	}
	public UserVO setJoinPath(int joinPath) {
		this.joinPath = joinPath;
		return this;
	}
	public int getUserGrade() {
		return userGrade;
	}
	public UserVO setUserGrade(int userGrade) {
		this.userGrade = userGrade;
		return this;
	}
	public String getUserPhoneNum() {
		return userPhoneNum;
	}
	public UserVO setUserPhoneNum(String userPhoneNum) {
		this.userPhoneNum = userPhoneNum;
		return this;
	}
	
	@Override
	public String toString() {
		return "UserVO [userNo=" + userNo + ", userId=" + userId + ", userPw=" + userPw + ", userEmail=" + userEmail
				+ ", userBirth=" + userBirth + ", joinPath=" + joinPath + ", userGrade=" + userGrade + ", userPhoneNum="
				+ userPhoneNum + "]";
	}
	
	
	
}

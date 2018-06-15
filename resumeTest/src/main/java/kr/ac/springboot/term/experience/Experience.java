package kr.ac.springboot.term.experience;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import kr.ac.springboot.term.resume.Resume;

@Entity
public class Experience {
	
	public Experience() {
		
	}
	
	public Experience(String role, String day, String pname, String desc, Resume resume) {
//		super();
		this.role = role;
		this.pname = pname;
		this.desc = desc;
		this.day = day;
		this.resume = resume;
	}
	
	@ManyToOne(fetch=FetchType.LAZY)
    private Resume resume;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long eno;
	
    private String role; // 역할 
    private String day; // 기간
    private String pname; // 과제 이름
    private String desc; // 내용 설명
    
    @CreationTimestamp
    private Timestamp regdate;

    @UpdateTimestamp
    private Timestamp updatedate;

	public Long getEno() {
		return eno;
	}

	public void setEno(Long eno) {
		this.eno = eno;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Timestamp getRegdate() {
		return regdate;
	}

	public void setRegdate(Timestamp regdate) {
		this.regdate = regdate;
	}

	public Timestamp getUpdatedate() {
		return updatedate;
	}

	public void setUpdatedate(Timestamp updatedate) {
		this.updatedate = updatedate;
	}

	public Resume getResume() {
		return resume;
	}

	public void setResume(Resume resume) {
		this.resume = resume;
	}
	
	

    
    
}

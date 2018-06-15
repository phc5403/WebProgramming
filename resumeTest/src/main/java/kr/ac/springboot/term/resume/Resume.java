package kr.ac.springboot.term.resume;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import kr.ac.springboot.term.experience.Experience;


@Entity
public class Resume {
	
	public Resume() {
		
	}
	
    public Resume(String name, String sn, String unmajor, String email, String sistr) {
		super();
		this.name = name;
		this.sn = sn;
		this.unmajor = unmajor;
		this.email = email;
		this.sistr = sistr;
	}
    
    @OneToMany(mappedBy="resume", fetch=FetchType.LAZY)
    private List<Experience> experience;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long rno;

    private String name; // 이름
    private String sn; // 학번
    private String unmajor; // 학교 및 학과
    private String email; // 이메일
    
    @CreationTimestamp
    private Timestamp regdate;

    @UpdateTimestamp
    private Timestamp updatedate;
    
    public String getSn() {
		return sn;
	}

	public void setSn(String sn) {
		this.sn = sn;
	}

	public String getUnmajor() {
		return unmajor;
	}

	public void setUnmajor(String unmajor) {
		this.unmajor = unmajor;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSistr() {
		return sistr;
	}

	public void setSistr(String sistr) {
		this.sistr = sistr;
	}

	private String sistr;

    public Long getRno() {
        return rno;
    }

    public void setRno(Long rno) {
        this.rno = rno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

	public List<Experience> getExperience() {
		return experience;
	}

	public void setExperience(List<Experience> experience) {
		this.experience = experience;
	}
	
	
}

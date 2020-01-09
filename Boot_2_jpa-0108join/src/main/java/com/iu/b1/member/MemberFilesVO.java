package com.iu.b1.member;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "memberFiles")
//@SequenceGenerator(sequenceName = "file_seq",name = "file")
public class MemberFilesVO {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int fnum;
	//private String id;
	private String fname;
	private String oname;
	
	@OneToOne
	@JoinColumn(name = "id")
	private MemberVO memberVO;
}

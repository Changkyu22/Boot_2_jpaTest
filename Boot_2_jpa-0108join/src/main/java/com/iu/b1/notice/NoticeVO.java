package com.iu.b1.notice;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.iu.b1.Board.BoardVO;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "notice")
@Data
public class NoticeVO extends BoardVO{
	
	@OneToMany(mappedBy = "noticeVO", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<NoticeFilesVO> noticeFilesVOs;
	
}

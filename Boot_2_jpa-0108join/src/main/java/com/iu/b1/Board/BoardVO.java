package com.iu.b1.Board;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import lombok.Data;


@Data
@MappedSuperclass
public class BoardVO {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int num;
	private String title;
	private String writer;
	private String contents;
	private String regDate;
	private int hit;
}

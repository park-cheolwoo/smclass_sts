package com.java.dto;

import java.sql.Timestamp;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@DynamicInsert
@Entity
public class EventDto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //db시퀀스 사용
	private int eno;
	@Column(nullable = false,length=100)
	private String etitle;
	@Lob
	private String econtent;
	@ManyToOne(fetch=FetchType.EAGER) // EAGER : 즉시 가져옴
	@JoinColumn(name="id")
	private String id;
	@ColumnDefault("0")
	private int ehit;
	@UpdateTimestamp
	private Timestamp edate;
	private String efile;
	private String efile2;
	private Timestamp stdate;
	private Timestamp enddate;
	private int openchk;

}

package cn.segema.learn.util;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonRootName("Person")
public class Person {
	
	public Person(String name, String nickname, int age, String identityCode, LocalDate birthday) {
		super();
		this.name = name;
		this.nickname = nickname;
		this.age = age;
		this.identityCode = identityCode;
		this.birthday = birthday;
	}

	@JsonProperty("Name")
	private String name;

	@JsonProperty("NickName")
	//@JacksonXmlText
	private String nickname;

	@JsonProperty("Age")
	private int age;

	@JsonProperty("IdentityCode")
	private String identityCode;

	@JsonProperty
	//@JacksonXmlProperty(isAttribute = true)
	@JsonFormat(pattern = "yyyy-MM-DD")
	private LocalDate birthday;
}

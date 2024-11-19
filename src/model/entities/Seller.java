package model.entities;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor @AllArgsConstructor
@Getter @Setter
@EqualsAndHashCode (of = "id")
@ToString
public class Seller implements Serializable {
	private static final long serialVersionUID = 1L;
	//attributes
	private Integer id;
	private String name;
	private String email;
	private Date birthDate;
	private Double baseSalary;
	private Department department;
}

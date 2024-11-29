package model.entities;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@EqualsAndHashCode(of = "id")

@NoArgsConstructor @AllArgsConstructor
@Getter @Setter
public class Department implements Serializable {
	private static final long serialVersionUID = 1L;
	// attributes
	private Integer id;
	private String name;
	
	@Override
	public String toString() {
		return name;
	}

	
}

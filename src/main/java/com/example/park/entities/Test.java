package com.example.park.entities;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data @Getter @Setter
public class Test {
	
	public static int MyTestMethode() {
		System.out.println("hello");
		return 1;
	}

}

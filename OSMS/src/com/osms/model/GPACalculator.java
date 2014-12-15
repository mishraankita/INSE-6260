package com.osms.model;

import java.util.HashMap;
import java.util.Map;

public class GPACalculator {
	private Map<String, Double> gpaMap = new HashMap<String, Double>();
	private Double count;
	private Double sum;

	public GPACalculator() {
		gpaMap.put("A+", 4.3);
		gpaMap.put("A", 4.0);
		gpaMap.put("A-", 3.7);
		gpaMap.put("B+", 3.3);
		gpaMap.put("B", 3.0);
		gpaMap.put("B-", 2.7);
		gpaMap.put("C+", 2.3);
		gpaMap.put("C", 2.0);
		gpaMap.put("C-", 1.7);
		gpaMap.put("D+", 1.3);
		gpaMap.put("D", 1.0);
		gpaMap.put("D-", 0.7);
		gpaMap.put("F", 0.0);
		gpaMap.put("FNS", 0.0);
		gpaMap.put("R", 0.0);
		gpaMap.put("GNR", 0.0);

		count = 0.0;
		sum = 0.0;
	}

	public double getGPA() {
		if (count <= 0.0)
			return 0.0;
		return sum / count;
	}

	public boolean addGrade(String grade) {
		if (grade == null)
			return false;
		Double gpa = gpaMap.get(grade);
		if (gpa == null)
			return false;
		sum += gpa;
		count++;
		return true;
	}

	public void Reset() {
		sum = 0.0;
		count = 0.0;
	}
}

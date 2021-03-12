package com.groovyTests

class Activity2 {

	static void main(args) {
		
		def marks = [45, 96, 67, 54, 77]
		def totalMarks = 0;
		marks.each { totalMarks+=it }
		
		println totalMarks
		
		def avg = totalMarks/5 as Integer
		
		println avg
		
		def grade = "F"
		switch(avg) {
			case (90..100):
				grade = "A"
				break
			case (80..89):
				grade = "B"
				break
			case (70..79):
				grade = "C"
				break;
			case (50..69):
				grade = "D"
				break;
			default:
				grade = "F"
		}
		
		println "Grade = ${grade}"
	}
}

package com.groovyTests

class Activity4 {

	static void main(args) {
		
		def myStr = "This is a Groovy Language"
		println "Actual string : ${myStr}"
		
		def myStrReversed = myStr.reverse()		
		println "Reversed string : ${myStrReversed}"
		
		def myStrSubstr = myStr.substring(10)
		println "Substring : ${myStrSubstr}"
		
		def myStrSeparatedWords = myStr.split(' ')
		println "Separated words : ${myStrSeparatedWords}"
		
		def myStrReplaced = myStr.replaceAll("Groovy", "")
		println "Replace : ${myStrReplaced}"
		
		def myStrLower = myStr.toLowerCase()
		println "Lower case : ${myStrLower}"
		
		def myStrUpper = myStr.toUpperCase()
		println "Upper case : ${myStrUpper}"			
		
	}
}

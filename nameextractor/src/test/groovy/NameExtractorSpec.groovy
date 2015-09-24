import spock.lang.Specification
import spock.lang.Unroll

class NameExtractorSpec extends Specification{
	
	NameExtractor nameExtractor = new NameExtractor()
	
	def "canary test"(){
		expect:
		true == true
	}
	
	@Unroll
	def "shoud return #expectedNames for full name '#fullName'"(){
		given:
		fullName
		
		when:
		String[] names = nameExtractor.extractNames(fullName)
		
		then:
		expectedNames == names
		
		where:
		fullName | expectedNames
		"Ram Kumar" | ["Ram", "Kumar"]
		"Ram Kumar Sharma" | ["Ram", "Kumar Sharma"]
		"Ram Kumar Prakash Sharma" | ['Ram', 'Kumar Prakash Sharma']
		"Kumar, Ram" | ["Ram", "Kumar"]
		"Sharma, Ram Kumar" | ["Ram Kumar", "Sharma"]
		"Sharma, Ram Kumar Prakash" | ['Ram Kumar Prakash', 'Sharma']
	}
}
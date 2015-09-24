import spock.lang.Specification
import spock.lang.Unroll

class PersonExtractorSpec extends Specification{
	
	PersonExtractor personExtractor = new PersonExtractor()
	
	@Unroll
	def "Should return #expectedPerson for full name '#fullName'"(){
		given:
		fullName
		
		when:
		Person person = personExtractor.extractPerson(fullName)
		
		then:
		expectedPerson == person
		
		where:
		fullName | expectedPerson
		'Ram Kumar' | new Person('Ram', 'Kumar')
		"Ram Kumar Sharma" | new Person("Ram", "Kumar Sharma")
		"Ram Kumar Prakash Sharma" | new Person('Ram', 'Kumar Prakash Sharma')
		"Kumar, Ram" | new Person("Ram", "Kumar")
		"Sharma, Ram Kumar" | new Person("Ram Kumar", "Sharma")
		"Sharma, Ram Kumar Prakash" | new Person('Ram Kumar Prakash', 'Sharma')
	}
}
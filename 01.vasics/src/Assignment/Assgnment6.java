package Assignment;
public class Assgnment6 {
	public static void main(String[] args) {
		String paragraph= new String( "NLP techniques are becoming widely popular scientific research areas as well as Information Technology industry. Language technology together with Information Technology can enhance the lives of people with different capabilities. This system implements voice command mobile phone dialer application. The strength of the system is that it can make phone call to the contact name written in either English scripts or Myanmar scripts.");
		
		//Total Sentences
		String[] splits = paragraph.split("\\. ");
		System.out.println("Number of sentences -> " + splits.length);
		
		//Total words
		String[] splits1 = paragraph.split(" ");
		System.out.println("Total words -> " + splits1.length);		
	}
}

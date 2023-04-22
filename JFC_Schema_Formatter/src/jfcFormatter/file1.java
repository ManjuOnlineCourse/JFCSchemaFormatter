package jfcFormatter;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;  
class file1 {  
	public static void main(String args[])  
	{  
		List<String> finalData = new ArrayList<String>();
		String initialData = "{\r\n"
				+ "	\"SubmissionData\": {\r\n"
				+ "		\"name\": \"SubmissionData\",\r\n"
				+ "		\"dataType\": \"Obejct\",\r\n"
				+ "		\"Properties\": {";
		System.out.println(initialData);
		finalData.add(initialData);
		try  
		{  
			File file=new File("C:\\Users\\91814\\Desktop\\Result\\Input.txt");    //creates a new file instance  
			FileReader fr=new FileReader(file);   //reads the file  
			BufferedReader br=new BufferedReader(fr);  //creates a buffering character input stream  
			StringBuffer sb=new StringBuffer();    //constructs a string buffer with no characters  
			String line;
			List<String> list = new ArrayList<String>();
			List<String> list3 = new ArrayList<String>();

			while((line=br.readLine())!=null)  
			{  
				list.add(line);
				sb.append(line);      //appends line to string buffer  
				sb.append("\n");     //line feed   
			} 
			for (String string : list) {
				string = string.trim();
				list3.add(string);
			}
			for (String string : list3) {

				//if(string.equals("{") || string.equals("[")|| string.equals("]")|| string.equals("}"))
				if(string.equals("[")|| string.equals("]")|| string.equals("}") || string.equals("],"))
				{
					if(string.equals("]"))
					{
						string="}";
						System.out.println(string);
						finalData.add(string);
					}
					else if (string.equals("],")) {
						string = "},";
						System.out.print(string);
						finalData.add(string);
					}
					else {
						System.out.print(string);
						finalData.add(string);
					}

				}
				else {
					String[] splited = string.split(":");
					for (int i = 0; i < splited.length; i++) {
						String string2 = splited[i];
						String value = null;
						if(i==0)
						{
							//if(string2!="{"||string2!="}"||string2!="["||string2!="]"||
							//		string2!="\"{\""||string2!="\"}\""||string2!="\"[\"" || string2!="\"]\""||!string2.equals("},"))
							//{
							if(!string2.equals("},") && !string2.equals("{")) 
							{
								String doubleCoteRemovedString = string2.replaceAll("\"", "");
								value =  "\"" + doubleCoteRemovedString+ "\""+":" +"{\n" + "\"" +"name" + "\"" +":"+"\""+ doubleCoteRemovedString +"\""+",";
								System.out.println(value);
								finalData.add(value);
							}
							else if (string2.equals("},") ) {
								value =  ",";
								System.out.println(value);
								finalData.add(value);
							}
							else {
								break;
							}
						}
						else {
							if(!string2.contains("\""))
							{
								string2= string2.trim();
								if(string2.contains("true")||string2.contains("True") || string2.contains("TRUE")) {
									if(string2.equals("true,")||string2.equals("True,")||string2.equals("TRUE,"))
									{
										String temp ="\""+"dataType"+"\":"+"\""+"True"+"\""+"\n},";
										System.out.println(temp);

										finalData.add(temp);
									}
									else {
										String temp1 = "\""+"dataType"+"\":"+"\""+"True"+"\""+"\n}";
										System.out.println(temp1);
										finalData.add(temp1);
									}
								}
								else if(string2.contains("false")||string2.contains("False")||string2.contains("FASLE")) {
									if(string2.equals("false,")||string2.equals("False,")||string2.equals("FALSE,"))
									{
										String temp3 = "\""+"dataType"+"\":"+"\""+"False"+"\""+"\n},";
										System.out.println(temp3);
										finalData.add(temp3);
									}
									else {
										String temp4 = "\""+"dataType"+"\":"+"\""+"False"+"\""+"\n}";
										System.out.println(temp4);
										finalData.add(temp4);
									}
								}
								else if(string2.equals("[{") || string2.equals("[")) {
									String s="\"properties\":{";
									s = "\""+"dataType"+"\":"+"\""+"Array"+"\",\n"+s;
									System.out.println(s);
									finalData.add(s);
								}
								else if(string2.equals("},")) {
									System.out.println(",");
									finalData.add(",");
								}
								else if(string2.equals("{")) {
									String s="\"properties\":{";
									s = "\""+"dataType"+"\":"+"\""+"Object"+"\","+"\n"+s;
									System.out.println(s);
									finalData.add(s);

								}
								else {
									if(string2.contains(","))
									{
										String temp5 = "\""+"dataType"+"\":"+"\""+"Number"+"\""+"\n},";
										System.out.println(temp5);
										finalData.add(temp5);
									}
									else {
										String temp6 = "\""+"dataType"+"\":"+"\""+"Number"+"\""+"\n}";
										System.out.println(temp6);
										finalData.add(temp6);

									}
								}
							}
							else if (!string2.contains(",")) {
								String temp7 = "\""+"dataType"+"\":"+"\""+"Text"+"\""+"\n}";
								System.out.print(temp7);
								finalData.add(temp7);

							}
							else {
								String temp8 ="\""+"dataType"+"\":"+"\""+"Text"+"\""+"\n},";
								System.out.println(temp8);
								finalData.add(temp8);
							}
						}
					}


				}
			}
			System.out.println("}}");
			finalData.add("}}");
			//			System.out.println("__________________________________________________");
			//			for (String string : finalData) {
			//				System.out.println(string);
			//			}
			fr.close();
		}  
		catch(IOException e)  
		{  
			e.printStackTrace();  
		}  

		//file writter
		try{    
			FileWriter fw=new FileWriter("C:\\Users\\91814\\Desktop\\Result\\Output.txt");  
			for (String string : finalData) {
				fw.write(string);
			}
			fw.close();    
		}
		catch(Exception e)
		{
			System.out.println(e);
			}    
		System.out.println("Success...");    

	} 
}
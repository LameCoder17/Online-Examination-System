package JavaQuiz;

import java.io.File;
import java.util.Random;
import java.util.Scanner;

public class quiz {
	
	static String[][] qpa = new String[10][5];
	static String[][] qca = new String[10][2];

    public static String[][] setQuiz(){
         Random random = new Random();
         try {
              File myObj = new File("questionsAndAnswers.txt");
              Scanner myReader = new Scanner(myObj);
              int i = 0;
              while (myReader.hasNextLine()) {
                   qpa[i][0] = myReader.nextLine();
                   qca[i][0] = qpa[i][0];
                   qpa[i][1] = myReader.nextLine();
                   qpa[i][2] = myReader.nextLine();
                   qpa[i][3] = myReader.nextLine();
                   qpa[i][4] = myReader.nextLine();
                   for(int j = 0;j<10;j++){  // Jumbles options
                        int startIndex = random.nextInt(4)+1;  //Because options are stored from 1-4
                        int endIndex = random.nextInt(4)+1;
                        String temp = qpa[i][startIndex];
                        qpa[i][startIndex] = qpa[i][endIndex];
                        qpa[i][endIndex] = temp;
                   }
                   qca[i][1] = myReader.nextLine();  // Reads answer
                   i++;
                   try{
                        myReader.nextLine();
                   }
                   catch(Exception e){
                        System.out.println("File Over");  // Because no blank space at the end
                   }
              }
              myReader.close();  // Close file
         }
         catch(Exception e) {
              e.printStackTrace();
         }
         for(int k = 0;k<100;k++){  // Jumbles questions and answers
              int startIndex = random.nextInt(10);
              int endIndex = random.nextInt(10);
              String[] temp = qpa[startIndex];
              qpa[startIndex] = qpa[endIndex];
              qpa[endIndex] = temp;
              temp = qca[startIndex];
              qca[startIndex] = qca[endIndex];
              qca[endIndex] = temp;
         }
		 return qpa;
	}

     public static String[][] setAnswer(){
          return qca;
     }
}


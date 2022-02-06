import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

   public class TestInputAbsenc {

      @Test
      public void testInput() {
         
         String newLine="";
         if (System.getProperty("os.name").startsWith("Windows")) {
            newLine="\r\n";
         } else {
            newLine="\n";
         }

         InputStream stdin = System.in;

         int month=9;
         int absence=10;

         String input=String.valueOf(month)+newLine+String.valueOf(absence);
         System.setIn(new ByteArrayInputStream(input.getBytes()));

         ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
         PrintStream ps = new PrintStream(byteArrayOutputStream);
         PrintStream stdout = System.out;
         System.setOut(ps);

         MyAbsence.main(new String[0]);

         System.setIn(stdin);
         System.setOut(stdout);

         String outStream="Hianyzasok konyvelese!"+newLine+"Honap sorszama:"+"Adja meg a "+String.valueOf(month)+". honapban a hianyzasok szamat:A diak a "+month+". honapban "+absence+" napot hianyzott!"+newLine;
         String expected=outStream;

         String actual=byteArrayOutputStream.toString();

         //String ans=actual.replace(expected,"");

         Assertions.assertEquals(expected,actual,"Hianyzik a masodik input a sorbol vagy a szoveget nem jol adta meg vagy az osszesito sor hibas!)");
      }

  }

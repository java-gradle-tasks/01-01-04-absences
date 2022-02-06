   import org.junit.jupiter.api.Assertions;
   import org.junit.jupiter.api.Test;

   import java.io.ByteArrayInputStream;
   import java.io.ByteArrayOutputStream;
   import java.io.InputStream;
   import java.io.PrintStream;

   public class TestInputMonth {

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

         String outStream="Hianyzasok konyvelese!"+newLine+"Honap sorszama:";
         String expected=outStream;

         String actual=byteArrayOutputStream.toString();

         boolean found=actual.contains(expected);

         Assertions.assertTrue(found,"Hianyzik az elso input a kodbol vagy a szoveg nem megfelelo!");
      }
   }

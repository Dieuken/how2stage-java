package domein;
import java.io.UnsupportedEncodingException; 
import java.math.BigInteger;
import java.security.MessageDigest; 
import java.security.NoSuchAlgorithmException; 
 
public class Hash 
{ 
    public String encrypt(String string){
        
        
        
        try{
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        if(string.equals(null))
        {
           return null;
        }
        

        byte[] digest = md.digest(string.getBytes("UTF-8")); // Change this to "UTF-16" if needed
        BigInteger hashnummer = new BigInteger(1, digest);
        
        String output = hashnummer.toString(16);
        return output;
        }
        catch(Exception ex){
            ex.printStackTrace();
            return null;
        } 
    }
    
} 
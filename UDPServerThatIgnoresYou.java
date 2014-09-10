import java.net.*;
import java.io.*;
import java.util.*;
public class UDPServerThatIgnoresYou {
    static Random rnd = new Random();//Returns a ramdom number
    public static void main(String args[]){ 
        
            server();

        
    }
    public static void server(){
        DatagramSocket server = null;
        try{  
            server = new DatagramSocket(9999);
            byte[] buf = new byte[1024];
            while(true){
                DatagramPacket dataPacket = new DatagramPacket(buf, 1024);
                server.receive(dataPacket);
                String str = new String(buf, 0, dataPacket.getLength());
                //System.out.println(str);
                if(rnd.nextInt(10) < 7) {
                    System.out.println("Got request " + str + " but ignoring it.");
                    continue;
                }
                else {
                    System.out.println("Got request" + str + "And making a reply");
                }
                int x = extractFirstInteger(str);
                int y = extractSecondInteger(str);
                String operator = extractOperation(str);
                int result = performOperation(x, y, operator);
                String sendResult = "" + result;
                DatagramPacket dataPackettoSend = new DatagramPacket(sendResult.getBytes(), sendResult.length(),
                dataPacket.getAddress(), dataPacket.getPort());
                server.send(dataPackettoSend);
            }     
        }
        catch(SocketException e){
            System.out.println("Socket: " + e.getMessage());
        } 
        catch(IOException e){
            System.out.println("IO: " + e.getMessage());
        }
        finally{
            if (server != null) {
                server.close();
            }
        }      
    }
    public static int performOperation(int x, int y, String operator){
        int result = 0;
        switch(operator){
            case "+":
                result = addition(x, y); break;
            case "-":
                result = substraction(x, y); break;
            case "X":
                result = multiplication(x, y); break;
            case "/":
                result = division(x, y); break;
            case "^":
                result = exponentiation(x, y); break;

        }
        return result;
            
    }
    public static int extractFirstInteger(String str){
        int length = str.length();
        int endIndex = 0;
        for (int i = 0; i < length; i++) {
            if(Character.isDigit(str.charAt(i))){
                endIndex = i;
            }        
            else break;
        }
        int x  = Integer.parseInt(str.substring(0, endIndex + 1));
        System.out.println("First integer ----" + x);
        return x;
    }
    public static int extractSecondInteger(String str){
        int length = str.length();
        int startIndex = 0;
        int endIndex = 0;
        for (int i = 0; i < length; i++) {
            if(Character.isDigit(str.charAt(i))){
                startIndex = i;
            }      
            else break;  
        }
        for (int i = startIndex + 1; i < length; i++) {
            if(Character.isDigit(str.charAt(i))){
                startIndex = i;
                break;
            }        
        }
        for (int i = startIndex; i < length; i++) {
            if(Character.isDigit(str.charAt(i))){
                endIndex = i;
            }        
        }
        int y  = Integer.parseInt(str.substring(startIndex, endIndex + 1));
        System.out.println("second Integer ----" + y);
        return y;
    }
    public static String extractOperation(String str){
        String operator;
        int length = str.length();
        int index = 0;
        for (int i = 0; i < length; i++) {
            if(!Character.isDigit(str.charAt(i)) && str.charAt(i) != ' '){
                index = i;
            }        
        }
        operator = str.substring(index, index + 1);
        System.out.println("operator ----" + operator);
        return operator;
    }
    public static int addition(int x, int y){
        return x + y;
    }
    public static int substraction(int x, int y){
        return x - y;
    }
    public static int multiplication(int x, int y){
        return x * y;
    }
    public static int division(int x, int y){
        return x / y;
    }
    public static int exponentiation(int x, int y){
        return (int)exponentiationHelper((double)x, (double)y);
    }
    public static double exponentiationHelper(double x, double y){
        return Math.pow(x, y);
    }
}

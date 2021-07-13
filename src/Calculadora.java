import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import net.bytebuddy.asm.Advice.Return;

public class Calculadora {

	public static void main(String[] args) throws MalformedURLException  {
	
		// TODO Auto-generated method stub
		

		// Configurar conexion con app
		File appDir = new File("src");
        File app = new File(appDir, "Calculadora.apk");
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "CarlosEmulador");
		cap.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
		
		// Para automatizar android 
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");		
		AndroidDriver<AndroidElement> driver = new AndroidDriver<>(new URL ("http://127.0.0.1:4723/wd/hub"),cap);
		 
		// Se Declaran variables de Numeros
		MobileElement Cero;
		MobileElement Uno;
		MobileElement Dos;
		MobileElement Tres;
		MobileElement Cuatro;
		MobileElement Cinco;
		MobileElement Seis;
		MobileElement Siete;
		MobileElement Ocho;
		MobileElement Nueve;
		MobileElement Punto;
		
		Cero = driver.findElementById("com.google.android.calculator:id/digit_0");		
		
		Uno = driver.findElementById("com.google.android.calculator:id/digit_1");		
		
		Dos = driver.findElementById("com.google.android.calculator:id/digit_2");		
		
		Tres = driver.findElementById("com.google.android.calculator:id/digit_3");		

		Cuatro = driver.findElementById("com.google.android.calculator:id/digit_4");
		
		Cinco = driver.findElementById("com.google.android.calculator:id/digit_5");		
		
		Seis = driver.findElementById("com.google.android.calculator:id/digit_6");		
		
		Siete = driver.findElementById("com.google.android.calculator:id/digit_7");		
		
		Ocho = driver.findElementById("com.google.android.calculator:id/digit_8");		
		 
		Nueve = driver.findElementById("com.google.android.calculator:id/digit_9");
		
		Punto = driver.findElementById("com.google.android.calculator:id/dec_point");
			
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		// Se declaran variables de operadores 
		
		MobileElement suma;
		MobileElement resta;
		MobileElement Multiplica;
		MobileElement Divide;
		MobileElement Borrar;
		MobileElement Limpiar;
		MobileElement Igual;
		MobileElement Resultado;
		MobileElement Mensaje;
		MobileElement Porcentaje;
		
		
		
		suma = driver.findElementByAccessibilityId("plus");
		resta = driver.findElementByAccessibilityId("minus");
		Multiplica = driver.findElementByAccessibilityId("multiply");
		Divide = driver.findElementByAccessibilityId("divide");
		Borrar = driver.findElementByAccessibilityId("delete");
		Igual = driver.findElementByAccessibilityId("equals");
		Mensaje = driver.findElementById("com.google.android.calculator:id/result_preview");
				
					
		Limpiar = driver.findElementByXPath("//*[@class='android.widget.Button' and @index=0]");		
		Resultado = driver.findElementByXPath("//*[@class='android.widget.TextView' and @index=0]");	
		
		
		
		// Casos de Pruebas Operaciones Básicas
		// Operacion de Suma 
		
		if(Resultado.getText().equals("")) {
		Ocho.click();suma.click();Nueve.click();
		Igual.click();
		}
			
		   
			if(Resultado.getText().equals("17"))
	        {
	            System.out.println("Resultado de suma exitosa");
	            Resultado.clear();  
	        }
	        else
	        {
	            System.out.println("Resultado de suma Fallida");
	            Resultado.clear();    	            
	        }	
						
			
	    // Operacion de Resta 
			
			if(Resultado.getText().equals("")) 
			{				 
				 Cinco.click();Cero.click();Cero.click();resta.click();Uno.click();Cero.click();Cero.click();
				 Igual.click();
			}	 
				 
				 if(Resultado.getText().equals("400"))
			        {
			            System.out.println("Resultado de la resta exitoso");
			            Resultado.clear();  
			        }
			        else
			        {
			            System.out.println("Resultado de la resta fallido");
			            Resultado.clear();    	            
			        }	
	
		
					
		 // Multiplicacion
			if(Resultado.getText().equals("")) 
			{
		 
				 Nueve.click();Multiplica.click();Ocho.click();Igual.click();	
			}	 
	
			
			if(Resultado.getText().equals("72"))
	        {
	            System.out.println("Resultado de la multiplicación exitoso");
	            Resultado.clear();  
	        }
	        else
	        {
	            System.out.println("Resultado de la multiplicación fallido");
	            Resultado.clear();    	            
	        }	
			
		 // Divide
			if(Resultado.getText().equals("")) 
			{	
		     Nueve.click(); Cero.click();Cero.click();Cero.click();Divide.click();Cinco.click();
		     Igual.click();
			}
			
			if(Resultado.getText().equals("1800"))
	        {
	            System.out.println("Resultado de la division exitoso");
	            Resultado.clear();  
	        }
	        else
	        {
	            System.out.println("Resultado de la division fallido");
	            Resultado.clear();    	            
	        }	
			
		 
		 // Casos de Borde
						
		 //1) Division con decimales
			
			if(Resultado.getText().equals("")) 
			{	
		      Nueve.click(); Cinco.click(); Divide.click();Cero.click();Punto.click();Nueve.click();
		      Igual.click();
		      
			} 
		  
			if(Resultado.getText().equals("105,555555555"))
	        {
	            System.out.println("Resultado de la operacion con decimales exitoso");
	            Resultado.clear();  
	        }
	        else
	        {
	            System.out.println("Resultado de la operaccion con decimales fallido");
	            Resultado.clear();    	            
	        }	
				  	
			
			//2) Division entre cero
			
			if(Resultado.getText().equals("")) 
			{	
		      Nueve.click(); Seis.click(); Divide.click();Cero.click();
		      Igual.click();
		      
		      
			} 
			
			if(Mensaje.getText().equals("Can't divide by 0"))
	        {
	            System.out.println("No se puede dividir entre cero");
	            Mensaje.clear();
	            	            
	        }
						
			
			//3) Multiplicar por cero 
			
			if(Mensaje.getText().equals("")) 
			{
			  	
		      Nueve.click(); Multiplica.click();Cero.click();
		      Igual.click();
		     
			}
					  
			if(Resultado.getText().equals("0"))
	        {
	            System.out.println("Resultado Correcto");
	            Resultado.clear();  
	        }
			 else
		        {
		            System.out.println("Resultado Incorrecto");
		            Resultado.clear();    	            
		        }
		
		}
	}
		 
	